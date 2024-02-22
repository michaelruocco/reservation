package uk.co.mruoc;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Builder
@Data
public class ReservationDto {

    private final String timestamp;
    private final String email;
    private final String name;
    private final int size;
}
