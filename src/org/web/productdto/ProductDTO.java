package org.web.productdto;

public class ProductDTO {

	private int product_No;
	private int product_Group;
	private int product_Indent;
	private int product_Step;
	private int product_Hit;
	private String memberId;
	private String product_Name;
	private String product_Categories;
	private String product_Explanation;
	private int product_Price;
	private int product_Inventory;
	private String product_fileDBName;
	private String product_fileRealName;

	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(int product_No, int product_Group, int product_Indent, int product_Step, int product_Hit,
			String memberId, String product_Name, String product_Categories, String product_Explanation,
			int product_Price, int product_Inventory, String product_fileDBName, String product_fileRealName) {
		super();
		this.product_No = product_No;
		this.product_Group = product_Group;
		this.product_Indent = product_Indent;
		this.product_Step = product_Step;
		this.product_Hit = product_Hit;
		this.memberId = memberId;
		this.product_Name = product_Name;
		this.product_Categories = product_Categories;
		this.product_Explanation = product_Explanation;
		this.product_Price = product_Price;
		this.product_Inventory = product_Inventory;
		this.product_fileDBName = product_fileDBName;
		this.product_fileRealName = product_fileRealName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public final int getProduct_No() {
		return product_No;
	}

	public final void setProduct_No(int product_No) {
		this.product_No = product_No;
	}

	public final int getProduct_Group() {
		return product_Group;
	}

	public final void setProduct_Group(int product_Group) {
		this.product_Group = product_Group;
	}

	public final int getProduct_Indent() {
		return product_Indent;
	}

	public final void setProduct_Indent(int product_Indent) {
		this.product_Indent = product_Indent;
	}

	public final int getProduct_Step() {
		return product_Step;
	}

	public final void setProduct_Step(int product_Step) {
		this.product_Step = product_Step;
	}

	public final int getProduct_Hit() {
		return product_Hit;
	}

	public final void setProduct_Hit(int product_Hit) {
		this.product_Hit = product_Hit;
	}

	public final String getProduct_Name() {
		return product_Name;
	}

	public final void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	public final String getProduct_Categories() {
		return product_Categories;
	}

	public final void setProduct_Categories(String product_Categories) {
		this.product_Categories = product_Categories;
	}

	public final String getProduct_Explanation() {
		return product_Explanation;
	}

	public final void setProduct_Explanation(String product_Explanation) {
		this.product_Explanation = product_Explanation;
	}

	public final int getProduct_Price() {
		return product_Price;
	}

	public final void setProduct_Price(int product_Price) {
		this.product_Price = product_Price;
	}

	public final int getProduct_Inventory() {
		return product_Inventory;
	}

	public final void setProduct_Inventory(int product_Inventory) {
		this.product_Inventory = product_Inventory;
	}

	public final String getProduct_fileDBName() {
		return product_fileDBName;
	}

	public final void setProduct_fileDBName(String product_fileDBName) {
		this.product_fileDBName = product_fileDBName;
	}

	public final String getProduct_fileRealName() {
		return product_fileRealName;
	}

	public final void setProduct_fileRealName(String product_fileRealName) {
		this.product_fileRealName = product_fileRealName;
	}

}
