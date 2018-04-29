package cn.sdhqtj.hjt.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import cn.sdhqtj.hjt.entity.Login;
import cn.sdhqtj.hjt.entity.Yonghu;
import cn.sdhqtj.hjt.service.LoginService;
import cn.sdhqtj.hjt.service.RoleService;
import cn.sdhqtj.hjt.service.YonghuService;

public class UserRealm extends AuthorizingRealm {

	@Autowired
	LoginService loginService;

	@Autowired
	RoleService roleService;

	@Autowired
	YonghuService YonghuService;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();

		// 角色的集合
		List<Yonghu> yonghu = YonghuService.getuserByUseranme(username);
		// System.out.println("----------------------账号"+user);

		List<String> roles = roleService.rolenamelist(yonghu.get(0).getYhjsid());
		// System.out.println("----------------------角色集合"+roles);

		// 权限的集合
		// System.out.println("-----------角色ID"+user.get(0).getRole_id());
		List<String> permissions = roleService.urllist(yonghu.get(0).getYhjsid());
		// System.out.println("-----------------------------权限集合"+permissions);

		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.addRoles(roles);// 设置角色
		authorizationInfo.addStringPermissions(permissions);// 设置权限

		return authorizationInfo;

	}

	/**
	 * 身份验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		Login lo = new Login();
		lo.setUsername(username);
		Login login = loginService.validatelogon(lo);

		if (login == null) {
			throw new IncorrectCredentialsException();// 没找到帐号
		}

		// if (Boolean.FALSE.equals(login.getEnable())) {
		// throw new LockedAccountException(); //帐号锁定
		// }
		/**
		 * 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得的不好可以在此判断或自定义实现
		 */
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(login.getUsername(), login.getPassword(),
				getName());
		return info;
	}

	@Override
	public String getName() {
		return getClass().getName();
	}

}
