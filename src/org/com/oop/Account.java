package org.com.oop;

public class Account {
	private String accountNumber;
	private double balance;
	private String costumerName;
	private String email;
	private String phoneNumber;
	
	//constructor
	public Account() {
		//Eğer default constructor çağırılır ve o nesneyi yaratırken aşağıdaki constructor a göre default değerler vermek istersek:
		this("0000",0.0,"Default name","default mail","default phone number");
		//bu ifadeyi kullanırsak aşağıdaki constructor'u çağırmış oluruz, ve onu bir kez çalıştırmış oluruz.
		System.out.println("Empty constructor called...");
	}
	public Account(String accountNumber,double balance,String costumerName,String email,String phoneNumber) {
		System.out.println("Account constructor with parameters called..");
		this.accountNumber=accountNumber;
		//eğer burada direkt atama yapmak yerine setters üzerinden atama yaparsak uygunluğu test etmiş oluruz.
		//Fakat bu tartışmalı bir konudur ve genel olarak değerler direkt olarak atanır.
		//this.balance=balance;
		setBalance(balance);
		this.costumerName=costumerName;
		this.email=email;
		this.phoneNumber=phoneNumber;
	}
	
	//yalnıza 3 parametre alan ve diğer parametreleri otomatik olarak dolduran constructor
	public Account(String costumerName,String email,String phoneNumber) {
		this("1234",0.0,costumerName,email,phoneNumber);
	}
	
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		if(balance>=0) {
			this.balance=balance;
		}else {
			this.balance=0.0;
		}
	}
	public String getCostumerName() {
		return costumerName;
	}
	public void setCostumerName(String costumerName) {
		this.costumerName = costumerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void depositFunds(double amount) {
		
		this.balance+=amount;
	}
	
	public void withdrawFunds(double amount) {
		if(amount<=this.balance) {
			this.balance-=amount;
			System.out.println("Hesaptan "+amount+" miktarında para çekildi. Kalan: "+this.balance);
		}else {
			System.out.println("Yalnızca "+this.balance+" miktarında bakiye bulunmaktadır.");
		}
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", costumerName=" + costumerName
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
	

}
