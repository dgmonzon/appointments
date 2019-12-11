package com.segmax.portlet.sample;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

/**
 * Portlet implementation class VisitorManager
 */
// rep.a@rxtro.com
// rep.b@rxtro.com

public class VisitorManager extends MVCPortlet {
 
	public void takeAppointment(ActionRequest request, ActionResponse response) {
		try {
			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			User user = themeDisplay.getUser();
			String appDateStr = ParamUtil.getString(request, "appDate", null);
			Long surgeryId = ParamUtil.getLong(request, "surgeryId", 0);
			System.out.println("Add APPOINTMENT");
			AppointmentLocalServiceUtil.addAppointment(surgeryId, user.getUserId(), dateFormatter.parse(appDateStr));
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setRenderParameter("jspPage", "/html/visitormanager/view.jsp");
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
