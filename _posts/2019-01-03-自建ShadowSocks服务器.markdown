---
layout: post
title:  "自建ShadowSocks服务器"
date:   2019-01-03 10:50:00
categories: main
---

[EC2]: http://githubstatic.celerysoft.com/blog/assets/postImages/2016011501.png "EC2"
[AMI]: http://githubstatic.celerysoft.com/blog/assets/postImages/2016011503.png "AMI"
[T2]: http://githubstatic.celerysoft.com/blog/assets/postImages/2016011504.png "T2"
[Label]: http://githubstatic.celerysoft.com/blog/assets/postImages/2016011505.png "Label"
[SecrectKey]: http://githubstatic.celerysoft.com/blog/assets/postImages/2016011506.png "SecrectKey"
[IP]: http://githubstatic.celerysoft.com/blog/assets/postImages/2016011507.png "IP"
[Instance]: http://githubstatic.celerysoft.com/blog/assets/postImages/2016011508.png "Instance"

一、注册AWS
首先，到 http://aws.amazon.com/cn/ 注册，如果你以前有亚马逊账号，直接登录就好。一路下来资料照填，用中文即可。需要注意的是，注册过程需要绑定信用卡，说好是免费的，怎么还要绑定信用卡扣费呢？所谓免费，就是在你没有用超的情况下（作为Shadowsocks服务器，唯一能超限使用的就是网络流量，每月15G流量）。绑定信用卡应该会扣两笔钱，都是1美元，一笔是预授权，一笔应该是押金，1年后会返还，如果超限使用，顺便用着1美金抵扣。

注册完会需要输入你的手机号，AWS会拨通你的手机号，让你输入一个数字完成注册，我第一次没接到电话，重试了一遍就好了。
二、创建AWS实例
用刚才注册好的账号登录AWS控制台，点击EC2（云中的虚拟服务器）
！[EC2]（EC2）
<br>
定制服务器类型，点击启动实例
![启动实例](http://githubstatic.celerysoft.com/blog/assets/postImages/2016011502.png "启动实例")
<br>
勾选仅免费套餐，我选择了Amazon Linux AMI，我对Linux没什么研究（有什么说错的地方请斧正），就选了这个，你可以选择Ubuntu什么的，但接下来的教程都是按照Amazon Linux AMI为蓝本介绍的。
！[AMI]（AMI）
<br>
定制实例类型总共有7个项目，一个一个来，实例类型选择t2 micro，
![T2](T2)
<br>
然后下一步，接下来的都不用修改，直接下一步，到第五步标签和实例，这个可以按图这样设置，
![Label](Label)
<br>
配置安全组的时候，建议先允许所有流量，开放所有端口，这个可以稍后再修改，你可以自己配置适合自己的防火墙设置。

最后确定开始审核。这时候会提示生成密钥对，这个很重要，一定要保存好，没有这个密钥对是无法远程登录管理你的服务器的，所以一定要保存好。
![SecrectKey](SecrectKey)
<br>
连接到服务器
定制完成后等几分钟，一般是在给你的服务器进行开发，等初始化完成后，就可以进行远程连接了，右键你的实例，点击连接。会弹出连接提示，如果你使用的是Windows，可以查看使用 PuTTY 从 Windows 连接到 Linux 实例，如果你是Linux或者Mac OS，可以直接通过SSH连接到你的服务器，具体可以查看亚马逊给出的文档使用 SSH 连接到 Linux 实例。
![IP](IP)
记住下图中所示位置这个公有IP，它是你的Shadowssocks的服务器IP。
![Instance](Instance)
<br>
主要说说使用Mac OS系统通过SSH连接到服务器

首先，打开终端，使用chmod命令确保私有密钥不是公开可见的：

chmod 400 /Users/Celery/.ssh/celerysoft.pem
/Users/Celery/.ssh/celerysoft.pem 是刚才下载的密钥对.pem文件的路径。

然后，通过ssh命令连接到服务器
```
ssh -i /Users/Celery/.ssh/celerysoft.pem ec2-user@ec2-11-111-11-111.ap-northeast-1.compute.amazonaws.com
```
ec2-user 是用户名，Amazon Linux AMI默认的是ec2-user，

ec2-11-111-11-111.ap-northeast-1.compute.amazonaws.com 是你的服务器的公有DNS，这些信息右键点击你的实例，点击连接，弹出的提示框里都写着。

登录成功后，你能看到如下响应信息：
```
The authenticity of host 'ec2-198-51-100-1.compute-1.amazonaws.com (10.254.142.33)'
can't be established.
RSA key fingerprint is 1f:51:ae:28:bf:89:e9:d8:1f:25:5d:37:2d:7d:b8:ca:9f:f5:f1:6f.
Are you sure you want to continue connecting (yes/no)?
```
输入yes，然后按回车。
<br>
为了方便管理，可以下载手机客户端 AWS Console 随时开启和关闭实例。

<br>
三、在服务器安装及配置Shadowsocks
任何关于配置和安装Shadowsocks的说明，可以查阅Shadowsocks的项目Wiki。
<br>
安装Shadowsocks
以此输入以下命令来安装Shadowsocks
```
sudo yum install -y python-setuptools
sudo easy_install pip
sudo pip install git+https://github.com/shadowsocks/shadowsocks.git@master
```
仔细看看有没有错误，如无错误即可继续
<br>
配置Shadowsocks
在终端输入
```
ssserver -h
```
查看Shadowsocks的帮助，适合进阶玩家。
<br>
如果提示没有ssserver这个命令，可以通过
```
which ssserver
```
查看Shadowsocks的路径，一般是在/usr/local/bin目录下，我们只需要把/usr/local/bin加入到/etc/profile文件中即可。

也可以通过
```
/usr/local/bin/ssserver
```
来执行相应的命令。

例如查看帮助为
```
/usr/local/bin/ssserver -h
```
<br>
接下来创建shadowsocks目录，用于存放配置文件
```
mkdir /etc/shadowsocks
```
创建其配置文件
```
sudo vim /etc/shadowsocks/config.json
```
配置文件的内容如下
```
{

"server": "0.0.0.0",

"server_port": 443,

"local_address": "127.0.0.1",

"local_port": 1080,

"password": "celerysoft.github.io",

"timeout": 300,

"method": "aes-256-cfb",

"fast_open": false,

"workers": 1

}
```
<br>
配置文件说明	 
server	服务端监听地址(IPv4或IPv6)
server_port	服务端端口，一般为443
local_address	本地监听地址，缺省为127.0.0.1
local_port	本地监听端口，一般为1080
password	用以加密的密匙
timeout	超时时间（秒）
method	加密方法，默认为aes-256-cfb，更多请查阅Encryption
fast_open	是否启用TCP-Fast-Open，true或者false
workers	worker数量，如果不理解含义请不要改（这个只在Unix和Linux下有用）
启动Shadowsocks服务器
依次输入以下命令来启动Shadowsocks
```
sudo ssserver -c /etc/shadowsocks/config.json -d start
```
如果想停止Shadowsocks服务，可以这样停止
```
sudo ssserver -c /etc/shadowsocks/config.json -d stop
```
如果更改了Shadowsocks的配置文件，可以通过restart命令来重启Shadowsocks服务
```
sudo ssserver -c /etc/shadowsocks/config.json -d restart
```
设置Shadowsocks开机启动
服务器运行久了，偶尔需要重启一下，重启时每次都要手动启动hadowsocks的话就太麻烦了，可以将其加到开机启动项。
```
sudo vi /etc/rc.local
```
将带有ssserver内容的行删除，最后加入
```
sudo ssserver -c /etc/shadowsocks.json -d start
```
<br>
然后保存退出，这样，服务器上的操作就算完成了，接下来改对本地计算机进行操作了。
<br>
在AWS控制台开启相应的端口
需要在安全组里把相应的端口打开，这个自己处理吧。
<br>
四、本地连接至Shadowsocks服务器
[**下载Shadowsocks-GUI客户端**](https://sourceforge.net/projects/shadowsocksgui/files/dist/)<br>
<br>
当然你也可以到GitHub下载最新的客户端：
[**Windows客户端下载地址**](https://github.com/shadowsocks/shadowsocks-windows/releases)<br>
[**macOS客户端下载地址**](https://github.com/shadowsocks/shadowsocks-iOS/releases)<br>
Linux客户端下载地址
<br>
安装之后，添加服务器，地址为AWS的外网地址，登录AWS控制台，查看正在运行中的实例，找到公有ip。 端口号为刚才配置Shadowsocks服务器时的端口号，密码也是刚才配置的，设置完之后保存。 由于Shadowsocks-GUI For Mac OS已经集成了系统Pac，所以无需任何额外设置，即可畅游互联网啦。

<br>

[**参考**](https://celerysoft.github.io/2016-01-15.html)

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
