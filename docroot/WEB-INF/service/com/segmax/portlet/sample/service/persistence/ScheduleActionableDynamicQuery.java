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

package com.segmax.portlet.sample.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.segmax.portlet.sample.model.Schedule;
import com.segmax.portlet.sample.service.ScheduleLocalServiceUtil;

/**
 * @author segmax
 * @generated
 */
public abstract class ScheduleActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public ScheduleActionableDynamicQuery() throws SystemException {
		setBaseLocalService(ScheduleLocalServiceUtil.getService());
		setClass(Schedule.class);

		setClassLoader(com.segmax.portlet.sample.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("scheduleId");
	}
}