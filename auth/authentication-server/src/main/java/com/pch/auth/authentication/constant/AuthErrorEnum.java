package com.pch.auth.authentication.constant;

import com.pch.common.response.IErrorCode;

/**
 * <P> oauth 错误返回码 </P>
 *
 * @Author: pch
 * @Date: 2021/2/24
 */
public enum AuthErrorEnum implements IErrorCode {

    INVALID_REQUEST("040001", "无效请求"),
    INVALID_CLIENT("040002", "无效client_id"),
    INVALID_GRANT("040003", "无效授权"),
    INVALID_SCOPE("040004", "无效scope"),
    INVALID_TOKEN("040005", "无效token"),
    INSUFFICIENT_SCOPE("040010", "授权不足"),
    REDIRECT_URI_MISMATCH("040020", "redirect url不匹配"),
    ACCESS_DENIED("040030", "拒绝访问"),
    METHOD_NOT_ALLOWED("040040", "不支持该方法"),
    SERVER_ERROR("040050", "权限服务错误"),
    UNAUTHORIZED_CLIENT("040060", "未授权客户端"),
    UNAUTHORIZED("040061", "未授权"),
    UNSUPPORTED_RESPONSE_TYPE("040070", " 支持的响应类型"),
    UNSUPPORTED_GRANT_TYPE("040071", "不支持的授权类型");

    /**
     * 错误类型码
     */
    private String code;
    /**
     * 错误类型描述信息
     */
    private String msg;

    AuthErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
