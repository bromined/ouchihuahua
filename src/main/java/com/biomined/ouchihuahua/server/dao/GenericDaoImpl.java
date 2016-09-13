package com.biomined.ouchihuahua.server.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by scole on 11/6/14.
 */
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    private static final String PERSISTENCE_UNIT_NAME = "PaintrackerPersistenceUnit";
    static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    protected EntityManager em;

    private Class<T> type;

    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public long countAll(final Map<String, Object> params) {

        final StringBuffer queryString = new StringBuffer(
                "SELECT count(o) from ");

        queryString.append(type.getSimpleName()).append(" o ");
//        queryString.append(this.greetQueryClauses(params, null));

        final Query query = this.em.createQuery(queryString.toString());

        return (Long) query.getSingleResult();

    }

    @Override
    public T create(final T t) {

        em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
        return t;
    }

    @Override
    public void delete(final Long id) {

        em = factory.createEntityManager();
        em.getTransaction().begin();
        em.remove(this.em.getReference(type, id));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public T find(final Long id) {

        em = factory.createEntityManager();
        em.getTransaction().begin();
        T t = (T) em.find(type, id);
        em.getTransaction().commit();
        em.close();
        return t;
    }

    @Override
    public T update(final T t) {

        em = factory.createEntityManager();
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
        em.close();
        return t;
    }
}
