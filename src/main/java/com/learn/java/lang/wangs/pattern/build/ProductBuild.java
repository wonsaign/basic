package com.learn.java.lang.wangs.pattern.build;

import java.util.Date;
import java.util.UUID;

import com.alibaba.fastjson.JSON;

//@Data
class Product {

	private String id;
	private String name;
	private String type;
	private Date createTime;
	private String factory;
	private String size;
	private String basicPrice;// 成本价 
	private String no;
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public String getFactory() {
		return factory;
	}
	public String getSize() {
		return size;
	}
	public String getBasicPrice() {
		return basicPrice;
	}
	public String getNo() {
		return no;
	}
	// 私有构造方法
	private Product(ProdcutBuilder builder) {
		this.name = builder.name;
		this.type = builder.type;
		this.createTime = builder.createTime;
		this.factory = builder.factory;
		this.size = builder.size;
		this.basicPrice = builder.basicPrice;
		this.no = builder.no;
	}
	
	
	
	// 内部类的作用:可以获取,内部类的私有属性
	public static class ProdcutBuilder {
		private final String id;
		private String name;
		private String type;
		private Date createTime;
		private String factory;
		private String size;
		private String basicPrice;// 成本价 
		private String no;
		
		public Product bulid() {
			return new Product(this);
		}
		
		public ProdcutBuilder(String id) {
			this.id = id;
		}
		public ProdcutBuilder buildName(String name) {
			this.name = name;
			return this;
		}
		public ProdcutBuilder buildCreateTime(Date createTime) {
			this.createTime = createTime;
			return this;
		}
		public ProdcutBuilder buildFactory(String factory) {
			this.factory = factory;
			return this;
		}
		public ProdcutBuilder buildSize(String size) {
			this.size = size;
			return this;
		}
		public ProdcutBuilder buildBasicPrice(String basicPrice) {
			this.basicPrice = basicPrice;
			return this;
		}
		public ProdcutBuilder buildNo(String no) {
			this.no = no;
			return this;
		}
	}
	
}
public class ProductBuild{
	public static void main(String[] args) {
		Product p = new Product.ProdcutBuilder(UUID.randomUUID().toString())
				.buildName("测试产品")
				.buildBasicPrice("不要钱")
				.buildFactory("罗技")
				.bulid();
		System.out.println(JSON.toJSONString(p));
	}
}