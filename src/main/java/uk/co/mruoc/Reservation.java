package uk.co.mruoc;

import java.time.Instant;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Data
public class Reservation {

    private final Instant timestamp;
    private final String email;
    private final String name;
    private final int size;
}
