package com.mobile.app.store

import com.mobile.guava.data.PlatformContext
import java.io.File

object TestContext : PlatformContext {

    override fun getCacheDir(): File {
        TODO("Not yet implemented")
    }

    override fun getFilesDir(): File {
        TODO("Not yet implemented")
    }

    override fun getDatabasePath(name: String): File {
        TODO("Not yet implemented")
    }

    override fun getExternalCacheDir(): File {
        TODO("Not yet implemented")
    }

    override fun getExternalFilesDir(type: String?): File {
        TODO("Not yet implemented")
    }
}