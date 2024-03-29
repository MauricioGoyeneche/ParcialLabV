package com.example.SimulacroParcial.interfaces;

import com.example.SimulacroParcial.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    String NATIVE_QUERY = "select p.title, u.name, count(c.*) as quantity from user u inner join publication p on u.id = p.id_user " +
            "inner join comentary c on p.id = c.id_publication";

    @Query(value = NATIVE_QUERY , nativeQuery = true)
    List<PublicacionesXUsuarioRepo> getPublicacionesPorUsuario();

}
