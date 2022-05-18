package ar.com.MercadoLibre;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${ambiente}.properties" // Obtiene el path del archivo de properties segun ambiente
})
public interface Ambiente extends Config {


    String urlMercadoLibre();
    String wordToSearch();





}
