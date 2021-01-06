/**
 * 版权所有 2019 山东新北洋信息技术股份有限公司
 * 保留所有权利。
 */
package com.gs.common.enums;

/**
 * @EnumName : DelayTypeEnum
 * @Description : 枚举描述
 * @Author : gs
 * @Date: 2020-07-02 16:51
 */

public enum DelayTypeEnum {
    DELAY_10s(10, "10s"),
    DELAY_60s(60, "60s");

    private Integer code;
    private String value;

    DelayTypeEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    /**
     * 根据code查询value
     */
    public static String getCodeByValue(Integer code) {
        for (DelayTypeEnum data : DelayTypeEnum.values()) {
            if (data.code.equals(code)) {
                return data.value;
            }
        }
        return code.toString();
    }
}
