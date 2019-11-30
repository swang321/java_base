import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author whh  2019/11/20 16:14
 */
public class AQSTest extends AbstractQueuedSynchronizer {

    protected AQSTest() {
        super();
    }

    @Override
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }

    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);
    }

    @Override
    protected int tryAcquireShared(int arg) {
        return super.tryAcquireShared(arg);
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
        return super.tryReleaseShared(arg);
    }

    @Override
    protected boolean isHeldExclusively() {
        return super.isHeldExclusively();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
