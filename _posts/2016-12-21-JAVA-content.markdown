---
layout: post
title:  "关于在JAVA下的文本文件读写问题"
date:   2017-02-03 23:50:00
categories: main
---

	这两天被读写文本文件给弄伤了，怎么调都有问题，其实读写无非就是用Reader和Writer下的类进行操作，但是我想边读边写一个文本文件，以实现近修改文本文件中的部分行，但就是不停出错。今天终于发现问题就出来“边读边写同一个文件”这里，首先给出一个正确操作的代码：
<br>
```Java
inputStream = Settings.class.getClass().getResourceAsStream(FILEPATH);
reader = new BufferedReader(new InputStreamReader(inputStream,"GBK"));
while ((read = reader.readLine()) != null) {
content.add(read);
}
reader.close();
outputStream = new FileOutputStream(file);
writer = new PrintWriter(outputStream);
for (String s : content){
if (s.startsWith(name)){
writer.println(name + " = " + value);
}
else
writer.println(s);
}
writer.close();
```
<br>
	可以注意到的是，对于同一个文件File，reader和writer同时只能够开启一个，所以边读边写这种方式肯定是会出错的，正确的方式应该是先读取文件内容到自定义的数据结构中，在关闭reader之后，再通过对之前存储下来的文本内容进行判断，然后重新覆盖回写，同时注意，PrintWriter是属于字符型的writer，会有一个缓冲区，所以在执行完写入命令后，需要通过close()命令来真正实现对文件的写入（或者是flush()）。



