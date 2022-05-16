package org.cgsdream.gankwithqmui

import android.content.Context
import android.graphics.Color
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.GridView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.*
import com.qmuiteam.qmui.arch.QMUIFragment
import com.qmuiteam.qmui.arch.annotation.LatestVisitRecord
import com.qmuiteam.qmui.kotlin.*
import com.qmuiteam.qmui.util.QMUIWindowInsetHelper

@LatestVisitRecord
class AndroidIssue1Fragment: QMUIFragment() {

    override fun onCreateView(): View {
        return DemoLayout(requireContext())
    }

    class DemoLayout(context: Context): FrameLayout(context){

        private val listAdapter = Adapter()

        private val recyclerView = RecyclerView(context).apply {

            // 通过 setPadding + clipToPadding 来做右边的露点
            setPadding(0,0, dip(80), 0)
            clipToPadding = false

            adapter = listAdapter

            itemAnimator = DefaultItemAnimator().apply {
                supportsChangeAnimations = false
            }

            // 翻页
            PagerSnapHelper().attachToRecyclerView(this)

            // grid 布局，这里固定 spanCount, 实际边缘条件会变
            layoutManager = object:GridLayoutManager(
                context,
                3,
                HORIZONTAL,
                false){
                override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
                    return LayoutParams(matchParent, matchParent)
                }
            }
        }

        init {
            fitsSystemWindows = true
            QMUIWindowInsetHelper.handleWindowInsets(
                this,
                WindowInsetsCompat.Type.statusBars() or WindowInsetsCompat.Type.displayCutout()
            )
            val constraintLayout = ConstraintLayout(context)
            addView(constraintLayout, LayoutParams(matchParent, matchParent))
            constraintLayout.addView(recyclerView, ConstraintLayout.LayoutParams(0, dip(300)).apply {
                alignParentHor()
                topToTop = constraintParentId
            })
        }
    }


    class ItemView(context: Context): FrameLayout(context){

        val textView = AppCompatTextView(context)

        init {
            // 避免内容与RV 左边重叠
            setPadding(dip(20), dip(16), dip(20), dip(16))
            val inner = FrameLayout(context).apply {
                setBackgroundColor(Color.LTGRAY)
            }
            inner.addView(textView, LayoutParams(wrapContent, wrapContent).apply {
                gravity = Gravity.CENTER_VERTICAL or Gravity.LEFT
            })
            addView(inner, LayoutParams(matchParent, matchParent))
            setBackgroundColor(Color.RED)
        }
    }

    class VH(val cellView: ItemView): RecyclerView.ViewHolder(cellView){

    }
    class Adapter(): RecyclerView.Adapter<VH>(){

        private val data = mutableListOf<String>()

        init {
            update(30)
        }


        fun update(count: Int){
            data.clear()
            (0..count).mapTo(data){ "Item: $it" }
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            return VH(ItemView(parent.context)).apply {
                cellView.onClick {
                    data[adapterPosition] = "changed"
                    notifyItemChanged(adapterPosition)
                }
            }
        }

        override fun onBindViewHolder(holder: VH, position: Int) {
            data.getOrNull(position)?.let {
                holder.cellView.textView.text = it
            }
        }

        override fun getItemCount(): Int {
            return data.size
        }

    }
}

