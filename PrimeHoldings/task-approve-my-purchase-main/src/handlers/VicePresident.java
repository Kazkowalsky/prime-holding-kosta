package handlers;

import common.Type;

/**
 * //TODO - Implement approval implementation for VicePresident level
 */
public class VicePresident extends Approver {
    @Override
    public void approve(int id, int cost, Type type) {
        if (canApprove(id, cost, type)) {
            System.out.println("Vice President approved purchase with id " + id + " that costs " + cost);
            return;
        }

        System.out.println("Purchase with id " + id + " needs approval from higher position than Vice President.");
        next.approve(id, cost, type);
    }

    @Override
    protected boolean canApprove(int id, int cost, Type type) {

        if (type == Type.CONSUMABLES && cost <= 700) return true;

        if (type == Type.CLERICAL && cost <= 1500) return true;

        if (type == Type.GADGETS && cost <= 2000) return true;

        if (type == Type.GAMING && cost <= 4500) return true;

        if (type == Type.PC && cost <= 6500) return true;

        return false;
    }
}
