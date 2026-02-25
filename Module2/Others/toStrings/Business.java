package Module2.Others.toStrings;

public class Business {
    protected String name;
    protected String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name + " -- " + address;
    }

    public boolean equals(Business obj) {
        return this.name.equals(obj.name) && this.address.equals(obj.address);
    }
}
