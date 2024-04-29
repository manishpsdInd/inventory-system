package com.ecom.product;

import java.math.BigDecimal;

import com.ecom.product.constant.ProductCategory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	private Integer productType;
	private ProductCategory productCategory;
	private BigDecimal productMRP;
	private BigDecimal productMargin;
	private String productStatus;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getProductType() {
		return productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public BigDecimal getProductMRP() {
		return productMRP;
	}

	public void setProductMRP(BigDecimal productMRP) {
		this.productMRP = productMRP;
	}

	public BigDecimal getProductMargin() {
		return productMargin;
	}

	public void setProductMargin(BigDecimal productMargin) {
		this.productMargin = productMargin;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

}
