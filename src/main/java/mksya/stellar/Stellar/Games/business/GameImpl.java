package mksya.stellar.Stellar.Games.business;

import mksya.stellar.Stellar.Games.entities.Grid;
import mksya.stellar.Stellar.Games.entities.Ship;
import mksya.stellar.Stellar.Games.entities.Spot;
import mksya.stellar.Stellar.Games.entities.enums.AXIS;
import mksya.stellar.Stellar.Games.entities.enums.DIRECTION;
import mksya.stellar.Stellar.Games.entities.enums.SHIPCLASS;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        generateFleet();

    }

    private void generateFleet() {
        Grid grid = new Grid();
        List<Spot> shipsPosition = new ArrayList<>();
        grid.setSpots(shipsPosition);

        Ship carrier = generateShip(SHIPCLASS.CARRIER.value);
        shipsPosition.addAll(carrier.getCoordinates());

        Ship cruiser1 = generateShipWithCheckingOnGrid(shipsPosition, SHIPCLASS.CRUISER);

        shipsPosition.addAll(cruiser1.getCoordinates());

        Ship cruiser2 = generateShipWithCheckingOnGrid(shipsPosition, SHIPCLASS.CRUISER);
        shipsPosition.addAll(cruiser2.getCoordinates());

        Ship destroyer1 = generateShipWithCheckingOnGrid(shipsPosition, SHIPCLASS.DESTROYER);
        shipsPosition.addAll(destroyer1.getCoordinates());

        Ship destroyer2 = generateShipWithCheckingOnGrid(shipsPosition, SHIPCLASS.DESTROYER);
        shipsPosition.addAll(destroyer2.getCoordinates());

        Ship corvette1 = generateShipWithCheckingOnGrid(shipsPosition, SHIPCLASS.CORVETTE);
        shipsPosition.addAll(corvette1.getCoordinates());

        Ship corvette2 = generateShipWithCheckingOnGrid(shipsPosition, SHIPCLASS.CORVETTE);
        shipsPosition.addAll(corvette2.getCoordinates());

        Ship submmarine1 = generateShipWithCheckingOnGrid(shipsPosition, SHIPCLASS.SUBMARINE);
        shipsPosition.addAll(submmarine1.getCoordinates());

        Ship submmarine2 = generateShipWithCheckingOnGrid(shipsPosition, SHIPCLASS.SUBMARINE);
        shipsPosition.addAll(submmarine2.getCoordinates());
    }

    private Ship generateShipWithCheckingOnGrid(List<Spot> shipsPosition, SHIPCLASS shipclass) {
        Ship ship = generateShip(shipclass.value);
        while (checkShipPosition(ship.getCoordinates(), shipsPosition)) {
            ship = generateShip(shipclass.value);
        }
        return ship;
    }

    private boolean checkShipPosition(List<Spot> shipSpots, List<Spot> shipsPosition) {
        return shipSpots.stream().anyMatch(spot -> checkSpotAvailibility(spot, shipsPosition));
    }

    private boolean checkSpotAvailibility(Spot spotToCheck, List<Spot> existingSpots) {
        return existingSpots.stream().anyMatch(spot -> compareSpotCoordinates(spotToCheck, spot));
    }

    private boolean compareSpotCoordinates(Spot spot, Spot existingSpot) {
        return !Objects.equals(spot.getX(), existingSpot.getX()) && !Objects.equals(spot.getY(), existingSpot.getY());
    }

    private Ship generateShip(int shipclassValue) {
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

        ship.setCoordinates(spots);
        return ship;
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


    private Spot generateSpot() {
        Spot spot = new Spot();
        spot.setX(getRandomNumber(0, 9));
        spot.setY(getRandomNumber(0, 9));
        return spot;
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
