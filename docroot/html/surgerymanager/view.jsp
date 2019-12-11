<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.UserLocalService"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.segmax.portlet.sample.service.AppointmentLocalServiceUtil"%>
<%@page import="com.segmax.portlet.sample.model.Appointment"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.segmax.portlet.sample.service.ScheduleLocalServiceUtil"%>
<%@page import="com.segmax.portlet.sample.model.Schedule"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<portlet:defineObjects />

<%

String[] daysOfWeek = new String[]{"NONE","SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};

ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
User surgery = themeDisplay.getUser();

DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>

<div>
	<h3>Schedule</h3>
	
	<portlet:actionURL name="addSchedule" var="addScheduleUrl" />
	<form action="<%=addScheduleUrl.toString() %>" method="post" name="addSchedule" id="addSchedule">
		<select name='<portlet:namespace/>day'>
			<option value="<%=Calendar.MONDAY%>">Monday</option>
			<option value="<%=Calendar.TUESDAY%>">Tuesday</option>
			<option value="<%=Calendar.WEDNESDAY%>">Wednesday</option>
			<option value="<%=Calendar.THURSDAY%>">Thursday</option>
			<option value="<%=Calendar.FRIDAY%>">Friday</option>
		</select>
		<select name="<portlet:namespace/>hour">
			<option value="9">9:00</option>
			<option value="12">12:00</option>
			<option value="15">15:00</option>
			<option value="18">18:00</option>
		</select>
		<button class="btn">Send</button>
	</form>
</div>

<liferay-ui:search-container delta="10" curParam="schCur" emptyResultsMessage="No schedules"  >
	<liferay-ui:search-container-results>
		<%
			List<Schedule> schedules = new ArrayList<Schedule>(ScheduleLocalServiceUtil.getSchedulesBySurgery(surgery.getUserId()));
			Collections.sort(schedules, new Comparator<Schedule> () {
				public int compare(Schedule sch1, Schedule sch2) {
					if (sch1.getDay() == sch2.getDay()) {
						return Integer.compare(sch1.getHour(), sch2.getHour());
					} else {
						return Integer.compare(sch1.getDay(), sch2.getDay());
					}
				}
			});
			results = ListUtil.subList(schedules, searchContainer.getStart(), searchContainer.getEnd());
			total = schedules.size();
			pageContext.setAttribute("results",results);
			pageContext.setAttribute("total",total);
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
		className="com.segmax.portlet.sample.model.Schedule"
		keyProperty="scheduleId"
		modelVar="schedule">
		
	<liferay-ui:search-container-column-text
		name="Day"
		value="<%=daysOfWeek[schedule.getDay()] %>"
	/>
	<liferay-ui:search-container-column-text
		name="Hour"
		value="<%=StringUtil.add(String.valueOf(schedule.getHour()), \":00\", \"\") %>"
	/>
	
	<liferay-ui:search-container-column-jsp
		align="right"
		path="/html/surgerymanager/scheduleActions.jsp"
	/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>


<div>
	<h3>Appointments</h3>
	<ul>
	<%
		List<Appointment> apps = AppointmentLocalServiceUtil.getAppointments(0, AppointmentLocalServiceUtil.getAppointmentsCount());
		for (Appointment app : apps) {
			User visitor = UserLocalServiceUtil.getUser(app.getVisitorId());
	%>
		<li><%=visitor.getFullName()%> <%=app.getAppDate() %></li>
	<%	} %>
	</ul>
</div>

<liferay-ui:search-container delta="10" curParam="appCur" emptyResultsMessage="No appointments"  >
	<liferay-ui:search-container-results>
		<%
			results = ListUtil.subList(apps, searchContainer.getStart(), searchContainer.getEnd());
			total = apps.size();
			pageContext.setAttribute("results",results);
			pageContext.setAttribute("total",total);
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
		className="com.segmax.portlet.sample.model.Appointment"
		keyProperty="appId"
		modelVar="app">
	<%
		User visitor = UserLocalServiceUtil.getUser(app.getVisitorId());
	%>
	<liferay-ui:search-container-column-text
		name="Visitor Name"
		value="<%=visitor.getFullName() %>"
	/>
	<liferay-ui:search-container-column-text
		name="Date"
		value="<%=dateFormatter.format(app.getAppDate()) %>"
	/>
	<liferay-ui:search-container-column-jsp
		align="right"
		path="/html/surgerymanager/appMadeActions.jsp"
	/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>


