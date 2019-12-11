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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Appointment}.
 * </p>
 *
 * @author segmax
 * @see Appointment
 * @generated
 */
public class AppointmentWrapper implements Appointment,
	ModelWrapper<Appointment> {
	public AppointmentWrapper(Appointment appointment) {
		_appointment = appointment;
	}

	@Override
	public Class<?> getModelClass() {
		return Appointment.class;
	}

	@Override
	public String getModelClassName() {
		return Appointment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("appId", getAppId());
		attributes.put("appDate", getAppDate());
		attributes.put("surgeryId", getSurgeryId());
		attributes.put("visitorId", getVisitorId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long appId = (Long)attributes.get("appId");

		if (appId != null) {
			setAppId(appId);
		}

		Date appDate = (Date)attributes.get("appDate");

		if (appDate != null) {
			setAppDate(appDate);
		}

		Long surgeryId = (Long)attributes.get("surgeryId");

		if (surgeryId != null) {
			setSurgeryId(surgeryId);
		}

		Long visitorId = (Long)attributes.get("visitorId");

		if (visitorId != null) {
			setVisitorId(visitorId);
		}
	}

	/**
	* Returns the primary key of this appointment.
	*
	* @return the primary key of this appointment
	*/
	@Override
	public long getPrimaryKey() {
		return _appointment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this appointment.
	*
	* @param primaryKey the primary key of this appointment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_appointment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the app ID of this appointment.
	*
	* @return the app ID of this appointment
	*/
	@Override
	public long getAppId() {
		return _appointment.getAppId();
	}

	/**
	* Sets the app ID of this appointment.
	*
	* @param appId the app ID of this appointment
	*/
	@Override
	public void setAppId(long appId) {
		_appointment.setAppId(appId);
	}

	/**
	* Returns the app date of this appointment.
	*
	* @return the app date of this appointment
	*/
	@Override
	public java.util.Date getAppDate() {
		return _appointment.getAppDate();
	}

	/**
	* Sets the app date of this appointment.
	*
	* @param appDate the app date of this appointment
	*/
	@Override
	public void setAppDate(java.util.Date appDate) {
		_appointment.setAppDate(appDate);
	}

	/**
	* Returns the surgery ID of this appointment.
	*
	* @return the surgery ID of this appointment
	*/
	@Override
	public long getSurgeryId() {
		return _appointment.getSurgeryId();
	}

	/**
	* Sets the surgery ID of this appointment.
	*
	* @param surgeryId the surgery ID of this appointment
	*/
	@Override
	public void setSurgeryId(long surgeryId) {
		_appointment.setSurgeryId(surgeryId);
	}

	/**
	* Returns the visitor ID of this appointment.
	*
	* @return the visitor ID of this appointment
	*/
	@Override
	public long getVisitorId() {
		return _appointment.getVisitorId();
	}

	/**
	* Sets the visitor ID of this appointment.
	*
	* @param visitorId the visitor ID of this appointment
	*/
	@Override
	public void setVisitorId(long visitorId) {
		_appointment.setVisitorId(visitorId);
	}

	@Override
	public boolean isNew() {
		return _appointment.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_appointment.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _appointment.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_appointment.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _appointment.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _appointment.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_appointment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _appointment.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_appointment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_appointment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_appointment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AppointmentWrapper((Appointment)_appointment.clone());
	}

	@Override
	public int compareTo(
		com.segmax.portlet.sample.model.Appointment appointment) {
		return _appointment.compareTo(appointment);
	}

	@Override
	public int hashCode() {
		return _appointment.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.segmax.portlet.sample.model.Appointment> toCacheModel() {
		return _appointment.toCacheModel();
	}

	@Override
	public com.segmax.portlet.sample.model.Appointment toEscapedModel() {
		return new AppointmentWrapper(_appointment.toEscapedModel());
	}

	@Override
	public com.segmax.portlet.sample.model.Appointment toUnescapedModel() {
		return new AppointmentWrapper(_appointment.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _appointment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _appointment.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_appointment.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AppointmentWrapper)) {
			return false;
		}

		AppointmentWrapper appointmentWrapper = (AppointmentWrapper)obj;

		if (Validator.equals(_appointment, appointmentWrapper._appointment)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Appointment getWrappedAppointment() {
		return _appointment;
	}

	@Override
	public Appointment getWrappedModel() {
		return _appointment;
	}

	@Override
	public void resetOriginalValues() {
		_appointment.resetOriginalValues();
	}

	private Appointment _appointment;
}