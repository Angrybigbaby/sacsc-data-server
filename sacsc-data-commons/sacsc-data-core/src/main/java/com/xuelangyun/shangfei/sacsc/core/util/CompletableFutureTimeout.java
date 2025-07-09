package com.xuelangyun.shangfei.sacsc.core.util;

import java.util.concurrent.*;
import java.util.function.BiConsumer;

/**
 * @author zijian.qjd
 * @since 2023/8/4 10:28
 */
public class CompletableFutureTimeout {

  public static <T> CompletableFuture<T> orTimeout(
      CompletableFuture<T> future, long timeout, TimeUnit unit) {
    if (null == unit) {
      throw new NullPointerException();
    }
    if (null == future) {
      throw new NullPointerException();
    }
    if (future.isDone()) {
      return future;
    }

    return future.whenComplete(new Canceller(Delayer.delay(new Timeout(future), timeout, unit)));
  }

  static final class Timeout implements Runnable {
    final CompletableFuture<?> f;

    Timeout(CompletableFuture<?> f) {
      this.f = f;
    }

    public void run() {
      if (f != null && !f.isDone()) {
        f.completeExceptionally(new TimeoutException());
      }
    }
  }

  static final class Canceller implements BiConsumer<Object, Throwable> {
    final Future<?> f;

    Canceller(Future<?> f) {
      this.f = f;
    }

    public void accept(Object ignore, Throwable ex) {
      if (ex == null && f != null && !f.isDone()) {
        f.cancel(false);
      }
    }
  }

  static final class Delayer {
    static ScheduledFuture<?> delay(Runnable command, long delay, TimeUnit unit) {
      return delayer.schedule(command, delay, unit);
    }

    static final class DaemonThreadFactory implements ThreadFactory {
      public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        t.setName("CompletableFutureDelayScheduler");
        return t;
      }
    }

    static final ScheduledThreadPoolExecutor delayer;

    static {
      (delayer = new ScheduledThreadPoolExecutor(1, new DaemonThreadFactory()))
          .setRemoveOnCancelPolicy(true);
    }
  }
}
