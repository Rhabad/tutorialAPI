package com.rhabad.tutorial;

import com.rhabad.tutorial.models.Libro;
import com.rhabad.tutorial.models.Producto;
import com.rhabad.tutorial.models.UserData;
import com.rhabad.tutorial.mybeans.MiBean;
import com.rhabad.tutorial.mybeans.MiComponent;
import com.rhabad.tutorial.services.IOrderService;
import com.rhabad.tutorial.services.OrdenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@RestController
public class Rutas {


    private IOrderService ordenService;
    private MiBean miBean;
    @Autowired
    private MiComponent component;

    public Rutas(IOrderService iOrderService, MiBean miBean){
        this.ordenService = iOrderService;
        this.miBean = miBean;
    }


    private final Logger logger = LoggerFactory.getLogger(Rutas.class);




    @GetMapping("/hola")
    public String primeraRutaGET(){
        return "Hola mundo desde spring, primera ruta";
    }

    @GetMapping("/libro/{id}/editorial/{editorial}")
    public String leerLibros(@PathVariable int id, @PathVariable String editorial){
        return "leyendo libro "+id+" de la editorial "+ editorial;
    }

    @GetMapping("/libro2/{id}")
    public String leerLibros2(@PathVariable int id, @RequestParam String params){
        return "leyendo libro "+id+" paramas: "+params;
    }

    @PostMapping("/libro")
    public String guardarLibros(@RequestBody Libro libro){

        logger.debug("libro {} editorial {} ", libro.nombre, libro.editorial);


        return "Libro guardado";
    }


    @GetMapping("/saludar")
    @ResponseStatus(value = HttpStatus.MOVED_PERMANENTLY, reason = "Fue movida a version 2 de la API")
    public String miSegundaRutaConStatus(){
        return "Aprendiendo status http en spring boot";
    }

    @GetMapping("/animales/{lugar}")
    public ResponseEntity<String> getAnimales(@PathVariable String lugar){
        if (lugar.equals("granja")){
            return ResponseEntity.status(HttpStatus.OK).body("Caballo, baca, oveja, perro, gallina");
        } else if (lugar.equals("selva")) {
            return ResponseEntity.status(HttpStatus.OK).body("Serpiente, puma, cocodrilo, mono");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lugar no valido");
        }

    }

    @GetMapping("/calcular/{numero}")
    public int getCalculo(@PathVariable int numero){
        throw new NullPointerException("La clave del usuario es 12341 y pass 123123, no deberia leerse en postman");
    }

    @GetMapping("/userdata/v1")
    public ResponseEntity<String> getUserData(){
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body("{\"name\": \"mary\"}");

    }

    @GetMapping("/userdata/v2")
    public Map<String, Map<String, Object>> getUserdata2(){
        return Map.of("user", Map.of("name", "mary","age", 25));
    }

    @GetMapping("/userdata/v3")
    public UserData getUserDataVersion3(){
        return new UserData("mary", 23, "nicolas 123123");
    }


    @PostMapping("/order")
    public String crearOrden(@RequestBody List<Producto> products){
        ordenService.saveOrder(products);
        return "Productos Guardados";
    }

    @GetMapping("/mibean")
    public String saludarBean(){
        miBean.saludar();
        return "completado";
    }

    @GetMapping("/component")
    public String saludarComponente(){
        component.saludarDesdeComponente();
        return "completado";
    }

}
