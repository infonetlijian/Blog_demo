---
layout: post
title:  "[科研小记]Windows下Word程序Ctrl+V快捷键失灵的解决方案"
date:   2022-11-3 22:44:00
categories: main
---

之前发现电脑在Word环境下粘贴快捷键失灵，但是其它程序Ctrl+V一切正常，当时写材料不多，一直没有在意。今天涉及写很多材料，这个小问题实在影响效率。本来以为可能是输入法快捷键冲突，查阅资料后发现居然是因为Mathtype的插件加载项问题，让人实在无语。详细操作见下面文档，简而言之，在Word选项->加载项->选中Mathtype->选中下方管理中的模板->取消Mathtype加载项即可。
<br>
[**MathType插件选项**](https://jingyan.baidu.com/article/b7001fe1400ca94f7282dde6.html)
<br>
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
