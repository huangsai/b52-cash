package com.mobile.app.store

import com.mobile.app.store.file.PlatformPrefs

object TestPrefs : PlatformPrefs {

    override val deviceId: String
        get() = TODO("Not yet implemented")

    override var flavorId: Int
        get() = TODO("Not yet implemented")
        set(value) {}

    override var loginName: String
        get() = TODO("Not yet implemented")
        set(value) {}

    override var loginPassword: String
        get() = TODO("Not yet implemented")
        set(value) {}

    override var token: String
        get() = TODO("Not yet implemented")
        set(value) {}

    override var userId: String
        get() = TODO("Not yet implemented")
        set(value) {}
}