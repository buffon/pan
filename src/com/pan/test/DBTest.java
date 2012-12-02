package com.pan.test;

import java.sql.Connection;

import com.pan.db.DataBaseManager;

public class DBTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection conn = DataBaseManager.getConnection();
		System.out.print(conn);

	}

}
