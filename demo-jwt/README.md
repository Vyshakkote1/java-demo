# 使用JWT进行验证

JWT可以理解为一个加密的字符串，里面由三部分组成：头部(Header)、负载(Payload)、签名（signature），由base64加密后的header和payload使用.连接组成的字符串，然后通过header中声明的加密方式进行加盐secret组合加密，然后就构成了JWT字符串，接下来介绍如何在SpringBoot中整合JWT实现登陆注册


- 使用拦截器进拦截请求

```java
public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HashMap<String, String> map=new HashMap<>();
        String token = request.getHeader("token");
        try {
            //如果验证成功放行请求
            DecodedJWT verify = JwtUtils.verify(token);
            return true;
        }
        catch (Exception exception)
        {
            map.put("msg","123456");
        }
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json:charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }
}
```

- 配置拦截器

```java
@Configuration
public class InterceptConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor())
                //拦截的路径 需要进行token验证的路径
                .addPathPatterns("/test/verity")
                //放行的路径
                .excludePathPatterns("/user/login");
    }
}
```

# 延伸

这就是SpringBoot整合JWT实际项目一个大概的流程，但是细节方面secret（私钥）肯定每个用户都是不一样的，这里给写死了，而且私钥得保存在一个安全的地方。包括payload部分不能存放敏感的密码信息等等，还可以进行优化。

