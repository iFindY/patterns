package main.java.de.arkadi.creational.builder.one;

public class LunchOrder {

    private String bread;
    private String condiments;
    private String dressing;
    private String meat;

    public static class Builder {
        private String bread;
        private String condiments = "Penguin";
        private String dressing;
        private String meat;

        public Builder() {
        }

        public LunchOrder build() {
            LunchOrder lunch = new LunchOrder();
            lunch.setBread(bread);
            lunch.setCondiments(condiments);
            lunch.setDressing(dressing);
            lunch.setMeat(meat);
            return lunch;
        }

        public Builder bread(String bread) {
            this.bread = bread;
            return this;
        }

        public Builder condiments(String condiments) {
            this.condiments = condiments;
            return this;
        }

        public Builder dressing(String dressing) {
            this.dressing = dressing;
            return this;
        }

        public Builder meat(String meat) {
            this.meat = meat;
            return this;
        }

    }

    public static Builder configure() {
        return new Builder();
    }

    public LunchOrder() {
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public void setCondiments(String condiments) {
        this.condiments = condiments;
    }

    public void setDressing(String dressing) {
        this.dressing = dressing;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public String getBread() {
        return bread;
    }

    public String getCondiments() {
        return condiments;
    }

    public String getDressing() {
        return dressing;
    }

    public String getMeat() {
        return meat;
    }
}
