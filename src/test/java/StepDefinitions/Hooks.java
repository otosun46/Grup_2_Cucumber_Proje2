/**
 * @Author:Otosun Tarih :09/10/2020
 */
package StepDefinitions;

import Utilities.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    @Before
    public void before(Scenario scenario){
//        System.out.println("Seneryo basladi");
//        System.out.println("Seneryonun id si: "+scenario.getId());
        System.out.println("Senaryo: "+scenario.getName());
    }

    @After
    public void after(Scenario scenario){
//        System.out.println("Seneryo bitti");
//        System.out.println("Seneryonun id si: "+scenario.getId());
        System.out.println("Sonuc  : "+scenario.getStatus());
        System.out.println("============================================================");
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
      //  Driver.quitDriver();
    }
}
