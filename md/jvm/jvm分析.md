## jvm 故障分析及性能优化

#### 使用jstack定位线程堆栈信息

thread dump:    
    主要记录JVM在某一时刻各个线程执行的情况，以栈的形式显示，是一个文本文件。
    通过对thread dump文件可以分析出程序的问题出现在什么地方，
    从而定位具体的代码然后进行修正。thread dump需要结合占用系统资源的线程id进行分析
    才有意义

heap dump:
    主要记录了在某一时刻JVM堆中对象使用的情况，即某个时刻JVM堆的快照，
    是一个二进制文件，主要用于分析哪些对象占用了太大的堆空间，
    从而发现导致内存泄漏的对象。


cpu飙高

1   ps -aux |grep java   查询 Java线程 pid(27984)

2   ps -mp pid -o THREAD,tid,time  找出 占用 cpu 高 的 tid(27998)

3   printf "%x" tid     把 tid 转换成 十六进制  (6d5e)

4   jstack pid | grep tid十六进制 -A 30  eg:  jstack 1 | grep 1 -A 30


//        docker exec -it mine_pool /bin/bash    进入 容器

//        docker-compose up -d --build    构建



生成 thread dump 文件
eg: 线程 id  2576

jstack 1 > /opt/thread/thread.txt   打印线程状态

jmap -heap 1 > /opt/thread/dump.txt  打印 堆栈空间状态


jps     jvm 显示所有虚拟机进程


jstat       收集jvm虚拟机运行数据   

jinfo       显示虚拟机配置信息

jmap        生成 虚拟机内存快照

jhat        JVM HEAP DUMP BROWSER分析heapdump文件 它会简历一个http/html服务器让用户可以在浏览器上查看分析结果

jstack      显示虚拟机线程快照


jps -l     eg: 31405 demo-0.0.1-SNAPSHOT.jar

jstat -gc 31405 250 20    
eg:     参数   每隔250毫秒查询一次 31405 线程id 得垃圾收集情况 收集 20 次

jinfo 31405  eg:  jvm虚拟机参数