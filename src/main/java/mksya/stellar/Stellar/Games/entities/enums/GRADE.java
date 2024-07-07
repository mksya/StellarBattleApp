package mksya.stellar.Stellar.Games.entities.enums;


public enum GRADE {

    RYADOVOY("RYADOVOY"),
    YEFREYTOR("YEFREYTOR"),
    SERJANT("SERJANT"),
    LEYTENANT("LEYTENANT"),
    KAPITAN("KAPITAN"),
    MAYOR("MAYOR"),
    POLKOVNIK("POLKOVNIK"),
    GENERAL("GENERAL"),
    ADMIRAL("ADMIRAL");

    public final String value;

    GRADE(String value){
        this.value=value;
    }

}
