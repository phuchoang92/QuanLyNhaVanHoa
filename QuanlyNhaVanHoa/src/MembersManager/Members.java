package MembersManager;

public class Members {
    private String name;
    private String job;
    private int day, month, year;
    private String phoneNumber;

    public Members(String name, String job, int day, int month, int year, String phoneNumber) {
        this.name = name;
        this.job = job;
        this.day = day;
        this.month = month;
        this.year = year;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String dateOfBirth(){
        return String.valueOf(day)+"/"+String.valueOf(month)+"/"+String.valueOf(year);
    }
}
