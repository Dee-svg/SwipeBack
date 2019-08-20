package com.gw.swipeback;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;

import com.gw.swipeback.annotations.EnableSwipeBack;
import com.gw.swipeback.annotations.SetSwipeParameter;

/**
 * 作者：kkan on 2019/05/14
 * 当前类注释:
 * SwipeBack
 * style 中须设置 否则黑屏
 <item name="android:windowIsTranslucent">true</item>
 <item name="android:windowBackground">@android:color/transparent</item>
 */
public class SwipeBack {

    public static void init(Application application) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                openDragToCloseForActivity(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {}

            @Override
            public void onActivityResumed(Activity activity) {}

            @Override
            public void onActivityPaused(Activity activity) {}

            @Override
            public void onActivityStopped(Activity activity) {}

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {}

            @Override
            public void onActivityDestroyed(Activity activity) {}
        });
    }

    /**
     * 设置SwipeBackLayout
     *
     * @param activity the specified activity
     */
    private static void openDragToCloseForActivity(@NonNull final Activity activity) {
        assertActivityDestroyed(activity);

        EnableSwipeBack enableSwipeBack = activity.getClass().getAnnotation(EnableSwipeBack.class);
        if(null == enableSwipeBack || !enableSwipeBack.value()) return;
        SwipeBackLayout snakeHackLayout = new SwipeBackLayout(activity);
        snakeHackLayout.attachToActivity(activity);

        SetSwipeParameter dragParameter = activity.getClass().getAnnotation(SetSwipeParameter.class);
        setDragParameter(dragParameter, snakeHackLayout);

    }

    private static void assertActivityDestroyed(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 && activity.isDestroyed()) {
            throw new IllegalStateException("You cannot add this feature to a destroyed activity");
        }
    }

    /**
     * 设置SwipeBackLayout 属性
     */
    private static void setDragParameter(@Nullable SetSwipeParameter swipeParameter, SwipeBackLayout swipeBackLayout) {
        if(null != swipeParameter) {
            swipeBackLayout.setAutoFinishedVelocityLimit(swipeParameter.velocityLimit());
            swipeBackLayout.setDirectionMode(swipeParameter.directionMode());
            swipeBackLayout.setMaskAlpha(swipeParameter.maskAlpha());
            swipeBackLayout.setSwipeBackFactor(swipeParameter.swipeBackFactor());
            swipeBackLayout.setSwipeFromEdge(swipeParameter.isSwipeFromEdge());
        }
    }

    /**
     * 设置activity 滑动关闭 开启或关闭
     * @param activity the specified activity
     * @param enable true: turn on, false: turn off
     */
    public static void enableDragToClose(@NonNull Activity activity, boolean enable) {
        if(activity.isFinishing()) return;

        if(enable) {
            EnableSwipeBack enableSwipeBack = activity.getClass().getAnnotation(EnableSwipeBack.class);
            if (null == enableSwipeBack || !enableSwipeBack.value()) {
                throw new AndroidRuntimeException("If you want to dynamically turn the slide-off feature on or off, add the EnableSwipeBack annotation to "
                        + activity.getClass().getName() + " and set to true");
            }
        }

        ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
        View topWindowView = decorView.getChildAt(0);

        if(!(topWindowView instanceof SwipeBackLayout)) {
            throw new AndroidRuntimeException("Did you enable the keep activities option in the settings? if not, commit issue please");
        }

        ((SwipeBackLayout) topWindowView).ignoreDragEvent(!enable);
    }

}
