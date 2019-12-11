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

import com.segmax.portlet.sample.model.Appointment;

/**
 * The persistence interface for the appointment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author segmax
 * @see AppointmentPersistenceImpl
 * @see AppointmentUtil
 * @generated
 */
public interface AppointmentPersistence extends BasePersistence<Appointment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppointmentUtil} to access the appointment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the appointments where surgeryId = &#63;.
	*
	* @param surgeryId the surgery ID
	* @return the matching appointments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.segmax.portlet.sample.model.Appointment> findBySurgeryId(
		long surgeryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the appointments where surgeryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.segmax.portlet.sample.model.impl.AppointmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surgeryId the surgery ID
	* @param start the lower bound of the range of appointments
	* @param end the upper bound of the range of appointments (not inclusive)
	* @return the range of matching appointments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.segmax.portlet.sample.model.Appointment> findBySurgeryId(
		long surgeryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the appointments where surgeryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.segmax.portlet.sample.model.impl.AppointmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surgeryId the surgery ID
	* @param start the lower bound of the range of appointments
	* @param end the upper bound of the range of appointments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching appointments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.segmax.portlet.sample.model.Appointment> findBySurgeryId(
		long surgeryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first appointment in the ordered set where surgeryId = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appointment
	* @throws com.segmax.portlet.sample.NoSuchAppointmentException if a matching appointment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Appointment findBySurgeryId_First(
		long surgeryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchAppointmentException;

	/**
	* Returns the first appointment in the ordered set where surgeryId = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appointment, or <code>null</code> if a matching appointment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Appointment fetchBySurgeryId_First(
		long surgeryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last appointment in the ordered set where surgeryId = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appointment
	* @throws com.segmax.portlet.sample.NoSuchAppointmentException if a matching appointment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Appointment findBySurgeryId_Last(
		long surgeryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchAppointmentException;

	/**
	* Returns the last appointment in the ordered set where surgeryId = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appointment, or <code>null</code> if a matching appointment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Appointment fetchBySurgeryId_Last(
		long surgeryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the appointments before and after the current appointment in the ordered set where surgeryId = &#63;.
	*
	* @param appId the primary key of the current appointment
	* @param surgeryId the surgery ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next appointment
	* @throws com.segmax.portlet.sample.NoSuchAppointmentException if a appointment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Appointment[] findBySurgeryId_PrevAndNext(
		long appId, long surgeryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchAppointmentException;

	/**
	* Removes all the appointments where surgeryId = &#63; from the database.
	*
	* @param surgeryId the surgery ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySurgeryId(long surgeryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of appointments where surgeryId = &#63;.
	*
	* @param surgeryId the surgery ID
	* @return the number of matching appointments
	* @throws SystemException if a system exception occurred
	*/
	public int countBySurgeryId(long surgeryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the appointments where visitorId = &#63;.
	*
	* @param visitorId the visitor ID
	* @return the matching appointments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.segmax.portlet.sample.model.Appointment> findByVisitorId(
		long visitorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the appointments where visitorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.segmax.portlet.sample.model.impl.AppointmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param visitorId the visitor ID
	* @param start the lower bound of the range of appointments
	* @param end the upper bound of the range of appointments (not inclusive)
	* @return the range of matching appointments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.segmax.portlet.sample.model.Appointment> findByVisitorId(
		long visitorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the appointments where visitorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.segmax.portlet.sample.model.impl.AppointmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param visitorId the visitor ID
	* @param start the lower bound of the range of appointments
	* @param end the upper bound of the range of appointments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching appointments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.segmax.portlet.sample.model.Appointment> findByVisitorId(
		long visitorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first appointment in the ordered set where visitorId = &#63;.
	*
	* @param visitorId the visitor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appointment
	* @throws com.segmax.portlet.sample.NoSuchAppointmentException if a matching appointment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Appointment findByVisitorId_First(
		long visitorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchAppointmentException;

	/**
	* Returns the first appointment in the ordered set where visitorId = &#63;.
	*
	* @param visitorId the visitor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appointment, or <code>null</code> if a matching appointment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Appointment fetchByVisitorId_First(
		long visitorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last appointment in the ordered set where visitorId = &#63;.
	*
	* @param visitorId the visitor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appointment
	* @throws com.segmax.portlet.sample.NoSuchAppointmentException if a matching appointment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Appointment findByVisitorId_Last(
		long visitorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchAppointmentException;

	/**
	* Returns the last appointment in the ordered set where visitorId = &#63;.
	*
	* @param visitorId the visitor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appointment, or <code>null</code> if a matching appointment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Appointment fetchByVisitorId_Last(
		long visitorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the appointments before and after the current appointment in the ordered set where visitorId = &#63;.
	*
	* @param appId the primary key of the current appointment
	* @param visitorId the visitor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next appointment
	* @throws com.segmax.portlet.sample.NoSuchAppointmentException if a appointment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Appointment[] findByVisitorId_PrevAndNext(
		long appId, long visitorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchAppointmentException;

	/**
	* Removes all the appointments where visitorId = &#63; from the database.
	*
	* @param visitorId the visitor ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVisitorId(long visitorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of appointments where visitorId = &#63;.
	*
	* @param visitorId the visitor ID
	* @return the number of matching appointments
	* @throws SystemException if a system exception occurred
	*/
	public int countByVisitorId(long visitorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the appointments where surgeryId = &#63; and visitorId = &#63; and appDate = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param visitorId the visitor ID
	* @param appDate the app date
	* @return the matching appointments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.segmax.portlet.sample.model.Appointment> findBySurgeryAndVisitorAndAppDate(
		long surgeryId, long visitorId, java.util.Date appDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the appointments where surgeryId = &#63; and visitorId = &#63; and appDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.segmax.portlet.sample.model.impl.AppointmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surgeryId the surgery ID
	* @param visitorId the visitor ID
	* @param appDate the app date
	* @param start the lower bound of the range of appointments
	* @param end the upper bound of the range of appointments (not inclusive)
	* @return the range of matching appointments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.segmax.portlet.sample.model.Appointment> findBySurgeryAndVisitorAndAppDate(
		long surgeryId, long visitorId, java.util.Date appDate, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the appointments where surgeryId = &#63; and visitorId = &#63; and appDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.segmax.portlet.sample.model.impl.AppointmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surgeryId the surgery ID
	* @param visitorId the visitor ID
	* @param appDate the app date
	* @param start the lower bound of the range of appointments
	* @param end the upper bound of the range of appointments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching appointments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.segmax.portlet.sample.model.Appointment> findBySurgeryAndVisitorAndAppDate(
		long surgeryId, long visitorId, java.util.Date appDate, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first appointment in the ordered set where surgeryId = &#63; and visitorId = &#63; and appDate = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param visitorId the visitor ID
	* @param appDate the app date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appointment
	* @throws com.segmax.portlet.sample.NoSuchAppointmentException if a matching appointment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Appointment findBySurgeryAndVisitorAndAppDate_First(
		long surgeryId, long visitorId, java.util.Date appDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchAppointmentException;

	/**
	* Returns the first appointment in the ordered set where surgeryId = &#63; and visitorId = &#63; and appDate = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param visitorId the visitor ID
	* @param appDate the app date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appointment, or <code>null</code> if a matching appointment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Appointment fetchBySurgeryAndVisitorAndAppDate_First(
		long surgeryId, long visitorId, java.util.Date appDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last appointment in the ordered set where surgeryId = &#63; and visitorId = &#63; and appDate = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param visitorId the visitor ID
	* @param appDate the app date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appointment
	* @throws com.segmax.portlet.sample.NoSuchAppointmentException if a matching appointment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Appointment findBySurgeryAndVisitorAndAppDate_Last(
		long surgeryId, long visitorId, java.util.Date appDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchAppointmentException;

	/**
	* Returns the last appointment in the ordered set where surgeryId = &#63; and visitorId = &#63; and appDate = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param visitorId the visitor ID
	* @param appDate the app date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appointment, or <code>null</code> if a matching appointment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Appointment fetchBySurgeryAndVisitorAndAppDate_Last(
		long surgeryId, long visitorId, java.util.Date appDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the appointments before and after the current appointment in the ordered set where surgeryId = &#63; and visitorId = &#63; and appDate = &#63;.
	*
	* @param appId the primary key of the current appointment
	* @param surgeryId the surgery ID
	* @param visitorId the visitor ID
	* @param appDate the app date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next appointment
	* @throws com.segmax.portlet.sample.NoSuchAppointmentException if a appointment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Appointment[] findBySurgeryAndVisitorAndAppDate_PrevAndNext(
		long appId, long surgeryId, long visitorId, java.util.Date appDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchAppointmentException;

	/**
	* Removes all the appointments where surgeryId = &#63; and visitorId = &#63; and appDate = &#63; from the database.
	*
	* @param surgeryId the surgery ID
	* @param visitorId the visitor ID
	* @param appDate the app date
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySurgeryAndVisitorAndAppDate(long surgeryId,
		long visitorId, java.util.Date appDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of appointments where surgeryId = &#63; and visitorId = &#63; and appDate = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param visitorId the visitor ID
	* @param appDate the app date
	* @return the number of matching appointments
	* @throws SystemException if a system exception occurred
	*/
	public int countBySurgeryAndVisitorAndAppDate(long surgeryId,
		long visitorId, java.util.Date appDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the appointment in the entity cache if it is enabled.
	*
	* @param appointment the appointment
	*/
	public void cacheResult(
		com.segmax.portlet.sample.model.Appointment appointment);

	/**
	* Caches the appointments in the entity cache if it is enabled.
	*
	* @param appointments the appointments
	*/
	public void cacheResult(
		java.util.List<com.segmax.portlet.sample.model.Appointment> appointments);

	/**
	* Creates a new appointment with the primary key. Does not add the appointment to the database.
	*
	* @param appId the primary key for the new appointment
	* @return the new appointment
	*/
	public com.segmax.portlet.sample.model.Appointment create(long appId);

	/**
	* Removes the appointment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param appId the primary key of the appointment
	* @return the appointment that was removed
	* @throws com.segmax.portlet.sample.NoSuchAppointmentException if a appointment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Appointment remove(long appId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchAppointmentException;

	public com.segmax.portlet.sample.model.Appointment updateImpl(
		com.segmax.portlet.sample.model.Appointment appointment)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the appointment with the primary key or throws a {@link com.segmax.portlet.sample.NoSuchAppointmentException} if it could not be found.
	*
	* @param appId the primary key of the appointment
	* @return the appointment
	* @throws com.segmax.portlet.sample.NoSuchAppointmentException if a appointment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Appointment findByPrimaryKey(
		long appId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchAppointmentException;

	/**
	* Returns the appointment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param appId the primary key of the appointment
	* @return the appointment, or <code>null</code> if a appointment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.segmax.portlet.sample.model.Appointment fetchByPrimaryKey(
		long appId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the appointments.
	*
	* @return the appointments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.segmax.portlet.sample.model.Appointment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the appointments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.segmax.portlet.sample.model.impl.AppointmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appointments
	* @param end the upper bound of the range of appointments (not inclusive)
	* @return the range of appointments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.segmax.portlet.sample.model.Appointment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the appointments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.segmax.portlet.sample.model.impl.AppointmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appointments
	* @param end the upper bound of the range of appointments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of appointments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.segmax.portlet.sample.model.Appointment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the appointments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of appointments.
	*
	* @return the number of appointments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}