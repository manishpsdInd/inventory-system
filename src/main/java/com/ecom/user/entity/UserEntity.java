package com.ecom.user.entity;

import com.ecom.cart.dto.CartEntity;
import com.ecom.order.dto.OrderEntity;
import com.ecom.user.constant.UserType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String userName;

	@Enumerated(EnumType.STRING)
	private UserType userType;

	private String userPhone;

	@ManyToOne
	@JoinColumn(name = "cart_Id")
	private CartEntity cartService;

	@ManyToOne
	@JoinColumn(name = "address_Id")
	private AddressEntity userAddress;

	@ManyToOne
	@JoinColumn(name = "order_Id")
	private OrderEntity orderService;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public CartEntity getCartService() {
		return cartService;
	}

	public void setCartService(CartEntity cartService) {
		this.cartService = cartService;
	}

	public AddressEntity getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(AddressEntity userAddress) {
		this.userAddress = userAddress;
	}

	public OrderEntity getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderEntity orderService) {
		this.orderService = orderService;
	}
}
