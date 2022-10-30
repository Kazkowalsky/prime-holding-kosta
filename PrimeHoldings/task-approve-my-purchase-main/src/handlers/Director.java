package handlers;

import common.Type;

/**
 * //TODO - If needed, validate logic and if possible optimize code.
 */
public class Director extends Approver {

    @Override
    public void approve(int id, int cost, Type type) {
        if (canApprove(id, cost, type)) {
            System.out.println("Director approved purchase with id " + id + " that costs " + cost);
            return;
        }

        System.out.println("Purchase with id " + id + " needs approval from higher position than Director.");
        next.approve(id, cost, type);
    }
    // CLEAN CODE
    @Override
    protected boolean canApprove(int id, int cost, Type type) {

        if (type == Type.CONSUMABLES && cost <= 500) return true;
        
        if (type == Type.CLERICAL && cost <= 1000) return true;
        
        if (type == Type.GADGETS && cost <= 1500) return true;
        
        if (type == Type.GAMING && cost <= 3500) return true;

        if (type == Type.PC && cost <= 6000) return true;

        return false;
    }
}
