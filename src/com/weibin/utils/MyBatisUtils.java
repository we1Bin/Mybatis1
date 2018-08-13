package com.weibin.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 *  @author Weibin on 2018/8/10.
 *  @version 1.0
 *  
 */
public class MyBatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession(){
        try {
            InputStream is  = Resources.getResourceAsStream("mybatis.xml");

            if (sqlSessionFactory == null){
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            }
            return sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
