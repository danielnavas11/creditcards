package ar.com.firstdata.creditcards.service;

import ar.com.firstdata.creditcards.rest.CreditCardApiRestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(CreditCardApiRestController.class)
public class TarjetaServiceTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void obtenerMarcaSCO(){
        try {
            mvc.perform(get("/consultar?marca=SCO&importe=12345"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.marca").value("SCO"))
                    .andExpect(jsonPath("$.importe").value("12345.0"))
                    .andExpect(jsonPath("$.tasa").value("1172.775"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void obtenerMarcaSQUA(){
        try {
            mvc.perform(get("/consultar?marca=SQUA&importe=12345"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.marca").value("SQUA"))
                    .andExpect(jsonPath("$.importe").value("12345.0"))
                    .andExpect(jsonPath("$.tasa").value("617.25"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void obtenerMarcaPERE(){
        try {
            mvc.perform(get("/consultar?marca=PERE&importe=12345"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.marca").value("PERE"))
                    .andExpect(jsonPath("$.importe").value("12345.0"))
                    .andExpect(jsonPath("$.tasa").value("234.55500000000004"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void obtenerMarcaInvalida(){
        try {
            mvc.perform(get("/consultar?marca=ssssss&importe=1"))
                    .andExpect(status().is(400))
                    .andExpect(jsonPath("$.marca").value("Marca invalida"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
