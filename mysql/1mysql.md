### java_basic   mysql

#### 存储引擎


##### InnoDB 存储引擎

支持事务 行锁设计 外键

##### MyISAM 存储引擎

不持支事务 表锁设计 支持全文索引

##### NDB 存储引擎

##### Memory 存储引擎  （之前称 heap 存储引擎）  讲表中的数据存放在内存中

##### Archive 存储引擎  只支持 insert 和 select

##### Federated 存储引擎  不存放数据，指向一台远程mysql数据库服务器

##### Maria 存储引擎  不存放数据，指向一台远程mysql数据库服务器


##### mysql连接方式

    tcp/ip
    命名管道和共享内存   （win）
    unix域套接字         （linux/unix）
    