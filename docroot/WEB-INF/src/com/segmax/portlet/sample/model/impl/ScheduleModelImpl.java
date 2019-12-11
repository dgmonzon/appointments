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

package com.segmax.portlet.sample.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.segmax.portlet.sample.model.Schedule;
import com.segmax.portlet.sample.model.ScheduleModel;
import com.segmax.portlet.sample.model.ScheduleSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Schedule service. Represents a row in the &quot;KT_Schedule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.segmax.portlet.sample.model.ScheduleModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ScheduleImpl}.
 * </p>
 *
 * @author segmax
 * @see ScheduleImpl
 * @see com.segmax.portlet.sample.model.Schedule
 * @see com.segmax.portlet.sample.model.ScheduleModel
 * @generated
 */
@JSON(strict = true)
public class ScheduleModelImpl extends BaseModelImpl<Schedule>
	implements ScheduleModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a schedule model instance should use the {@link com.segmax.portlet.sample.model.Schedule} interface instead.
	 */
	public static final String TABLE_NAME = "KT_Schedule";
	public static final Object[][] TABLE_COLUMNS = {
			{ "scheduleId", Types.BIGINT },
			{ "surgeryId", Types.BIGINT },
			{ "day", Types.INTEGER },
			{ "hour", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table KT_Schedule (scheduleId LONG not null primary key,surgeryId LONG,day INTEGER,hour INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table KT_Schedule";
	public static final String ORDER_BY_JPQL = " ORDER BY schedule.scheduleId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY KT_Schedule.scheduleId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.segmax.portlet.sample.model.Schedule"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.segmax.portlet.sample.model.Schedule"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.segmax.portlet.sample.model.Schedule"),
			true);
	public static long SURGERYID_COLUMN_BITMASK = 1L;
	public static long SCHEDULEID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Schedule toModel(ScheduleSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Schedule model = new ScheduleImpl();

		model.setScheduleId(soapModel.getScheduleId());
		model.setSurgeryId(soapModel.getSurgeryId());
		model.setDay(soapModel.getDay());
		model.setHour(soapModel.getHour());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Schedule> toModels(ScheduleSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Schedule> models = new ArrayList<Schedule>(soapModels.length);

		for (ScheduleSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.segmax.portlet.sample.model.Schedule"));

	public ScheduleModelImpl() {
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
	public Class<?> getModelClass() {
		return Schedule.class;
	}

	@Override
	public String getModelClassName() {
		return Schedule.class.getName();
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

	@JSON
	@Override
	public long getScheduleId() {
		return _scheduleId;
	}

	@Override
	public void setScheduleId(long scheduleId) {
		_scheduleId = scheduleId;
	}

	@JSON
	@Override
	public long getSurgeryId() {
		return _surgeryId;
	}

	@Override
	public void setSurgeryId(long surgeryId) {
		_columnBitmask |= SURGERYID_COLUMN_BITMASK;

		if (!_setOriginalSurgeryId) {
			_setOriginalSurgeryId = true;

			_originalSurgeryId = _surgeryId;
		}

		_surgeryId = surgeryId;
	}

	public long getOriginalSurgeryId() {
		return _originalSurgeryId;
	}

	@JSON
	@Override
	public int getDay() {
		return _day;
	}

	@Override
	public void setDay(int day) {
		_day = day;
	}

	@JSON
	@Override
	public int getHour() {
		return _hour;
	}

	@Override
	public void setHour(int hour) {
		_hour = hour;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Schedule.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Schedule toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Schedule)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ScheduleImpl scheduleImpl = new ScheduleImpl();

		scheduleImpl.setScheduleId(getScheduleId());
		scheduleImpl.setSurgeryId(getSurgeryId());
		scheduleImpl.setDay(getDay());
		scheduleImpl.setHour(getHour());

		scheduleImpl.resetOriginalValues();

		return scheduleImpl;
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

		if (!(obj instanceof Schedule)) {
			return false;
		}

		Schedule schedule = (Schedule)obj;

		long primaryKey = schedule.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		ScheduleModelImpl scheduleModelImpl = this;

		scheduleModelImpl._originalSurgeryId = scheduleModelImpl._surgeryId;

		scheduleModelImpl._setOriginalSurgeryId = false;

		scheduleModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Schedule> toCacheModel() {
		ScheduleCacheModel scheduleCacheModel = new ScheduleCacheModel();

		scheduleCacheModel.scheduleId = getScheduleId();

		scheduleCacheModel.surgeryId = getSurgeryId();

		scheduleCacheModel.day = getDay();

		scheduleCacheModel.hour = getHour();

		return scheduleCacheModel;
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

	private static ClassLoader _classLoader = Schedule.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Schedule.class
		};
	private long _scheduleId;
	private long _surgeryId;
	private long _originalSurgeryId;
	private boolean _setOriginalSurgeryId;
	private int _day;
	private int _hour;
	private long _columnBitmask;
	private Schedule _escapedModel;
}