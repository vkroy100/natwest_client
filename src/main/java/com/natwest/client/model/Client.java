package com.natwest.client.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Client {

	@Id
	String sourceName;

	int costPerCadet;
	String websiteAddress;
	LocalDate date;
	int numberOfRecruit;

	public Client(String sourceName, int costPerCadet, String websiteAddress, LocalDate date, int numberOfRecruit) {
		super();
		this.sourceName = sourceName;
		this.costPerCadet = costPerCadet;
		this.websiteAddress = websiteAddress;
		this.date = date;
		this.numberOfRecruit = numberOfRecruit;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public int getCostPerCadet() {
		return costPerCadet;
	}

	public void setCostPerCadet(int costPerCadet) {
		this.costPerCadet = costPerCadet;
	}

	public String getWebsiteAddress() {
		return websiteAddress;
	}

	public void setWebsiteAddress(String websiteAddress) {
		this.websiteAddress = websiteAddress;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getNumberOfRecruit() {
		return numberOfRecruit;
	}

	public void setNumberOfRecruit(int numberOfRecruit) {
		this.numberOfRecruit = numberOfRecruit;
	}

}
