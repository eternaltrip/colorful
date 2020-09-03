package com.colorful.nuoche.common.units.xss;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;

public class XssAndSqlHttpServletRequestWrapper extends HttpServletRequestWrapper {

	private HttpServletRequest request;

	public XssAndSqlHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	@Override
	public String getHeader(String name) {
		String value = super.getHeader(name);
		if (!StringUtils.isEmpty(value)) {
			value = StringEscapeUtils.escapeHtml4(value);
		}
		return value;
	}

	/**
	 * getParameter和getParameterValues， 
	 * {@link XssAndSqlHttpServletRequestWrapper getParameter} 方法是直接通过request获得querystring类型的入参调用的方法。
	 * 如果是通过springMVC注解类型来获得参数的话，走的是 {@link XssAndSqlHttpServletRequestWrapper
	 * getParameterValues} 的方法.
	 */

	@Override
	public String getParameter(String name) {
		String value = request.getParameter(name);
		if (!StringUtils.isEmpty(value)) {
			value = StringEscapeUtils.escapeHtml4(value);
		}
		return value;
	}

	@Override
	public String[] getParameterValues(String name) {
		String[] parameterValues = super.getParameterValues(name);
		if (parameterValues == null) {
			return null;
		}
		for (int i = 0; i < parameterValues.length; i++) {
			String value = parameterValues[i];
			// 这个过滤xss攻击的工具类，现在是借助第三方插件使用的。 也可以自己写一个工具类 比如下面的 XssUtil
//			parameterValues[i] = StringEscapeUtils.escapeHtml4(value);
			// 自定义工具类
			parameterValues[i] = XssUtil.xssEncode(parameterValues[i]);

		}
		return parameterValues;
	}
}
