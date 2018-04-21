ehcache :

sample:


C10K:http://www.cocoachina.com/bbs/read.php?tid-1705273.html

https://www.oschina.net/translate/c10k

http://www.runoob.com/memcached/window-install-memcached.html


windows安装
sc create "Memcached11211" binPath= "D:\tools\memcache\memcached-amd64\memcached.exe -d runservice -p 11211" DisplayName= "Memcached11211" start= auto

D:\tools\memcache\memcached-amd64D:\tools\memcache\memcached-amd64\memcached.exe -d install


schtasks /create /sc onstart /tn memcached /tr "'D:\tools\memcache\memcached-amd64\memcached.exe' -m 512"

我们可以通过使用 "c:\memcached\memcached.exe -h" 命令查看更多的参数配置。



