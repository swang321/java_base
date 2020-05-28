# java_basic 

# java_nio

JAVA NIO: channel and buffers
    
    标准的io基于字节流和字符流操作，nio基于通道和缓冲区操作，nio模式 
    数据总是从通道读取到缓冲区，或者从缓冲区写入到通道中

java nio non-blocking io（非阻塞io）

java nio selectors（选择器）

    选择器用于监听多个通道的事件，（）单个线程可以监听多个数据通道
    所有channel通道都需要注册到selectors中  
    
selectors 监听四种类型事件

    connect
    accept
    read
    write
    
这四种事件用SelectionKey的四个常量来表示

    SelectionKey.OP_CONNECT
    SelectionKey.OP_ACCEPT
    SelectionKey.OP_READ
    SelectionKey.OP_WRITE


NIO 核心部分

    Channels
    Buffers
    Selectors

使用Buffer读写数据一般遵循以下四个步骤：

    写入数据到Buffer
    调用flip()方法          需要通过flip()方法将Buffer从写模式切换到读模式。在读模式下，可以读取之前写入到buffer的所有数据。
    从Buffer中读取数据
    调用clear()方法或者compact()方法            有两种方式能清空缓冲区：调用clear()或compact()方法
     