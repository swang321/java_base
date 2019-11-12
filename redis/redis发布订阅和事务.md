# java_basic 

#####   redis发布订阅

创建了订阅频道名为 redisChat:

    subscribe redisChat
    
    

#### 事务

事务是一个单独的隔离操作：事务中的所有命令都会序列化、按顺序地执行。事务在执行的过程中，不会被其他客户端发送来的命令请求所打断。

事务是一个原子操作：事务中的命令要么全部被执行，要么全部都不执行。

    localhost:0>multi
    "OK"
    localhost:0>SET book-name "Mastering C++ in 21 days"
    "QUEUED"
    localhost:0>GET book-name
    "QUEUED"
    localhost:0>SADD tag "C++" "Programming" "Mastering Series"
    "QUEUED"
    localhost:0>SMEMBERS tag
    "QUEUED"
    localhost:0>EXEC
     1)  "OK"
     2)  "Mastering C++ in 21 days"
     3)  "3"
     4)    1)   "Programming"
     2)   "C++"
     3)   "Mastering Series"

* 开始事务。
* 命令入队。
* 执行事务。



