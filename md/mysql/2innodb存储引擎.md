### java_basic   mysql

#### innodb存储引擎
    
    
    
    SHOW ENGINES  # 查询各个存储引擎信息
    SHOW STATUS   #
    
可配置

    SHOW VARIABLES LIKE "innodb_buffer_pool_size"   #  缓冲池的大小
    SHOW VARIABLES LIKE "innodb_buffer_pool_instances"   #  缓冲池的个数
    
#### innodb 关键特性

插入缓冲

两次写

自适应哈希索引

异步io

刷新邻接页

