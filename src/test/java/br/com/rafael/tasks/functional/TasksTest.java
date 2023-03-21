package br.com.rafael.tasks.functional;

import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static Util.Util.*;

public class TasksTest  extends BaseTest{
    @Before
    public void StartTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    @After
    public void FinishTest() {
        driver.quit();
    }
    @Test
    public void deveSalvarTarefaComSucesso() {
        ClickElementById(driver, "addTodo");

        WriteInElementById(driver, "task", "Test Selenium");

        WriteInElementById(driver, "dueDate", "01/12/2023");

        ClickElementById(driver, "saveButton");

        AssertElementById(driver, "message", "Success!");
    }

    @Test
    public void naoDeveSalvarTarefaSemDescricao() {
        ClickElementById(driver, "addTodo");

        WriteInElementById(driver, "dueDate", "20/03/2023");

        ClickElementById(driver, "saveButton");

        AssertElementById(driver, "message", "Fill the task description");
    }

    @Test
    public void naoDeveSalvarTarefaSemData() {
        ClickElementById(driver, "addTodo");

        WriteInElementById(driver, "task", "Test Selenium");

        ClickElementById(driver, "saveButton");

        AssertElementById(driver, "message", "Fill the due date");
    }

    @Test
    public void naoDeveSalvarTarefaComDataPassada() {
        ClickElementById(driver, "addTodo");

        WriteInElementById(driver, "task", "Test Selenium");

        WriteInElementById(driver, "dueDate", "10/10/2010");

        ClickElementById(driver, "saveButton");

        AssertElementById(driver, "message", "Due date must not be in past");
    }

    @Test
    public void deveRemoverTarefaComSucesso() {
        ClickElementById(driver, "addTodo");

        WriteInElementById(driver, "task", "Test Selenium");

        WriteInElementById(driver, "dueDate", "01/12/2023");

        ClickElementById(driver, "saveButton");

        AssertElementById(driver, "message", "Success!");

       ClickElementByPath(driver, "//a[@class='btn btn-outline-danger btn-sm']");

        AssertElementById(driver, "message", "Success!");

    }
}
