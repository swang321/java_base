package thread_base.thread_pool;

import java.util.concurrent.RecursiveTask;

/**
 * @Author whh
 */
public class CountTask extends RecursiveTask<Integer> {

    // 分割
    private static final int THRESHOLE = 2;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        int sum = 0;
        boolean canCompute = (end - start) <= THRESHOLE;
        if (canCompute) {
            for (int i = start; i < end; i++) {
                sum += i;
            }
        } else {
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle, end);
            leftTask.fork();
            rightTask.fork();

            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            sum = leftResult + rightResult;
        }
        return sum;
    }
}
