package ManagerInfrastructure;

public class Infras {
    private String name;
    private int count;
    private String importFirm;
    private String location;
    private String dateImport;
    private String insurance;

    public Infras(String name, int count, String importFirm, String location, String dateImport, String insurance) {
        this.name = name;
        this.count = count;
        this.importFirm = importFirm;
        this.location = location;
        this.dateImport = dateImport;
        this.insurance = insurance;
    }

    public Infras(String name, int count) {
        this.name = name;
        this.count = count;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getImportFirm() {
        return importFirm;
    }

    public void setImportFirm(String importFirm) {
        this.importFirm = importFirm;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateImport() {
        return dateImport;
    }

    public void setDateImport(String dateImport) {
        this.dateImport = dateImport;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }


}
