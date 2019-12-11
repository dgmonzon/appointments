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

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Schedule service. Represents a row in the &quot;KT_Schedule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.segmax.portlet.sample.model.impl.ScheduleModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.segmax.portlet.sample.model.impl.ScheduleImpl}.
 * </p>
 *
 * @author segmax
 * @see Schedule
 * @see com.segmax.portlet.sample.model.impl.ScheduleImpl
 * @see com.segmax.portlet.sample.model.impl.ScheduleModelImpl
 * @generated
 */
public interface ScheduleModel extends BaseModel<Schedule> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a schedule model instance should use the {@link Schedule} interface instead.
	 */

	/**
	 * Returns the primary key of this schedule.
	 *
	 * @return the primary key of this schedule
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this schedule.
	 *
	 * @param primaryKey the primary key of this schedule
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the schedule ID of this schedule.
	 *
	 * @return the schedule ID of this schedule
	 */
	public long getScheduleId();

	/**
	 * Sets the schedule ID of this schedule.
	 *
	 * @param scheduleId the schedule ID of this schedule
	 */
	public void setScheduleId(long scheduleId);

	/**
	 * Returns the surgery ID of this schedule.
	 *
	 * @return the surgery ID of this schedule
	 */
	public long getSurgeryId();

	/**
	 * Sets the surgery ID of this schedule.
	 *
	 * @param surgeryId the surgery ID of this schedule
	 */
	public void setSurgeryId(long surgeryId);

	/**
	 * Returns the day of this schedule.
	 *
	 * @return the day of this schedule
	 */
	public int getDay();

	/**
	 * Sets the day of this schedule.
	 *
	 * @param day the day of this schedule
	 */
	public void setDay(int day);

	/**
	 * Returns the hour of this schedule.
	 *
	 * @return the hour of this schedule
	 */
	public int getHour();

	/**
	 * Sets the hour of this schedule.
	 *
	 * @param hour the hour of this schedule
	 */
	public void setHour(int hour);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.segmax.portlet.sample.model.Schedule schedule);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.segmax.portlet.sample.model.Schedule> toCacheModel();

	@Override
	public com.segmax.portlet.sample.model.Schedule toEscapedModel();

	@Override
	public com.segmax.portlet.sample.model.Schedule toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}