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
		Subject subject = SecurityUtils.getSubject();
		if("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))) {
			return true;
		}
		// 取到参数 ，强制转换判断。
		String[] arra = (String[]) mappedValue;
		if (arra == null || arra.length == 0) {
			System.out.println("-----b--------" + request.getServletPath());
			return subject.isPermitted(request.getServletPath());
		} else {
			for (String reqpath : arra) {
				System.out.println("-----a--------" + reqpath);
				if (subject.isPermitted(reqpath)) {
					return true;
				}
			}
		}
		return false;

	}
}
