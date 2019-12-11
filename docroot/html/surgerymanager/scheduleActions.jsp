<%@page import="com.segmax.portlet.sample.model.Schedule"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="javax.portlet.PortletURL" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.model.User" %>
<%@page import="java.util.List"%>

<portlet:defineObjects />

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Schedule schedule = (Schedule) row.getObject();
%>

<liferay-ui:icon-menu>
	<portlet:actionURL name="deleteSchedule" var="deleteScheduleUrl">
		<portlet:param name="scheduleId" value="<%= String.valueOf(schedule.getScheduleId()) %>"></portlet:param>
	</portlet:actionURL>
	<liferay-ui:icon image="delete" message="Delete" url="<%= deleteScheduleUrl.toString() %>" />
</liferay-ui:icon-menu>