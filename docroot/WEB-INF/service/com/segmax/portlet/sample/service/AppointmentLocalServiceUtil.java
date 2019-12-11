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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Appointment. This utility wraps
 * {@link com.segmax.portlet.sample.service.impl.AppointmentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author segmax
 * @see AppointmentLocalService
 * @see com.segmax.portlet.sample.service.base.AppointmentLocalServiceBaseImpl
 * @see com.segmax.portlet.sample.service.impl.AppointmentLocalServiceImpl
 * @generated
 */
public class AppointmentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.segmax.portlet.sample.service.impl.AppointmentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the appointment to the database. Also notifies the appropriate model listeners.
	*
	* @param appointment the appointment
	* @return the appointment that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.segmax.portlet.sample.model.Appointment addAppointment(
		com.segmax.portlet.sample.model.Appointment appointment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAppointment(appointment);
	}

	/**
	* Creates a new appointment with the primary key. Does not add the appointment to the database.
	*
	* @param appId the primary key for the new appointment
	* @return the new appointment
	*/
	public static com.segmax.portlet.sample.model.Appointment createAppointment(
		long appId) {
		return getService().createAppointment(appId);
	}

	/**
	* Deletes the appointment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param appId the primary key of the appointment
	* @return the appointment that was removed
	* @throws PortalException if a appointment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.segmax.portlet.sample.model.Appointment deleteAppointment(
		long appId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAppointment(appId);
	}

	/**
	* Deletes the appointment from the database. Also notifies the appropriate model listeners.
	*
	* @param appointment the appointment
	* @return the appointment that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.segmax.portlet.sample.model.Appointment deleteAppointment(
		com.segmax.portlet.sample.model.Appointment appointment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAppointment(appointment);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.segmax.portlet.sample.model.impl.AppointmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.segmax.portlet.sample.model.impl.AppointmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.segmax.portlet.sample.model.Appointment fetchAppointment(
		long appId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAppointment(appId);
	}

	/**
	* Returns the appointment with the primary key.
	*
	* @param appId the primary key of the appointment
	* @return the appointment
	* @throws PortalException if a appointment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.segmax.portlet.sample.model.Appointment getAppointment(
		long appId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAppointment(appId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.segmax.portlet.sample.model.Appointment> getAppointments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAppointments(start, end);
	}

	/**
	* Returns the number of appointments.
	*
	* @return the number of appointments
	* @throws SystemException if a system exception occurred
	*/
	public static int getAppointmentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAppointmentsCount();
	}

	/**
	* Updates the appointment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param appointment the appointment
	* @return the appointment that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.segmax.portlet.sample.model.Appointment updateAppointment(
		com.segmax.portlet.sample.model.Appointment appointment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAppointment(appointment);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void addAppointment(java.lang.Long surgeryId,
		java.lang.Long visitorId, java.util.Date appDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addAppointment(surgeryId, visitorId, appDate);
	}

	public static java.util.List<com.segmax.portlet.sample.model.Appointment> getBySurgery(
		java.lang.Long surgeryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBySurgery(surgeryId);
	}

	public static java.util.List<com.segmax.portlet.sample.model.Appointment> getByVisitor(
		java.lang.Long visitorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByVisitor(visitorId);
	}

	public static java.util.List<com.segmax.portlet.sample.model.Appointment> getBySurgeryAndAppDate(
		java.lang.Long surgeryId, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBySurgeryAndAppDate(surgeryId, date);
	}

	public static java.util.List<com.segmax.portlet.sample.model.Appointment> getBySurgeryAndVisitorAndAppDate(
		java.lang.Long surgeryId, java.lang.Long visitorId, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getBySurgeryAndVisitorAndAppDate(surgeryId, visitorId, date);
	}

	public static void clearService() {
		_service = null;
	}

	public static AppointmentLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AppointmentLocalService.class.getName());

			if (invokableLocalService instanceof AppointmentLocalService) {
				_service = (AppointmentLocalService)invokableLocalService;
			}
			else {
				_service = new AppointmentLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(AppointmentLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(AppointmentLocalService service) {
	}

	private static AppointmentLocalService _service;
}