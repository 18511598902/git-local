/**
 * 版权所有 2019 山东新北洋信息技术股份有限公司
 * 保留所有权利。
 */
package com.gs.common.enums;

import com.gs.service.PayService;
import com.gs.service.impl.AliPayServiceImpl;
import com.gs.service.impl.WxPayServiceImpl;

/**
 * @EnumName : PayTpeyEnum
 * @Description : 枚举描述
 * @Author : gs
 * @Date: 2020-12-23 09:40
 */

public enum PayTypeEnum {

    WX("wx", new WxPayServiceImpl()),
    ALI("ali", new AliPayServiceImpl());

    private String name;

    private PayService payService;

    PayTypeEnum(String name, PayService payService) {
        this.name = name;
        this.payService = payService;
    }

    public String getName() {
        return name;
    }

    public PayService getPayService() {
        return payService;
    }

    public static PayTypeEnum match(String name) {
        PayTypeEnum[] values = PayTypeEnum.values();
        for (PayTypeEnum value : values) {
            if (value.name.equals(name)) {
                return value;
            }
        }
        return null;
    }
}
