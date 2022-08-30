package com.company.objectProgram.polimorfizm.polimorfizmNaKlasach;

public class WordDocument extends DocumentItem{

    public String wordMethod(){
        return "word method";
    }

    @Override
    public String getDescription() {
        return "Class representing word document.";
    }
}
