类似美团到下拉刷新动画效果
==
![](https://github.com/zjdyhant/MeiTuanAnimation/blob/master/app/src/main/res/raw/meituanAnim.gif)<br>
#使用的listView
https://github.com/MarkMjw/PullToRefresh.git
#动画效果
帧动画（图片来自美团）
#整体实现
##下拉过程
设置header height，0 -> Height
##刷新后弹回
设置header marginTop,0 -> Height
##弹回后

设置header高度为0

<br>


## 2020/07/27-2020/07/31

#### 业务完成情况
1. 完成心遇接入友盟统计sdk.
2. 声网的音视频文档浏览和sdk测试.
3. 熟悉项目代码.
#### 技术完成情况

#### 遇到问题和风险

#### 思考总结
接入友盟统计sdk:
    外部sdk方面:需要更加全面的了解功能与方法,这样才能充分的使用外部sdk功能. 
    接入方面:需要更了解项目代码,才能在更合适的位置,进行外部代码的插入. 要充分考虑外部代码与本地代码的冲突问题,不要因为外部代码导致本地功能缺失.
声网音视频文档浏览和sdk测试:
    因为本地项目已有core_mic(直播项目对于声网sdk的封装库)依赖,所以看文档的时候,主要关注“1对1视频”和“直播”的差别,以及一些废弃方法上.
    

@cloudmusic-moyi

