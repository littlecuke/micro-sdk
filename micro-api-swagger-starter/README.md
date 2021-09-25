# swagger


#### yml配置文件配置

```
micro:
  swagger3:
    enable: true
    title: "title"
    description: "description"
    version: "1.0.0"
    contact:
      developer: "auth-xx"
      url: "https://www.xxx.com/"
      email: "auth-xx@company.com"
```

####安全框架放行
```
@Override
public void configure(WebSecurity web) throws Exception {
    //忽略swagger3所需要用到的静态资源，允许访问
    web.ignoring().antMatchers( "/swagger-ui.html",
            "/swagger-ui/**",
            "/swagger-resources/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/webjars/**");
}
```
