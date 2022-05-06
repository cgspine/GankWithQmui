package org.cgsdream.gankwithqmui

import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.qmuiteam.qmui.arch.QMUIFragment
import com.qmuiteam.qmui.kotlin.alignParentHor
import com.qmuiteam.qmui.kotlin.constraintParentId
import com.qmuiteam.qmui.kotlin.matchConstraint
import com.qmuiteam.qmui.kotlin.wrapContent
import com.qmuiteam.qmui.widget.QMUITopBarLayout
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView

class HomeFragment : QMUIFragment() {
    override fun onCreateView(): View {
        return ConstraintLayout(requireContext()).apply {
            val topBar = QMUITopBarLayout(requireContext()).apply {
                id = View.generateViewId()
                setTitle("Gank QMUI")
                fitsSystemWindows = true
            }
            addView(topBar, ConstraintLayout.LayoutParams(0, wrapContent).apply {
                alignParentHor()
                topToTop = constraintParentId
            })


            val groupListView = QMUIGroupListView(context)
            QMUIGroupListView.newSection(context)
                .addItemView(
                    groupListView.createItemView("UIIssues")
                ) {
                    startFragment(UIIssuesFragment())
                }
                .addItemView(
                    groupListView.createItemView("RecyclerViewIssue")
                ) {
                    startFragment(RecyclerViewIssueFragment())
                }
                .addTo(groupListView)
            addView(groupListView, ConstraintLayout.LayoutParams(0, 0).apply {
                alignParentHor()
                topToBottom = topBar.id
                bottomToBottom = constraintParentId
            })
        }
    }
}