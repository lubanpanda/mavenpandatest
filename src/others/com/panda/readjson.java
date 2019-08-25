package com.panda;
/**
 * @author panda   84305510@qq.com
 * @date 2019-06-23 11:03
 */

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class readjson {
    public static void main(String[] args) {

        JsonObject object = new JsonObject();
        object.addProperty("cat", "it");

        JsonArray array = new JsonArray();

        JsonObject lan1 = new JsonObject();
        lan1.addProperty("id", 1);
        lan1.addProperty("name", "java");
    }
}