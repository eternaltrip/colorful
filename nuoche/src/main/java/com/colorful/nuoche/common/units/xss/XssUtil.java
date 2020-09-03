package com.colorful.nuoche.common.units.xss;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * 自定义的xss过滤器
 * @author travel
 *
 */
public class XssUtil {
	public static final String REPLACE_STRING = "*";

	private XssUtil() {
	}

	/**
	 * xss校验
	 * 
	 * @param s
	 * @return
	 */
	public static String xssEncode(String s) {
		if (StringUtils.isEmpty(s)) {
			return s;
		} else {
			s = stripXSSAndSql(s);
		}
		StringBuilder sb = new StringBuilder(s.length() + 16);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case '>':
				sb.append("＞");// 转义大于号
				break;
			case '<':
				sb.append("＜");// 转义小于号
				break;
			case '\'':
				sb.append("＇");// 转义单引号
				break;
			case '\"':
				sb.append("＂");// 转义双引号
				break;
			case '&':
				sb.append("＆");// 转义&
				break;
			case '#':
				sb.append("＃");// 转义#
				break;
			default:
				sb.append(c);
				break;
			}
		}
		return sb.toString();
	}

	/**
	 * xss校验
	 * 
	 * @param value
	 * @return
	 */
	public static String stripXSSAndSql(String value) {
		if (StringUtils.isNotEmpty(value)) {
			// Avoid null characters
			value = value.replaceAll(" ", REPLACE_STRING);
			// Avoid anything between script tags
			Pattern scriptPattern = Pattern.compile(
					"<[\r\n| | ]*script[\r\n| | ]*>(.*?)</[\r\n| | ]*script[\r\n| | ]*>", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll(REPLACE_STRING);
			// Avoid anything in a src="http://www.yihaomen.com/article/java/..." type of
			// e-xpression
			scriptPattern = Pattern.compile("src[\r\n| | ]*=[\r\n| | ]*[\\\"|\\\'](.*?)[\\\"|\\\']",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll(REPLACE_STRING);
			// Remove any lonesome </script> tag
			scriptPattern = Pattern.compile("</[\r\n| | ]*script[\r\n| | ]*>", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll(REPLACE_STRING);
			// Remove any lonesome <script ...> tag
			scriptPattern = Pattern.compile("<[\r\n| | ]*script(.*?)>",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll(REPLACE_STRING);
			// Avoid eval(...) expressions
			scriptPattern = Pattern.compile("eval\\((.*?)\\)",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll(REPLACE_STRING);
			// Avoid e-xpression(...) expressions
			scriptPattern = Pattern.compile("e-xpression\\((.*?)\\)",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll(REPLACE_STRING);
			// Avoid javascript:... expressions
			scriptPattern = Pattern.compile("javascript[\r\n| | ]*:[\r\n| | ]*", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll(REPLACE_STRING);
			// Avoid vbscript:... expressions
			scriptPattern = Pattern.compile("vbscript[\r\n| | ]*:[\r\n| | ]*", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll(REPLACE_STRING);
			// Avoid onload= expressions
			scriptPattern = Pattern.compile("onload(.*?)=",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll(REPLACE_STRING);
			// Avoid /r /n:... expressions
			scriptPattern = Pattern.compile("\"\\\\s*|\\t|\\r|\\n\"",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");
		}
		return value;
	}

}
