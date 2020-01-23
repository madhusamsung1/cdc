package com.ObjectRepository;

import org.openqa.selenium.By;

public class Locators {

	public final By userName = By.name("email");
	public final By password = By.name("pass");
	public final By login = By.id("loginbutton");
	



// SBI page locators

public final By sbi_Login = By.xpath("//*[text()='LOGIN'][1]");
public final By sbi_ContinueToLogin = By.xpath("//*[text()='CONTINUE TO LOGIN']");
public final By sbi_LoginPage_LoginButton = By.id("Button2");



//Delta
public final By UserName_Delta = By.id("userId");
public final By Password_Delta = By.id("password");
public final By Login_Delta = By.xpath("//button[@class='btn btn-danger loginButton']");


//JustRecharge

public final By Add_Mobile_Number = By.xpath("//a[@class='addMobileLink']");
public final By Mobile_No = By.id("txtpopMobileNo");
public final By NickName = By.id("txtpopMobileNickname");
public final By Operator = By.id("ddlpopMobileSP");
public final By Add = By.id("btnPopupAddMobile");





}