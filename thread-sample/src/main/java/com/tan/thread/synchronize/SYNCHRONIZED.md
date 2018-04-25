##方法内变量线程安全？（方法内变量为栈所有，栈是线程私有的内存？）

##实例变量非线程安全？（实例变量为堆所有，堆是线程共享的内存？）

##synchronized锁可重入（类的synchronized方法调用本类的其他synchronized方法是永远可以调用的）

##线程出现异常，锁自动释放（见ThrowExceptionNoLock）。

##同步不具有继承性。同步不可以被继承（见SynchronizedCanBeNotExtends）。

##synchronized可使用場景。
    ###1同步方法。
    ###2同步代码块 