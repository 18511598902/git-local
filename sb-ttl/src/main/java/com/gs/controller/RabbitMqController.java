/**
 * 版权所有 2019 山东新北洋信息技术股份有限公司
 * 保留所有权利。
 */
package com.gs.controller;

import com.gs.common.enums.PayTypeEnum;
import com.gs.sender.DelayMessageSender;
import com.gs.service.PayService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

/**
 * @author : gs
 * @ClassName : RabbitMqController
 * @Description : 类描述
 * @Date: 2020-07-02 16:54
 */

@Slf4j
@RequestMapping("/rabbitmq")
@RestController
public class RabbitMqController {

    @Autowired
    private DelayMessageSender sender;

    @RequestMapping("/sendMsg")
    public void sendMsg(String msg, Integer delayType) {
        log.info("当前时间：{},收到请求，msg:{},delayType:{}", new Date(), msg, delayType);
        sender.sendMsg(msg, delayType);
    }

    @RequestMapping("/okHttpGet")
    public void okHttp() {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url("https://publicobject.com/helloworld.txt")
                .build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/okHttpPost")
    public void okHttpPost(@org.springframework.web.bind.annotation.RequestBody String aaa) {
        String url = "https://www.baidu.com/";
        OkHttpClient okHttpClient = new OkHttpClient();

        RequestBody body = new FormBody.Builder()
                .add("键", "值")
                .add("键", "值")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @author: gs
     * 功能描述: <br>
     * <使用枚举替代if else>
     * @date: 2020/12/23 下午1:11
     * @param: a
     * @return: java.lang.String
     */
    @RequestMapping(value = "/payTest", method = RequestMethod.GET)
    public String payTest(String a) {
        PayTypeEnum payTypeEnum = PayTypeEnum.match(a);
        System.out.println("11111111"+a);
        if (payTypeEnum == null) {
            System.out.println("未知的支付方式");
            return a;
        }
        //new PayService的实现
        PayService payService = payTypeEnum.getPayService();
        //调用qrCode接口
        String b = payService.qrCode(a);
        System.out.println(b);
        return b;
    }

}
