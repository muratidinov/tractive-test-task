/*
 * Rinat Muratidinov. Do not reproduce without permission in writing.
 * Copyright (c) 2022 RM. All rights reserved.
 */

package kg.rinat.exception;

/**
 * ProductService exception
 *
 * @author Rinat Muratidinov
 */
public class ProductServiceException extends RuntimeException {

  private String message;

  public ProductServiceException(String message) {
    super(message);
  }
}
