# java_basic 

# bio

一请求一线程BIO ----- 同步阻塞I/O
    
    BioSocketClient.java 和 BioSocketServer.java 两个类 演示   bio通信模型1.jpg  模型



1个或多个线程处理N个客户端的模型  

    BioSocketServerThreadPool.java 和 BioSocketClient.java 演示  
    伪异步io模型(实质还是 同步阻塞io).jpg 模型
    
    在 Socket socket = serverSocket.accept(); 处打了断点，有20个客户端同时发出请求，
    可服务端还是一个一个的处理，其它线程都处于阻塞状态
    
    
 
阻塞IO 和 非阻塞IO


    这两个概念是程序级别的。主要描述的是程序请求操作系统IO操作后，如果IO资源没有准备好，
    那么程序该如何处理的问题：前者等待；后者继续执行（并且使用线程一直轮询，直到有IO资源准备好了）


同步IO 和非同步IO

    这两个概念是操作系统级别的。主要描述的是操作系统在收到程序请求IO操作后，如果IO资源没有准备好，
    该如何处理相应程序的问题：前者不响应，直到IO资源准备好以后；
    后者返回一个标记（好让程序和自己知道以后的数据往哪里通知），当IO资源准备好以后，再用事件机制返回给程序。
    
# nio

    目前流程的多路复用IO实现主要包括四种：select、poll、epoll、kqueue



IO模型	| 相对性能	| 关键思路|操作系统 |	JAVA支持情况 |
------| -------|------|------|------|
select |	较高 |	Reactor|	windows/Linux |	支持,Reactor模式(反应器设计模式)。Linux操作系统的 kernels 2.4内核版本之前，默认使用select；而目前windows下对同步IO的支持，都是select模型
poll |	较高 |	Reactor|	Linux|	Linux下的JAVA NIO框架，Linux kernels 2.6内核版本之前使用poll进行支持。也是使用的Reactor模式
epoll |	高	| Reactor/Proactor|	Linux|	Linux kernels 2.6内核版本及以后使用epoll进行支持；Linux kernels 2.6内核版本之前使用poll进行支持；另外一定注意，由于Linux下没有Windows下的IOCP技术提供真正的 异步IO 支持，所以Linux下使用epoll模拟异步IO
kqueue |	高 |	Proactor Linux|	目前JAVA的版本不支持	|


#### 多路复用IO的优缺点

    1   不用再使用多线程来进行IO处理了（包括操作系统内核IO管理模块和应用程序进程而言）。当然实际业务的处理中，应用程序进程还是可以引入线程池技术的
    2   同一个端口可以处理多种协议，例如，使用ServerSocketChannel测测的服务器端口监听，既可以处理TCP协议又可以处理UDP协议。
    3   操作系统级别的优化：多路复用IO技术可以是操作系统级别在一个端口上能够同时接受多个客户端的IO事件。
    同时具有之前我们讲到的阻塞式同步IO和非阻塞式同步IO的所有特点。Selector的一部分作用更相当于“轮询代理器”。
    4   都是同步IO：目前我们介绍的阻塞式IO、非阻塞式IO甚至包括多路复用IO，这些都是基于操作系统级别对“同步IO”的实现。
    我们一直在说“同步IO”，一直都没有详细说，什么叫做“同步IO”。实际上一句话就可以说清楚：只有上层（包括上层的某种代理机制）
    系统询问我是否有某个事件发生了，否则我不会主动告诉上层系统事件发生了
