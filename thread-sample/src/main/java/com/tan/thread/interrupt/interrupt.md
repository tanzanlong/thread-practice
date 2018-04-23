一般来说中断线程分为三种情况：

(一) ：中断非阻塞线程

(二)：中断阻塞线程

(三)：不可中断线程

(一) ：中断非阻塞线程


##(一) ：中断非阻塞线程
中断非阻塞线程通常有两种方式：

###(1)采用线程共享变量(见InterruptNonBlockedThreadWithVariable)
###(2) 采用中断机制(见InterruptNonBlockedThreadWithVariable)


##(二)：中断阻塞线程(见InterruptBlockedThreadWithInterrupted)

当线程调用Thread.sleep()、Thread.join()、object.wait()再或者调用阻塞的i/o操作方法时，都会使得当前线程进入阻塞状态。那么此时如果在线程处于阻塞状态是调用

interrupt() 方法设置线程中断标志位时会出现什么情况呢！ 此时处于阻塞状态的线程会抛出一个异常，并且会清除线程中断标志位(设置为false)。这样一来线程就能退出

阻塞状态。当然抛出异常的方法就是造成线程处于阻塞状态的Thread.sleep()、Thread.join()、object.wait()这些方法。

##(三)：不可中断线程

有一种情况是线程不能被中断的，就是调用synchronized关键字和reentrantLock.lock()获取锁的过程。

但是如果调用带超时的tryLock方法reentrantLock.tryLock(longtimeout, TimeUnit unit)，那么如果线程在等待时被中断，将抛出一个InterruptedException异常，这是一个非常

有用的特性，因为它允许程序打破死锁。你也可以调用reentrantLock.lockInterruptibly()方法，它就相当于一个超时设为无限的tryLock方法。



