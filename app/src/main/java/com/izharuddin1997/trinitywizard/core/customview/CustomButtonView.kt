package com.izharuddin1997.trinitywizard.core.customview

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.izharuddin1997.trinitywizard.R

class CustomButtonView(
    private val ctx: Context,
    attrs: AttributeSet
) : AppCompatButton(ctx, attrs) {

    init {
        ctx.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomButtonView,
            0,
            0
        ).apply {
            kotlin.runCatching {
                val background = getResourceId(
                    R.styleable.CustomButtonView_android_background,
                    R.drawable.bg_custom_button
                )
                val textColor =
                    getInt(R.styleable.CustomButtonView_android_textColor, R.color.white)

                setBackgroundResource(background)
                setTextColor(ContextCompat.getColor(ctx, textColor))
            }.onSuccess { recycle() }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        gravity = Gravity.CENTER
        isAllCaps = false
    }
}