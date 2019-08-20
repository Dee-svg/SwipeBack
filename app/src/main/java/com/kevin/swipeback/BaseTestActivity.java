package com.kevin.swipeback;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gw.swipeback.SwipeBack;
import com.gw.swipeback.SwipeBackLayout;
import com.gw.swipeback.annotations.EnableSwipeBack;
import com.gw.swipeback.annotations.SetSwipeParameter;

@EnableSwipeBack()
@SetSwipeParameter(/*设置是否仅可以从边缘滑动*/isSwipeFromEdge = true ,
/*滑动方向*/directionMode = SwipeBackLayout.DirectionMode.FROM_LEFT
/*其他属性不常用，根据需求修改*/)
public abstract class BaseTestActivity extends AppCompatActivity {

    public BaseTestActivity context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
    }


    //关闭侧滑返回
    public void swipeDragToClose() {
        SwipeBack.enableDragToClose(context, false);
    }
}
