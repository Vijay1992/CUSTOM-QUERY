package net.codejava;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	public static void main(String[] args) throws Exception {
		BCryptPasswordEncoder bcrpt = new BCryptPasswordEncoder();
		String password = "vinay2020";
		String encodepwd = bcrpt.encode(password);
		System.out.println(encodepwd);
	}

}
