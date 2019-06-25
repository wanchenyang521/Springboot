package com.wanchenyang.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 晨阳
 * @version 1.0
 * @date 2019-04-24 15:04
 * @description
 **/
public class C3p0Util
{
    private static ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

    /**
     * 获取连接池
     */
    public static DataSource getDataSource()
    {
        return comboPooledDataSource;
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() throws Exception {
        return comboPooledDataSource.getConnection();
    }

		// 释放资源
	public static void release(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		rs = null;

		release(conn, stmt);
	}

	// 释放资源
	public static void release(Connection conn, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		stmt = null;

		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn = null;
	}


}
