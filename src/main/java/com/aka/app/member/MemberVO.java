package com.aka.app.member;

import java.sql.Date;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class MemberVO implements UserDetails, OAuth2User{
	
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
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Map<String, Object> getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
