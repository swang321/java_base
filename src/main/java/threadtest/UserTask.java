package threadtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author whh
 */
public class UserTask implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(UserTask.class);

    private User user;

    public UserTask(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        log.info(Thread.currentThread().getName() + "user:[{}]", user.toString());
    }
}
