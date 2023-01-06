package org.example.entry;


public class Dept {
    private int id;
    private String dpetName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDpetName() {
        return dpetName;
    }

    public void setDpetName(String dpetName) {
        this.dpetName = dpetName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", dpetName='" + dpetName + '\'' +
                '}';
    }
}
