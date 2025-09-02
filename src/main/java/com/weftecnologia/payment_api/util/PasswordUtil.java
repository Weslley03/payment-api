package com.weftecnologia.payment_api.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

  public static String hash(String plainPassword) {
    return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
  }

  public static boolean compare(String plainPassword, String hashedPassword) {
    if (plainPassword == null || hashedPassword == null) {
      return false;
    }
    return BCrypt.checkpw(plainPassword, hashedPassword);
  }
}
