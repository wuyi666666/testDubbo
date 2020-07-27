package org.example.sgs.template.core.service;

import com.alibaba.druid.filter.config.ConfigTools;

/**
 * 该类主要用于druid连接源数的密码加密
 * @author 698533
 *
 */
public class JdbcEncryptUtils {
	
	public static void main(String[] args) throws Exception{
		//注意druid的版本，
		String pwd = "appmgr123456";
		String pwdEnc = ConfigTools.encrypt(pwd);
		System.out.println(pwdEnc);
	}
	

}
