package kg.rinat.service;

import kg.rinat.exception.ProductServiceException;
import kg.rinat.model.ProductDto;
import kg.rinat.model.PurchasedProductDto;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Product service
 *
 * @author Rinat Muratidinov
 */
public class ProductService {

  /**
   * Aggregate purchased products info
   *
   * @param productCodes List of purchased product codes
   * @param productInfoMap Map of mappings for purchased products
   * @return Aggregated info list of purchased products
   */
  public List<PurchasedProductDto> aggregatePurchasedProducts(
      List<String> productCodes, Map<String, ProductDto> productInfoMap) {

    if (productCodes == null || productCodes.isEmpty()) {
      return Collections.emptyList();
    }

    if (productInfoMap == null || productInfoMap.isEmpty()) {
      throw new ProductServiceException("There is no information about purchased products");
    }

    return productCodes.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet()
        .stream()
        .map(
            entry -> {
              String productCode = entry.getKey();
              ProductDto productDto = productInfoMap.get(productCode);

              if (productDto == null) {
                throw new ProductServiceException(
                    String.format("There is no information about product '%s'", productCode));
              }

              return PurchasedProductDto.purchasedProductDtoBuilder()
                  .edition(productDto.getEdition())
                  .version(productDto.getVersion())
                  .quantity(entry.getValue().intValue())
                  .build();
            })
        .collect(Collectors.toList());
  }
}
