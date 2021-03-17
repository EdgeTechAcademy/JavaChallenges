public class Shoe {
    private float size;
    private String material;
    private String brand;
    private boolean slipOn;

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isSlipOn() {
        return slipOn;
    }

    public void setSlipOn(boolean slipOn) {
        this.slipOn = slipOn;
    }

    @Override
    public String toString() {
        return "Shoe{" +
                "size=" + size +
                ", material='" + material + '\'' +
                ", brand='" + brand + '\'' +
                ", slipOn=" + slipOn +
                '}';
    }

    public Shoe() {
    }

    public Shoe(float size, String material, String brand, boolean slipOn) {
        this.size = size;
        this.material = material;
        this.brand = brand;
        this.slipOn = slipOn;
    }
}
