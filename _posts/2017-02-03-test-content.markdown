---
layout:default
title:欢迎
---
{{page.title}}

# 欢迎来到李健的博客
[**个人简介**](https://github.com/infonetlijian/blog/raw/master/photos/myself.jpg)
：<br>
在读硕士
2015年毕业于安徽大学，获工学学士学位；
2015年至今，在中国科学技术大学信息网络实验室攻读硕士学位。<br>
**学术著作**：<br>
[1] Hao Wu, Jian Li, Hancheng Lu, Peilin Hong. A Two-layer Caching Model for Content Delivery Services in Satellite-terrestrial Networks. Accepted, IEEE GLOBECOM 2016.<br>
[2] Jian Li, Hancheng Lu, Yali Wang. Temporal Netgrid Model based Routing Optimization in Satellite Networks. Accepted, IEEE ICC 2017.<br>
**联系方式**：<br>
E-mail: lijian9@mail.ustc.edu.cn <br>

{% for post in site.posts %}
{{ post.date | date_to_string }} {{ post.title }}
{% endfor %}



