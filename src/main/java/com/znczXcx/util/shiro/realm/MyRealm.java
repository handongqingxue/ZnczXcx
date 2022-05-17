package com.znczXcx.util.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.znczXcx.dao.*;
import com.znczXcx.entity.*;

public class MyRealm extends AuthorizingRealm {
	@Autowired
	private QiYeMapper qiYeMapper;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		// TODO Auto-generated method stub
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		QiYe qy=new QiYe(token.getUsername(),String.valueOf(token.getPassword()));
		QiYe resultMsg=qiYeMapper.getByQyhMm(qy);
		if(token.getUsername().equals(resultMsg.getQyh())
				&&
				String.valueOf(token.getPassword()).equals(resultMsg.getMm())){
			return new SimpleAuthenticationInfo(resultMsg,resultMsg.getMm(),resultMsg.getQyh());
		}else{
			throw new AuthenticationException();
		}
	}

}
