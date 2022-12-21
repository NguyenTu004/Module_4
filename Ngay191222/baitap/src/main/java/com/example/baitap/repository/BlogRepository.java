package com.example.baitap.repository;

import com.example.baitap.model.Blog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BlogRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Blog> findAll() {
        TypedQuery<Blog> query = em.createQuery("select b from Blog as b", Blog.class);
        return query.getResultList();
    }
    public Blog findById(long id){
        TypedQuery<Blog> query = em.createQuery("select b from Blog as b where b.id =: id", Blog.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public void save(Blog blog){
        if (blog.getId() != 0) {
            em.merge(blog);
        }else {
            em.persist(blog);
        }
    }
    public void delete(Blog blog){
        em.remove(blog);
    }
}
