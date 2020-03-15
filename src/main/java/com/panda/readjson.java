package com.panda;
/**
 * @author panda   84305510@qq.com
 * @date 2019-06-23 11:03
 */

import java.io.UnsupportedEncodingException;

public class readjson {
    public static void main(String[] args) throws UnsupportedEncodingException {

//        JsonObject object = new JsonObject();
//        object.addProperty("cat", "it");
//
//        JsonArray array = new JsonArray();
//
//        JsonObject lan1 = new JsonObject();
//        lan1.addProperty("id", 1);
//        lan1.addProperty("name", "java");
		String[] info = {"nishuo,woshuo"};
		for (int i = 0; i < info.length; i++) {
			System.out.println(info[i]);
		}
		String a = "你好hello";
		int b = a.getBytes("GBK").length;
		int c = String.valueOf(255).getBytes("GBK").length;
		System.out.println(b + "<<<>>>" + c);
	}
}