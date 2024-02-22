package uk.co.mruoc;

import java.time.Instant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationRepository repository;

    @PostMapping
    public ResponseEntity<Void> post(ReservationDto dto) {
        repository.create(Reservation.builder()
                .timestamp(Instant.parse("2024-02-22T22:19:53Z"))
                .email("willy.gnonto@gmail.com")
                .name("William Gnonto")
                .size(5)
                .build());
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(null);
    }
}
