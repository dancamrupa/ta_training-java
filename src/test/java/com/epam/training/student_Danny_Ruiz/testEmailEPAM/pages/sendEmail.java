package com.epam.training.student_Danny_Ruiz.testEmailEPAM.pages;

import org.openqa.selenium.By;

public class sendEmail {

    By userPage = By.xpath("//label[@id='ybarAccountMenuOpener']");
    By email = By.id("ybarMailLink");
    By newEmailButton = By.xpath("//a[contains(text(),'Redactar')]");
    By toRecipient = By.id("message-to-field");
    By subject = By.xpath("//input[@data-test-id='compose-subject']");
    By message = By.xpath("//div[@data-test-id='rte']");
    By send = By.xpath("//button[@data-test-id='compose-send-button']");

}
