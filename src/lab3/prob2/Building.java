package lab3.prob2;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private int maintainenceCost;

    private List<Apartment> apartments = new ArrayList<>();

    Building(int maintainenceCost, int rent){
        this.maintainenceCost = maintainenceCost;
        addApartment(new Apartment(rent));
    }

    public void addApartment(Apartment apartment){
        apartments.add(apartment);
    }

    public void addApartment(int rent){
        apartments.add(new Apartment(rent));
    }

    public int getMaintainenceCost() {
        return maintainenceCost;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public int calcProfits(){
        int total = 0;
        for (Apartment apartment : apartments) {
            total+=apartment.getRent();
        }
        return total - maintainenceCost;
    }
}
