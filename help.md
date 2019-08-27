1.类注释模板参考
*
 * @Author  $user$
 * @Description //TODO $end$
 * @Date $time$ $date$
 * @Param $param$
 * @return $return$
 **/
 
2.公共包放入私服命令
 mvn install:install-file -DgroupId=com.zdzc -DartifactId=zdzc-common -Dversion=1.0-SNAPSHOT -Dpackaging=jar -Dfile=zdzc-common-1.0-SNAPSHOT.jar
 
 
3.注册中心集群jar 包启动命令
 
 java -jar zdzc-eureka-1.0-SNAPSHOT.jar --spring.profiles.active=peer1
 
 java -jar zdzc-eureka-1.0-SNAPSHOT.jar --spring.profiles.active=peer2
 
 java -jar zdzc-eureka-1.0-SNAPSHOT.jar --spring.profiles.active=peer3
 
 
 
 
4.项目启动顺序：

注册中心（eureka）----配置中心（config）----服务端 （service） ---- 客户端 （client）
 
 
5.刷新配置文件接口
  http://ip:端口/actuator/refresh     
  在@RefreshScope （这个注解声明了刷新配置的范围，如果使用config配置类的话，就声明到配置类上即可)注解下的配置，可生效
  
  例如：基础服务的service 刷新配置文件 http://localhost:8090/actuator/refresh
  
6.日志配置
  
  日志配置放在git 上 springcloud-config项目服务中，logger.xml 中可配置文件大小以及生成规则。
  
 


