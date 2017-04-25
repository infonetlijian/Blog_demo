---
layout: post
title:  "关于java项目从eclipse移植到intellij idea的抓狂之旅"
date:   2017-04-25 22:01:00
categories: main
---

又一次作死，尝试把之前的java项目从eclipse移植到intellij idea，没办法，知乎上一群人吹捧intellij idea，不过对于我而言其实是因为mac平台的eclipse实在是太不好用了……
虽然总算成功了，但是java 3d的模块貌似就是有问题，后面再解决吧……
成功移植经历，参照网站：http://m.2cto.com/kf/201608/539241.html，还有把lib文件单独拿出来和源代码文件夹分开，再单独导入到library下面，同时在run的时候进行configuration里面，虽然没有读出主程序，但直接在名城栏输入core.DTNSim来强制运行，居然运行成功……


