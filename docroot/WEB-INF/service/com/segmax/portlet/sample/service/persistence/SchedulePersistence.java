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

import com.liferay.portal.service.persistence.BasePersistence;

import com.segmax.portlet.sample.model.Schedule;

/**
 * The persistence interface for the schedule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author segmax
 * @see SchedulePersistenceImpl
 * @see ScheduleUtil
 * @generated
 */
public interface SchedulePersistence extends BasePersistence<Schedule> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ScheduleUtil} to access the schedule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the schedules where surgeryId = &#63;.
	*
	* @param surgeryId the surgery ID
	* @return the matching schedules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.segmax.portlet.sample.model.Schedule> findBySurgeryId(
		long surgeryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the schedules where surgeryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.segmax.portlet.sample.model.impl.ScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surgeryId the surgery ID
	* @param start the lower bound of the range of schedules
	* @param end the upper bound of the range of schedules (not inclusive)
	* @return the range of matching schedules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.segmax.portlet.sample.model.Schedule> findBySurgeryId(
		long surgeryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the schedules where surgeryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.segmax.portlet.sample.model.impl.ScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surgeryId the surgery ID
	* @param start the lower bound of the range of schedules
	* @param end the upper bound of the range of schedules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching schedules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.segmax.portlet.sample.model.Schedule> findBySurgeryId(
		long surgeryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first schedule in the ordered set where surgeryId = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching schedule
	* @throws com.segmax.portlet.sample.NoSuchScheduleException if a matching schedule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Schedule findBySurgeryId_First(
		long surgeryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchScheduleException;

	/**
	* Returns the first schedule in the ordered set where surgeryId = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching schedule, or <code>null</code> if a matching schedule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Schedule fetchBySurgeryId_First(
		long surgeryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last schedule in the ordered set where surgeryId = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching schedule
	* @throws com.segmax.portlet.sample.NoSuchScheduleException if a matching schedule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Schedule findBySurgeryId_Last(
		long surgeryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchScheduleException;

	/**
	* Returns the last schedule in the ordered set where surgeryId = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching schedule, or <code>null</code> if a matching schedule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Schedule fetchBySurgeryId_Last(
		long surgeryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the schedules before and after the current schedule in the ordered set where surgeryId = &#63;.
	*
	* @param scheduleId the primary key of the current schedule
	* @param surgeryId the surgery ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next schedule
	* @throws com.segmax.portlet.sample.NoSuchScheduleException if a schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Schedule[] findBySurgeryId_PrevAndNext(
		long scheduleId, long surgeryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchScheduleException;

	/**
	* Removes all the schedules where surgeryId = &#63; from the database.
	*
	* @param surgeryId the surgery ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySurgeryId(long surgeryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of schedules where surgeryId = &#63;.
	*
	* @param surgeryId the surgery ID
	* @return the number of matching schedules
	* @throws SystemException if a system exception occurred
	*/
	public int countBySurgeryId(long surgeryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the schedule in the entity cache if it is enabled.
	*
	* @param schedule the schedule
	*/
	public void cacheResult(com.segmax.portlet.sample.model.Schedule schedule);

	/**
	* Caches the schedules in the entity cache if it is enabled.
	*
	* @param schedules the schedules
	*/
	public void cacheResult(
		java.util.List<com.segmax.portlet.sample.model.Schedule> schedules);

	/**
	* Creates a new schedule with the primary key. Does not add the schedule to the database.
	*
	* @param scheduleId the primary key for the new schedule
	* @return the new schedule
	*/
	public com.segmax.portlet.sample.model.Schedule create(long scheduleId);

	/**
	* Removes the schedule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scheduleId the primary key of the schedule
	* @return the schedule that was removed
	* @throws com.segmax.portlet.sample.NoSuchScheduleException if a schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Schedule remove(long scheduleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchScheduleException;

	public com.segmax.portlet.sample.model.Schedule updateImpl(
		com.segmax.portlet.sample.model.Schedule schedule)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the schedule with the primary key or throws a {@link com.segmax.portlet.sample.NoSuchScheduleException} if it could not be found.
	*
	* @param scheduleId the primary key of the schedule
	* @return the schedule
	* @throws com.segmax.portlet.sample.NoSuchScheduleException if a schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Schedule findByPrimaryKey(
		long scheduleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchScheduleException;

	/**
	* Returns the schedule with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param scheduleId the primary key of the schedule
	* @return the schedule, or <code>null</code> if a schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Schedule fetchByPrimaryKey(
		long scheduleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the schedules.
	*
	* @return the schedules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.segmax.portlet.sample.model.Schedule> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.segmax.portlet.sample.model.Schedule> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the schedules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.segmax.portlet.sample.model.impl.ScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of schedules
	* @param end the upper bound of the range of schedules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of schedules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.segmax.portlet.sample.model.Schedule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the schedules from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of schedules.
	*
	* @return the number of schedules
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}