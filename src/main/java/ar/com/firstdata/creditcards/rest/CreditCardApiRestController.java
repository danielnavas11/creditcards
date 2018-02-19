package ar.com.firstdata.creditcards.rest;

import ar.com.firstdata.creditcards.enums.TypeTasa;
import ar.com.firstdata.creditcards.model.Marca;
import ar.com.firstdata.creditcards.model.Tasa;
import ar.com.firstdata.creditcards.rest.entity.ResponseTasa;
import ar.com.firstdata.creditcards.service.TarjetaService;
import ar.com.firstdata.creditcards.service.impl.TarjetaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/")
public class CreditCardApiRestController {

    @Autowired
    static TarjetaService service = new TarjetaServiceImpl();

    private final Map<String, Marca> map;

    public CreditCardApiRestController() {
        this.map = new HashMap<>();
        map.put("SQUA", new Marca("SQUA", new Tasa(TypeTasa.AnioEntreMes)));
        map.put("SCO", new Marca("SCO", new Tasa(TypeTasa.DiaMesPor05)));
        map.put("PERE", new Marca("PERE", new Tasa(TypeTasa.MesPor01)));
    }

    @RequestMapping(value = "/consultar")
    public ResponseEntity<ResponseTasa> consultarTasa(@RequestParam(name = "importe") double importe,
                                               @RequestParam(name = "marca") String marca) {
        Double valor = null;
        try {
            valor = service.getTasaOperacion(map.get(marca.toUpperCase()), importe);
        }catch (Exception e){

        }
        if (valor != null) {
            return new ResponseEntity<ResponseTasa>(new ResponseTasa(marca.toUpperCase(), importe, valor), HttpStatus.OK);
        } else {
            return new ResponseEntity<ResponseTasa>(new ResponseTasa("Marca invalida"),HttpStatus.BAD_REQUEST);
        }
    }
}
