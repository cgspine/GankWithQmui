package org.cgsdream.gankwithqmui

import com.qmuiteam.qmui.arch.QMUIFragmentActivity
import com.qmuiteam.qmui.arch.annotation.DefaultFirstFragment
import com.qmuiteam.qmui.arch.annotation.LatestVisitRecord

@LatestVisitRecord
@DefaultFirstFragment(HomeFragment::class)
class CommonHolderActivity : QMUIFragmentActivity() {

    override fun getContextViewId(): Int {
        return R.id.app_common_holder_fragment_container
    }
}