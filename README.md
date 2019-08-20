# 工作使我快乐，放假妨碍我进步
**我爱工作！工作使我快乐！工作使我进步！工作使我致富！优秀是一种习惯，我徜徉在工作的海洋，吸吮着工作的雨露，同事喊我吃饭，我充耳不闻，老板喊我喝水，我无动于衷，我只喜欢工作！**

## 项目介绍
   - 解决侧滑黑频
   - 注入使用更便捷
## 使用介绍
-1.[创建Application](https://github.com/skpy5272/SwipeBack/blob/master/app/src/main/java/com/kevin/swipeback/MyTestApplication.java)

```Java
    public class MyTestApplication extends Application {
     @Override
     public void onCreate() {
          super.onCreate();
           //初始化侧滑退出
           SwipeBack.init(this);
     }
    }
 ```
或在已有 Application的onCreate方法中加入
```Java
        SwipeBack.init(this);
```

-2.在 [style.xml](https://github.com/skpy5272/SwipeBack/blob/master/app/src/main/res/values/styles.xml)中创建新的 或继承AppTheme 主题 一切水泥
```Java
    <!--防侧滑黑屏，使用该主题-->
    <style name="AppTheme.SwipeBack" parent="AppTheme">
        <item name="android:windowIsTranslucent">true</item>
        <item name="android:windowBackground">@android:color/transparent</item>
    </style>
```
-3.在AndroidManifest.xml 中使用新建的主题
全局
```Java
    <application
        ...
          android:theme="@style/AppTheme.SwipeBack">
        ...
    </application>
```

还是 单个
```Java
          <activity android:name=".ui.MainActivity"
            android:theme="@style/AppTheme.SwipeBack"/>
```
都行

-4. 使用代码对Activity 进行注解
```Java
    @EnableSwipeBack()
    @SetSwipeParameter(/*设置是否仅可以从边缘滑动*/isSwipeFromEdge = true ,
    /*滑动方向*/directionMode = SwipeBackLayout.DirectionMode.FROM_LEFT/*其他属性不常用，根据需求修改*/)
    public abstract class BaseTestActivity extends AppCompatActivity {}
```

[查看其他属性，点这里（懒着画表）](https://github.com/skpy5272/SwipeBack/blob/master/swipeback/src/main/java/com/gw/swipeback/annotations/SetSwipeParameter.java)

-5.关闭开启侧滑返回
```Java
SwipeBack.enableDragToClose(context, false/*false 关闭  true开启*/);
```


#### 开发环境信息
-1. AS版本3.4.2
-2. jdk 1.8

#### 参与贡献
-1. KKan (164994601@qq.com)


## 支持鸣谢
##### 1. [SwipeBackLayout](https://github.com/gongwen/SwipeBackLayout)
-像大佬们膜拜
-![ ](https://raw.githubusercontent.com/skpy5272/SwipeBack/master/img/mobai.gif)
