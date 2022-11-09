package com.company.klasZagnieżdżone.podsumowania;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BlockOfFlats {
    private List<Flat> flats;


//    ze wzglednu na to ze mamy klase Flat prywatna mozemy sie do niej odwołac tylko w tej klasie

    public BlockOfFlats(List<BigDecimal> areas) {
        List<Flat> flats = new ArrayList<>();

        for (BigDecimal area : areas) {
            flats.add(new Flat(area));
        }
        this.flats = flats;
    }

    public BlockOfFlats() {

    }

    public List<Flat> getFlats() {
        return flats;
    }

    public class Flat {
        private BigDecimal area;

        public Flat(BigDecimal area) {
            this.area = area;
        }

        @Override
        public String toString() {
            return "Flat{" +
                    "area=" + area +
                    '}';
        }
    }
}
