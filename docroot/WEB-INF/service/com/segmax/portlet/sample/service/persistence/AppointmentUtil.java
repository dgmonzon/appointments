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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.segmax.portlet.sample.model.Appointment;

import java.util.List;

/**
 * The persistence utility for the appointment service. This utility wraps {@link AppointmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author segmax
 * @see AppointmentPersistence
 * @see AppointmentPersistenceImpl
 * @generated
 */
public class AppointmentUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Appointment appointment) {
		getPersistence().clearCache(appointment);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Appointment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Appointment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Appointment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Appointment update(Appointment appointment)
		throws SystemException {
		return getPersistence().update(appointment);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Appointment update(Appointment appointment,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(appointment, serviceContext);
	}

	/**
	* Returns all the appointments where surgeryId = &#63;.
	*
	* @param surgeryId the surgery ID
	* @return the matching appointments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.segmax.portlet.sample.model.Appointment> findBySurgeryId(
		long surgeryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySurgeryId(surgeryId);
	}

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
	public static java.util.List<com.segmax.portlet.sample.model.Appointment> findBySurgeryId(
		long surgeryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySurgeryId(surgeryId, start, end);
	}

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
	public static java.util.List<com.segmax.portlet.sample.model.Appointment> findBySurgeryId(
		long surgeryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurgeryId(surgeryId, start, end, orderByComparator);
	}

	/**
	* Returns the first appointment in the ordered set where surgeryId = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appointment
	* @throws com.segmax.portlet.sample.NoSuchAppointmentException if a matching appointment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.segmax.portlet.sample.model.Appointment findBySurgeryId_First(
		long surgeryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchAppointmentException {
		return getPersistence()
				   .findBySurgeryId_First(surgeryId, orderByComparator);
	}

	/**
	* Returns the first appointment in the ordered set where surgeryId = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appointment, or <code>null</code> if a matching appointment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.segmax.portlet.sample.model.Appointment fetchBySurgeryId_First(
		long surgeryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurgeryId_First(surgeryId, orderByComparator);
	}

	/**
	* Returns the last appointment in the ordered set where surgeryId = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appointment
	* @throws com.segmax.portlet.sample.NoSuchAppointmentException if a matching appointment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.segmax.portlet.sample.model.Appointment findBySurgeryId_Last(
		long surgeryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchAppointmentException {
		return getPersistence()
				   .findBySurgeryId_Last(surgeryId, orderByComparator);
	}

	/**
	* Returns the last appointment in the ordered set where surgeryId = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appointment, or <code>null</code> if a matching appointment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.segmax.portlet.sample.model.Appointment fetchBySurgeryId_Last(
		long surgeryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurgeryId_Last(surgeryId, orderByComparator);
	}

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
	public static com.segmax.portlet.sample.model.Appointment[] findBySurgeryId_PrevAndNext(
		long appId, long surgeryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchAppointmentException {
		return getPersistence()
				   .findBySurgeryId_PrevAndNext(appId, surgeryId,
			orderByComparator);
	}

	/**
	* Removes all the appointments where surgeryId = &#63; from the database.
	*
	* @param surgeryId the surgery ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySurgeryId(long surgeryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySurgeryId(surgeryId);
	}

	/**
	* Returns the number of appointments where surgeryId = &#63;.
	*
	* @param surgeryId the surgery ID
	* @return the number of matching appointments
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySurgeryId(long surgeryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySurgeryId(surgeryId);
	}

	/**
	* Returns all the appointments where visitorId = &#63;.
	*
	* @param visitorId the visitor ID
	* @return the matching appointments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.segmax.portlet.sample.model.Appointment> findByVisitorId(
		long visitorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVisitorId(visitorId);
	}

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
	public static java.util.List<com.segmax.portlet.sample.model.Appointment> findByVisitorId(
		long visitorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVisitorId(visitorId, start, end);
	}

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
	public static java.util.List<com.segmax.portlet.sample.model.Appointment> findByVisitorId(
		long visitorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVisitorId(visitorId, start, end, orderByComparator);
	}

	/**
	* Returns the first appointment in the ordered set where visitorId = &#63;.
	*
	* @param visitorId the visitor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appointment
	* @throws com.segmax.portlet.sample.NoSuchAppointmentException if a matching appointment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.segmax.portlet.sample.model.Appointment findByVisitorId_First(
		long visitorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchAppointmentException {
		return getPersistence()
				   .findByVisitorId_First(visitorId, orderByComparator);
	}

	/**
	* Returns the first appointment in the ordered set where visitorId = &#63;.
	*
	* @param visitorId the visitor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appointment, or <code>null</code> if a matching appointment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.segmax.portlet.sample.model.Appointment fetchByVisitorId_First(
		long visitorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVisitorId_First(visitorId, orderByComparator);
	}

	/**
	* Returns the last appointment in the ordered set where visitorId = &#63;.
	*
	* @param visitorId the visitor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appointment
	* @throws com.segmax.portlet.sample.NoSuchAppointmentException if a matching appointment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.segmax.portlet.sample.model.Appointment findByVisitorId_Last(
		long visitorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchAppointmentException {
		return getPersistence()
				   .findByVisitorId_Last(visitorId, orderByComparator);
	}

	/**
	* Returns the last appointment in the ordered set where visitorId = &#63;.
	*
	* @param visitorId the visitor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appointment, or <code>null</code> if a matching appointment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.segmax.portlet.sample.model.Appointment fetchByVisitorId_Last(
		long visitorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVisitorId_Last(visitorId, orderByComparator);
	}

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
	public static com.segmax.portlet.sample.model.Appointment[] findByVisitorId_PrevAndNext(
		long appId, long visitorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchAppointmentException {
		return getPersistence()
				   .findByVisitorId_PrevAndNext(appId, visitorId,
			orderByComparator);
	}

	/**
	* Removes all the appointments where visitorId = &#63; from the database.
	*
	* @param visitorId the visitor ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVisitorId(long visitorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVisitorId(visitorId);
	}

	/**
	* Returns the number of appointments where visitorId = &#63;.
	*
	* @param visitorId the visitor ID
	* @return the number of matching appointments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVisitorId(long visitorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVisitorId(visitorId);
	}

	/**
	* Returns all the appointments where surgeryId = &#63; and appDate = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param appDate the app date
	* @return the matching appointments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.segmax.portlet.sample.model.Appointment> findBySurgeryAndAppDate(
		long surgeryId, java.util.Date appDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySurgeryAndAppDate(surgeryId, appDate);
	}

	/**
	* Returns a range of all the appointments where surgeryId = &#63; and appDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.segmax.portlet.sample.model.impl.AppointmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surgeryId the surgery ID
	* @param appDate the app date
	* @param start the lower bound of the range of appointments
	* @param end the upper bound of the range of appointments (not inclusive)
	* @return the range of matching appointments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.segmax.portlet.sample.model.Appointment> findBySurgeryAndAppDate(
		long surgeryId, java.util.Date appDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurgeryAndAppDate(surgeryId, appDate, start, end);
	}

	/**
	* Returns an ordered range of all the appointments where surgeryId = &#63; and appDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.segmax.portlet.sample.model.impl.AppointmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surgeryId the surgery ID
	* @param appDate the app date
	* @param start the lower bound of the range of appointments
	* @param end the upper bound of the range of appointments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching appointments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.segmax.portlet.sample.model.Appointment> findBySurgeryAndAppDate(
		long surgeryId, java.util.Date appDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurgeryAndAppDate(surgeryId, appDate, start, end,
			orderByComparator);
	}

	/**
	* Returns the first appointment in the ordered set where surgeryId = &#63; and appDate = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param appDate the app date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appointment
	* @throws com.segmax.portlet.sample.NoSuchAppointmentException if a matching appointment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.segmax.portlet.sample.model.Appointment findBySurgeryAndAppDate_First(
		long surgeryId, java.util.Date appDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchAppointmentException {
		return getPersistence()
				   .findBySurgeryAndAppDate_First(surgeryId, appDate,
			orderByComparator);
	}

	/**
	* Returns the first appointment in the ordered set where surgeryId = &#63; and appDate = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param appDate the app date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appointment, or <code>null</code> if a matching appointment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.segmax.portlet.sample.model.Appointment fetchBySurgeryAndAppDate_First(
		long surgeryId, java.util.Date appDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurgeryAndAppDate_First(surgeryId, appDate,
			orderByComparator);
	}

	/**
	* Returns the last appointment in the ordered set where surgeryId = &#63; and appDate = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param appDate the app date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appointment
	* @throws com.segmax.portlet.sample.NoSuchAppointmentException if a matching appointment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.segmax.portlet.sample.model.Appointment findBySurgeryAndAppDate_Last(
		long surgeryId, java.util.Date appDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchAppointmentException {
		return getPersistence()
				   .findBySurgeryAndAppDate_Last(surgeryId, appDate,
			orderByComparator);
	}

	/**
	* Returns the last appointment in the ordered set where surgeryId = &#63; and appDate = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param appDate the app date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appointment, or <code>null</code> if a matching appointment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.segmax.portlet.sample.model.Appointment fetchBySurgeryAndAppDate_Last(
		long surgeryId, java.util.Date appDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurgeryAndAppDate_Last(surgeryId, appDate,
			orderByComparator);
	}

	/**
	* Returns the appointments before and after the current appointment in the ordered set where surgeryId = &#63; and appDate = &#63;.
	*
	* @param appId the primary key of the current appointment
	* @param surgeryId the surgery ID
	* @param appDate the app date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next appointment
	* @throws com.segmax.portlet.sample.NoSuchAppointmentException if a appointment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.segmax.portlet.sample.model.Appointment[] findBySurgeryAndAppDate_PrevAndNext(
		long appId, long surgeryId, java.util.Date appDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchAppointmentException {
		return getPersistence()
				   .findBySurgeryAndAppDate_PrevAndNext(appId, surgeryId,
			appDate, orderByComparator);
	}

	/**
	* Removes all the appointments where surgeryId = &#63; and appDate = &#63; from the database.
	*
	* @param surgeryId the surgery ID
	* @param appDate the app date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySurgeryAndAppDate(long surgeryId,
		java.util.Date appDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySurgeryAndAppDate(surgeryId, appDate);
	}

	/**
	* Returns the number of appointments where surgeryId = &#63; and appDate = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param appDate the app date
	* @return the number of matching appointments
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySurgeryAndAppDate(long surgeryId,
		java.util.Date appDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySurgeryAndAppDate(surgeryId, appDate);
	}

	/**
	* Returns all the appointments where surgeryId = &#63; and visitorId = &#63; and appDate = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param visitorId the visitor ID
	* @param appDate the app date
	* @return the matching appointments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.segmax.portlet.sample.model.Appointment> findBySurgeryAndVisitorAndAppDate(
		long surgeryId, long visitorId, java.util.Date appDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurgeryAndVisitorAndAppDate(surgeryId, visitorId,
			appDate);
	}

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
	public static java.util.List<com.segmax.portlet.sample.model.Appointment> findBySurgeryAndVisitorAndAppDate(
		long surgeryId, long visitorId, java.util.Date appDate, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurgeryAndVisitorAndAppDate(surgeryId, visitorId,
			appDate, start, end);
	}

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
	public static java.util.List<com.segmax.portlet.sample.model.Appointment> findBySurgeryAndVisitorAndAppDate(
		long surgeryId, long visitorId, java.util.Date appDate, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurgeryAndVisitorAndAppDate(surgeryId, visitorId,
			appDate, start, end, orderByComparator);
	}

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
	public static com.segmax.portlet.sample.model.Appointment findBySurgeryAndVisitorAndAppDate_First(
		long surgeryId, long visitorId, java.util.Date appDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchAppointmentException {
		return getPersistence()
				   .findBySurgeryAndVisitorAndAppDate_First(surgeryId,
			visitorId, appDate, orderByComparator);
	}

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
	public static com.segmax.portlet.sample.model.Appointment fetchBySurgeryAndVisitorAndAppDate_First(
		long surgeryId, long visitorId, java.util.Date appDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurgeryAndVisitorAndAppDate_First(surgeryId,
			visitorId, appDate, orderByComparator);
	}

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
	public static com.segmax.portlet.sample.model.Appointment findBySurgeryAndVisitorAndAppDate_Last(
		long surgeryId, long visitorId, java.util.Date appDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchAppointmentException {
		return getPersistence()
				   .findBySurgeryAndVisitorAndAppDate_Last(surgeryId,
			visitorId, appDate, orderByComparator);
	}

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
	public static com.segmax.portlet.sample.model.Appointment fetchBySurgeryAndVisitorAndAppDate_Last(
		long surgeryId, long visitorId, java.util.Date appDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurgeryAndVisitorAndAppDate_Last(surgeryId,
			visitorId, appDate, orderByComparator);
	}

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
	public static com.segmax.portlet.sample.model.Appointment[] findBySurgeryAndVisitorAndAppDate_PrevAndNext(
		long appId, long surgeryId, long visitorId, java.util.Date appDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchAppointmentException {
		return getPersistence()
				   .findBySurgeryAndVisitorAndAppDate_PrevAndNext(appId,
			surgeryId, visitorId, appDate, orderByComparator);
	}

	/**
	* Removes all the appointments where surgeryId = &#63; and visitorId = &#63; and appDate = &#63; from the database.
	*
	* @param surgeryId the surgery ID
	* @param visitorId the visitor ID
	* @param appDate the app date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySurgeryAndVisitorAndAppDate(long surgeryId,
		long visitorId, java.util.Date appDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeBySurgeryAndVisitorAndAppDate(surgeryId, visitorId, appDate);
	}

	/**
	* Returns the number of appointments where surgeryId = &#63; and visitorId = &#63; and appDate = &#63;.
	*
	* @param surgeryId the surgery ID
	* @param visitorId the visitor ID
	* @param appDate the app date
	* @return the number of matching appointments
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySurgeryAndVisitorAndAppDate(long surgeryId,
		long visitorId, java.util.Date appDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBySurgeryAndVisitorAndAppDate(surgeryId, visitorId,
			appDate);
	}

	/**
	* Caches the appointment in the entity cache if it is enabled.
	*
	* @param appointment the appointment
	*/
	public static void cacheResult(
		com.segmax.portlet.sample.model.Appointment appointment) {
		getPersistence().cacheResult(appointment);
	}

	/**
	* Caches the appointments in the entity cache if it is enabled.
	*
	* @param appointments the appointments
	*/
	public static void cacheResult(
		java.util.List<com.segmax.portlet.sample.model.Appointment> appointments) {
		getPersistence().cacheResult(appointments);
	}

	/**
	* Creates a new appointment with the primary key. Does not add the appointment to the database.
	*
	* @param appId the primary key for the new appointment
	* @return the new appointment
	*/
	public static com.segmax.portlet.sample.model.Appointment create(long appId) {
		return getPersistence().create(appId);
	}

	/**
	* Removes the appointment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param appId the primary key of the appointment
	* @return the appointment that was removed
	* @throws com.segmax.portlet.sample.NoSuchAppointmentException if a appointment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.segmax.portlet.sample.model.Appointment remove(long appId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchAppointmentException {
		return getPersistence().remove(appId);
	}

	public static com.segmax.portlet.sample.model.Appointment updateImpl(
		com.segmax.portlet.sample.model.Appointment appointment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(appointment);
	}

	/**
	* Returns the appointment with the primary key or throws a {@link com.segmax.portlet.sample.NoSuchAppointmentException} if it could not be found.
	*
	* @param appId the primary key of the appointment
	* @return the appointment
	* @throws com.segmax.portlet.sample.NoSuchAppointmentException if a appointment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.segmax.portlet.sample.model.Appointment findByPrimaryKey(
		long appId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.segmax.portlet.sample.NoSuchAppointmentException {
		return getPersistence().findByPrimaryKey(appId);
	}

	/**
	* Returns the appointment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param appId the primary key of the appointment
	* @return the appointment, or <code>null</code> if a appointment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.segmax.portlet.sample.model.Appointment fetchByPrimaryKey(
		long appId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(appId);
	}

	/**
	* Returns all the appointments.
	*
	* @return the appointments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.segmax.portlet.sample.model.Appointment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.segmax.portlet.sample.model.Appointment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.segmax.portlet.sample.model.Appointment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the appointments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of appointments.
	*
	* @return the number of appointments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AppointmentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AppointmentPersistence)PortletBeanLocatorUtil.locate(com.segmax.portlet.sample.service.ClpSerializer.getServletContextName(),
					AppointmentPersistence.class.getName());

			ReferenceRegistry.registerReference(AppointmentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AppointmentPersistence persistence) {
	}

	private static AppointmentPersistence _persistence;
}