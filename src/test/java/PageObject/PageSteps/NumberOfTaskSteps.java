package PageObject.PageSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static PageObject.PageElements.AuthorizationPageElem.*;
import static PageObject.PageElements.LoggedPageElem.projectTest;
import static PageObject.PageElements.LoggedPageElem.projectsDropButton;
import static PageObject.PageElements.TestProjectPageElem.numberOfTaskList;
import static PageObject.PageElements.TestProjectPageElem.taskList;
import static PageObject.PageSteps.AuthorizationSteps.openUrl;
import static utils.Configuration.getConfigurationValue;

public class NumberOfTaskSteps {

    @Step ("Проверить общее количество задач")
    public static void numberOfTask() {
        openUrl(getConfigurationValue("jiraUrl"));
        loginLane.shouldBe(Condition.visible).click();
        loginLane.sendKeys(getConfigurationValue("login"));
        passwordLane.click();
        passwordLane.sendKeys(getConfigurationValue("password"));
        loginButton.click();
        projectsDropButton.shouldBe(Condition.visible).click();
        projectTest.click();
        taskList.shouldBe(Condition.visible).click();
        String str = numberOfTaskList.getText();
        String[] subStr;
        String delimiter = " ";
        subStr = str.split(delimiter);
        System.out.println("Общее количество задач: " + subStr[0]);
    }
}
