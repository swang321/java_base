### java_basic   mysql

#### innodb存储引擎
    
    
    
    SHOW ENGINES  # 查询各个存储引擎信息
    SHOW STATUS   #
    
可配置

    SHOW VARIABLES LIKE "innodb_buffer_pool_size"   #  缓冲池的大小
    SHOW VARIABLES LIKE "innodb_buffer_pool_instances"   #  缓冲池的个数