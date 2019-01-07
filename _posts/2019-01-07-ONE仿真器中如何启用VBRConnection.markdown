---
layout: post
title:  "ONE仿真器中如何启用VBRConnection"
date:   2019-01-07 16:27:00
categories: main
---

今天重新写仿真，发现好多东西都忘了，在此做一些记录。<br>
ONE v1.60里默认有CBRConnection 以及 VBRConnection，但是默认启用是用CBRConnection的，setting文件里也无法进行选择，当需要启用VBRConnection时，需要修改对应的Interface模块，例如默认的SimpleBroadcastInterface中含有connect()以及createConnection()这两个函数，会涉及到 new CBRConnction()。 进行相应修改即可。
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
