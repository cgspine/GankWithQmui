package org.cgsdream.gankwithqmui

import android.view.View
import com.qmuiteam.qmui.arch.QMUIFragmentActivity
import com.qmuiteam.qmui.arch.annotation.DefaultFirstFragment
import com.qmuiteam.qmui.arch.annotation.FirstFragments

@FirstFragments(
    value = [
        HomeFragment::class
    ]
)
@DefaultFirstFragment(HomeFragment::class)
class CommonHolderActivity : QMUIFragmentActivity() {

    override fun getContextViewId(): Int {
        return R.id.app_common_holder_fragment_container
    }
}