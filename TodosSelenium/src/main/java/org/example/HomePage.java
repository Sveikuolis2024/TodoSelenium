package org.example;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[placeholder='What needs to be done?']")
    private WebElement placeToWrite;

    @FindBy(css = ".todo-list label")
    private List<WebElement> todoItems;

    @FindBy(css = ".todo-list li:nth-child(2)")
    private WebElement write2List;
    @FindBy(css = ".todo-list li:nth-child(3)")
    private WebElement write3List;

    @FindBy(css = ".todo-list li .toggle")
    private List<WebElement> toggleTodo;
    @FindBy(css = ".todo-list li.completed")
    private List<WebElement> appearCompletedClass;
    @FindBy(css = ".destroy")
    private List<WebElement> deleteButton;
    @FindBy(css = ".clear-completed")
    private List<WebElement> clearCompleted;

    @FindBy(xpath = "//strong")
    private WebElement leftItem;

    @FindBy(css = "a[href*='active']")
    private WebElement activeFieldButton;
    @FindBy(css = "a[href*='completed']")
    private WebElement clickCompletedFieldButton;
    @FindBy(xpath = "//input[@placeholder='What needs to be done?']")
    private WebElement placeHolderText;

    public void addToDo(String checkList) {
        placeToWrite.sendKeys(checkList + Keys.ENTER);
    }

    public String get1List(int number) {
        return todoItems.get(number - 1).getText();
    }

    public int getCompletedItems() {
        return appearCompletedClass.size();
    }


// priimtu tiek parametru, kiek paduosim

    public void multipleParameter(String... addToDo) {
        for (String text : addToDo) {
        }
    }

    //to do paspaudziam varnele ir nusibraukia tekstas. Tikrinam, ar atsiranda tas atliktas veiksmas.
    public void completeTodo(int nth) {
        toggleTodo.get(nth - 1).click();
    }

    public boolean isClassDisplayed() {
        return appearCompletedClass.get(0).isDisplayed();
    }

    //    delete list
    public void clickDeleteButton(int deleteText) {
        Actions action = new Actions(driver);
        action.moveToElement(todoItems.get(deleteText - 1)).perform();
        deleteButton.get(deleteText - 1).click();
//        hoverinimas
    }

    public boolean isListEmpty() {
        return todoItems.isEmpty();
    }

    public void clickClearCompleted() {
        clearCompleted.get(0).click();
    }

    public int getToDosCount() {
        return todoItems.size();
    }

    public String getItemToDoText(int i) {
        return todoItems.get(i - 1).getText();
    }

    public String getItemsLeft() {
        return leftItem.getText();
    }

    public void getActiveFieldButton() {
        activeFieldButton.click();
    }

    public void getCompletedFieldButton() {
        clickCompletedFieldButton.click();
    }

    public boolean isPlaceHolderTextDisplayed() {
        return placeHolderText.isDisplayed();
    }

    public String getPlaceHolderText() {
        return placeToWrite.getAttribute("placeholder");
    }

    public boolean isClearCompletedButtonDisplayed(){
        return !clearCompleted.isEmpty();

    }
}

//    eina nuoroda su * reiskia, kad ima visa nuoroda su tekstu active. o kitu atveju completed.
//    a[href*='active']
//    a[href*='completed']
