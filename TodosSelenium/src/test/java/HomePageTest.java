import org.example.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage;


    @Test
    void userWritesCheckList() {
        homePage = new HomePage(driver);
        String toDo1 = "Home work";
        String toDo2 = "2 Laukelis";
        String toDo3 = "3 Laukelis";
        homePage.addToDo("Home work");
        homePage.addToDo("2 Laukelis");
        homePage.addToDo("3 Laukelis");
        homePage.multipleParameter(toDo1, toDo2, toDo3);
        Assertions.assertEquals(toDo1, homePage.get1List(1), "Nesutinka");
        Assertions.assertEquals(toDo2, homePage.get1List(2), "Nesutinka");
        Assertions.assertEquals(toDo3, homePage.get1List(3), "Nesutinka");
        homePage.completeTodo(1);
        Assertions.assertTrue(homePage.isClassDisplayed(), "false, jei blogai");
    }

    @Test
    void userDeletelist() {
        homePage = new HomePage(driver);
        String toDo1 = "Home work";
        homePage.addToDo("Home work");
        homePage.multipleParameter(toDo1);
        Assertions.assertEquals(toDo1, homePage.get1List(1), "Nesutinka");
        homePage.completeTodo(1);
        homePage.clickDeleteButton(1);
        Assertions.assertTrue(homePage.isListEmpty());
    }

    @Test
    void userDelete1ItemFromList() {
        homePage = new HomePage(driver);
        String toDo1 = "Home work";
        String toDo2 = "2 Laukelis";
        homePage.addToDo("Home work");
        homePage.addToDo("2 Laukelis");
        homePage.multipleParameter(toDo1, toDo2);
        Assertions.assertEquals(toDo1, homePage.get1List(1), "Nesutinka");
        Assertions.assertEquals(toDo2, homePage.get1List(2), "Nesutinka");
        homePage.completeTodo(1);
        homePage.clickDeleteButton(1);
//        Assertions.assertEquals(1, homePage.getToDosCount());
//        Assertions.assertEquals(itemToDoText1,homePage.getItemToDoText(1));

    }

    @Test
    void userClearCompletedList() {
        homePage = new HomePage(driver);
        String toDo1 = "Home work";
        String toDo2 = "2 Laukelis";
        String toDo3 = "3 Laukelis";
        homePage.addToDo("Home work");
        homePage.addToDo("2 Laukelis");
        homePage.addToDo("3 Laukelis");
        homePage.multipleParameter(toDo1, toDo2, toDo3);
        homePage.completeTodo(2);
        homePage.clickClearCompleted();
        Assertions.assertEquals(2, homePage.getToDosCount());
        Assertions.assertEquals(toDo1, homePage.getItemToDoText(1));
        Assertions.assertEquals(toDo3, homePage.getItemToDoText(2));
    }

    //Prideti 3 checklistus, patikrinti po to ar checkedclear dingsta
//
    //        Addtodo ("A","B")
//        assert 2 items left
//        Complete("A")
//        assert 1 item left
//        Remove("B)
//        assert 0 items left
    @Test
    void leftItems() {
        homePage = new HomePage(driver);
        String toDo1 = "Medium";
        String toDo2 = "Hard";
        homePage.addToDo("Medium");
        homePage.addToDo("Hard");
        homePage.multipleParameter(toDo1, toDo2);
        Assertions.assertEquals("2", homePage.getItemsLeft());
        homePage.completeTodo(1);
        Assertions.assertEquals("1", homePage.getItemsLeft());
        homePage.clickDeleteButton(2);
        Assertions.assertEquals("0", homePage.getItemsLeft());

    }

    //    add a,b,c
//    filter active
//    rodo A B C
//    complete B
//    rodo A C
//    filter Completed
//    rodo B
    @Test
    void workingFilter() {
        homePage = new HomePage(driver);
        String toDo1 = "1 Laiskas";
        String toDo2 = "2 Paukstis";
        String toDo3 = "3 Namai";
        homePage.addToDo("1 Laiskas");
        homePage.addToDo("2 Paukstis");
        homePage.addToDo("3 Namai");
        homePage.multipleParameter(toDo1, toDo2, toDo3);
        homePage.getActiveFieldButton();
        Assertions.assertEquals(3, homePage.getToDosCount());
        homePage.completeTodo(2);
        Assertions.assertEquals(2, homePage.getToDosCount());
        homePage.getCompletedFieldButton();
        Assertions.assertEquals(1, homePage.getToDosCount());
    }
//Atidarius svetaine, neras jokio Itemo per to do puslapi.

    @Test
    void emptyListThenOpen() {
        homePage = new HomePage(driver);
        Assertions.assertEquals(0, homePage.getToDosCount());
    }
//    Kai atidarom matom placeholder. Patikrinti, kad matome irasyta teksta laukelyje.

    @Test
    void seePlaceholderWithText() {
        homePage = new HomePage(driver);
        Assertions.assertTrue(homePage.isPlaceHolderTextDisplayed(), "false, jei blogai");
//        kitas variantas.
        String expectedPlaceholder = "What needs to be done?";
        Assertions.assertEquals(expectedPlaceholder, homePage.getPlaceHolderText());
    }

    //    suvedam kazkoki, padarom, paspaudziam, kad butu atklikintas ir tikrinam.
    @Test
    void checkActiveFields() {
        homePage = new HomePage(driver);
        homePage.addToDo("Medium");
        homePage.completeTodo(1);
        homePage.completeTodo(1);
        Assertions.assertEquals(0, homePage.getCompletedItems());
    }

    //    parasai list ir tuomet nera clear completed teksto, o kai paspaudi varnele, atsiranda.
    @Test
    void checkClearCompletedText() {
        homePage = new HomePage(driver);
        String toDo1 = "Medium";
        homePage.addToDo("Medium");
        homePage.multipleParameter(toDo1);
        Assertions.assertFalse(homePage.isClearCompletedButtonDisplayed());
        homePage.completeTodo(1);
        Assertions.assertTrue(homePage.isClearCompletedButtonDisplayed());
    }
}