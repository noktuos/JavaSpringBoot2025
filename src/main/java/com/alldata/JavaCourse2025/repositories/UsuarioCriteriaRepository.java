package com.alldata.JavaCourse2025.repositories;


import com.alldata.JavaCourse2025.entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioCriteriaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Usuario>  buscarPorNombreYEdad(String nombre, Integer edad){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Usuario> query = criteriaBuilder.createQuery(Usuario.class);
        Root<Usuario> usuarioRoot = query.from(Usuario.class);

        List<Predicate> predicates = new ArrayList<>();
        if(nombre != null){
            predicates.add(criteriaBuilder.equal(usuarioRoot.get("nombre"),nombre));
        }
        if(edad != null){
            predicates.add(criteriaBuilder.equal(usuarioRoot.get("edad"),edad));
        }
        query.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(query).getResultList();
    }
}
