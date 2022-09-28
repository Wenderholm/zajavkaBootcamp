package com.company.kolekcje.immutableTraining;

import java.util.ArrayList;
import java.util.List;

public final class CatImmutable {
     private final List<String> friendsNames;

//     II blokada towrzenie kopii w konstruktorze
    public CatImmutable(List<String> friendsNames) {
        this.friendsNames = new ArrayList<>(friendsNames);
    }
//    I blokada tworzenie kopii w getterach
    public List<String> getFriendsNames(){
        return new ArrayList<>(friendsNames);
    }

    @Override
    public String toString() {
        return "CatImmutable{" +
                "friendsNames=" + friendsNames +
                '}';
    }
}
