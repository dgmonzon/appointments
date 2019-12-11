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

import com.segmax.portlet.sample.service.ClpSerializer;
import com.segmax.portlet.sample.service.ScheduleLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author segmax
 */
public class ScheduleClp extends BaseModelImpl<Schedule> implements Schedule {
	public ScheduleClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Schedule.class;
	}

	@Override
	public String getModelClassName() {
		return Schedule.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _scheduleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setScheduleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _scheduleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scheduleId", getScheduleId());
		attributes.put("surgeryId", getSurgeryId());
		attributes.put("day", getDay());
		attributes.put("hour", getHour());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long scheduleId = (Long)attributes.get("scheduleId");

		if (scheduleId != null) {
			setScheduleId(scheduleId);
		}

		Long surgeryId = (Long)attributes.get("surgeryId");

		if (surgeryId != null) {
			setSurgeryId(surgeryId);
		}

		Integer day = (Integer)attributes.get("day");

		if (day != null) {
			setDay(day);
		}

		Integer hour = (Integer)attributes.get("hour");

		if (hour != null) {
			setHour(hour);
		}
	}

	@Override
	public long getScheduleId() {
		return _scheduleId;
	}

	@Override
	public void setScheduleId(long scheduleId) {
		_scheduleId = scheduleId;

		if (_scheduleRemoteModel != null) {
			try {
				Class<?> clazz = _scheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setScheduleId", long.class);

				method.invoke(_scheduleRemoteModel, scheduleId);
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

		if (_scheduleRemoteModel != null) {
			try {
				Class<?> clazz = _scheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setSurgeryId", long.class);

				method.invoke(_scheduleRemoteModel, surgeryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDay() {
		return _day;
	}

	@Override
	public void setDay(int day) {
		_day = day;

		if (_scheduleRemoteModel != null) {
			try {
				Class<?> clazz = _scheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setDay", int.class);

				method.invoke(_scheduleRemoteModel, day);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getHour() {
		return _hour;
	}

	@Override
	public void setHour(int hour) {
		_hour = hour;

		if (_scheduleRemoteModel != null) {
			try {
				Class<?> clazz = _scheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setHour", int.class);

				method.invoke(_scheduleRemoteModel, hour);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getScheduleRemoteModel() {
		return _scheduleRemoteModel;
	}

	public void setScheduleRemoteModel(BaseModel<?> scheduleRemoteModel) {
		_scheduleRemoteModel = scheduleRemoteModel;
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

		Class<?> remoteModelClass = _scheduleRemoteModel.getClass();

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

		Object returnValue = method.invoke(_scheduleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ScheduleLocalServiceUtil.addSchedule(this);
		}
		else {
			ScheduleLocalServiceUtil.updateSchedule(this);
		}
	}

	@Override
	public Schedule toEscapedModel() {
		return (Schedule)ProxyUtil.newProxyInstance(Schedule.class.getClassLoader(),
			new Class[] { Schedule.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ScheduleClp clone = new ScheduleClp();

		clone.setScheduleId(getScheduleId());
		clone.setSurgeryId(getSurgeryId());
		clone.setDay(getDay());
		clone.setHour(getHour());

		return clone;
	}

	@Override
	public int compareTo(Schedule schedule) {
		long primaryKey = schedule.getPrimaryKey();

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

		if (!(obj instanceof ScheduleClp)) {
			return false;
		}

		ScheduleClp schedule = (ScheduleClp)obj;

		long primaryKey = schedule.getPrimaryKey();

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

		sb.append("{scheduleId=");
		sb.append(getScheduleId());
		sb.append(", surgeryId=");
		sb.append(getSurgeryId());
		sb.append(", day=");
		sb.append(getDay());
		sb.append(", hour=");
		sb.append(getHour());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.segmax.portlet.sample.model.Schedule");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>scheduleId</column-name><column-value><![CDATA[");
		sb.append(getScheduleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surgeryId</column-name><column-value><![CDATA[");
		sb.append(getSurgeryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>day</column-name><column-value><![CDATA[");
		sb.append(getDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hour</column-name><column-value><![CDATA[");
		sb.append(getHour());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _scheduleId;
	private long _surgeryId;
	private int _day;
	private int _hour;
	private BaseModel<?> _scheduleRemoteModel;
	private Class<?> _clpSerializerClass = com.segmax.portlet.sample.service.ClpSerializer.class;
}