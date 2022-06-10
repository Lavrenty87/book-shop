package ru.learnup.bookshop.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RolesRepository extends JpaRepository<Rolez, Long> {
    Set<Rolez> findByRolezIn(Set<String> rolez);
}
