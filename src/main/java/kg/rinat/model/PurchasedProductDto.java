/*
 * Rinat Muratidinov. Do not reproduce without permission in writing.
 * Copyright (c) 2022 RM. All rights reserved.
 */

package kg.rinat.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Purchased product data
 *
 * @author Rinat Muratidinov
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PurchasedProductDto extends ProductDto {

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
