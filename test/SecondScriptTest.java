import org.junit.Test;

/**
 * Created by Alexandr Podkopaev on 06.11.2016.
 */
public class SecondScriptTest {

    //Тестирование по второму сценарию с выбором наушников дороже 5 тысяч

    @Test
    public void name() throws Exception {
        MyTest1 secondScriptTest = new MyTest1();
        String device = "Наушники";
        int cost = 5000;
        String[] brands = {"Beats"};
        secondScriptTest.myTest(device,cost, brands);
    }
}
