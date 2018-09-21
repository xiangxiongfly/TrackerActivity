# TrackerActivity
Android 内存被回收后直接重启APP



流程： SplashActivity -> MainActivity -> SecondActivity -> ThirdActivity -> APP被强杀，内存被回收，APP就会重启，重走流程 -> SplashActivity -> MainActivity



![流程展示](https://github.com/xiangxiongfly/TrackerActivity/blob/master/img/img.gif?raw=true)