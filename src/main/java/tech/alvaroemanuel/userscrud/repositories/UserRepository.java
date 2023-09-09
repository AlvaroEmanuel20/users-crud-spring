package tech.alvaroemanuel.userscrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.alvaroemanuel.userscrud.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
