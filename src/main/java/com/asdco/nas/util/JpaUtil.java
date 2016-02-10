package com.asdco.nas.util;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	 * Save a single JPA entity or a {@link Collection} of JPA entities to the
	 * database
	 * 
	 * @param entity
	 *            a single JPA entity or a {@link Collection} of JPA entities
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
}
