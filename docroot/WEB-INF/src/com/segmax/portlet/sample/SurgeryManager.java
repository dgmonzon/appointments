package com.segmax.portlet.sample;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.segmax.portlet.sample.service.AppointmentLocalServiceUtil;
import com.segmax.portlet.sample.service.ScheduleLocalServiceUtil;

/**
 * Portlet implementation class SurgeryManager
 */
// clinica.a@rxtro.com
// clinica.b@rxtro.com
public class SurgeryManager extends MVCPortlet {
 
	public void addSchedule(ActionRequest request, ActionResponse response) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			User user = themeDisplay.getUser();
			Integer day = ParamUtil.getInteger(request, "day", 0);
			Integer hour = ParamUtil.getInteger(request, "hour", 0);
			System.out.println("action schedule added");
			ScheduleLocalServiceUtil.addSchedule(user.getUserId(), day, hour);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		response.setRenderParameter("jspPage", "/html/surgerymanager/view.jsp");
	}
	
	public void deleteSchedule(ActionRequest request, ActionResponse response) {
		try {
			Long scheduleId = ParamUtil.getLong(request, "scheduleId", 0);
			ScheduleLocalServiceUtil.deleteSchedule(scheduleId);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setRenderParameter("jspPage", "/html/surgerymanager/view.jsp");
	}

	public void cancelAppointment(ActionRequest request, ActionResponse response) {
		try {
			Long appId = ParamUtil.getLong(request, "appId", 0);
			AppointmentLocalServiceUtil.deleteAppointment(appId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setRenderParameter("jspPage", "/html/visitormanager/view.jsp");
	}
}
