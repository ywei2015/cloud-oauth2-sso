# cloud-oauth2-sso
微服务框架下单点登陆与鉴权，两个项目均采用网关服务集成springSecurity+oauth2.0+jtw机制做单点登陆认证，<br>
不同的是cloud-zuul-oauth2-sso采用zuul网关和oauth2.0授权码模式而cloud-gateway-oauth2-sso采用gateway网关<br>
和oauth2.0用户密码第三方授权模式。在权限方面cloud-zuul-oauth2-sso使用认证服务加载角色权限到token再于网关<br>
服务解析出来，然后与当前路径做比对，cloud-gateway-oauth2-sso则是通过认证服务把权限资源加载到redis。<br>
性能方面cloud-gateway-oauth2-sso使用gateway做网关webflux使用到了netty 做服务器具有更高性能和吞吐量<br>


## zuul-oauth2-sso
主要采用 nacos注册中心 zuul服务网关 openFegin实现RPC负载均衡熔断降级处理 springbootAdmin监控每个服务性能<br>
-admin-server 监控中心 （已与注册中心整合，被监控服务不需要额外配置）<br>
-gateway 网关负载均衡 整合oauth2.0+springbootSecurity+jwt实现单点登陆认证和权限鉴定<br>
-oauth-server 关联数据库登陆认证 token权限管理 自定义登陆页面<br>
-order-server 订单服务<br>
-repertory-server 库存服务<br>
-common 统一返回 统一异常处理 （基于自定义assert枚举类）<br>

## gateway-oauth2-sso
主要采用 nacos注册中心 gateway服务网关<br>
-oauth2-gateway 网关负载均衡 整合oauth2.0+springbootSecurity+jwt实现单点登陆认证和权限鉴定<br>
-oauth2-auth 关联数据库登陆认证 token权限管理 自定义登陆页面<br>
-oauth2-api 测试api服务<br>
