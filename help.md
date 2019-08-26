类注释模板

*
 * @Author  $user$
 * @Description //TODO $end$
 * @Date $time$ $date$
 * @Param $param$
 * @return $return$
 **/
 
 
 
 公共包放入私服命令
 mvn install:install-file -DgroupId=com.zdzc -DartifactId=zdzc-common -Dversion=1.0-SNAPSHOT -Dpackaging=jar -Dfile=zdzc-common-1.0-SNAPSHOT.jar
 
 注册中心集群jar 包启动命令
 
 java -jar zdzc-eureka-1.0-SNAPSHOT.jar --spring.profiles.active=peer1
 
 java -jar zdzc-eureka-1.0-SNAPSHOT.jar --spring.profiles.active=peer2
 
 java -jar zdzc-eureka-1.0-SNAPSHOT.jar --spring.profiles.active=peer3
 
 

