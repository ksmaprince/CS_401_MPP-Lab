package lab3.prob2;

import java.util.ArrayList;
import java.util.List;

public class LandlordInfo {
    private List<Building> buildings = new ArrayList<>();

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public int calcProfits(){
        int profit = 0;
        for (Building building : buildings) {
            profit +=building.calcProfits();
        }
        return profit;
    }
}
