package model;

public class Product {

    private int code;
    private String name;
    private boolean hidden;

    public Product(int code, String name, boolean hidden) {
        this.code = code;
        this.name = name;
        this.hidden = hidden;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
