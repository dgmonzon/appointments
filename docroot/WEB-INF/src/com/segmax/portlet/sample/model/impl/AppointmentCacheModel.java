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

package com.segmax.portlet.sample.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.segmax.portlet.sample.model.Appointment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Appointment in entity cache.
 *
 * @author segmax
 * @see Appointment
 * @generated
 */
public class AppointmentCacheModel implements CacheModel<Appointment>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{appId=");
		sb.append(appId);
		sb.append(", appDate=");
		sb.append(appDate);
		sb.append(", surgeryId=");
		sb.append(surgeryId);
		sb.append(", visitorId=");
		sb.append(visitorId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Appointment toEntityModel() {
		AppointmentImpl appointmentImpl = new AppointmentImpl();

		appointmentImpl.setAppId(appId);

		if (appDate == Long.MIN_VALUE) {
			appointmentImpl.setAppDate(null);
		}
		else {
			appointmentImpl.setAppDate(new Date(appDate));
		}

		appointmentImpl.setSurgeryId(surgeryId);
		appointmentImpl.setVisitorId(visitorId);

		appointmentImpl.resetOriginalValues();

		return appointmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		appId = objectInput.readLong();
		appDate = objectInput.readLong();
		surgeryId = objectInput.readLong();
		visitorId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(appId);
		objectOutput.writeLong(appDate);
		objectOutput.writeLong(surgeryId);
		objectOutput.writeLong(visitorId);
	}

	public long appId;
	public long appDate;
	public long surgeryId;
	public long visitorId;
}