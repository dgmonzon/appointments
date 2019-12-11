<%@page import="com.segmax.portlet.sample.model.impl.AppointmentImpl"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.segmax.portlet.sample.service.AppointmentLocalServiceUtil"%>
<%@page import="com.segmax.portlet.sample.model.Appointment"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.UserLocalService"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.segmax.portlet.sample.service.ScheduleLocalServiceUtil"%>
<%@page import="com.segmax.portlet.sample.model.Schedule"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<portlet:defineObjects />

<%
	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	User visitor = themeDisplay.getUser();

	DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	List<Appointment> availableAppointments = new ArrayList<Appointment>();
	List<Schedule> schedules = ScheduleLocalServiceUtil.getSchedules(0, ScheduleLocalServiceUtil.getSchedulesCount());
	
	for (Schedule sch : schedules) {
	
		Integer day = sch.getDay();
		Integer hour = sch.getHour();
		Long surgeryId = sch.getSurgeryId();
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, day);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		Calendar to = Calendar.getInstance();
		to.add(Calendar.DAY_OF_YEAR, 30);
		while (cal.getTime().before(to.getTime())) {
			if (cal.getTime().after(Calendar.getInstance().getTime())) {
				Date appDate = dateFormatter.parse(dateFormatter.format(cal.getTime()));
				List<Appointment> apps = AppointmentLocalServiceUtil.getBySurgeryAndAppDate(sch.getSurgeryId(), appDate);
				Appointment app = null;
				if (apps.size() > 0) {
					app = apps.get(0);
				} else {
					app = new AppointmentImpl();
					app.setAppId(0);
					app.setAppDate(appDate);
					app.setSurgeryId(sch.getSurgeryId());
					app.setVisitorId(visitor.getUserId());
				}
				availableAppointments.add(app);
			}
			cal.add(Calendar.DAY_OF_YEAR, 7);
		}
	}
	
%>

<h3>Appointments</h3>

<liferay-ui:search-container delta="10" emptyResultsMessage="No appointments"  >
	<liferay-ui:search-container-results>
		<%
			Collections.sort(availableAppointments, new Comparator<Appointment>() {
				public int compare(Appointment a1, Appointment a2) {
					return a1.getAppDate().compareTo(a2.getAppDate());
				}
			});
			results = ListUtil.subList(availableAppointments, searchContainer.getStart(), searchContainer.getEnd());
			total = availableAppointments.size();
			pageContext.setAttribute("results",results);
			pageContext.setAttribute("total",total);
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
		className="com.segmax.portlet.sample.model.Appointment"
		keyProperty="appId"
		modelVar="app">
	<%
		User surgery = UserLocalServiceUtil.getUser(app.getSurgeryId());
	%>
	<liferay-ui:search-container-column-text
		name="Clinic"
		value="<%=surgery.getFullName() %>"
	/>
	<liferay-ui:search-container-column-text
		name="Date"
		value="<%=dateFormatter.format(app.getAppDate()) %>"
	/>
	<liferay-ui:search-container-row-parameter name="visitorId" value="<%=visitor.getUserId() %>" />
	<liferay-ui:search-container-row-parameter name="surgeryId" value="<%=surgery.getUserId() %>" />
	<liferay-ui:search-container-column-jsp
		align="right"
		path="/html/visitormanager/addAppointmentActions.jsp"
	/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>


