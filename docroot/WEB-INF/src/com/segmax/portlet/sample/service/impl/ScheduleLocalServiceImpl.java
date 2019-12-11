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

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.segmax.portlet.sample.model.Schedule;
import com.segmax.portlet.sample.service.base.ScheduleLocalServiceBaseImpl;

/**
 * The implementation of the schedule local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.segmax.portlet.sample.service.ScheduleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author segmax
 * @see com.segmax.portlet.sample.service.base.ScheduleLocalServiceBaseImpl
 * @see com.segmax.portlet.sample.service.ScheduleLocalServiceUtil
 */
public class ScheduleLocalServiceImpl extends ScheduleLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.segmax.portlet.sample.service.ScheduleLocalServiceUtil} to access the schedule local service.
	 */
	
	public void addSchedule(Long surgeryId, Integer day, Integer hour) throws SystemException {
		Schedule schedule = schedulePersistence.create(CounterLocalServiceUtil.increment(Schedule.class.getName()));
		schedule.setDay(day);
		schedule.setHour(hour);
		schedule.setSurgeryId(surgeryId);
		System.out.println("schedule added");
		schedulePersistence.update(schedule);
	}
	
	public List<Schedule> getSchedulesBySurgery(Long surgeryId) throws SystemException {
		return schedulePersistence.findBySurgeryId(surgeryId);
	}
}