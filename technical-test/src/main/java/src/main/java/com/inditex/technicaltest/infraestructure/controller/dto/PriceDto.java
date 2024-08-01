package com.inditex.technicaltest.infraestructure.controller.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Model for the price
 */
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Schema(name = "Price", description = "Model for the price")
@JsonTypeName("Price")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-01T13:18:46.921392800+02:00[Europe/Madrid]", comments = "Generator version: 7.7.0")
public class PriceDto {

  private Long id;

  private Long productId;

  private Long brandId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime startDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime endDate;

  private Double price;

  public PriceDto id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Id of the price.
   * @return id
   */
  
  @Schema(name = "id", description = "Id of the price.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public PriceDto productId(Long productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Id of the product.
   * @return productId
   */
  
  @Schema(name = "product_id", description = "Id of the product.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("product_id")
  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public PriceDto brandId(Long brandId) {
    this.brandId = brandId;
    return this;
  }

  /**
   * Id of the brand.
   * @return brandId
   */
  
  @Schema(name = "brand_id", description = "Id of the brand.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("brand_id")
  public Long getBrandId() {
    return brandId;
  }

  public void setBrandId(Long brandId) {
    this.brandId = brandId;
  }

  public PriceDto startDate(LocalDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Starting date of the price application.
   * @return startDate
   */
  
  @Schema(name = "start_date", description = "Starting date of the price application.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("start_date")
  public LocalDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
  }

  public PriceDto endDate(LocalDateTime endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * End date of the price application.
   * @return endDate
   */
  
  @Schema(name = "end_date", description = "End date of the price application.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("end_date")
  public LocalDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDateTime endDate) {
    this.endDate = endDate;
  }

  public PriceDto price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Price of the product to apply
   * @return price
   */
  
  @Schema(name = "price", description = "Price of the product to apply", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("price")
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriceDto price = (PriceDto) o;
    return Objects.equals(this.id, price.id) &&
        Objects.equals(this.productId, price.productId) &&
        Objects.equals(this.brandId, price.brandId) &&
        Objects.equals(this.startDate, price.startDate) &&
        Objects.equals(this.endDate, price.endDate) &&
        Objects.equals(this.price, price.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, productId, brandId, startDate, endDate, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriceDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    brandId: ").append(toIndentedString(brandId)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

