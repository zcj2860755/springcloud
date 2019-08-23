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
 
 
 
 
 SELECT
 	b.contacts,
 	b.phone,
 	b.equip_model,
 	b.id,
 	b.area_id,
 	b.equip_code,
 	b.address,
 	max(sd.upload_time) AS alarm_time,
 	a.telephone,
 	count(sd.alarm_id) AS remind_times,
 	s.label AS alarmType,
 	u.nickname,
 	u.telephone
 FROM
 	equip_info b
 LEFT JOIN amp_alarm_info a ON a.equip_id = b.equip_code
 LEFT JOIN sensor_data sd ON a.alarm_id = sd.alarm_id
 LEFT JOIN sys_area_user c ON c.area_id = b.area_id
 LEFT JOIN user_info u ON u.id = c.user_id
 LEFT JOIN sys_dict s ON s.`value` = a.alarm_type
 AND s.type = 'amp_monitor_type'
 WHERE
 	b.equip_code = '865820030132703'
 AND b.del_flag = '0'
 AND a.alarm_type IN (10001, 10012)
 AND a.`status` = 0
 AND c.user_id = '791'
 ORDER BY
 	a.alarm_time DESC
 LIMIT 1
 
 
 
 

