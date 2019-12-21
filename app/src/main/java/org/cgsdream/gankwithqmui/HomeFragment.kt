package org.cgsdream.gankwithqmui

import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.qmuiteam.qmui.arch.QMUIFragment
import com.qmuiteam.qmui.kotlin.wrapContent

class HomeFragment: QMUIFragment(){
    override fun onCreateView(): View {
        return FrameLayout(context!!).apply {
            val textView = TextView(context).apply {
                text = "第一个 Fragment"
            }
            addView(textView, FrameLayout.LayoutParams(wrapContent, wrapContent).apply {
                gravity = Gravity.CENTER
            })
        }
    }
}