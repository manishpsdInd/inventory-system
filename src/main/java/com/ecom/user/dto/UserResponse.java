package com.ecom.user.dto;

import com.ecom.cart.dto.CartEntity;
import com.ecom.order.dto.OrderEntity;
import com.ecom.user.constant.UserType;
import com.ecom.user.entity.AddressEntity;

public class UserResponse {

	private Long userId;
	private String userName;
	private UserType userType;
	private String userPhone;
	private AddressEntity userAddress;
	private CartEntity cartService;
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

	public AddressEntity getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(AddressEntity userAddress) {
		this.userAddress = userAddress;
	}

	public CartEntity getCartService() {
		return cartService;
	}

	public void setCartService(CartEntity cartService) {
		this.cartService = cartService;
	}

	public OrderEntity getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderEntity orderService) {
		this.orderService = orderService;
	}

}
