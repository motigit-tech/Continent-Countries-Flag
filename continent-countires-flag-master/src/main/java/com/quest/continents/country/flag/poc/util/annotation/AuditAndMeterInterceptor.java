package com.quest.continents.country.flag.poc.util.annotation;



import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.quest.continents.country.flag.poc.service.IMetricService;
import com.quest.continents.country.flag.poc.util.StringUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



public class AuditAndMeterInterceptor implements HandlerInterceptor {

	/** Logger object */
	private static final Logger LOGGER = LogManager.getLogger(AuditAndMeterInterceptor.class);
	
	@Autowired
	IMetricService metricService;
		

	/** Called Before Method Execution. */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HandlerMethod hm = (HandlerMethod) handler;
		Method method = hm.getMethod();
		Class<?> clazz = method.getDeclaringClass();

		if (clazz.isAnnotationPresent(AuditAndMeter.class)) {
			request.setAttribute("REQ_STARTTIME", System.currentTimeMillis());
		}

		return true;
	}

	/** Called After Method Execution. */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		Object startTime = request.getAttribute("REQ_STARTTIME");
		if (null == startTime) {
			return;
		}

		request.setAttribute("REQ_ENDTIME", System.currentTimeMillis());
	}

	/** Called After Request Completion. */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		Object startTime = request.getAttribute("REQ_STARTTIME");
		Object endTime = request.getAttribute("REQ_ENDTIME");
		if (null == startTime || null == endTime) {
			return;
		}

		writeAuditMessage((Long) startTime, (Long) endTime, request, ex);
		
		/* To Update API metrics */
		metricService.increaseCount(request.getPathInfo(), response.getStatus());
		
	}

	// ----------------------------------------------------------------------------
	private void writeAuditMessage(Long startTime, Long endTime, HttpServletRequest request, Exception ex) {

		String requestURL = request.getRequestURL().toString();
		String queryString = request.getQueryString();		
		

		StringBuilder json = new StringBuilder();
		StringUtil.append(json, "{");
		StringUtil.append(json, "messageType: ", "MS_API_AUDIT", ",");			
		StringUtil.append(json, "requestURL: ", requestURL, ",");
		StringUtil.append(json, "queryString: ", queryString, ",");		
		StringUtil.append(json, "startTime: ", startTime, ",");
		StringUtil.append(json, "endTime: ", endTime, ",");

		if (null == ex) {
			StringUtil.append(json, "Status: ", "SUCCESS", ",");
		} else {
			StringUtil.append(json, "Status: ", "FAILURE", ",");
			StringUtil.append(json, "exception: ", ex.getStackTrace());
		}

		StringUtil.append(json, "}");
		LOGGER.info(json.toString());
	}
}