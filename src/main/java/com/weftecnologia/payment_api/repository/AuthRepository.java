package com.weftecnologia.payment_api.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.weftecnologia.payment_api.dto.user.AuthUserDTO;
import com.weftecnologia.payment_api.dto.user.ResponseAuthUserDTO;
import com.weftecnologia.payment_api.entity.User;
import com.weftecnologia.payment_api.util.JwtUtil;
import com.weftecnologia.payment_api.util.PasswordUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class AuthRepository {

  @PersistenceContext
  private EntityManager em;
  private UserRepository userRepository;

  public AuthRepository(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public ResponseAuthUserDTO auth(AuthUserDTO dto) {
    try {
      Optional<User> userOpt = this.userRepository.getUserByEmail(dto.getEmail());

      if (userOpt.isEmpty()) {
        return new ResponseAuthUserDTO(
            false,
            "usuário com email: " + dto.getEmail() + " não encontrado.");
      }

      User user = userOpt.get();

      if (!PasswordUtil.compare(dto.getPassword(), user.getPassword())) {
        return new ResponseAuthUserDTO(
            false,
            "password inválido.");
      }

      String token = JwtUtil.generateToken(user.getId());
      return new ResponseAuthUserDTO(true, "usuário autenticado.", token);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseAuthUserDTO(false, "erro ao acessar o banco de dados.");
    }
  }
}
