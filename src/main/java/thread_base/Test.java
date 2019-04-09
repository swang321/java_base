package thread_base;

import javax.xml.transform.Result;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author whh
 */
public class Test {

    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock();

        Map map = new HashMap(16);

        


    }

    void solve(Executor e, Collection<Callable<Result>> solvers) throws InterruptedException, ExecutionException {
        CompletionService<Result> ecs = new ExecutorCompletionService<Result>(e);
        for (Callable<Result> s : solvers) {
            ecs.submit(s);
        }
        int n = solvers.size();
        for (int i = 0; i < n; ++i) {
            Result r = ecs.take().get();
            if (r != null) {
                System.out.println(r);
            }
        }
    }


}



