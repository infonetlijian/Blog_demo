---
layout: post
title:  "TensorFlow 学习笔记 - TensorFlow 在macOS下的安装"
date:   2018-8-6 10:42:00
categories: main
---
**TensorFlow 在macOS下的安装**
<br>
目前我使用的方式是利用anaconda创建独立的python环境，来使用TensorFlow。<br>
安装的方法有两种：<br>
1.在线安装<br>
通过pip或者pip3进行选择安装源进行在线安装（pip是针对Python 2的安装包指令，pip3是针对Python 3的，不要弄混淆），最简单的命令为：pip3 install tensorflow。执行后，anaconda会在其下载源中搜索与本机最匹配的TensorFlow版本进行安装。<br>
同样，可以通过命令：anaconda search -t conda tensorflow 搜索当前在anaconda软件源中可用的TensorFlow版本，再利用：anaconda showaaronzs/tensorflow 获取指定TensorFlow版本的详细信息以及下载链接。<br>

2.官网上下载最新的whl文件，进行本地安装(适用于网络状况不佳的情况)<br>
通过访问https://pypi.python.org/pypi/tensorflow，可以获取最新的TensorFlow安装包，通过直接下载至本地，再利用：pip3 install “/Downloads/文件目录” 命令可以直接安装。<br>
当然同样可以通过上述网站中的获取的下载地址利用：pip3 install https://pypi.python.org/packages/86/9f/be0165c6eefd841e6928e54d3d083fa174f92d640fdc52f73a33dc9c54d1/tensorflow-1.4.0-cp36-cp36m-manylinux1_x86_64.whl#md5=518b64689653e180116fb5484060474e 命令进行直接安装。

可参考的两个链接：<br>
https://blog.csdn.net/yhily2008/article/details/79176968<br>
https://www.jianshu.com/p/d54546ab315e



<div id="disqus_thread"></div>
<script>

/**
*  RECOMMENDED CONFIGURATION VARIABLES: EDIT AND UNCOMMENT THE SECTION BELOW TO INSERT DYNAMIC VALUES FROM YOUR PLATFORM OR CMS.
*  LEARN WHY DEFINING THESE VARIABLES IS IMPORTANT: https://disqus.com/admin/universalcode/#configuration-variables*/
/*
var disqus_config = function () {
this.page.url = PAGE_URL;  // Replace PAGE_URL with your page's canonical URL variable
this.page.identifier = PAGE_IDENTIFIER; // Replace PAGE_IDENTIFIER with your page's unique identifier variable
};
*/
(function() { // DON'T EDIT BELOW THIS LINE
var d = document, s = d.createElement('script');
s.src = 'https://nathendrake.disqus.com/embed.js';
s.setAttribute('data-timestamp', +new Date());
(d.head || d.body).appendChild(s);
})();
</script>
<noscript>Please enable JavaScript to view the <a href="https://disqus.com/?ref_noscript">comments powered by Disqus.</a></noscript>

<br>
<br>

<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-101909927-1', 'auto');
  ga('send', 'pageview');

</script>
