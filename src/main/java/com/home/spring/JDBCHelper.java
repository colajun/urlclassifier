package com.home.spring;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by hadoop on 16-10-31.
 */
public class JDBCHelper implements   Serializable{
    public  static HashMap<String, JdbcTemplate> templateMap = new HashMap<>();

    public  static  JdbcTemplate createMysqlTemplate(String templateNanme, String url,
                                                     String username, String password,
                                                     int initialSize, int maxActive
                                                     ){

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxActive(maxActive);
        JdbcTemplate template = new JdbcTemplate(dataSource);
        templateMap.put(templateNanme, template);
        return  template;
    }
    public  static  JdbcTemplate getJdbcTemplate(String templateName){
        return  templateMap.get(templateName);
    }



}
