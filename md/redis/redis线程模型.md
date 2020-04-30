# java_basic 

#####   redis线程模型


    redis基于reactor模式开发了网络事件处理器，这个处理器叫做文件事件处理器，
    file event handler这个文件事件处理器，是单线程的，redis才叫做单线程的模型


文件事件处理器:
    
    多个socket
    IO多路复用程序
    文件事件分派器
    事件处理器（命令请求处理器、命令回复处理器、连接应答处理器，等等）

