/**
 * 版权所有 2019 山东新北洋信息技术股份有限公司
 * 保留所有权利。
 */
package com.gs.service.impl;

import com.gs.service.PayService;
import org.springframework.stereotype.Service;

/**
 * @author : gs
 * @ClassName : AliPayServiceImpl
 * @Description : 类描述
 * @Date: 2020-12-23 09:42
 */
@Service
public class AliPayServiceImpl implements PayService {
    @Override
    public String qrCode(String a) {
        System.out.println("aliPayService");
        return a;
    }
}
