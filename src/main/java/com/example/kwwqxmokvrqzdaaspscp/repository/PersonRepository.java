package com.example.kwwqxmokvrqzdaaspscp.repository;

import com.example.kwwqxmokvrqzdaaspscp.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Query(value = "SELECT * FROM ( SELECT *, ROW_NUMBER() OVER (ORDER BY id) AS RowNum FROM Person) AS Sub WHERE RowNum BETWEEN :offset + 1 AND :offset + :limit", nativeQuery = true)
    List<Person> findAllWithLimitAndOffset(@Param("limit")int limit, @Param("offset") int offset);

}
