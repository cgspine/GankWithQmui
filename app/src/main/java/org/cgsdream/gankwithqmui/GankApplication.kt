package org.cgsdream.gankwithqmui

import android.app.Application
import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager

class GankApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        QMUISwipeBackActivityManager.init(this)
    }
}