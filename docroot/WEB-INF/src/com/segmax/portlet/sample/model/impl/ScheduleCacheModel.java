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

import com.segmax.portlet.sample.model.Schedule;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Schedule in entity cache.
 *
 * @author segmax
 * @see Schedule
 * @generated
 */
public class ScheduleCacheModel implements CacheModel<Schedule>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{scheduleId=");
		sb.append(scheduleId);
		sb.append(", surgeryId=");
		sb.append(surgeryId);
		sb.append(", day=");
		sb.append(day);
		sb.append(", hour=");
		sb.append(hour);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Schedule toEntityModel() {
		ScheduleImpl scheduleImpl = new ScheduleImpl();

		scheduleImpl.setScheduleId(scheduleId);
		scheduleImpl.setSurgeryId(surgeryId);
		scheduleImpl.setDay(day);
		scheduleImpl.setHour(hour);

		scheduleImpl.resetOriginalValues();

		return scheduleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		scheduleId = objectInput.readLong();
		surgeryId = objectInput.readLong();
		day = objectInput.readInt();
		hour = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(scheduleId);
		objectOutput.writeLong(surgeryId);
		objectOutput.writeInt(day);
		objectOutput.writeInt(hour);
	}

	public long scheduleId;
	public long surgeryId;
	public int day;
	public int hour;
}