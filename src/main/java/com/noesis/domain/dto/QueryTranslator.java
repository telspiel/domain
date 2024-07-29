package com.noesis.domain.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class QueryTranslator {
	
	@Autowired
	private  NamedParameterJdbcTemplate jdbcTemplate;
public  List<UserOptimizeDto> getRoleBasedData(String parentId) {
		
//		String sqlQuery = "SELECT a.user_name, b.cust_type AS type_name " +
//                "FROM ng_user a " +
//                "LEFT JOIN ng_customer_type b ON a.customer_type = b.id " +
//                "WHERE a.parent_id =:parentId";
	String sqlQuery = "SELECT a.user_name, b.cust_type AS type_name ,a.id\r\n"
			+ "FROM ng_user a \r\n"
			+ "LEFT JOIN ng_customer_type b ON a.customer_type = b.id \r\n"
			+ "WHERE a.parent_id = :parentId ";
		
		System.out.println("PARENT ID => "+parentId);
		
		Map<String, Object> params = new HashMap<>();
		params.put("parentId", parentId);
		
		return jdbcTemplate.query(sqlQuery,params, (resultSet, i) -> {
			UserOptimizeDto data = new UserOptimizeDto();
			data.setUserName(resultSet.getString("user_name"));
			data.setUserrole(resultSet.getString("type_name"));
			data.setId(resultSet.getString("id"));
			
			
			return data;
		});
		
		
	}
	
	// end new method


public  List<UserOptimizeDto> getUserDetails(String userName) {
	
//	String sqlQuery = "SELECT a.user_name, b.cust_type AS type_name " +
//            "FROM ng_user a " +
//            "LEFT JOIN ng_customer_type b ON a.customer_type = b.id " +
//            "WHERE a.parent_id =:parentId";
String sqlQuery = "select user_name,id from ng_user where user_name= :userName";
	
	System.out.println("LOGGEDIN USER NAME => "+userName);
	
	Map<String, Object> params = new HashMap<>();
	params.put("userName", userName);
	
	return jdbcTemplate.query(sqlQuery,params, (resultSet, i) -> {
		UserOptimizeDto data = new UserOptimizeDto();
		data.setUserName(resultSet.getString("user_name"));
		//data.setUserrole(resultSet.getString("type_name"));
		data.setId(resultSet.getString("id"));
		
		return data;
	});
	
	
}
// logged in with role
public  List<UserOptimizeDto> getRoleBasedDataLogged(String userName) {
	
//	String sqlQuery = "SELECT a.user_name, b.cust_type AS type_name " +
//            "FROM ng_user a " +
//            "LEFT JOIN ng_customer_type b ON a.customer_type = b.id " +
//            "WHERE a.parent_id =:parentId";
String sqlQuery = "SELECT a.user_name, b.cust_type AS type_name ,a.id\r\n"
		+ "FROM ng_user a \r\n"
		+ "LEFT JOIN ng_customer_type b ON a.customer_type = b.id \r\n"
		+ "WHERE a.user_name = :userName ";
	
	System.out.println("USER NAME => "+userName);
	
	Map<String, Object> params = new HashMap<>();
	params.put("userName", userName);
	
	return jdbcTemplate.query(sqlQuery,params, (resultSet, i) -> {
		UserOptimizeDto data = new UserOptimizeDto();
		data.setUserName(resultSet.getString("user_name"));
		data.setUserrole(resultSet.getString("type_name"));
		data.setId(resultSet.getString("id"));
		
		return data;
	});
	
	
}
// new 
//public  List<SmppStat> getRoleBasedDataLogged4(String userName) {
//	
////	String sqlQuery = "SELECT a.user_name, b.cust_type AS type_name " +
////            "FROM ng_user a " +
////            "LEFT JOIN ng_customer_type b ON a.customer_type = b.id " +
////            "WHERE a.parent_id =:parentId";
//String sqlQuery = "SELECT a.user_name, b.cust_type AS type_name ,a.id\r\n"
//		+ "FROM ng_user a \r\n"
//		+ "LEFT JOIN ng_customer_type b ON a.customer_type = b.id \r\n"
//		+ "WHERE a.user_name = :userName ";
//	
//	System.out.println("PARENT ID => "+userName);
//	
//	Map<String, Object> params = new HashMap<>();
//	params.put("userName", userName);
//	
//	return jdbcTemplate.query(sqlQuery,params, (resultSet, i) -> {
//		SmppStat data = new SmppStat();
//		data.setUserName(resultSet.getString("user_name"));
//		data.setUserrole(resultSet.getString("type_name"));
//		data.setId(resultSet.getInt("id"));
//		
//		return data;
//	});
//	
//	
//}


public  List<NumberRoutingClientData> getClientData() {
	
//	String sqlQuery = "SELECT a.user_name, b.cust_type AS type_name " +
//            "FROM ng_user a " +
//            "LEFT JOIN ng_customer_type b ON a.customer_type = b.id " +
//            "WHERE a.parent_id =:parentId";
String sqlQuery = "select  user_name,id from ng_user where customer_type = '3'";
	
	
	
	Map<String, Object> params = new HashMap<>();
	//params.put("userName", userName);
	
	return jdbcTemplate.query(sqlQuery,params, (resultSet, i) -> {
		NumberRoutingClientData data = new NumberRoutingClientData();
		data.setName(resultSet.getString("user_name"));
		//data.setUserrole(resultSet.getString("type_name"));
		data.setId(resultSet.getString("id"));
		
		return data;
	});
	
	
}

// end


// group id
//public  List<NumberRoutingClientData> getGroupId() {
//	
//
//String sqlQuery = "select  user_name,id from ng_user where customer_type = '3'";
//	
//	
//	
//	Map<String, Object> params = new HashMap<>();
//	//params.put("userName", userName);
//	
//	return jdbcTemplate.query(sqlQuery,params, (resultSet, i) -> {
//		NumberRoutingClientData data = new NumberRoutingClientData();
//		data.setName(resultSet.getString("user_name"));
//		//data.setUserrole(resultSet.getString("type_name"));
//		data.setId(resultSet.getString("id"));
//		
//		return data;
//	});
//	
//	
//}

// group name and id
public  List<GroupIdAndName> getGroupId() {
	

String sqlQuery = "select group_name,id from ng_routing_group_master;\r\n"
		+ "";
	
	
	
	Map<String, Object> params = new HashMap<>();
	//params.put("userName", userName);
	
	return jdbcTemplate.query(sqlQuery,params, (resultSet, i) -> {
		GroupIdAndName data = new GroupIdAndName();
		data.setGroupName(resultSet.getString("group_name"));
		//data.setUserrole(resultSet.getString("type_name"));
		data.setId(resultSet.getString("id"));
		
		return data;
	});
	
	
}



}
