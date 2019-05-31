---
layout: post
title:  "[仿真平台]ONE仿真器中关于ConnectivityGrid的运行机制"
date:   2019-01-07 22:39:00
categories: main
---

今天写一个仿真程序，用到了两种不同类型的节点，但是发现配备不同种类interface的节点，相互之间无法建立connection，经过测试发现是ConnectivityGrid的维护机制问题。
<br>
首先，虽然每个节点的NetworkInterface中，都各自维护了一个ConnectivityGrid，但是其初始化是依靠setHost()当中调用ConnectivityGridFactory函数来添加各个节点的。
<br>
再仔细去看ConnectivityGridFactory，会发现其实这是一个静态函数，其中有一个gridobjects的HashMap，并以interface种类的hashcode作为key来寻址，因此到这里十分明显，只有同类型的interface才能够进行通信，
<br>
(例如Node1配备Interface1和Interface2，而Node2只配备Interface1和Interface3，则Interface1相互之间可通信，Interface2和4则相互之间无法通信)
配备其的节点才会被加入到对应的grid当中，从而在每次NetworkInterface进行update时，才有机会判断是否在通信范围内，并建立connection。
<br>

[**相关推荐网站**](http://sparkandshine.net/en/the-one-use-notes-directory/)

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
