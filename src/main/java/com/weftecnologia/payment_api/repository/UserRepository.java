package com.weftecnologia.payment_api.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.weftecnologia.payment_api.dto.user.CreateUserDTO;
import com.weftecnologia.payment_api.dto.user.ResponseUserDTO;
import com.weftecnologia.payment_api.entity.User;
import com.weftecnologia.payment_api.exception.exceptions.UserAlreadyExistsException;
import com.weftecnologia.payment_api.util.PasswordUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class UserRepository {

  @PersistenceContext
  private EntityManager em;

  @Transactional
  public ResponseUserDTO create(CreateUserDTO dto) {
    try {

      this.getUserByEmail(dto.getEmail())
          .ifPresent(u -> {
            throw new UserAlreadyExistsException(dto.getEmail());
          });

      User user = new User(
          dto.getName(),
          dto.getEmail(),
          PasswordUtil.hash(dto.getPassword()));

      em.persist(user);

      return new ResponseUserDTO(user.getId(), user.getName(), user.getEmail());
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("erro ao inserir usuário.", e);
    }
  }

  public Optional<User> getUserByEmail(String email) {
    try {
      User user = em.createQuery(
          "SELECT u FROM User u WHERE u.email = :email", User.class)
          .setParameter("email", email)
          .getSingleResult();
      return Optional.of(user);
    } catch (NoResultException e) {
      return Optional.empty();
    }
  }
}
