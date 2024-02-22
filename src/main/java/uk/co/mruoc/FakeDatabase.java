package uk.co.mruoc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FakeDatabase implements Iterable<Reservation>, ReservationRepository {

    private final Collection<Reservation> reservations;

    public FakeDatabase() {
        this(new ArrayList<>());
    }

    @Override
    public Iterator<Reservation> iterator() {
        return reservations.iterator();
    }

    @Override
    public void create(Reservation reservation) {
        reservations.add(reservation);
    }
}
