/*
 * Rinat Muratidinov. Do not reproduce without permission in writing.
 * Copyright (c) 2022 RM. All rights reserved.
 */

package kg.rinat.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Product data
 *
 * @author Rinat Muratidinov
 */
@Data
@NoArgsConstructor
public class ProductDto {

  /** Version */
  private int version;

  /** Edition */
  private String edition;

  public ProductDto(int version) {
    this.version = version;
  }

  public ProductDto(int version, String edition) {
    this.version = version;
    this.edition = edition;
  }
}
