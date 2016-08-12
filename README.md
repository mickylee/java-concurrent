# java-concurrent

`java concurrent api demo`

### Semaphore和Exchanger类的使用

Semaphore

   	用于控制对某资源访问的同一时间的并发量。

    semaphore.tryAcquire():尝试获取，不阻塞
    semaphore.acquire():没信号量可用时，将进行阻塞等

    semaphore.release():
    	线程抛出各种异常，都别忘了在finally中释放信号量；
    	如果释放的比获取的信号量还多，例如获取了2个，释放了5次，那么当前信号量就动态的增加为5了，要注意。

### 工具类CountDownLatch和CyclicBarrier

### Phaser类

### Executor接口和ThreadPoolExecutor线程池

### Future和Callable的使用

### CompletionService的使用

### ExecutorService接口

### ScheduledExecutorService的使用

### Fork-Join分治编程

### 并发集合框架

