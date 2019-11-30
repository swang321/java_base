# java_basic 

#####   redis 数据类型

string（字符串）
    
    SET name "w3cschool.cn"          
    OK
    GET name
    w3cschool.cn

hash（哈希）

    HMSET user:1 username w3cschool.cn password w3cschool.cn
    OK
    HGETALL user:1
    1) "username"
    2) "w3cschool.cn"
    3) "password"
    4) "w3cschool.cn"
    5) "points"
    6) "200"
    
list（列表）

    lpush w3cschool.cn redis
    (integer) 1
    lpush w3cschool.cn mongodb
    (integer) 2
    lrange w3cschool.cn 0 10
    1) "mongodb"
    2) "redis"

set（集合） 集合是通过哈希表实现的，所以添加，删除，查找的复杂度都是O(1)。
    
    添加一个string元素到,key对应的set集合中，成功返回1,如果元素以及在集合中返回0,
    key对应的set不存在返回错误

    sadd w3cschool.cn redis
    1
    sadd w3cschool.cn mongodb
    1
    sadd w3cschool.cn mongodb
    0
    smembers w3cschool.cn
    1)  "mongodb"
    2)  "redis"
    
    
    
zset(sorted set：有序集合)

    zadd w3cschool.cn 0 redis
    1
    zadd w3cschool.cn 0 mongodb
    1
    zrangebyscore w3cschool.cn 0 1000
    1)  "mongodb"
    2)  "redis"





















