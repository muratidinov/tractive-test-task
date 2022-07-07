/*
 * Rinat Muratidinov. Do not reproduce without permission in writing.
 * Copyright (c) 2022 RM. All rights reserved.
 */

package kg.rinat.model;

import lombok.Builder;
import lombok.Data;

/**
 * Purchased product data
 *
 * @author Rinat Muratidinov
 */
@Data
public class PurchasedProductDto extends ProductDto{

  /** Quantity */
  private int quantity;


  public PurchasedProductDto(int version) {
    super(version);
  }

  public PurchasedProductDto(int version, String edition) {
    super(version, edition);
  }

  @Builder(builderMethodName = "purchasedProductDtoBuilder")
  public PurchasedProductDto(int version, String edition, int quantity) {
    super(version, edition);
    this.quantity = quantity;
  }
}
