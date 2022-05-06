package org.cgsdream.gankwithqmui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.qmuiteam.qmui.arch.QMUIFragment
import com.qmuiteam.qmui.arch.annotation.LatestVisitRecord
import com.qmuiteam.qmui.kotlin.dip

@LatestVisitRecord
class RecyclerViewIssueFragment : QMUIFragment() {

    override fun onCreateView(): View {
        return RecyclerViewIssueLayout(requireContext())
    }
}

class RecyclerViewIssueLayout(context: Context): LinearLayout(context){
    private val recyclerView1 = RecyclerView(context).apply {
        layoutManager = LinearLayoutManager(context)
    }
    private val recyclerView2 = RecyclerView(context).apply {
        layoutManager = LinearLayoutManager(context)
    }

    private val adapter1 = Adapter().also {
        recyclerView1.adapter = it
    }
    private val adapter2 = Adapter().also {
        recyclerView2.adapter = it
    }

    private var list1Count = 200
    private var list2Count = 200

    init {
        addView(recyclerView1, LayoutParams(0, LayoutParams.MATCH_PARENT, 1f))
        addView(recyclerView2, LayoutParams(0, LayoutParams.MATCH_PARENT, 1f))

        adapter1.magicLogic = {
            // notice here:
            // notify another recyclerView update it's data(the data count is less than before.)
            adapter2.update(--list2Count)
        }
        adapter1.update(list1Count)
        adapter2.update(list2Count)
    }
}

class VH(val tv: TextView): RecyclerView.ViewHolder(tv)

fun View.dip(value: Int): Int {
    return (value * resources.displayMetrics.density).toInt()
}

class Adapter: RecyclerView.Adapter<VH>(){

    var magicLogic: ((pos: Int)-> Unit)? = null

    private val dataList = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(TextView(parent.context).apply {
            val paddingHor = parent.dip(20)
            val paddingVer = parent.dip(16)
            setPadding(paddingHor, paddingVer, paddingHor, paddingVer)
        })
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.tv.text = dataList[position]
        // notice here:
        // notify another recyclerView update it's data.
        // normally we will not do this, but when the project grow, everything is possible.
        magicLogic?.invoke(position)
    }

    override fun getItemViewType(position: Int): Int {
        // Just for demo, make the crash easier to happen.
        return position
    }

    fun update(listCount: Int){
        // do not use async diff.
        dataList.clear()
        (0..listCount).mapTo(dataList){ "Item $it"}
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = dataList.size
}
