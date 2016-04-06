package com.asdco.nas.util;

import java.util.Collection;
import java.util.HashMap;
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

	public <T> T executeGetSingleResult(String queryName, Map<String, Object> parameters, Class<T> resultClass) {
		TypedQuery<T> query = em.createNamedQuery(queryName, resultClass);
		if (null != parameters) {
			for (Map.Entry<String, Object> pair : parameters.entrySet()) {
				query.setParameter(pair.getKey(), pair.getValue());
			}
		}
		return query.getSingleResult();
	}

	public <T> T executeGetSingleResult(String queryName, Class<T> resultClass, Object... perameters) {

		return executeGetSingleResult(queryName, createPeramiterMap(perameters), resultClass);
	}

	public void merge(Object entity) {
		if (entity instanceof Collection) {
			for (Object object : (Collection<?>) entity) {
				em.merge(object);
			}
		} else {
			em.merge(entity);
		}

	}

public static void main(String[] args) {
	Map map = new JpaUtil().createPeramiterMap("45",67,"78",23);
	System.out.println("Hello world");
}

	private Map<String, Object> createPeramiterMap(Object... listOfPram) {
		HashMap<String, Object> map = new HashMap<>();
		Object[] newArray = { "id", 23 };
		int g = 0;
		int h = 1;
		for (int i = 0; i < listOfPram.length; i++) {
			map.put((String) newArray[g], newArray[h]);
			g = g + 2;
			h = h + 2;
		}

		/**
		 * Get thet first object, write it to the map pos1[stringof][pram1]
		 * pos2[][pram2] pos3[][pram3]
		 * 
		 **/
		return map;
	}

}
