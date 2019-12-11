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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.segmax.portlet.sample.service.AppointmentLocalServiceUtil;
import com.segmax.portlet.sample.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author segmax
 */
public class AppointmentClp extends BaseModelImpl<Appointment>
	implements Appointment {
	public AppointmentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Appointment.class;
	}

	@Override
	public String getModelClassName() {
		return Appointment.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _appId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAppId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _appId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("appId", getAppId());
		attributes.put("appDate", getAppDate());
		attributes.put("surgeryId", getSurgeryId());
		attributes.put("visitorId", getVisitorId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long appId = (Long)attributes.get("appId");

		if (appId != null) {
			setAppId(appId);
		}

		Date appDate = (Date)attributes.get("appDate");

		if (appDate != null) {
			setAppDate(appDate);
		}

		Long surgeryId = (Long)attributes.get("surgeryId");

		if (surgeryId != null) {
			setSurgeryId(surgeryId);
		}

		Long visitorId = (Long)attributes.get("visitorId");

		if (visitorId != null) {
			setVisitorId(visitorId);
		}
	}

	@Override
	public long getAppId() {
		return _appId;
	}

	@Override
	public void setAppId(long appId) {
		_appId = appId;

		if (_appointmentRemoteModel != null) {
			try {
				Class<?> clazz = _appointmentRemoteModel.getClass();

				Method method = clazz.getMethod("setAppId", long.class);

				method.invoke(_appointmentRemoteModel, appId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getAppDate() {
		return _appDate;
	}

	@Override
	public void setAppDate(Date appDate) {
		_appDate = appDate;

		if (_appointmentRemoteModel != null) {
			try {
				Class<?> clazz = _appointmentRemoteModel.getClass();

				Method method = clazz.getMethod("setAppDate", Date.class);

				method.invoke(_appointmentRemoteModel, appDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSurgeryId() {
		return _surgeryId;
	}

	@Override
	public void setSurgeryId(long surgeryId) {
		_surgeryId = surgeryId;

		if (_appointmentRemoteModel != null) {
			try {
				Class<?> clazz = _appointmentRemoteModel.getClass();

				Method method = clazz.getMethod("setSurgeryId", long.class);

				method.invoke(_appointmentRemoteModel, surgeryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVisitorId() {
		return _visitorId;
	}

	@Override
	public void setVisitorId(long visitorId) {
		_visitorId = visitorId;

		if (_appointmentRemoteModel != null) {
			try {
				Class<?> clazz = _appointmentRemoteModel.getClass();

				Method method = clazz.getMethod("setVisitorId", long.class);

				method.invoke(_appointmentRemoteModel, visitorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAppointmentRemoteModel() {
		return _appointmentRemoteModel;
	}

	public void setAppointmentRemoteModel(BaseModel<?> appointmentRemoteModel) {
		_appointmentRemoteModel = appointmentRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _appointmentRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_appointmentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AppointmentLocalServiceUtil.addAppointment(this);
		}
		else {
			AppointmentLocalServiceUtil.updateAppointment(this);
		}
	}

	@Override
	public Appointment toEscapedModel() {
		return (Appointment)ProxyUtil.newProxyInstance(Appointment.class.getClassLoader(),
			new Class[] { Appointment.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AppointmentClp clone = new AppointmentClp();

		clone.setAppId(getAppId());
		clone.setAppDate(getAppDate());
		clone.setSurgeryId(getSurgeryId());
		clone.setVisitorId(getVisitorId());

		return clone;
	}

	@Override
	public int compareTo(Appointment appointment) {
		long primaryKey = appointment.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AppointmentClp)) {
			return false;
		}

		AppointmentClp appointment = (AppointmentClp)obj;

		long primaryKey = appointment.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{appId=");
		sb.append(getAppId());
		sb.append(", appDate=");
		sb.append(getAppDate());
		sb.append(", surgeryId=");
		sb.append(getSurgeryId());
		sb.append(", visitorId=");
		sb.append(getVisitorId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.segmax.portlet.sample.model.Appointment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>appId</column-name><column-value><![CDATA[");
		sb.append(getAppId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>appDate</column-name><column-value><![CDATA[");
		sb.append(getAppDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surgeryId</column-name><column-value><![CDATA[");
		sb.append(getSurgeryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>visitorId</column-name><column-value><![CDATA[");
		sb.append(getVisitorId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _appId;
	private Date _appDate;
	private long _surgeryId;
	private long _visitorId;
	private BaseModel<?> _appointmentRemoteModel;
	private Class<?> _clpSerializerClass = com.segmax.portlet.sample.service.ClpSerializer.class;
}