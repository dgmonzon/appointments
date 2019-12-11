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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.segmax.portlet.sample.NoSuchAppointmentException;
import com.segmax.portlet.sample.model.Appointment;
import com.segmax.portlet.sample.model.impl.AppointmentImpl;
import com.segmax.portlet.sample.model.impl.AppointmentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the appointment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author segmax
 * @see AppointmentPersistence
 * @see AppointmentUtil
 * @generated
 */
public class AppointmentPersistenceImpl extends BasePersistenceImpl<Appointment>
	implements AppointmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AppointmentUtil} to access the appointment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AppointmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AppointmentModelImpl.ENTITY_CACHE_ENABLED,
			AppointmentModelImpl.FINDER_CACHE_ENABLED, AppointmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AppointmentModelImpl.ENTITY_CACHE_ENABLED,
			AppointmentModelImpl.FINDER_CACHE_ENABLED, AppointmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AppointmentModelImpl.ENTITY_CACHE_ENABLED,
			AppointmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SURGERYID =
		new FinderPath(AppointmentModelImpl.ENTITY_CACHE_ENABLED,
			AppointmentModelImpl.FINDER_CACHE_ENABLED, AppointmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySurgeryId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURGERYID =
		new FinderPath(AppointmentModelImpl.ENTITY_CACHE_ENABLED,
			AppointmentModelImpl.FINDER_CACHE_ENABLED, AppointmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySurgeryId",
			new String[] { Long.class.getName() },
			AppointmentModelImpl.SURGERYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SURGERYID = new FinderPath(AppointmentModelImpl.ENTITY_CACHE_ENABLED,
			AppointmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySurgeryId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the appointments where surgeryId = &#63;.
	 *
	 * @param surgeryId the surgery ID
	 * @return the matching appointments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Appointment> findBySurgeryId(long surgeryId)
		throws SystemException {
		return findBySurgeryId(surgeryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Appointment> findBySurgeryId(long surgeryId, int start, int end)
		throws SystemException {
		return findBySurgeryId(surgeryId, start, end, null);
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
	@Override
	public List<Appointment> findBySurgeryId(long surgeryId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURGERYID;
			finderArgs = new Object[] { surgeryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SURGERYID;
			finderArgs = new Object[] { surgeryId, start, end, orderByComparator };
		}

		List<Appointment> list = (List<Appointment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Appointment appointment : list) {
				if ((surgeryId != appointment.getSurgeryId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_APPOINTMENT_WHERE);

			query.append(_FINDER_COLUMN_SURGERYID_SURGERYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AppointmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surgeryId);

				if (!pagination) {
					list = (List<Appointment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Appointment>(list);
				}
				else {
					list = (List<Appointment>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Appointment findBySurgeryId_First(long surgeryId,
		OrderByComparator orderByComparator)
		throws NoSuchAppointmentException, SystemException {
		Appointment appointment = fetchBySurgeryId_First(surgeryId,
				orderByComparator);

		if (appointment != null) {
			return appointment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surgeryId=");
		msg.append(surgeryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAppointmentException(msg.toString());
	}

	/**
	 * Returns the first appointment in the ordered set where surgeryId = &#63;.
	 *
	 * @param surgeryId the surgery ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment, or <code>null</code> if a matching appointment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Appointment fetchBySurgeryId_First(long surgeryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Appointment> list = findBySurgeryId(surgeryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Appointment findBySurgeryId_Last(long surgeryId,
		OrderByComparator orderByComparator)
		throws NoSuchAppointmentException, SystemException {
		Appointment appointment = fetchBySurgeryId_Last(surgeryId,
				orderByComparator);

		if (appointment != null) {
			return appointment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surgeryId=");
		msg.append(surgeryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAppointmentException(msg.toString());
	}

	/**
	 * Returns the last appointment in the ordered set where surgeryId = &#63;.
	 *
	 * @param surgeryId the surgery ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment, or <code>null</code> if a matching appointment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Appointment fetchBySurgeryId_Last(long surgeryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySurgeryId(surgeryId);

		if (count == 0) {
			return null;
		}

		List<Appointment> list = findBySurgeryId(surgeryId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Appointment[] findBySurgeryId_PrevAndNext(long appId,
		long surgeryId, OrderByComparator orderByComparator)
		throws NoSuchAppointmentException, SystemException {
		Appointment appointment = findByPrimaryKey(appId);

		Session session = null;

		try {
			session = openSession();

			Appointment[] array = new AppointmentImpl[3];

			array[0] = getBySurgeryId_PrevAndNext(session, appointment,
					surgeryId, orderByComparator, true);

			array[1] = appointment;

			array[2] = getBySurgeryId_PrevAndNext(session, appointment,
					surgeryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Appointment getBySurgeryId_PrevAndNext(Session session,
		Appointment appointment, long surgeryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APPOINTMENT_WHERE);

		query.append(_FINDER_COLUMN_SURGERYID_SURGERYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AppointmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(surgeryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(appointment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Appointment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appointments where surgeryId = &#63; from the database.
	 *
	 * @param surgeryId the surgery ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySurgeryId(long surgeryId) throws SystemException {
		for (Appointment appointment : findBySurgeryId(surgeryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(appointment);
		}
	}

	/**
	 * Returns the number of appointments where surgeryId = &#63;.
	 *
	 * @param surgeryId the surgery ID
	 * @return the number of matching appointments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySurgeryId(long surgeryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SURGERYID;

		Object[] finderArgs = new Object[] { surgeryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APPOINTMENT_WHERE);

			query.append(_FINDER_COLUMN_SURGERYID_SURGERYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surgeryId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SURGERYID_SURGERYID_2 = "appointment.surgeryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VISITORID =
		new FinderPath(AppointmentModelImpl.ENTITY_CACHE_ENABLED,
			AppointmentModelImpl.FINDER_CACHE_ENABLED, AppointmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVisitorId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VISITORID =
		new FinderPath(AppointmentModelImpl.ENTITY_CACHE_ENABLED,
			AppointmentModelImpl.FINDER_CACHE_ENABLED, AppointmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVisitorId",
			new String[] { Long.class.getName() },
			AppointmentModelImpl.VISITORID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VISITORID = new FinderPath(AppointmentModelImpl.ENTITY_CACHE_ENABLED,
			AppointmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVisitorId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the appointments where visitorId = &#63;.
	 *
	 * @param visitorId the visitor ID
	 * @return the matching appointments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Appointment> findByVisitorId(long visitorId)
		throws SystemException {
		return findByVisitorId(visitorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Appointment> findByVisitorId(long visitorId, int start, int end)
		throws SystemException {
		return findByVisitorId(visitorId, start, end, null);
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
	@Override
	public List<Appointment> findByVisitorId(long visitorId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VISITORID;
			finderArgs = new Object[] { visitorId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VISITORID;
			finderArgs = new Object[] { visitorId, start, end, orderByComparator };
		}

		List<Appointment> list = (List<Appointment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Appointment appointment : list) {
				if ((visitorId != appointment.getVisitorId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_APPOINTMENT_WHERE);

			query.append(_FINDER_COLUMN_VISITORID_VISITORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AppointmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(visitorId);

				if (!pagination) {
					list = (List<Appointment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Appointment>(list);
				}
				else {
					list = (List<Appointment>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Appointment findByVisitorId_First(long visitorId,
		OrderByComparator orderByComparator)
		throws NoSuchAppointmentException, SystemException {
		Appointment appointment = fetchByVisitorId_First(visitorId,
				orderByComparator);

		if (appointment != null) {
			return appointment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("visitorId=");
		msg.append(visitorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAppointmentException(msg.toString());
	}

	/**
	 * Returns the first appointment in the ordered set where visitorId = &#63;.
	 *
	 * @param visitorId the visitor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment, or <code>null</code> if a matching appointment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Appointment fetchByVisitorId_First(long visitorId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Appointment> list = findByVisitorId(visitorId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Appointment findByVisitorId_Last(long visitorId,
		OrderByComparator orderByComparator)
		throws NoSuchAppointmentException, SystemException {
		Appointment appointment = fetchByVisitorId_Last(visitorId,
				orderByComparator);

		if (appointment != null) {
			return appointment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("visitorId=");
		msg.append(visitorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAppointmentException(msg.toString());
	}

	/**
	 * Returns the last appointment in the ordered set where visitorId = &#63;.
	 *
	 * @param visitorId the visitor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment, or <code>null</code> if a matching appointment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Appointment fetchByVisitorId_Last(long visitorId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVisitorId(visitorId);

		if (count == 0) {
			return null;
		}

		List<Appointment> list = findByVisitorId(visitorId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Appointment[] findByVisitorId_PrevAndNext(long appId,
		long visitorId, OrderByComparator orderByComparator)
		throws NoSuchAppointmentException, SystemException {
		Appointment appointment = findByPrimaryKey(appId);

		Session session = null;

		try {
			session = openSession();

			Appointment[] array = new AppointmentImpl[3];

			array[0] = getByVisitorId_PrevAndNext(session, appointment,
					visitorId, orderByComparator, true);

			array[1] = appointment;

			array[2] = getByVisitorId_PrevAndNext(session, appointment,
					visitorId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Appointment getByVisitorId_PrevAndNext(Session session,
		Appointment appointment, long visitorId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APPOINTMENT_WHERE);

		query.append(_FINDER_COLUMN_VISITORID_VISITORID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AppointmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(visitorId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(appointment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Appointment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appointments where visitorId = &#63; from the database.
	 *
	 * @param visitorId the visitor ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVisitorId(long visitorId) throws SystemException {
		for (Appointment appointment : findByVisitorId(visitorId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(appointment);
		}
	}

	/**
	 * Returns the number of appointments where visitorId = &#63;.
	 *
	 * @param visitorId the visitor ID
	 * @return the number of matching appointments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVisitorId(long visitorId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VISITORID;

		Object[] finderArgs = new Object[] { visitorId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APPOINTMENT_WHERE);

			query.append(_FINDER_COLUMN_VISITORID_VISITORID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(visitorId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_VISITORID_VISITORID_2 = "appointment.visitorId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SURGERYANDVISITORANDAPPDATE =
		new FinderPath(AppointmentModelImpl.ENTITY_CACHE_ENABLED,
			AppointmentModelImpl.FINDER_CACHE_ENABLED, AppointmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySurgeryAndVisitorAndAppDate",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURGERYANDVISITORANDAPPDATE =
		new FinderPath(AppointmentModelImpl.ENTITY_CACHE_ENABLED,
			AppointmentModelImpl.FINDER_CACHE_ENABLED, AppointmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySurgeryAndVisitorAndAppDate",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName()
			},
			AppointmentModelImpl.SURGERYID_COLUMN_BITMASK |
			AppointmentModelImpl.VISITORID_COLUMN_BITMASK |
			AppointmentModelImpl.APPDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SURGERYANDVISITORANDAPPDATE =
		new FinderPath(AppointmentModelImpl.ENTITY_CACHE_ENABLED,
			AppointmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySurgeryAndVisitorAndAppDate",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName()
			});

	/**
	 * Returns all the appointments where surgeryId = &#63; and visitorId = &#63; and appDate = &#63;.
	 *
	 * @param surgeryId the surgery ID
	 * @param visitorId the visitor ID
	 * @param appDate the app date
	 * @return the matching appointments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Appointment> findBySurgeryAndVisitorAndAppDate(long surgeryId,
		long visitorId, Date appDate) throws SystemException {
		return findBySurgeryAndVisitorAndAppDate(surgeryId, visitorId, appDate,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Appointment> findBySurgeryAndVisitorAndAppDate(long surgeryId,
		long visitorId, Date appDate, int start, int end)
		throws SystemException {
		return findBySurgeryAndVisitorAndAppDate(surgeryId, visitorId, appDate,
			start, end, null);
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
	@Override
	public List<Appointment> findBySurgeryAndVisitorAndAppDate(long surgeryId,
		long visitorId, Date appDate, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURGERYANDVISITORANDAPPDATE;
			finderArgs = new Object[] { surgeryId, visitorId, appDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SURGERYANDVISITORANDAPPDATE;
			finderArgs = new Object[] {
					surgeryId, visitorId, appDate,
					
					start, end, orderByComparator
				};
		}

		List<Appointment> list = (List<Appointment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Appointment appointment : list) {
				if ((surgeryId != appointment.getSurgeryId()) ||
						(visitorId != appointment.getVisitorId()) ||
						!Validator.equals(appDate, appointment.getAppDate())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_APPOINTMENT_WHERE);

			query.append(_FINDER_COLUMN_SURGERYANDVISITORANDAPPDATE_SURGERYID_2);

			query.append(_FINDER_COLUMN_SURGERYANDVISITORANDAPPDATE_VISITORID_2);

			boolean bindAppDate = false;

			if (appDate == null) {
				query.append(_FINDER_COLUMN_SURGERYANDVISITORANDAPPDATE_APPDATE_1);
			}
			else {
				bindAppDate = true;

				query.append(_FINDER_COLUMN_SURGERYANDVISITORANDAPPDATE_APPDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AppointmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surgeryId);

				qPos.add(visitorId);

				if (bindAppDate) {
					qPos.add(CalendarUtil.getTimestamp(appDate));
				}

				if (!pagination) {
					list = (List<Appointment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Appointment>(list);
				}
				else {
					list = (List<Appointment>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Appointment findBySurgeryAndVisitorAndAppDate_First(long surgeryId,
		long visitorId, Date appDate, OrderByComparator orderByComparator)
		throws NoSuchAppointmentException, SystemException {
		Appointment appointment = fetchBySurgeryAndVisitorAndAppDate_First(surgeryId,
				visitorId, appDate, orderByComparator);

		if (appointment != null) {
			return appointment;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surgeryId=");
		msg.append(surgeryId);

		msg.append(", visitorId=");
		msg.append(visitorId);

		msg.append(", appDate=");
		msg.append(appDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAppointmentException(msg.toString());
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
	@Override
	public Appointment fetchBySurgeryAndVisitorAndAppDate_First(
		long surgeryId, long visitorId, Date appDate,
		OrderByComparator orderByComparator) throws SystemException {
		List<Appointment> list = findBySurgeryAndVisitorAndAppDate(surgeryId,
				visitorId, appDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Appointment findBySurgeryAndVisitorAndAppDate_Last(long surgeryId,
		long visitorId, Date appDate, OrderByComparator orderByComparator)
		throws NoSuchAppointmentException, SystemException {
		Appointment appointment = fetchBySurgeryAndVisitorAndAppDate_Last(surgeryId,
				visitorId, appDate, orderByComparator);

		if (appointment != null) {
			return appointment;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surgeryId=");
		msg.append(surgeryId);

		msg.append(", visitorId=");
		msg.append(visitorId);

		msg.append(", appDate=");
		msg.append(appDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAppointmentException(msg.toString());
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
	@Override
	public Appointment fetchBySurgeryAndVisitorAndAppDate_Last(long surgeryId,
		long visitorId, Date appDate, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBySurgeryAndVisitorAndAppDate(surgeryId, visitorId,
				appDate);

		if (count == 0) {
			return null;
		}

		List<Appointment> list = findBySurgeryAndVisitorAndAppDate(surgeryId,
				visitorId, appDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Appointment[] findBySurgeryAndVisitorAndAppDate_PrevAndNext(
		long appId, long surgeryId, long visitorId, Date appDate,
		OrderByComparator orderByComparator)
		throws NoSuchAppointmentException, SystemException {
		Appointment appointment = findByPrimaryKey(appId);

		Session session = null;

		try {
			session = openSession();

			Appointment[] array = new AppointmentImpl[3];

			array[0] = getBySurgeryAndVisitorAndAppDate_PrevAndNext(session,
					appointment, surgeryId, visitorId, appDate,
					orderByComparator, true);

			array[1] = appointment;

			array[2] = getBySurgeryAndVisitorAndAppDate_PrevAndNext(session,
					appointment, surgeryId, visitorId, appDate,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Appointment getBySurgeryAndVisitorAndAppDate_PrevAndNext(
		Session session, Appointment appointment, long surgeryId,
		long visitorId, Date appDate, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APPOINTMENT_WHERE);

		query.append(_FINDER_COLUMN_SURGERYANDVISITORANDAPPDATE_SURGERYID_2);

		query.append(_FINDER_COLUMN_SURGERYANDVISITORANDAPPDATE_VISITORID_2);

		boolean bindAppDate = false;

		if (appDate == null) {
			query.append(_FINDER_COLUMN_SURGERYANDVISITORANDAPPDATE_APPDATE_1);
		}
		else {
			bindAppDate = true;

			query.append(_FINDER_COLUMN_SURGERYANDVISITORANDAPPDATE_APPDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AppointmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(surgeryId);

		qPos.add(visitorId);

		if (bindAppDate) {
			qPos.add(CalendarUtil.getTimestamp(appDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(appointment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Appointment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appointments where surgeryId = &#63; and visitorId = &#63; and appDate = &#63; from the database.
	 *
	 * @param surgeryId the surgery ID
	 * @param visitorId the visitor ID
	 * @param appDate the app date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySurgeryAndVisitorAndAppDate(long surgeryId,
		long visitorId, Date appDate) throws SystemException {
		for (Appointment appointment : findBySurgeryAndVisitorAndAppDate(
				surgeryId, visitorId, appDate, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(appointment);
		}
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
	@Override
	public int countBySurgeryAndVisitorAndAppDate(long surgeryId,
		long visitorId, Date appDate) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SURGERYANDVISITORANDAPPDATE;

		Object[] finderArgs = new Object[] { surgeryId, visitorId, appDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_APPOINTMENT_WHERE);

			query.append(_FINDER_COLUMN_SURGERYANDVISITORANDAPPDATE_SURGERYID_2);

			query.append(_FINDER_COLUMN_SURGERYANDVISITORANDAPPDATE_VISITORID_2);

			boolean bindAppDate = false;

			if (appDate == null) {
				query.append(_FINDER_COLUMN_SURGERYANDVISITORANDAPPDATE_APPDATE_1);
			}
			else {
				bindAppDate = true;

				query.append(_FINDER_COLUMN_SURGERYANDVISITORANDAPPDATE_APPDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surgeryId);

				qPos.add(visitorId);

				if (bindAppDate) {
					qPos.add(CalendarUtil.getTimestamp(appDate));
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SURGERYANDVISITORANDAPPDATE_SURGERYID_2 =
		"appointment.surgeryId = ? AND ";
	private static final String _FINDER_COLUMN_SURGERYANDVISITORANDAPPDATE_VISITORID_2 =
		"appointment.visitorId = ? AND ";
	private static final String _FINDER_COLUMN_SURGERYANDVISITORANDAPPDATE_APPDATE_1 =
		"appointment.appDate IS NULL";
	private static final String _FINDER_COLUMN_SURGERYANDVISITORANDAPPDATE_APPDATE_2 =
		"appointment.appDate = ?";

	public AppointmentPersistenceImpl() {
		setModelClass(Appointment.class);
	}

	/**
	 * Caches the appointment in the entity cache if it is enabled.
	 *
	 * @param appointment the appointment
	 */
	@Override
	public void cacheResult(Appointment appointment) {
		EntityCacheUtil.putResult(AppointmentModelImpl.ENTITY_CACHE_ENABLED,
			AppointmentImpl.class, appointment.getPrimaryKey(), appointment);

		appointment.resetOriginalValues();
	}

	/**
	 * Caches the appointments in the entity cache if it is enabled.
	 *
	 * @param appointments the appointments
	 */
	@Override
	public void cacheResult(List<Appointment> appointments) {
		for (Appointment appointment : appointments) {
			if (EntityCacheUtil.getResult(
						AppointmentModelImpl.ENTITY_CACHE_ENABLED,
						AppointmentImpl.class, appointment.getPrimaryKey()) == null) {
				cacheResult(appointment);
			}
			else {
				appointment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all appointments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AppointmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AppointmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the appointment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Appointment appointment) {
		EntityCacheUtil.removeResult(AppointmentModelImpl.ENTITY_CACHE_ENABLED,
			AppointmentImpl.class, appointment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Appointment> appointments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Appointment appointment : appointments) {
			EntityCacheUtil.removeResult(AppointmentModelImpl.ENTITY_CACHE_ENABLED,
				AppointmentImpl.class, appointment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new appointment with the primary key. Does not add the appointment to the database.
	 *
	 * @param appId the primary key for the new appointment
	 * @return the new appointment
	 */
	@Override
	public Appointment create(long appId) {
		Appointment appointment = new AppointmentImpl();

		appointment.setNew(true);
		appointment.setPrimaryKey(appId);

		return appointment;
	}

	/**
	 * Removes the appointment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appId the primary key of the appointment
	 * @return the appointment that was removed
	 * @throws com.segmax.portlet.sample.NoSuchAppointmentException if a appointment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Appointment remove(long appId)
		throws NoSuchAppointmentException, SystemException {
		return remove((Serializable)appId);
	}

	/**
	 * Removes the appointment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the appointment
	 * @return the appointment that was removed
	 * @throws com.segmax.portlet.sample.NoSuchAppointmentException if a appointment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Appointment remove(Serializable primaryKey)
		throws NoSuchAppointmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Appointment appointment = (Appointment)session.get(AppointmentImpl.class,
					primaryKey);

			if (appointment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAppointmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(appointment);
		}
		catch (NoSuchAppointmentException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Appointment removeImpl(Appointment appointment)
		throws SystemException {
		appointment = toUnwrappedModel(appointment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(appointment)) {
				appointment = (Appointment)session.get(AppointmentImpl.class,
						appointment.getPrimaryKeyObj());
			}

			if (appointment != null) {
				session.delete(appointment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (appointment != null) {
			clearCache(appointment);
		}

		return appointment;
	}

	@Override
	public Appointment updateImpl(
		com.segmax.portlet.sample.model.Appointment appointment)
		throws SystemException {
		appointment = toUnwrappedModel(appointment);

		boolean isNew = appointment.isNew();

		AppointmentModelImpl appointmentModelImpl = (AppointmentModelImpl)appointment;

		Session session = null;

		try {
			session = openSession();

			if (appointment.isNew()) {
				session.save(appointment);

				appointment.setNew(false);
			}
			else {
				session.merge(appointment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AppointmentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((appointmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURGERYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						appointmentModelImpl.getOriginalSurgeryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURGERYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURGERYID,
					args);

				args = new Object[] { appointmentModelImpl.getSurgeryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURGERYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURGERYID,
					args);
			}

			if ((appointmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VISITORID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						appointmentModelImpl.getOriginalVisitorId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VISITORID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VISITORID,
					args);

				args = new Object[] { appointmentModelImpl.getVisitorId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VISITORID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VISITORID,
					args);
			}

			if ((appointmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURGERYANDVISITORANDAPPDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						appointmentModelImpl.getOriginalSurgeryId(),
						appointmentModelImpl.getOriginalVisitorId(),
						appointmentModelImpl.getOriginalAppDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURGERYANDVISITORANDAPPDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURGERYANDVISITORANDAPPDATE,
					args);

				args = new Object[] {
						appointmentModelImpl.getSurgeryId(),
						appointmentModelImpl.getVisitorId(),
						appointmentModelImpl.getAppDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURGERYANDVISITORANDAPPDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURGERYANDVISITORANDAPPDATE,
					args);
			}
		}

		EntityCacheUtil.putResult(AppointmentModelImpl.ENTITY_CACHE_ENABLED,
			AppointmentImpl.class, appointment.getPrimaryKey(), appointment);

		return appointment;
	}

	protected Appointment toUnwrappedModel(Appointment appointment) {
		if (appointment instanceof AppointmentImpl) {
			return appointment;
		}

		AppointmentImpl appointmentImpl = new AppointmentImpl();

		appointmentImpl.setNew(appointment.isNew());
		appointmentImpl.setPrimaryKey(appointment.getPrimaryKey());

		appointmentImpl.setAppId(appointment.getAppId());
		appointmentImpl.setAppDate(appointment.getAppDate());
		appointmentImpl.setSurgeryId(appointment.getSurgeryId());
		appointmentImpl.setVisitorId(appointment.getVisitorId());

		return appointmentImpl;
	}

	/**
	 * Returns the appointment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the appointment
	 * @return the appointment
	 * @throws com.segmax.portlet.sample.NoSuchAppointmentException if a appointment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Appointment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAppointmentException, SystemException {
		Appointment appointment = fetchByPrimaryKey(primaryKey);

		if (appointment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAppointmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return appointment;
	}

	/**
	 * Returns the appointment with the primary key or throws a {@link com.segmax.portlet.sample.NoSuchAppointmentException} if it could not be found.
	 *
	 * @param appId the primary key of the appointment
	 * @return the appointment
	 * @throws com.segmax.portlet.sample.NoSuchAppointmentException if a appointment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Appointment findByPrimaryKey(long appId)
		throws NoSuchAppointmentException, SystemException {
		return findByPrimaryKey((Serializable)appId);
	}

	/**
	 * Returns the appointment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the appointment
	 * @return the appointment, or <code>null</code> if a appointment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Appointment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Appointment appointment = (Appointment)EntityCacheUtil.getResult(AppointmentModelImpl.ENTITY_CACHE_ENABLED,
				AppointmentImpl.class, primaryKey);

		if (appointment == _nullAppointment) {
			return null;
		}

		if (appointment == null) {
			Session session = null;

			try {
				session = openSession();

				appointment = (Appointment)session.get(AppointmentImpl.class,
						primaryKey);

				if (appointment != null) {
					cacheResult(appointment);
				}
				else {
					EntityCacheUtil.putResult(AppointmentModelImpl.ENTITY_CACHE_ENABLED,
						AppointmentImpl.class, primaryKey, _nullAppointment);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AppointmentModelImpl.ENTITY_CACHE_ENABLED,
					AppointmentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return appointment;
	}

	/**
	 * Returns the appointment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appId the primary key of the appointment
	 * @return the appointment, or <code>null</code> if a appointment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Appointment fetchByPrimaryKey(long appId) throws SystemException {
		return fetchByPrimaryKey((Serializable)appId);
	}

	/**
	 * Returns all the appointments.
	 *
	 * @return the appointments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Appointment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Appointment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Appointment> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Appointment> list = (List<Appointment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_APPOINTMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_APPOINTMENT;

				if (pagination) {
					sql = sql.concat(AppointmentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Appointment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Appointment>(list);
				}
				else {
					list = (List<Appointment>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the appointments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Appointment appointment : findAll()) {
			remove(appointment);
		}
	}

	/**
	 * Returns the number of appointments.
	 *
	 * @return the number of appointments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_APPOINTMENT);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the appointment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.segmax.portlet.sample.model.Appointment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Appointment>> listenersList = new ArrayList<ModelListener<Appointment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Appointment>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(AppointmentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_APPOINTMENT = "SELECT appointment FROM Appointment appointment";
	private static final String _SQL_SELECT_APPOINTMENT_WHERE = "SELECT appointment FROM Appointment appointment WHERE ";
	private static final String _SQL_COUNT_APPOINTMENT = "SELECT COUNT(appointment) FROM Appointment appointment";
	private static final String _SQL_COUNT_APPOINTMENT_WHERE = "SELECT COUNT(appointment) FROM Appointment appointment WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "appointment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Appointment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Appointment exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AppointmentPersistenceImpl.class);
	private static Appointment _nullAppointment = new AppointmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Appointment> toCacheModel() {
				return _nullAppointmentCacheModel;
			}
		};

	private static CacheModel<Appointment> _nullAppointmentCacheModel = new CacheModel<Appointment>() {
			@Override
			public Appointment toEntityModel() {
				return _nullAppointment;
			}
		};
}