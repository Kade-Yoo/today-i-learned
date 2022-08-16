# 동시성 제어
## ThreadLocal
- ThreadLocal을 사용할 시 저장공간을 분리하여 동시성을 제어할 수 있다.

### ThreadLocalMap
- ThreadLocalMap is a customized hash map suitable only for maintaining thread local values. No operations are exported outside of the ThreadLocal class. The class is package private to allow declaration of fields in class Thread. To help deal with very large and long-lived usages, the hash table entries use WeakReferences for keys. However, since reference queues are not used, stale entries are guaranteed to be removed only when the table starts running out of space.
- ThreadLocalMap은 Hash Map을 thread local 변수들을 유지하기 적합하게 커스터마이징한 것이다.
- ThreadLocal class의 작업을 외부로 노출시키지 않는다.
- ThreadLocal class는 클래스내에 Thread 클래스의 필드 선언을 허용하는 프라이빗 패키이다
- 매우 크고 긴 사이클 사용성을 다루는 것을 돕기 위해, hash table 엔트리들은 WeakReference를 사용한다.
- 그러나 참조 큐들이 사용되지 않았을 때, 테이블 공간이 부족할 때만 삭제시킨다.

### ThreadLocal set method
- Thread.currentThread() 호출
- Thread.threadLocals 반환
- ThreadLocalMap이 존재할 경우
  - map에 this key와 value를 이용하여 저장
- ThreadLocalMap이 존재하지 않을 경우
  - 신규 ThreadLocalMap을 생성

### ThreadLocal get method
- Thread.currentThread() 호출
- Thread.threadLocals 반환
- ThreadLocalMap이 null이 아니면서 현재 객체로 조회한 map의 값이 없을 때 =>
    - 입력받은 Generic반환 값으로 반환
- ThreadLocalMap이 null이 아니면서 현재 객체로 조회한 map값이 존재할 때
    - 입력받은 Generic값에 입력받은 값을 셋팅

## 동시성 제어 테스트
### ThreadLocal을 사용하지 않았을 때
- 동시성이 발생하는 경우

![](./src/img/StoreServiceO.png)

- 동시성이 발생하지 않는 경우

![](./src/img/StoreServiceX.png)

### ThreadLocal을 사용 했을 때
- 동시성이 발생하는 경우

![](./src/img/ThreadLocalStoreServiceO.png)

- 동시성이 발생하지 않는 경우

![](./src/img/ThreadLocalStoreServiceX.png)