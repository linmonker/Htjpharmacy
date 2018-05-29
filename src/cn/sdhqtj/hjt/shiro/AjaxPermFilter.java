package cn.sdhqtj.hjt.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

public class AjaxPermFilter extends AuthorizationFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest req, ServletResponse res, Object mappedValue) throws Exception {

		HttpServletRequest request = (HttpServletRequest) req;
		// 取到参数 ，强制转换判断。
		String[] arra = (String[]) mappedValue;
		Subject subject = SecurityUtils.getSubject();

		// 如果是Ajax请求
		if ("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))) {
			if (arra == null || arra.length == 0) {
				for (String reqpath : arra) {
					if (subject.isPermitted(reqpath)) {
						return true;
					}
				}
				return false;
			}
			return subject.isPermitted(request.getServletPath());
		}
		return true;
	}

}
