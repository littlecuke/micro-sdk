package com.auth.jwt.domain.metadata;

import lombok.Data;

import java.util.concurrent.TimeUnit;

@Data
public class JwtModel {

    private String secretKey;

    private long  expireTime;

    private TimeUnit expireUnit;
}
