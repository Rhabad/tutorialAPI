package com.rhabad.tutorial.mybeans;

import org.springframework.stereotype.Component;

@Component
public class MiComponent {

    public void saludarDesdeComponente(){
        System.out.println("Hola desde mi primer componente");
    }
}
