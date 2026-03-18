//package Model.unit;

public abstract class Unit {

    protected boolean active = true;



    public boolean isActive() {
        return active;
    }

    public void activate() {
        active = true;
    }

    public void deactivate() {
        active = false;
    }

    protected abstract boolean canBelongTo(Cell owner);



}
