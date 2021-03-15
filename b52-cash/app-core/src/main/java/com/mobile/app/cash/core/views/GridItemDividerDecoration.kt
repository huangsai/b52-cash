package com.mobile.app.cash.core.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.Dimension
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class GridItemDividerDecoration(
    @param:Dimension private val dividerSize: Int,
    @ColorInt dividerColor: Int
) : RecyclerView.ItemDecoration() {

    private val paint: Paint = Paint().also {
        it.color = dividerColor
        it.style = Paint.Style.FILL
    }

    constructor(
        context: Context,
        @DimenRes dividerSizeResId: Int,
        @ColorRes dividerColorResId: Int
    ) : this(
        context.resources.getDimensionPixelSize(dividerSizeResId),
        ContextCompat.getColor(context, dividerColorResId)
    )

    override fun onDrawOver(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        if (parent.isAnimating) return
        val lm = parent.layoutManager ?: return

        (0 until parent.childCount).forEach { i ->
            val child = parent.getChildAt(i)

            val right = lm.getDecoratedRight(child)
            val bottom = lm.getDecoratedBottom(child)
            // draw the bottom divider
            canvas.drawRect(
                lm.getDecoratedLeft(child).toFloat(),
                (bottom - dividerSize).toFloat(),
                right.toFloat(),
                bottom.toFloat(),
                paint
            )
            // draw the right edge divider
            canvas.drawRect(
                (right - dividerSize).toFloat(),
                lm.getDecoratedTop(child).toFloat(),
                right.toFloat(),
                (bottom - dividerSize).toFloat(),
                paint
            )
        }
    }
}