package com.xuelangyun.shangfei.sacsc.core.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author dengwei
 * @date 2023/5/31 15:53
 * @description 1.0
 */
public class ThreadPoolUtil {

    private static final ScheduledThreadPoolExecutor poolExecutor =
            new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() + 1);


    public static void schedule(Runnable command, long delay, TimeUnit unit) {
        poolExecutor.schedule(command, delay, unit);
    }

    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
        return poolExecutor.schedule(callable, delay, unit);
    }
}
