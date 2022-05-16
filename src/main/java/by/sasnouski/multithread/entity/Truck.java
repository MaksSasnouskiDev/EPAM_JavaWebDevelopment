package by.sasnouski.multithread.entity;

import java.util.Objects;
import java.util.concurrent.Callable;

public class Truck implements Callable<String> {
    private int truckId;
    private TruckState truckState;

    private int truckTonnage;
    int cargoWeight;

    private boolean isLoadedTruck;
    private boolean isFragile;


    public enum TruckState {
        NEW, LOADED, FINISHED
    }

    public Truck(int truckId, int truckTonnage, int cargoWeight,
                 boolean isLoadedTruck, boolean isFragile) {

        this.truckId = truckId;
        this.truckTonnage = truckTonnage;
        this.cargoWeight = cargoWeight;
        this.isLoadedTruck = isLoadedTruck;
        this.isFragile = isFragile;

        this.truckState = TruckState.NEW;

    }

    @Override
    public String call() {
        LogisticsBase logisticsBase = LogisticsBase.getBaseInstance();
        Terminal terminal = null;
        try {
            terminal = logisticsBase.acquireTerminal(isFragile);
            terminal.serveTruck(this);
            return String.format("Truck: %d Terminal: %d", this.getTruckId(), terminal.getTerminalId());

        } finally {
            logisticsBase.releaseTerminal(terminal);
        }
    }


    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public long getTruckId() {
        return truckId;
    }

    public void setTruckId(int truckId) {
        this.truckId = truckId;
    }

    public int getTruckTonnage() {
        return truckTonnage;
    }

    public void setTruckTonnage(int truckTonnage) {
        this.truckTonnage = truckTonnage;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public void setFragile(boolean fragile) {
        this.isFragile = fragile;
    }

    public TruckState getTruckState() {
        return truckState;
    }

    public void setTruckState(TruckState truckState) {
        this.truckState = truckState;
    }

    public boolean isLoadedTruck() {
        return isLoadedTruck;
    }

    public void setLoadedTruck(boolean loadedTruck) {
        this.isLoadedTruck = loadedTruck;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Truck truck = (Truck) o;

        if (truckId != truck.truckId) return false;
        if (isFragile != truck.isFragile) return false;
        if (isLoadedTruck != truck.isLoadedTruck) return false;
        return truckState == truck.truckState;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(truckId);
        result = 31 * result + (isFragile ? 1 : 0);
        result = 31 * result + (truckState != null ? truckState.hashCode() : 0);
        result = 31 * result + (isLoadedTruck ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Truck{truckId=").append(truckId).append(", truckTonnage=").append(truckTonnage)
                .append(", cargoWeight=").append(cargoWeight).append(", isLoadedTruck=").append(isLoadedTruck())
                .append(", isFragile=").append(isFragile).append(", truckState=").append(truckState).append('}');

        return sb.toString();
    }
}