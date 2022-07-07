/*
 * Rinat Muratidinov. Do not reproduce without permission in writing.
 * Copyright (c) 2022 RM. All rights reserved.
 */

package kg.rinat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import kg.rinat.exception.ProductServiceException;
import kg.rinat.model.ProductDto;
import kg.rinat.model.PurchasedProductDto;
import kg.rinat.service.ProductService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

/**
 * ProductsService junit-test
 *
 * @author Rinat Muratidinov
 */
class ProductServiceTest {

  /** Testing service */
  ProductService productService = new ProductService();

  @Test
  @DisplayName("Aggregate purchased products info")
  void aggregatePurchasedProducts() {

    // GIVEN
    List<String> codesList = List.of("CVCD", "SDFD", "DDDF", "SDFD");

    Map<String, ProductDto> codesToProductDtoMap =
        Map.of(
            "CVCD", new ProductDto(1, "X"),
            "SDFD", new ProductDto(2, "Z"),
            "DDDF", new ProductDto(1));

    // WHEN
    List<PurchasedProductDto> aggregate =
        productService.aggregatePurchasedProducts(codesList, codesToProductDtoMap);

    // THEN
    assertNotNull(aggregate);
    assertEquals(aggregate.size(), codesList.stream().distinct().count());
  }

  @Test
  @DisplayName("Aggregate purchased products info without product info")
  void aggregatePurchasedProductsWithoutProductInfo() {

    // GIVEN
    List<String> codesList = List.of("CVCD", "SDFD", "DDDF", "SDFD", "KLS");

    // WHEN
    assertThrows(
        ProductServiceException.class,
        () -> productService.aggregatePurchasedProducts(codesList, null));
  }

  @Test
  @DisplayName("Aggregate purchased products info with additional code")
  void aggregatePurchasedProductsWithAdditionalCode() {

    // GIVEN
    List<String> codesList = List.of("CVCD", "SDFD", "DDDF", "SDFD", "KLS");

    Map<String, ProductDto> codesToProductDtoMap =
        Map.of(
            "CVCD", new ProductDto(1, "X"),
            "SDFD", new ProductDto(2, "Z"),
            "DDDF", new ProductDto(1));

    // WHEN
    assertThrows(
        ProductServiceException.class,
        () -> productService.aggregatePurchasedProducts(codesList, codesToProductDtoMap));
  }
}
