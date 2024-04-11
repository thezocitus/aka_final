package com.aka.app.member;

import java.sql.Date;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class MemberVO implements UserDetails{
	
	private Long member_id;
	private Long department_id;
	private String email;
	private Date hire_date;
	private Date retire_date;
	private String phone;
	private String address;
	private String user_id;
	private String password;
	private String passwordCheck;
	private String username;
	private Long role_id;
	private String customer_key;
	private String profil;
	private String profil_ori;
	private Long position_id;
	
	// security
	private boolean accountNonExpired;			// 아이디가 없거나 만료
	private boolean accountNonLocked;			// 계정 잠김
	private boolean credentialsNonExpired;		// 비밀번호 유효기간 종료
	private boolean enabled;					// 휴면 계정
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	
}
