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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.segmax.portlet.sample.service.http.ScheduleServiceSoap}.
 *
 * @author segmax
 * @see com.segmax.portlet.sample.service.http.ScheduleServiceSoap
 * @generated
 */
public class ScheduleSoap implements Serializable {
	public static ScheduleSoap toSoapModel(Schedule model) {
		ScheduleSoap soapModel = new ScheduleSoap();

		soapModel.setScheduleId(model.getScheduleId());
		soapModel.setSurgeryId(model.getSurgeryId());
		soapModel.setDay(model.getDay());
		soapModel.setHour(model.getHour());

		return soapModel;
	}

	public static ScheduleSoap[] toSoapModels(Schedule[] models) {
		ScheduleSoap[] soapModels = new ScheduleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ScheduleSoap[][] toSoapModels(Schedule[][] models) {
		ScheduleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ScheduleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ScheduleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ScheduleSoap[] toSoapModels(List<Schedule> models) {
		List<ScheduleSoap> soapModels = new ArrayList<ScheduleSoap>(models.size());

		for (Schedule model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ScheduleSoap[soapModels.size()]);
	}

	public ScheduleSoap() {
	}

	public long getPrimaryKey() {
		return _scheduleId;
	}

	public void setPrimaryKey(long pk) {
		setScheduleId(pk);
	}

	public long getScheduleId() {
		return _scheduleId;
	}

	public void setScheduleId(long scheduleId) {
		_scheduleId = scheduleId;
	}

	public long getSurgeryId() {
		return _surgeryId;
	}

	public void setSurgeryId(long surgeryId) {
		_surgeryId = surgeryId;
	}

	public int getDay() {
		return _day;
	}

	public void setDay(int day) {
		_day = day;
	}

	public int getHour() {
		return _hour;
	}

	public void setHour(int hour) {
		_hour = hour;
	}

	private long _scheduleId;
	private long _surgeryId;
	private int _day;
	private int _hour;
}