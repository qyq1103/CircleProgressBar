package com.qyq.circleprogress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author :Net spirit
 * @date：2020/7/5 12:07
 * @desc:
 */
public class CircleProgressText extends RelativeLayout {
    private boolean isBold;
    private int textColor;
    private float textSize;

    private CircleProgress circleProgress;
    private TextView tvInfo;

    public CircleProgressText(Context context) {
        super(context, null);
    }

    public CircleProgressText(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public CircleProgressText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CircleProgressText);
        isBold = ta.getBoolean(R.styleable.CircleProgressText_isBoldd, false);
        textColor = ta.getColor(R.styleable.CircleProgressText_text_color, Color.BLACK);
        textSize = ta.getDimension(R.styleable.CircleProgressText_text_size, 16);
        ta.recycle();

        View view = View.inflate(context, R.layout.layout_circleprogress_text, this);
        circleProgress = view.findViewById(R.id.cp_bar);
        tvInfo = view.findViewById(R.id.tv_info);

        tvInfo.setTextColor(textColor);
        tvInfo.setTextSize(textSize);
        if (isBold) {
            tvInfo.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        } else {
            tvInfo.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        }
    }

    public void setTvInfo(String info) {
        tvInfo.setText(info);
    }

    public void setProgress(int progress) {
        circleProgress.setCurrProgress(progress);
    }

    public void setMaxProgress(int maxProgress) {
        circleProgress.setMaxProgress(maxProgress);
    }
}
