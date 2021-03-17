public class RunningShoe extends Shoe {

    private String endorsedBy;

    public String getEndorsedBy() {
        return endorsedBy;
    }

    @Override
    public String toString() {
        return "RunningShoe{" +
                "endorsedBy='" + endorsedBy + '\'' +
                "} " + super.toString();
    }

    public void setEndorsedBy(String endorsedBy) {
        this.endorsedBy = endorsedBy;
    }

    public RunningShoe(float size, String brand, String endorsedBy) {
        super(size, "Leather", brand, false);
        this.endorsedBy = endorsedBy;
    }
}
