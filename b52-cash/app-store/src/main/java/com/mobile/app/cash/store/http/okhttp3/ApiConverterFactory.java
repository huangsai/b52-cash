package com.mobile.app.cash.store.http.okhttp3;

import com.mobile.app.cash.store.StoreX;
import com.mobile.app.cash.store.http.entities.ApiResponse;
import com.mobile.guava.jvm.domain.SourceException;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.annotation.Nullable;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class ApiConverterFactory extends Converter.Factory {

    public static ApiConverterFactory create() {
        return new ApiConverterFactory();
    }

    private ApiConverterFactory() {
        super();
    }

    @Nullable
    @Override
    @SuppressWarnings("unchecked")
    public Converter<ResponseBody, ?> responseBodyConverter(
            Type type,
            Annotation[] annotations,
            Retrofit retrofit
    ) {
        Converter<ResponseBody, ApiResponse<?>> delegate = retrofit.nextResponseBodyConverter(
                this,
                Types.newParameterizedType(ApiResponse.class, type),
                annotations
        );
        Converter<ResponseBody, ApiResponse<Object>> ssDelegate = retrofit.nextResponseBodyConverter(
                this,
                Types.newParameterizedType(ApiResponse.class, Object.class),
                annotations
        );
        return new Converter<ResponseBody, Object>() {
            @Nullable
            @Override
            public Object convert(ResponseBody value) throws IOException {
                final byte[] bytes = value.bytes();
                final MediaType contentType = value.contentType();
                ApiResponse ssResponse = ssDelegate.convert(
                        ResponseBody.create(bytes, contentType)
                );

                if (ssResponse.isSuccess()) {
                    return delegate.convert(ResponseBody.create(bytes, contentType)).getData();
                } else {
                    if (StoreX.INSTANCE.HTTP_CODE_LOGGED_OUT == ssResponse.getCode()) {
                    }
                    throw new SourceException(ssResponse.getMsg(), ssResponse.getCode());
                }
            }
        };
    }
}
