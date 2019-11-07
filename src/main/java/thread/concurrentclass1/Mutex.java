package thread.concurrentclass1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author whh
 */
public class Mutex implements Lock, Serializable {

    // 继承AQS的静态内存类 重写方法

    private static class Sync extends AbstractQueuedSynchronizer {

        protected boolean isHeldExculusively() {
            return getState() == 1;
        }

        @Override
        protected boolean tryAcquire(int auquires) {
            assert auquires == 1;
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        /**
         * Releases the lock by setting state to zero
         */
        @Override
        protected boolean tryRelease(int releases) {
            assert releases == 1;
            if (getState() == 1) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        /**
         * Provides a Condition
         */
        Condition newCondition() {
            return new ConditionObject();
        }

        /**
         * Deserializes properly
         */
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            // reset to unlocked state
            setState(0);
        }

    }

    private final Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
