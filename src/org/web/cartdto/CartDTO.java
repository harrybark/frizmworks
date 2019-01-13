package org.web.cartdto;

public class CartDTO {

	private int cart_No;
	private String memberId;
	private int product_No;
	private String product_Name;
	private int numbers;
	private int product_Price;
	private int totalPrice;

	public CartDTO() {
		// TODO Auto-generated constructor stub
	}

	public CartDTO(int cart_No, String memberId, int product_No, String product_Name, int numbers, int product_Price,
			int totalPrice) {
		super();
		this.cart_No = cart_No;
		this.memberId = memberId;
		this.product_No = product_No;
		this.product_Name = product_Name;
		this.numbers = numbers;
		this.product_Price = product_Price;
		this.totalPrice = totalPrice;
	}

	public int getProduct_Price() {
		return product_Price;
	}

	public void setProduct_Price(int product_Price) {
		this.product_Price = product_Price;
	}

	public String getProduct_Name() {
		return product_Name;
	}

	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	public int getCart_No() {
		return cart_No;
	}

	public void setCart_No(int cart_No) {
		this.cart_No = cart_No;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getProduct_No() {
		return product_No;
	}

	public void setProduct_No(int product_No) {
		this.product_No = product_No;
	}

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

}
