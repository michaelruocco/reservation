package uk.co.mruoc;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import org.junit.jupiter.api.Test;

class ReservationControllerTest {

    @Test
    void postValidReservationWhenDatabaseIsEmpty() {
        var db = new FakeDatabase();
        var controller = new ReservationController(db);
        var dto = ReservationDto.builder()
                .timestamp("2024-02-22T22:19:53Z")
                .email("willy.gnonto@gmail.com")
                .name("William Gnonto")
                .size(5)
                .build();

        controller.post(dto);

        var expected = Reservation.builder()
                .timestamp(Instant.parse(dto.getTimestamp()))
                .email(dto.getEmail())
                .name(dto.getName())
                .size(dto.getSize())
                .build();
        assertThat(db).containsExactly(expected);
    }
}
