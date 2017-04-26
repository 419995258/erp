package com.lucene.erp.domain;

//商品实体类
public class Product {
	private int id;// 主键
	private int pid;// 商品编号
	private String name;// 商品名称
	private String supplier;// 供应商
	private String leader;// 负责人
	private String tel;// 联系电话
	private String certificateNum;// 证书号
	private String component;// 金料成分
	private String size;// 规格
	private double weight;// 金重
	private String subStone;// 配石
	private String mainStone;// 主石
	private double goldCost;// 金费
	private double handCost;// 工费
	private int quantity;// 数量
	private double cost;// 成本
	private String photoLink;// 商品图片链接地址
	private String note;// 备注
	private String photoName;//上传后的文件名

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCertificateNum() {
		return certificateNum;
	}

	public void setCertificateNum(String certificateNum) {
		this.certificateNum = certificateNum;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getSubStone() {
		return subStone;
	}

	public void setSubStone(String subStone) {
		this.subStone = subStone;
	}

	public String getMainStone() {
		return mainStone;
	}

	public void setMainStone(String mainStone) {
		this.mainStone = mainStone;
	}

	public double getGoldCost() {
		return goldCost;
	}

	public void setGoldCost(double goldCost) {
		this.goldCost = goldCost;
	}

	public double getHandCost() {
		return handCost;
	}

	public void setHandCost(double handCost) {
		this.handCost = handCost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getPhotoLink() {
		return photoLink;
	}

	public void setPhotoLink(String photoLink) {
		this.photoLink = photoLink;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public Product() {
	}

	public Product(int id, int pid, String name, String supplier, String leader, String tel, String certificateNum,
			String component, String size, double weight, String subStone, String mainStone, double goldCost,
			double handCost, int quantity, double cost, String photoLink, String note) {
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.supplier = supplier;
		this.leader = leader;
		this.tel = tel;
		this.certificateNum = certificateNum;
		this.component = component;
		this.size = size;
		this.weight = weight;
		this.subStone = subStone;
		this.mainStone = mainStone;
		this.goldCost = goldCost;
		this.handCost = handCost;
		this.quantity = quantity;
		this.cost = cost;
		this.photoLink = photoLink;
		this.note = note;
	}
	
	
	

	
	public Product(int id, int pid, String name, String supplier, String leader, String tel, String certificateNum,
			String component, String size, double weight, String subStone, String mainStone, double goldCost,
			double handCost, int quantity, double cost, String photoLink, String note, String photoName) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.supplier = supplier;
		this.leader = leader;
		this.tel = tel;
		this.certificateNum = certificateNum;
		this.component = component;
		this.size = size;
		this.weight = weight;
		this.subStone = subStone;
		this.mainStone = mainStone;
		this.goldCost = goldCost;
		this.handCost = handCost;
		this.quantity = quantity;
		this.cost = cost;
		this.photoLink = photoLink;
		this.note = note;
		this.photoName = photoName;
	}

	
	
	public Product(int pid, String name, String supplier, String leader, String tel, String certificateNum,
			String component, String size, double weight, String subStone, String mainStone, double goldCost,
			double handCost, int quantity, double cost, String photoLink, String note, String photoName) {
		super();
		this.pid = pid;
		this.name = name;
		this.supplier = supplier;
		this.leader = leader;
		this.tel = tel;
		this.certificateNum = certificateNum;
		this.component = component;
		this.size = size;
		this.weight = weight;
		this.subStone = subStone;
		this.mainStone = mainStone;
		this.goldCost = goldCost;
		this.handCost = handCost;
		this.quantity = quantity;
		this.cost = cost;
		this.photoLink = photoLink;
		this.note = note;
		this.photoName = photoName;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", pid=" + pid + ", name=" + name + ", supplier=" + supplier + ", leader=" + leader
				+ ", tel=" + tel + ", certificateNum=" + certificateNum + ", component=" + component + ", size=" + size
				+ ", weight=" + weight + ", subStone=" + subStone + ", mainStone=" + mainStone + ", goldCost="
				+ goldCost + ", handCost=" + handCost + ", quantity=" + quantity + ", cost=" + cost + ",photoLink="
				+ photoLink + ", note=" + note + ",photoLink="
				+ photoLink + "]";
	}

}
