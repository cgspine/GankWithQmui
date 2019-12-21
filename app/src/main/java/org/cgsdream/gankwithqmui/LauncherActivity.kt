package org.cgsdream.gankwithqmui

import android.os.Bundle
import com.qmuiteam.qmui.arch.QMUIActivity
import com.qmuiteam.qmui.arch.QMUIFragmentActivity

class LauncherActivity: QMUIActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = QMUIFragmentActivity.intentOf(this,
            CommonHolderActivity::class.java,
            HomeFragment::class.java)
        startActivity(intent)
        finish()
    }
}