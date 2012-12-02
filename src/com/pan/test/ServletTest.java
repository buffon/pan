package com.pan.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(new Date()).getClass());


	}

}
