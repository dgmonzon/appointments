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

package com.segmax.portlet.sample.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ScheduleLocalService}.
 *
 * @author segmax
 * @see ScheduleLocalService
 * @generated
 */
public class ScheduleLocalServiceWrapper implements ScheduleLocalService,
	ServiceWrapper<ScheduleLocalService> {
	public ScheduleLocalServiceWrapper(
		ScheduleLocalService scheduleLocalService) {
		_scheduleLocalService = scheduleLocalService;
	}

	/**
	* Adds the schedule to the database. Also notifies the appropriate model listeners.
	*
	* @param schedule the schedule
	* @return the schedule that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.segmax.portlet.sample.model.Schedule addSchedule(
		com.segmax.portlet.sample.model.Schedule schedule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleLocalService.addSchedule(schedule);
	}

	/**
	* Creates a new schedule with the primary key. Does not add the schedule to the database.
	*
	* @param scheduleId the primary key for the new schedule
	* @return the new schedule
	*/
	@Override
	public com.segmax.portlet.sample.model.Schedule createSchedule(
		long scheduleId) {
		return _scheduleLocalService.createSchedule(scheduleId);
	}

	/**
	* Deletes the schedule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scheduleId the primary key of the schedule
	* @return the schedule that was removed
	* @throws PortalException if a schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.segmax.portlet.sample.model.Schedule deleteSchedule(
		long scheduleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scheduleLocalService.deleteSchedule(scheduleId);
	}

	/**
	* Deletes the schedule from the database. Also notifies the appropriate model listeners.
	*
	* @param schedule the schedule
	* @return the schedule that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.segmax.portlet.sample.model.Schedule deleteSchedule(
		com.segmax.portlet.sample.model.Schedule schedule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleLocalService.deleteSchedule(schedule);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _scheduleLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.segmax.portlet.sample.model.impl.ScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.segmax.portlet.sample.model.impl.ScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.segmax.portlet.sample.model.Schedule fetchSchedule(
		long scheduleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleLocalService.fetchSchedule(scheduleId);
	}

	/**
	* Returns the schedule with the primary key.
	*
	* @param scheduleId the primary key of the schedule
	* @return the schedule
	* @throws PortalException if a schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.segmax.portlet.sample.model.Schedule getSchedule(long scheduleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scheduleLocalService.getSchedule(scheduleId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scheduleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the schedules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.segmax.portlet.sample.model.impl.ScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of schedules
	* @param end the upper bound of the range of schedules (not inclusive)
	* @return the range of schedules
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.segmax.portlet.sample.model.Schedule> getSchedules(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleLocalService.getSchedules(start, end);
	}

	/**
	* Returns the number of schedules.
	*
	* @return the number of schedules
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSchedulesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleLocalService.getSchedulesCount();
	}

	/**
	* Updates the schedule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param schedule the schedule
	* @return the schedule that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.segmax.portlet.sample.model.Schedule updateSchedule(
		com.segmax.portlet.sample.model.Schedule schedule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleLocalService.updateSchedule(schedule);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _scheduleLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_scheduleLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _scheduleLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void addSchedule(java.lang.Long surgeryId, java.lang.Integer day,
		java.lang.Integer hour)
		throws com.liferay.portal.kernel.exception.SystemException {
		_scheduleLocalService.addSchedule(surgeryId, day, hour);
	}

	@Override
	public java.util.List<com.segmax.portlet.sample.model.Schedule> getSchedulesBySurgery(
		java.lang.Long surgeryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleLocalService.getSchedulesBySurgery(surgeryId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ScheduleLocalService getWrappedScheduleLocalService() {
		return _scheduleLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedScheduleLocalService(
		ScheduleLocalService scheduleLocalService) {
		_scheduleLocalService = scheduleLocalService;
	}

	@Override
	public ScheduleLocalService getWrappedService() {
		return _scheduleLocalService;
	}

	@Override
	public void setWrappedService(ScheduleLocalService scheduleLocalService) {
		_scheduleLocalService = scheduleLocalService;
	}

	private ScheduleLocalService _scheduleLocalService;
}