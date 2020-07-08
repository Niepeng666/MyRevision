package com.bianhua.com.http;

import com.bianhua.com.Utils.exception.ApiException;
/**
 * @author bianhua`
 * @date 2020/07/08
 * qq:2241659414
 */
public interface DataCall<T> {

    void success(T data, Object... args);
    void fail(ApiException data, Object... args);


}
