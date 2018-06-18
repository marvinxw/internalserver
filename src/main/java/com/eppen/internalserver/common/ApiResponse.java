package com.eppen.internalserver.common;


import lombok.Data;

import java.io.Serializable;

@Data
public class ApiResponse<T> implements Serializable {

    public static final Integer OK = 1;
    public static final Integer ERROR = -1;

    private Integer code;

    private String msg;

    private T data;

}
