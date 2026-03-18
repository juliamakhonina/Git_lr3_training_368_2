package Model.units;

import Model.gamefield.Cell;
import Model.timer.MyTimer;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public abstract class Mine extends Unit{
    protected MyTimer _mineTimer;

    private List<MineListener> _listeners = new ArrayList();

    protected long period;

    protected Mine(long period, MyTimer timer) {
        this.period = period;
        _mineTimer = timer;
        startTimer();
    }

    private void startTimer() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                applyEffect();
                explode();
            }
        };

        _mineTimer.schedule(task, period);
    }
    protected boolean canBelongTo(Cell owner) {
        if (owner == null) return false;

        return true;
    }

    protected void explode() {
        fireMineExploded(this.owner());
        _listeners.clear();
        _owner.extractUnit(this);
        _owner = null;


    }

    protected abstract void applyEffect();

    public void addMineListener(MineListener el) { _listeners.add(el); }

    public void removeMineListener(MineListener el) { _listeners.remove(el); }

    private void fireMineExploded(Cell owner){
        MineEvent e = new MineEvent(this);
        for (MineListener listener : _listeners) {
            listener.mineExploded(e);
        }
    }
}
