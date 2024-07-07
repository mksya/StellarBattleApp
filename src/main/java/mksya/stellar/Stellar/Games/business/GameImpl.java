package mksya.stellar.Stellar.Games.business;

import mksya.stellar.Stellar.Games.entities.Ship;
import mksya.stellar.Stellar.Games.entities.Spot;
import mksya.stellar.Stellar.Games.entities.enums.AXIS;
import mksya.stellar.Stellar.Games.entities.enums.DIRECTION;
import mksya.stellar.Stellar.Games.entities.enums.SHIPCLASS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameImpl implements IGame {

    @Override
    public void lauchGame() {

        Scanner input = new java.util.Scanner(System.in);
        System.out.println("Quel est ton nom, Camarade ?");
        String name = input.next();
        System.out.println("Quel est ton grade, Camarade ?");
        String grade = input.next();

        switch (grade) {
            case "RYADOVOY":
                launchPrivateNarrative();
                break;
            case "YEFREYTOR":
                launchCaporalNarrative();
                break;
            case "SERJANT":
                launchSergentNarrative();
                break;
            case "LEYTENANT":
                launchLieutenantNarrative();
                break;
            case "KAPITAN":
                launchKapitanNarrative();
                break;
            case "MAYOR":
                launchMayorNarrative();
                break;
            case "POLKOVNIK":
                launchColonelNarrative();
                break;
            case "GENERAL":
                launchGeneralNarrative();
                break;
            case "ADMIRAL":
                launchAdmiralNarrative();
                break;
            default:
        }

    }


    private void launchPrivateNarrative() {
        System.out.println("La bataille va commencer. A ton poste, le troufion!");

        generateShip(SHIPCLASS.CARRIER.value);

        
        generateShip(SHIPCLASS.CRUISER.value);
        generateShip(SHIPCLASS.CRUISER.value);
        generateShip(SHIPCLASS.DESTROYER.value);
        generateShip(SHIPCLASS.DESTROYER.value);
        generateShip(SHIPCLASS.CORVETTE.value);
        generateShip(SHIPCLASS.CORVETTE.value);
        generateShip(SHIPCLASS.SUBMARINE.value);
        generateShip(SHIPCLASS.SUBMARINE.value);

    }

    private void generateShip(int shipclassValue) {
        Ship ship = new Ship();
        int x = getRandomNumber(1, 9);
        int y = getRandomNumber(1, 9);
        Spot originSpot = new Spot();
        originSpot.setX(x);
        originSpot.setY(y);
        ship.setAxis(getRandomAxis());
        ship.setDirection(getRandomDirection());
        ship.setOrigin(originSpot);
        ship.setShipClass(SHIPCLASS.CARRIER);

        List<Spot> spots = new ArrayList<>();
        while (spots.size() < shipclassValue) {
            Spot spot = new Spot();
            spots.add(spot);
        }
        ship.setCoordinates(spots);

        if (ship.getAxis() == AXIS.VERTICAL && ship.getDirection() == DIRECTION.POSITIVE) {
            spots.forEach(spot -> spot.setY(ship.getOrigin().getY()));
            spots.forEach(spot -> spot.setX(ship.getOrigin().getX()));
            for (int i = 1; i < spots.size(); i++) {
                spots.get(i).setX(spots.get(0).getX() + 1);
            }
        }

        if (ship.getAxis() == AXIS.VERTICAL && ship.getDirection() == DIRECTION.POSITIVE) {
            spots.forEach(spot -> spot.setY(ship.getOrigin().getY()));
            spots.forEach(spot -> spot.setX(ship.getOrigin().getX()));
            for (int i = 1; i < spots.size(); i++) {
                spots.get(i).setX(spots.get(0).getX() - 1);
            }
        }

        if (ship.getAxis() == AXIS.HORIZONTAL && ship.getDirection() == DIRECTION.POSITIVE) {
            spots.forEach(spot -> spot.setY(ship.getOrigin().getY()));
            spots.forEach(spot -> spot.setX(ship.getOrigin().getX()));
            for (int i = 1; i < spots.size(); i++) {
                spots.get(i).setY(spots.get(0).getY() + 1);
            }
        }

        if (ship.getAxis() == AXIS.HORIZONTAL && ship.getDirection() == DIRECTION.POSITIVE) {
            spots.forEach(spot -> spot.setY(ship.getOrigin().getY()));
            spots.forEach(spot -> spot.setX(ship.getOrigin().getX()));
            for (int i = 1; i < spots.size(); i++) {
                spots.get(i).setY(spots.get(0).getY() - 1);
            }
        }
    }


    private void launchCaporalNarrative() {
    }

    private void launchSergentNarrative() {
    }

    private void launchLieutenantNarrative() {
    }

    private void launchKapitanNarrative() {
    }

    private void launchMayorNarrative() {
    }

    private void launchColonelNarrative() {
    }

    private void launchGeneralNarrative() {
    }

    private void launchAdmiralNarrative() {
    }

    private void displayShip(Spot[][] grid) {
        Ship ship = new Ship();

        switch (ship.getShipClass()) {
            case CARRIER:

                break;

        }

    }


    private Spot[][] generateSpot() {
        int x = getRandomNumber(0, 9);
        int y = getRandomNumber(0, 9);
        return new Spot[x][y];
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private AXIS getRandomAxis() {
        return AXIS.valueOf(String.valueOf(((int) ((Math.random()) + 1))));
    }

    private DIRECTION getRandomDirection() {
        return DIRECTION.valueOf(String.valueOf(((int) ((Math.random()) + 1))));
    }

    @Override
    public void strike() {

    }

    @Override
    public void report() {

    }

    @Override
    public void harvest() {

    }
}
