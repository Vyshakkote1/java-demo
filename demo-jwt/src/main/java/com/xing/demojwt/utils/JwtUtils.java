package com.xing.demojwt.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Calendar;
import java.util.Map;

public class JwtUtils {
    //鉴权 相当于私钥保存在服务器上
    private  static  final String  secret="##@$%@#S#WS";
    public static  String getToken(Map<String,String> map)
    {
        Calendar instance=Calendar.getInstance();
        //默认七天过期
        instance.add(Calendar.DATE,7);
        //创建JWT
        JWTCreator.Builder builder = JWT.create();
        //payload
        map.forEach((k,v)->{
            builder.withClaim(k,v);//这里放入了敏感信息
        });
        //指定令牌过期时间
        builder.withExpiresAt(instance.getTime());
        String token=builder.sign(Algorithm.HMAC256(secret));
        return token;
    }

    public  static DecodedJWT verify(String token) {
        return  JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
    }
}
