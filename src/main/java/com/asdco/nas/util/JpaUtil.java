package com.asdco.nas.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * JPA utility class to manage any transactions to and from the database <br/>
 * <br/>
 * The @Stateless EJB annotation tells the server that any actions (specifically
 * JPA actions) performed by this bean with be transactional
 * 
 * @author MYarbrou
 *
 */
@Stateless
public class JpaUtil {

	/*
	 * The @PersistenceContext JPA annotation tells the server to create an
	 * entity manager using the persistence unit named "com.asdco.nas"
	 */
	@PersistenceContext(name = "com.asdco.nas")
	EntityManager em;

	/**
	 * Save a single JPA {@link Entity} or a {@link Collection} of JPA entities
	 * to the database
	 * 
	 * @param entity
	 *            a single JPA {@link Entity} or a {@link Collection} of JPA
	 *            entities
	 */
	public void persist(Object entity) {
		if (entity instanceof Collection) {
			for (Object object : (Collection<?>) entity) {
				em.persist(object);
			}
		} else {
			em.persist(entity);
		}
	}

	/**
	 * Build a named query contained in this persistence unit, add any given
	 * parameters, execute it and return the result set as a list of objects of
	 * class T.
	 * 
	 * @param queryName
	 *            the name of the query defined by the annotation
	 *            {@link NamedQuery} in a JPA {@link Entity}
	 * @param parameters
	 *            a {@link Map} of parameter names and their values, or null for
	 *            no parameters
	 * @param resultClass
	 *            the expected class of the objects returned
	 * @return a {@link List} of the objects from the results of the query
	 *         execution
	 */
	public <T> List<T> executeGetNamedQuery(String queryName, Map<String, Object> parameters, Class<T> resultClass) {
		TypedQuery<T> query = em.createNamedQuery(queryName, resultClass);
		if (null != parameters) {
			for (Map.Entry<String, Object> pair : parameters.entrySet()) {
				query.setParameter(pair.getKey(), pair.getValue());
			}
		}
		return query.getResultList();
	}
}
