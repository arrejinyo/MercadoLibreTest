package ar.com.MercadoLibre.test;


import ar.com.MercadoLibre.Ambiente;
import ar.com.MercadoLibre.services.BackEndClass;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;



public class Meli_BackEnd_Test{

    private Ambiente ambiente;

    @Test
    public void ambiente() {
        System.out.println("Iniciando ambiente: " + System.getProperty("ambiente"));
        ambiente = ConfigFactory.create(Ambiente.class);

    }


    @Test
    public void doSearch_test() {

        BackEndClass back = new BackEndClass();
        back.doSearch(ambiente.wordToSearch());
        back.searchFirstProductById();

    }

    @Test(dependsOnMethods = "doSearch_test", priority = 1)
        public void validar_titulo_test(){
        BackEndClass back = new BackEndClass();
        back.validateTitle();
    }

    @Test(dependsOnMethods = "doSearch_test",priority = 2)
    public void validar_precio_test(){
        BackEndClass back = new BackEndClass();
        back.validatePrice();
    }

    @Test(dependsOnMethods = "doSearch_test",priority = 3)
    public void validar_AceptaMp_test(){
        BackEndClass back = new BackEndClass();
        back.validateAcceptMp();
    }

    @Test(dependsOnMethods = "doSearch_test",priority = 4)
    public void validar_melicoin_test(){
        BackEndClass back = new BackEndClass();
        back.validateMelicoin();
    }

    @Test(dependsOnMethods = "doSearch_test",priority = 5)
    public void validar_envio_gratis_test(){
        BackEndClass back = new BackEndClass();
        back.validateFreeShipping();
    }



}