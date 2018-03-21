package cn.sdhqtj.hjt.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

public class PermFilter extends AuthorizationFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest req, ServletResponse arg1, Object arg2) throws Exception {

		HttpServletRequest requeest = (HttpServletRequest) req;
		Subject subject = SecurityUtils.getSubject();

		return subject.isPermitted(requeest.getServletPath());
	}

}
