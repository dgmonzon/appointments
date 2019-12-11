/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.segmax.portlet.sample.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.segmax.portlet.sample.model.Appointment;
import com.segmax.portlet.sample.service.base.AppointmentLocalServiceBaseImpl;

/**
 * The implementation of the appointment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.segmax.portlet.sample.service.AppointmentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author segmax
 * @see com.segmax.portlet.sample.service.base.AppointmentLocalServiceBaseImpl
 * @see com.segmax.portlet.sample.service.AppointmentLocalServiceUtil
 */
public class AppointmentLocalServiceImpl extends AppointmentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.segmax.portlet.sample.service.AppointmentLocalServiceUtil} to access the appointment local service.
	 */
	
	public void addAppointment(Long surgeryId, Long visitorId, Date appDate) throws SystemException {
		Appointment app = appointmentPersistence.create(CounterLocalServiceUtil.increment(Appointment.class.getName()));
		app.setAppDate(appDate);
		app.setVisitorId(visitorId);
		app.setSurgeryId(surgeryId);
		appointmentPersistence.update(app);
	}
	
	public List<Appointment> getBySurgery(Long surgeryId) throws SystemException {
		return appointmentPersistence.findBySurgeryId(surgeryId);
	}
	
	public List<Appointment> getByVisitor(Long visitorId) throws SystemException {
		return appointmentPersistence.findByVisitorId(visitorId);
	}
	
	public List<Appointment> getBySurgeryAndVisitorAndAppDate(Long surgeryId, Long visitorId, Date date) throws SystemException {
		return appointmentPersistence.findBySurgeryAndVisitorAndAppDate(surgeryId, visitorId, date);
	}
	
	
}