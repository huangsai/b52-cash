package com.mobile.app.cash.core.base

import timber.log.Timber

class BugTree : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
    }
}