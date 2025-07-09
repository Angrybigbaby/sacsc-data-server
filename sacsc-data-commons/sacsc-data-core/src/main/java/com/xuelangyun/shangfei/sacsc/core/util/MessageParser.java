package com.xuelangyun.shangfei.sacsc.core.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageParser {

  private String event;

  private Object data;

  public static JSONObject parse(String event, Object data) {
    return new MessageParser(event, data).parser();
  }

  public JSONObject parser() {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put(
        event, data != null ? JSON.toJSONString(data, SerializerFeature.WriteMapNullValue) : "");
    return jsonObject;
  }
}
