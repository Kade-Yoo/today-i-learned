# Redis Cluster 구성해본 후기

## Redis Cluster 구성한 이유
- 거창하게 구성한 후기라고 표현을 했지만 사실 Redis Cluster구성이 딱 Master, Slave 쌍이 3개 있었다
- 적용을 마음먹었던 이유는 회사에서 node.js의 ioredis 라이브러리를 사용하여 redis 접근을 하는데 slot이 부족한 이슈가 발생했다.
- 구글을 통해 서칭해본 것과 구성되어 있는 AWS ElastiCache Redis의 Slot을 확인해본 결과 Master에 xx개 Slave에 xx개로 이루어져 있었다
- 지금까지는 Master의 Slot만을 사용하도록 되어 있어 가용한 Slot이 실제론 Slave까지 xx개이지만 접근이 Master로만 되어 있기 때문에
- 접근 가능한 Slot은 사실상 Master의 Slot뿐이었다.
- 그렇다면 이슈를 해결하기 위해선 Master와 Slave 각 Slot을 적절하게 분배하도록 구성하면 될 것이다.
- 그 방법이 Redis Cluster이다.
- Redis Cluster로 구성할 경우 write는 Master로 read는 Slave Node로 붙게 된다.

## Redis Cluster 구성
- Master, Slave 쌍 3개(총 Node 수 : 6개) -> 서로 다른 포트에서 Node 동작
- port : 7000, 7001, 7002, 7003, 7004, 7005(각 포트별로 실행할 redis.conf 파일 셋팅)
### redis.conf
```
port 7000                                       -- port 설정
daemonize yes                                   -- background 실행 여부
logfile /Users/kdae/cluster/7000/log_7000       -- log file 경로
cluster-enabled yes                             -- cluster 사용 여부
cluster-config-file nodes.conf                  -- cluster 설정 파일
cluster-node-timeout 3000                       -- cluster node timeout 설정
appendonly yes                                  -- 스냅샷과 같은 append-only-file을 만드는 설정
dir /Users/kade/cluster/7000                    -- 디렉토리 위치
```

### redis node 실행
```
redis-server {path}/redis.conf
```

### Cluster master, slave 생성
```
redis-server --cluster mode 127.0.0.1:7000 127.0.0.1:7001 127.0.0.1:7002 127.0.0.1:7003
127.0.0.1:7004 127.0.0.1:7005 --cluster-replica 1
```

### Cluster slave node 추가
```
redis-server --cluster add-node 127.0.0.1:7006 127.0.0.1:7000 --cluster-slave --cluster-master-id {id}
```