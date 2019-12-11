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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Schedule}.
 * </p>
 *
 * @author segmax
 * @see Schedule
 * @generated
 */
public class ScheduleWrapper implements Schedule, ModelWrapper<Schedule> {
	public ScheduleWrapper(Schedule schedule) {
		_schedule = schedule;
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

	/**
	* Returns the primary key of this schedule.
	*
	* @return the primary key of this schedule
	*/
	@Override
	public long getPrimaryKey() {
		return _schedule.getPrimaryKey();
	}

	/**
	* Sets the primary key of this schedule.
	*
	* @param primaryKey the primary key of this schedule
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_schedule.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the schedule ID of this schedule.
	*
	* @return the schedule ID of this schedule
	*/
	@Override
	public long getScheduleId() {
		return _schedule.getScheduleId();
	}

	/**
	* Sets the schedule ID of this schedule.
	*
	* @param scheduleId the schedule ID of this schedule
	*/
	@Override
	public void setScheduleId(long scheduleId) {
		_schedule.setScheduleId(scheduleId);
	}

	/**
	* Returns the surgery ID of this schedule.
	*
	* @return the surgery ID of this schedule
	*/
	@Override
	public long getSurgeryId() {
		return _schedule.getSurgeryId();
	}

	/**
	* Sets the surgery ID of this schedule.
	*
	* @param surgeryId the surgery ID of this schedule
	*/
	@Override
	public void setSurgeryId(long surgeryId) {
		_schedule.setSurgeryId(surgeryId);
	}

	/**
	* Returns the day of this schedule.
	*
	* @return the day of this schedule
	*/
	@Override
	public int getDay() {
		return _schedule.getDay();
	}

	/**
	* Sets the day of this schedule.
	*
	* @param day the day of this schedule
	*/
	@Override
	public void setDay(int day) {
		_schedule.setDay(day);
	}

	/**
	* Returns the hour of this schedule.
	*
	* @return the hour of this schedule
	*/
	@Override
	public int getHour() {
		return _schedule.getHour();
	}

	/**
	* Sets the hour of this schedule.
	*
	* @param hour the hour of this schedule
	*/
	@Override
	public void setHour(int hour) {
		_schedule.setHour(hour);
	}

	@Override
	public boolean isNew() {
		return _schedule.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_schedule.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _schedule.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_schedule.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _schedule.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _schedule.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_schedule.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _schedule.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_schedule.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_schedule.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_schedule.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ScheduleWrapper((Schedule)_schedule.clone());
	}

	@Override
	public int compareTo(com.segmax.portlet.sample.model.Schedule schedule) {
		return _schedule.compareTo(schedule);
	}

	@Override
	public int hashCode() {
		return _schedule.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.segmax.portlet.sample.model.Schedule> toCacheModel() {
		return _schedule.toCacheModel();
	}

	@Override
	public com.segmax.portlet.sample.model.Schedule toEscapedModel() {
		return new ScheduleWrapper(_schedule.toEscapedModel());
	}

	@Override
	public com.segmax.portlet.sample.model.Schedule toUnescapedModel() {
		return new ScheduleWrapper(_schedule.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _schedule.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _schedule.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_schedule.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ScheduleWrapper)) {
			return false;
		}

		ScheduleWrapper scheduleWrapper = (ScheduleWrapper)obj;

		if (Validator.equals(_schedule, scheduleWrapper._schedule)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Schedule getWrappedSchedule() {
		return _schedule;
	}

	@Override
	public Schedule getWrappedModel() {
		return _schedule;
	}

	@Override
	public void resetOriginalValues() {
		_schedule.resetOriginalValues();
	}

	private Schedule _schedule;
}