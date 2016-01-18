package com.theoreticsinc.cms.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

public class InventorySummaryVO implements Serializable{

	private static final long serialVersionUID = -5085909229210745781L;

	public InventorySummaryVO(){}
	
	private String sourceCode;
	private String productCode;
	private String storeCode;
	private String unitQuantity;
	private String poQuantity;
	private String poUnit;
	private String poReturnUnit;
	private String soUnit;
	private String soReturnUnit;
	private String inventorySource;
	private String transactionDate;
	private String stockLocation;
	private String staffCode;
	private String stockCode;
	private String status;
	private String jobId;
	private String requested;
	private String comments;
	private String brand;
	

	public String getSourceCode() {
		return sourceCode;
	}
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getUnitQuantity() {
		return unitQuantity;
	}
	public void setUnitQuantity(String unitQuantity) {
		this.unitQuantity = unitQuantity;
	}
	public String getPoQuantity() {
		return poQuantity;
	}
	public void setPoQuantity(String poQuantity) {
		this.poQuantity = poQuantity;
	}
	public String getPoUnit() {
		return poUnit;
	}
	public void setPoUnit(String poUnit) {
		this.poUnit = poUnit;
	}
	public String getPoReturnUnit() {
		return poReturnUnit;
	}
	public void setPoReturnUnit(String poReturnUnit) {
		this.poReturnUnit = poReturnUnit;
	}
	public String getSoUnit() {
		return soUnit;
	}
	public void setSoUnit(String soUnit) {
		this.soUnit = soUnit;
	}
	public String getSoReturnUnit() {
		return soReturnUnit;
	}
	public void setSoReturnUnit(String soReturnUnit) {
		this.soReturnUnit = soReturnUnit;
	}
	public String getInventorySource() {
		return inventorySource;
	}
	public void setInventorySource(String inventorySource) {
		this.inventorySource = inventorySource;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getStockLocation() {
		return stockLocation;
	}
	public void setStockLocation(String stockLocation) {
		this.stockLocation = stockLocation;
	}
	public String getStaffCode() {
		return staffCode;
	}
	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getRequested() {
		return requested;
	}
	public void setRequested(String requested) {
		this.requested = requested;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
}
