package com.weftecnologia.payment_api.repository;

import org.springframework.stereotype.Repository;

import com.weftecnologia.payment_api.dto.user.AuthUserDTO;
import com.weftecnologia.payment_api.dto.user.ResponseAuthUserDTO;
import com.weftecnologia.payment_api.entity.User;
import com.weftecnologia.payment_api.util.PasswordUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class AuthRepository {

  @PersistenceContext
  private EntityManager em;

  public ResponseAuthUserDTO auth(AuthUserDTO dto) {
    try {
      User user = em.createQuery(
          "SELECT u FROM User u WHERE u.email = :email", User.class)
          .setParameter("email", dto.getEmail())
          .getSingleResult();

      if (user == null) {
        return new ResponseAuthUserDTO(
            false,
            "usuário com email: " + dto.getEmail() + " não encontrado.");
      }

      if (!PasswordUtil.compare(dto.getPassword(), user.getPassword())) {
        return new ResponseAuthUserDTO(
            false,
            "password inválido.");
      }

      return new ResponseAuthUserDTO(true, "usuário autenticado.");
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseAuthUserDTO(false, "erro ao acessar o banco de dados.");
    }
  }
}
