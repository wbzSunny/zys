package com.lzqs.zhangyushu.commomConstant;


import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 通用的返回类
 **/
public class ReturnMessage implements Serializable {
    //状态码 100-成功，200-失败
    private int code;
    //提示信息
    private String msg;
    //用户要返回给浏览器的数据
    private Map<String, Object> data = new LinkedHashMap<>();



    public static ReturnMessage success() {
        ReturnMessage result = new ReturnMessage();
        result.setCode(100);
        result.setMsg("成功");
        return result;
    }

    public static ReturnMessage fail() {
        ReturnMessage result = new ReturnMessage();
        result.setCode(200);
        result.setMsg("系统错误");
        return result;
    }

    public static ReturnMessage failWithMsg(String newmsg) {
        ReturnMessage result = new ReturnMessage();
        result.setCode(400);
        result.setMsg(newmsg);
        return result;
    }


    /**
     * 失败 + 自定义msg,缺省为"处理失败"
     *
     * @param newmsg
     * @return
     */
    public static ReturnMessage failWithMsg(int code, String newmsg) {
        ReturnMessage result = new ReturnMessage();
        result.setCode(code);
        if (StringUtils.isEmpty(newmsg)) {
            newmsg = "处理失败";
        }
        result.setMsg(newmsg);
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public ReturnMessage add(String key, Object value) {
        this.getData().put(key, value);
        return this;
    }
}
