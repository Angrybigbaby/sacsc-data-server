package com.xuelangyun.shangfei.sacsc.core.util;

import org.springframework.beans.BeanUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Beans {

  public static void convert(Object to, Object... froms) {
    if (to == null || froms == null || froms.length == 0) {
      return;
    }
    Stream.of(froms).filter(Objects::nonNull).forEach(from -> copy(to, from));
  }

  public static <T> T convert(Class<T> toClass, Object... froms) {
    if (toClass == null || froms == null) {
      return null;
    }
    if (Stream.of(froms).noneMatch(Objects::nonNull)) {
      return null;
    }
    try {
      T to = toClass.newInstance();
      convert(to, froms);
      return to;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static <T> List<T> convert(Class<T> toClass, Collection<? extends Object> froms) {
    if (toClass == null || froms == null) {
      return Collections.emptyList();
    }
    if (froms.stream().noneMatch(Objects::nonNull)) {
      return Collections.emptyList();
    }
    return froms.stream().map(_from -> convert(toClass, _from)).collect(Collectors.toList());
  }

  private static void copy(Object to, Object from) {
    if (to == null || from == null) {
      return;
    }
    BeanUtils.copyProperties(from, to);
  }
}
