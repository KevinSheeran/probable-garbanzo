package com.kevincode;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * User: kevin.xie<br/>
 * Date: 08/07/2020<br/>
 * Time: 18:09<br/>
 */
public class DemoTest {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        Map header = new HashMap();
        header.put("mcpTerminalId", "1000111");
        Map data = new HashMap();
        data.put("currency", "SGD");
        map.put("header", header);
        map.put("data", data);
        String out = JSON.toJSONString(map);
        System.out.println(out);
    }
}
