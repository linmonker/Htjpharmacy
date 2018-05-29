package cn.sdhqtj.hjt.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

public class PermFilter extends AuthorizationFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest req, ServletResponse res, Object mappedValue) throws Exception {

		HttpServletRequest request = (HttpServletRequest) req;
		
		// 如果是Ajax请求
		if("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))) {
			return true;
		}
		Subject subject = SecurityUtils.getSubject();
		return subject.isPermitted(request.getServletPath());
	}

}
