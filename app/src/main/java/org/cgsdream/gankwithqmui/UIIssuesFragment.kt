package org.cgsdream.gankwithqmui

import android.graphics.Color
import android.graphics.Typeface
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.qmuiteam.qmui.arch.QMUIFragment
import com.qmuiteam.qmui.arch.annotation.LatestVisitRecord
import com.qmuiteam.qmui.kotlin.*
import com.qmuiteam.qmui.qqface.QMUIQQFaceView
import com.qmuiteam.qmui.type.SerialLineIndentHandler
import com.qmuiteam.qmui.type.view.LineTypeView
import com.qmuiteam.qmui.widget.QMUITopBarLayout
import java.util.regex.Pattern

@LatestVisitRecord
class UIIssuesFragment : QMUIFragment() {
    override fun onCreateView(): View {
        return ConstraintLayout(requireContext()).apply {
            val topBar = QMUITopBarLayout(requireContext()).apply {
                id = View.generateViewId()
                setTitle("UI Issues")
                fitsSystemWindows = true
            }
            addView(topBar, ConstraintLayout.LayoutParams(0, wrapContent).apply {
                alignParentHor()
                topToTop = constraintParentId
            })


            val scrollView = ScrollView(context).apply {
                setBackgroundColor(0xFFCCCCCC.toInt())
            }
            addView(scrollView, ConstraintLayout.LayoutParams(0, 0).apply {
                alignParentHor()
                topToBottom = topBar.id
                bottomToBottom = constraintParentId
            })

            val scrollContent = LinearLayout(context).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(dip(16), 0, dip(16), 0)
            }
            scrollView.addView(scrollContent)
            scrollContent.wrap("场景1", scene1())
            scrollContent.wrap("场景2", scene2())
            scrollContent.wrap("场景3", scene3())
            scrollContent.wrap("场景4", scene4())
        }
    }



    private fun scene1(): View{
//        return LinearLayout(context).apply{
//            orientation = LinearLayout.HORIZONTAL
//            gravity = Gravity.BOTTOM
//            addView(TextView(context).apply {
//                text = "名字特别特别特别特别特别特别特别特别长的用户名"
//                textSize = 17f
//                isSingleLine = true
//                ellipsize = TextUtils.TruncateAt.END
//                setTextColor(Color.BLACK)
//            }, LinearLayout.LayoutParams(wrapContent, wrapContent))
//            addView(TextView(context).apply {
//                text = "发表了书摘"
//                textSize = 15f
//                setTextColor(Color.GRAY)
//            }, LinearLayout.LayoutParams(wrapContent, wrapContent, 1f).apply {
//                leftMargin = dip(2)
//            })
//
//            addView(TextView(context).apply {
//                text = "19:00"
//                textSize = 14f
//                setTextColor(Color.GRAY)
//            }, LinearLayout.LayoutParams(wrapContent, wrapContent).apply {
//                leftMargin = dip(5)
//            })
//        }

        return ConstraintLayout(requireContext()).apply {
            val (nameId, descId, timeId) = arrayOf(View.generateViewId(), View.generateViewId(), View.generateViewId())
            addView(LineTypeView(context).apply {
                id = nameId
                text = "名字特别特别特别特别特别特别特别特别长的用户名"
                textSize = sp(17).toFloat()
                maxLines = 1
                ellipsized = TextUtils.TruncateAt.END
                textColor = Color.BLACK
            }, ConstraintLayout.LayoutParams(wrapContent, wrapContent).apply {
                constrainedWidth = true
                leftToLeft = constraintParentId
                rightToLeft = descId
                horizontalBias = 0f
                horizontalChainStyle = ConstraintLayout.LayoutParams.CHAIN_PACKED
            })
            addView(TextView(context).apply {
                id = descId
                text = "发表了书摘"
                textSize = 15f
                setTextColor(Color.GRAY)
            }, ConstraintLayout.LayoutParams(wrapContent, wrapContent).apply {
                leftMargin = dip(2)
                rightMargin = dip(8)
                rightToLeft = timeId
                leftToRight = nameId
                bottomToBottom = nameId
            })

            addView(TextView(context).apply {
                id = timeId
                text = "19:00"
                textSize = 14f
                setTextColor(Color.GRAY)
            }, ConstraintLayout.LayoutParams(wrapContent, wrapContent).apply {
                bottomToBottom = nameId
                rightToRight = constraintParentId
            })
        }
    }

    private fun scene2(): View {
//        return ConstraintLayout(requireContext()).apply {
//            val (pre, suffix) = arrayOf(View.generateViewId(), View.generateViewId())
//            addView(LineTypeView(context).apply {
//                id = pre
//                text = "《这是一本名字特别特别特别特别特别特别特别特别长的书"
//                textSize = sp(17).toFloat()
//                maxLines = 1
//                ellipsized = TextUtils.TruncateAt.END
//                textColor = Color.BLACK
//            }, ConstraintLayout.LayoutParams(wrapContent, wrapContent).apply {
//                constrainedWidth = true
//                leftToLeft = constraintParentId
//                rightToLeft = suffix
//                horizontalBias = 0f
//                horizontalChainStyle = ConstraintLayout.LayoutParams.CHAIN_PACKED
//            })
//            addView(TextView(context).apply {
//                id = suffix
//                text = "》"
//                textSize = 15f
//                setTextColor(Color.GRAY)
//            }, ConstraintLayout.LayoutParams(wrapContent, wrapContent).apply {
//                rightToRight = constraintParentId
//                leftToRight = pre
//            })
//        }

        return LineTypeView(requireContext()).apply {
            text = "《这是一本名字特别特别特别特别特别特别特别特别长的书"
            textSize = sp(17).toFloat()
            maxLines = 1
            lineLayout.moreTextFixAtEnd = false
            lineLayout.moreText = "》"
            ellipsized = TextUtils.TruncateAt.END
            textColor = Color.BLACK
        }
    }


    private fun scene3(): View{

        return ConstraintLayout(requireContext()).apply {
            val coverView = View(context).apply {
                id = View.generateViewId()
                setBackgroundColor(Color.DKGRAY)
            }
            val titleView = QMUIQQFaceView(context).apply{
                id = View.generateViewId()
                text = "这是标题"
                textSize = sp(18)
                setEllipsize(TextUtils.TruncateAt.END)
                maxLine = 2
                setTypeface(Typeface.DEFAULT_BOLD)
                setTextColor(Color.BLACK)
            }

            val infoView = QMUIQQFaceView(context).apply {
                id = View.generateViewId()
                text = "这是一些简介这是一些简介这是一些简介这是一些简介这是一些简介这是一些简介这是一些简介这是一些简介这是一些简介这是一些简介这是一些简介这是一些简介这是一些简介这是一些简介这是一些简介这是一些简介"
                textSize = sp(16)
                maxLine = 1
                setEllipsize(TextUtils.TruncateAt.END)
                setTextColor(Color.DKGRAY)
            }

            titleView.setListener(object: QMUIQQFaceView.QQFaceViewListener {
                override fun onCalculateLinesChange(lines: Int) {
                    if(lines >= 2){
                        infoView.maxLine = 1
                    }else{
                        infoView.maxLine = 2
                    }
                }

                override fun onMoreTextClick() {

                }
            })

            addView(coverView,  ConstraintLayout.LayoutParams(dip(56), dip(80)).apply {
                topToTop = constraintParentId
                leftToLeft = constraintParentId
            })
            addView(titleView, ConstraintLayout.LayoutParams(0, wrapContent).apply {
                constrainedWidth = true
                rightToRight = constraintParentId
                leftToRight = coverView.id
                leftMargin = dip(8)
            })
            addView(infoView, ConstraintLayout.LayoutParams(0, wrapContent).apply {
                topMargin = dip(4)
                topToBottom = titleView.id
                alignViewHor(titleView.id)
            })
        }
    }

    private fun scene4(): View{

        return LineTypeView(requireContext()).apply {
            val content = "pinyin.这一条很重要，你要仔细研读研读。\n" +
                    "english.这一条不重要，但是有很多很多很多很多很多很多很多很多内容。。\n" +
                    "content.这一条特别重要，但是我也不知道对不对，只能放这里了，哈哈哈哈。\n"
            text = content
            textSize = sp(17).toFloat()
            lineLayout.moreText = "展开"
            lineLayout.moreTextColor = Color.BLUE
            maxLines = 4
            ellipsized = TextUtils.TruncateAt.END
            textColor = Color.BLACK

            val pairs = arrayListOf<Pair<Int, Int>>()
            val pattern = Pattern.compile("([a-z]+\\.)")
            val matcher = pattern.matcher(content)
            while (matcher.find()){
                pairs.add(matcher.start() to matcher.end() - 1)
            }

            pairs.forEach {
                addTextColorEffect(it.first, it.second, Color.DKGRAY)
            }
            lineLayout.lineIndentHandler = SerialLineIndentHandler(pairs)
        }
    }

    private fun LinearLayout.wrap(title: String, content: View){
        val titleView = TextView(context).apply {
            text = title
            setPadding(0, dip(32), 0, dip(24))
            textSize = 17f
            typeface = Typeface.DEFAULT_BOLD
        }
        addView(titleView, LinearLayout.LayoutParams(matchParent, wrapContent))
        addView(content, LinearLayout.LayoutParams(matchParent, wrapContent))
    }
}