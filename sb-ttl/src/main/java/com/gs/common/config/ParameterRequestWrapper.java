/**
 * 版权所有 2019 山东新北洋信息技术股份有限公司
 * 保留所有权利。
 */
package com.gs.common.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author : gs
 * @ClassName : ParameterRequestWrapper
 * @Description : 类描述
 * @Date: 2021-01-05 20:18
 */

public class ParameterRequestWrapper extends HttpServletRequestWrapper {
    private Map<String , String[]> params = new HashMap<>();

    public ParameterRequestWrapper(HttpServletRequest request) {
        // 将request交给父类，以便于调用对应方法的时候，将其输出，其实父亲类的实现方式和第一种new的方式类似
        super(request);
        //将参数表，赋予给当前的Map以便于持有request中的参数
        Map<String, String[]> requestMap=request.getParameterMap();
        this.params.putAll(requestMap);
    }
    /**
     * 重写getInputStream方法  post类型的请求参数必须通过流才能获取到值
     */
    @Override
    public ServletInputStream getInputStream() throws IOException {
        // 非json类型，直接返回
        if(!super.getHeader(HttpHeaders.CONTENT_TYPE).equalsIgnoreCase(MediaType.APPLICATION_JSON_VALUE)){
            return super.getInputStream();
        }
        //为空，直接返回
        String json = IOUtils.toString(super.getInputStream(), "utf-8");
        if (StringUtils.isEmpty(json)) {
            return super.getInputStream();
        }
        Map<String,Object> map = JSON.parseObject(json.trim());
        dealMap(map);
        ByteArrayInputStream bis = new ByteArrayInputStream(JSON.toJSONString(map).getBytes("utf-8"));
        return new MyServletInputStream(bis);
    }

    private void dealMap( Map<String,Object> map ){
        Set<String> set = map.keySet();
        Iterator<String> it=set.iterator();
        // 将parameter的值去除空格后重写回去
        while(it.hasNext()){
            String key= it.next();
            Object values = map.get(key);
            if (values instanceof String) {
                values = ((String) values).trim();
            }else if (values instanceof JSONArray){
                JSONArray json = (JSONArray) values;
                if(!json.isEmpty()){
                    for(int i=0;i<json.size();i++){
                        JSONObject job = json.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                        delJSONObject(job);
                    }
                }
            }
            map.put(key, values);
        }
    }
    private void delJSONObject(JSONObject jsonObject){
        Iterator<Map.Entry<String, Object>> iterator = jsonObject.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Object> entry =  iterator.next();
            String key = entry.getKey();
            Object values = entry.getValue();
            if (values instanceof String) {
                values = ((String) values).trim();
            }
            jsonObject.put(key, values);
        }
    }

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("k1","v1");
        Iterator<Map.Entry<String, Object>> iterator = jsonObject.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Object> entry =  iterator.next();
            entry.getValue();
            entry.getKey();
        }


    }
    /**
     * 重写getParameter 参数从当前类中的map获取
     */
    @Override
    public String getParameter(String name) {
        String[]values = params.get(name);
        if(values == null || values.length == 0) {
            return null;
        }
        return values[0];
    }
    /**
     * 重写getParameterValues
     */
    public String[] getParameterValues(String name) {//同上
        return params.get(name);
    }

    class MyServletInputStream extends  ServletInputStream{
        private ByteArrayInputStream bis;
        public MyServletInputStream(ByteArrayInputStream bis){
            this.bis=bis;
        }
        @Override
        public boolean isFinished() {
            return true;
        }

        @Override
        public boolean isReady() {
            return true;
        }

        @Override
        public void setReadListener(ReadListener listener) {
            //
        }
        @Override
        public int read() {
            return bis.read();
        }
    }
}
