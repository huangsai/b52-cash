package com.mobile.app.store.dagger

import com.mobile.app.store.http.okhttp3.ApiConverterFactory
import com.mobile.app.store.http.okhttp3.CommonHeadersInterceptor
import com.mobile.app.store.http.okhttp3.HostSelectionInterceptor
import com.mobile.app.store.http.service.DataService
import com.mobile.guava.data.DataModule
import com.mobile.guava.data.SimpleDataModule
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.LoggingEventListener
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import javax.net.ssl.SSLContext
import javax.net.ssl.X509TrustManager

@Module
class StoreModule : DataModule {

    private val delegate = SimpleDataModule()

    @Singleton
    @Provides
    override fun providePoorX509TrustManager(): X509TrustManager {
        return delegate.providePoorX509TrustManager()
    }

    @Singleton
    @Provides
    override fun providePoorSSLContext(x509TrustManager: X509TrustManager): SSLContext {
        return delegate.providePoorSSLContext(x509TrustManager)
    }

    @Singleton
    @Provides
    override fun provideHttpLoggingInterceptorLogger(): HttpLoggingInterceptor.Logger {
        return delegate.provideHttpLoggingInterceptorLogger()
    }

    @Singleton
    @Provides
    override fun provideHttpLoggingInterceptor(
        httpLoggingInterceptorLogger: HttpLoggingInterceptor.Logger
    ): HttpLoggingInterceptor {
        return delegate.provideHttpLoggingInterceptor(httpLoggingInterceptorLogger)
    }

    @Singleton
    @Provides
    override fun provideOkHttpClient(
        x509TrustManager: X509TrustManager,
        sslContext: SSLContext,
        httpLoggingInterceptor: HttpLoggingInterceptor,
        httpLoggingInterceptorLogger: HttpLoggingInterceptor.Logger
    ): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(HostSelectionInterceptor())
            .addInterceptor(CommonHeadersInterceptor())
            .addInterceptor(httpLoggingInterceptor)
            .eventListenerFactory(LoggingEventListener.Factory(httpLoggingInterceptorLogger))
            .sslSocketFactory(sslContext.socketFactory, x509TrustManager)
            .hostnameVerifier { _, _ -> true }
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .pingInterval(15 * 1000L, TimeUnit.MILLISECONDS)
            .build()
    }

    @Singleton
    @Provides
    override fun provideJson(): Moshi {
        return delegate.provideJson()
    }

    @Singleton
    @Provides
    override fun provideRetrofit(okHttpClient: OkHttpClient, json: Moshi): Retrofit {
        return return Retrofit.Builder()
            .baseUrl("https://www.google.com/")
            .client(okHttpClient)
            .addConverterFactory(ApiConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(json).asLenient())
            .build()
    }

    @Singleton
    @Provides
    fun provideDataService(retrofit: Retrofit): DataService {
        return retrofit.create(DataService::class.java)
    }
}