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
 * Provides a wrapper for {@link AppointmentLocalService}.
 *
 * @author segmax
 * @see AppointmentLocalService
 * @generated
 */
public class AppointmentLocalServiceWrapper implements AppointmentLocalService,
	ServiceWrapper<AppointmentLocalService> {
	public AppointmentLocalServiceWrapper(
		AppointmentLocalService appointmentLocalService) {
		_appointmentLocalService = appointmentLocalService;
	}

	/**
	* Adds the appointment to the database. Also notifies the appropriate model listeners.
	*
	* @param appointment the appointment
	* @return the appointment that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.segmax.portlet.sample.model.Appointment addAppointment(
		com.segmax.portlet.sample.model.Appointment appointment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _appointmentLocalService.addAppointment(appointment);
	}

	/**
	* Creates a new appointment with the primary key. Does not add the appointment to the database.
	*
	* @param appId the primary key for the new appointment
	* @return the new appointment
	*/
	@Override
	public com.segmax.portlet.sample.model.Appointment createAppointment(
		long appId) {
		return _appointmentLocalService.createAppointment(appId);
	}

	/**
	* Deletes the appointment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param appId the primary key of the appointment
	* @return the appointment that was removed
	* @throws PortalException if a appointment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.segmax.portlet.sample.model.Appointment deleteAppointment(
		long appId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _appointmentLocalService.deleteAppointment(appId);
	}

	/**
	* Deletes the appointment from the database. Also notifies the appropriate model listeners.
	*
	* @param appointment the appointment
	* @return the appointment that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.segmax.portlet.sample.model.Appointment deleteAppointment(
		com.segmax.portlet.sample.model.Appointment appointment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _appointmentLocalService.deleteAppointment(appointment);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _appointmentLocalService.dynamicQuery();
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
		return _appointmentLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _appointmentLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _appointmentLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _appointmentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _appointmentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.segmax.portlet.sample.model.Appointment fetchAppointment(
		long appId) throws com.liferay.portal.kernel.exception.SystemException {
		return _appointmentLocalService.fetchAppointment(appId);
	}

	/**
	* Returns the appointment with the primary key.
	*
	* @param appId the primary key of the appointment
	* @return the appointment
	* @throws PortalException if a appointment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.segmax.portlet.sample.model.Appointment getAppointment(
		long appId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _appointmentLocalService.getAppointment(appId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _appointmentLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.segmax.portlet.sample.model.Appointment> getAppointments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _appointmentLocalService.getAppointments(start, end);
	}

	/**
	* Returns the number of appointments.
	*
	* @return the number of appointments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAppointmentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _appointmentLocalService.getAppointmentsCount();
	}

	/**
	* Updates the appointment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param appointment the appointment
	* @return the appointment that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.segmax.portlet.sample.model.Appointment updateAppointment(
		com.segmax.portlet.sample.model.Appointment appointment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _appointmentLocalService.updateAppointment(appointment);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _appointmentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_appointmentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _appointmentLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void addAppointment(java.lang.Long surgeryId,
		java.lang.Long visitorId, java.util.Date appDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		_appointmentLocalService.addAppointment(surgeryId, visitorId, appDate);
	}

	@Override
	public java.util.List<com.segmax.portlet.sample.model.Appointment> getBySurgery(
		java.lang.Long surgeryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _appointmentLocalService.getBySurgery(surgeryId);
	}

	@Override
	public java.util.List<com.segmax.portlet.sample.model.Appointment> getByVisitor(
		java.lang.Long visitorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _appointmentLocalService.getByVisitor(visitorId);
	}

	@Override
	public java.util.List<com.segmax.portlet.sample.model.Appointment> getBySurgeryAndAppDate(
		java.lang.Long surgeryId, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _appointmentLocalService.getBySurgeryAndAppDate(surgeryId, date);
	}

	@Override
	public java.util.List<com.segmax.portlet.sample.model.Appointment> getBySurgeryAndVisitorAndAppDate(
		java.lang.Long surgeryId, java.lang.Long visitorId, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _appointmentLocalService.getBySurgeryAndVisitorAndAppDate(surgeryId,
			visitorId, date);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AppointmentLocalService getWrappedAppointmentLocalService() {
		return _appointmentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAppointmentLocalService(
		AppointmentLocalService appointmentLocalService) {
		_appointmentLocalService = appointmentLocalService;
	}

	@Override
	public AppointmentLocalService getWrappedService() {
		return _appointmentLocalService;
	}

	@Override
	public void setWrappedService(
		AppointmentLocalService appointmentLocalService) {
		_appointmentLocalService = appointmentLocalService;
	}

	private AppointmentLocalService _appointmentLocalService;
}