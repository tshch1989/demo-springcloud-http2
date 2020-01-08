# demo-springcloud-http2
* 通信使用http2
* 启动后访问
https://localhost:8080/echo.do?msg=111111
* TSL使用的RSA秘钥使用如下方式生成
keytool -genkey -alias tsc-http2 -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -dname "CN=tsc, OU=tsc, O=tsc, L=tsc, ST=tsc, C=CN"

* demo-web使用RestTemplate示例
* demo-web-feign使用FeignClient示例

