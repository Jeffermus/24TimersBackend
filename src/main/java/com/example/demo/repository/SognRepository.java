package com.example.demo.repository;

import com.example.demo.model.Sogn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SognRepository extends JpaRepository<Sogn, Integer> {
Sogn findById(int id);
@Query(value = "SELECT * FROM sogn WHERE kommune_id = ?1", nativeQuery = true)
List<Sogn> findBySmittetryk(int kommune_id);
}
