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

package com.segmax.portlet.sample.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.segmax.portlet.sample.service.http.AppointmentServiceSoap}.
 *
 * @author segmax
 * @see com.segmax.portlet.sample.service.http.AppointmentServiceSoap
 * @generated
 */
public class AppointmentSoap implements Serializable {
	public static AppointmentSoap toSoapModel(Appointment model) {
		AppointmentSoap soapModel = new AppointmentSoap();

		soapModel.setAppId(model.getAppId());
		soapModel.setAppDate(model.getAppDate());
		soapModel.setSurgeryId(model.getSurgeryId());
		soapModel.setVisitorId(model.getVisitorId());

		return soapModel;
	}

	public static AppointmentSoap[] toSoapModels(Appointment[] models) {
		AppointmentSoap[] soapModels = new AppointmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AppointmentSoap[][] toSoapModels(Appointment[][] models) {
		AppointmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AppointmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AppointmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AppointmentSoap[] toSoapModels(List<Appointment> models) {
		List<AppointmentSoap> soapModels = new ArrayList<AppointmentSoap>(models.size());

		for (Appointment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AppointmentSoap[soapModels.size()]);
	}

	public AppointmentSoap() {
	}

	public long getPrimaryKey() {
		return _appId;
	}

	public void setPrimaryKey(long pk) {
		setAppId(pk);
	}

	public long getAppId() {
		return _appId;
	}

	public void setAppId(long appId) {
		_appId = appId;
	}

	public Date getAppDate() {
		return _appDate;
	}

	public void setAppDate(Date appDate) {
		_appDate = appDate;
	}

	public long getSurgeryId() {
		return _surgeryId;
	}

	public void setSurgeryId(long surgeryId) {
		_surgeryId = surgeryId;
	}

	public long getVisitorId() {
		return _visitorId;
	}

	public void setVisitorId(long visitorId) {
		_visitorId = visitorId;
	}

	private long _appId;
	private Date _appDate;
	private long _surgeryId;
	private long _visitorId;
}