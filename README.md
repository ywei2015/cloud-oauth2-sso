# cloud-oauth2-sso
微服务框架下单点登陆与鉴权，两个项目均采用网关服务集成springSecurity+oauth2.0+jtw机制做单点登陆认证，<br>
不同的是cloud-zuul-oauth2-sso采用zuul网关和oauth2.0授权码模式而cloud-gateway-oauth2-sso采用gateway网关<br>
和oauth2.0用户密码第三方授权模式。在权限方面cloud-zuul-oauth2-sso使用认证服务加载角色权限到token再于网关<br>
服务解析出来，然后与当前路径做比对，cloud-gateway-oauth2-sso则是通过认证服务把权限资源加载到redis。<br>
性能安全方面cloud-gateway-oauth2-sso使用webflux具有更高性能和吞吐量，授权模式采用账号密码模式会将appId和<br>
appSecret暴露在客户端，所以cloud-gateway-oauth2-sso适合微信和APP场景应用，cloud-zuul-oauth2-sso适合做传统web场景应用。<br>

## cloud-zuul-oauth2-sso
主要采用 nacos注册中心 zuul服务网关 openFegin实现RPC负载均衡熔断降级处理 springbootAdmin监控每个服务性能<br>
-admin-server 监控中心<br>
-gateway 网关负载均衡 整合oauth2.0+springbootSecurity+jwt实现单点登陆认证和权限鉴定<br>
-oauth-server 关联数据库登陆认证 token权限管理 自定义登陆页面<br>
-order-server 订单服务<br>
-repertory-server 库存服务<br>

## cloud-gateway-oauth2-sso
主要采用 nacos注册中心 gateway服务网关<br>
-oauth2-gateway 网关负载均衡 整合oauth2.0+springbootSecurity+jwt实现单点登陆认证和权限鉴定<br>
-oauth2-auth 关联数据库登陆认证 token权限管理 自定义登陆页面<br>
-oauth2-api 测试api服务<br>
