import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class Pizza {

    private PizzaStatus status;
    public enum PizzaStatus {
        ORDERED (5){
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY (2){
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED (0){
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        public boolean isOrdered() {return false;}

        public boolean isReady() {return false;}

        public boolean isDelivered(){return false;}

        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        PizzaStatus (int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }
    }

    public boolean isDeliverable() {
        return this.status.isReady();
    }

    public void printTimeToDeliver() {
        System.out.println("Time to delivery is " +
                this.getStatus().getTimeToDelivery());
    }

    private PizzaStatus getStatus() {
        return status;
    }

    // Methods that set and get the status variable.

    @Test
    public void givenPizaOrder_whenReady_thenDeliverable() {
        Pizza testPz = new Pizza();
        testPz.setStatus(Pizza.PizzaStatus.READY);
        System.out.println("===>" + testPz.isDeliverable());
        System.out.println(testPz.isDeliverable());
//        assertTrue(testPz.isDeliverable());
    }

    private void setStatus(PizzaStatus ready) {
        this.status = ready;
    }
}
