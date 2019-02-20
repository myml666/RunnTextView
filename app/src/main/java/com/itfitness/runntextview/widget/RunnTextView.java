package com.itfitness.runntextview.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * @ProjectName: CustomDemo
 * @Package: com.itfitness.module.customdemo.anim.value
 * @ClassName: RunnTextView
 * @Description: java类作用描述 ：金钱滚动效果
 * @Author: 作者名：lml
 * @CreateDate: 2019/2/20 11:07
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/2/20 11:07
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */

public class RunnTextView extends TextView {
    private ValueAnimator mValueAnimator;
    private DecimalFormat mDf;

    public RunnTextView(Context context) {
        this(context,null);
    }
    public RunnTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public RunnTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init() {
        //格式化小数（保留小数点后两位）
        mDf = new DecimalFormat("0.00");
        initAnim();
    }
    /**
     * 初始化动画
     */
    private void initAnim() {
        mValueAnimator = ValueAnimator.ofFloat(0,0);
        mValueAnimator.setDuration(1000);//动画时间为1秒
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                if(value>0){
                    setText(mDf.format((float) animation.getAnimatedValue()));//当数值大于0的时候才赋值
                }
            }
        });
    }
    /**
     * 设置要显示的金钱
     * @param money
     */
    public void setMoney(float money){
        mValueAnimator.setFloatValues(0,money);
        mValueAnimator.start();
    }
    /**
     * 取消动画和动画监听
     */
    public void cancle(){
       mValueAnimator.removeAllUpdateListeners();
       mValueAnimator.cancel();
    }
}
