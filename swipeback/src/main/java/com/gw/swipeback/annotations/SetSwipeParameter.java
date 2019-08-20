package com.gw.swipeback.annotations;

import com.gw.swipeback.SwipeBackLayout;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者：kkan on 2019/05/14
 * 滑动关闭参数设置（可以用于单页特殊处理)
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SetSwipeParameter {
    /**
     * 设置滑动关闭的方向（上下左右）
     */
    int directionMode() default SwipeBackLayout.DirectionMode.FROM_LEFT;

    /**
     * 滑动最小检测速度
     */
    float velocityLimit() default 2000f;
    /**
     * 设置滑动因子
     */
    float swipeBackFactor() default 0.5f;

    /**
     * 设置边缘阴影透明度
     */
    int maskAlpha() default 125;

    /**
     * 设置是否仅可以从边缘滑动
     */
    boolean isSwipeFromEdge() default false;
}
