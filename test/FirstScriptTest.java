import org.junit.Test;

/**
 * Created by Alexandr Podkopaev on 06.11.2016.
 */
public class FirstScriptTest {

    //Тестирование по первому сценарию с выбором телевизоров дороже 20 тысяч

    @Test
    public void firstScriptTest() throws Exception {
        MyTest1 firstScriptTest = new MyTest1();
        String device = "Телевизоры";
        int cost = 20000;
        String[] brands = {"LG","Samsung"};
        firstScriptTest.myTest(device,cost, brands);
    }
}
