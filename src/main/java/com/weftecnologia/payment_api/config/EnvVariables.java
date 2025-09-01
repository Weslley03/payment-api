package com.weftecnologia.payment_api.config;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvVariables {
  private static final Dotenv dotenv = Dotenv.load();

  public static String getUrlDatabase() {
    return dotenv.get("URL_DATABASE");
  }

  public static String getUserDatabase() {
    return dotenv.get("USER_DATABASE");
  }

  public static String getUserPasswordDatabase() {
    return dotenv.get("USER_PASSWORD_DATABASE");
  }
}
