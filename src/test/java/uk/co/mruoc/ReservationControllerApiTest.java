package uk.co.mruoc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.UncheckedIOException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(controllers = ReservationController.class)
@Import({ReservationConfig.class})
class ReservationControllerApiTest {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    void homeReturnsJson() throws Exception {
        var reservation = ReservationDto.builder()
                .timestamp("2024-02-22T22:05:49Z")
                .email("georginio.rutter@hotmail.com")
                .name("Georginio Rutter")
                .size(2)
                .build();

        var result = post(reservation);

        result.andExpect(status().isOk()).andExpect(content().contentType(APPLICATION_JSON));
    }

    private ResultActions post(ReservationDto reservation) throws Exception {
        var request = MockMvcRequestBuilders.post("/reservations")
                .accept(APPLICATION_JSON)
                .content(toJson(reservation));
        return mockMvc.perform(request);
    }

    private static String toJson(Object o) {
        try {
            return MAPPER.writeValueAsString(o);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
