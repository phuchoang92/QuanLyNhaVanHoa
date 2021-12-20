package EventSystem;

public class Event {

    private int fee;
    private String name;
    private String hostName;
    private String startTime;
    private String endTime;
    private String dayStart;
    private String datEnd;
    private String phoneNumber;
    private String gender;

    public Event(String name,String hostName, String startTime, String endTime, String dayStart, String datEnd, String phoneNumber) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayStart = dayStart;
        this.datEnd = datEnd;
        this.phoneNumber = phoneNumber;
        this.hostName = hostName;
    }

    public Event(String name,String hostName, String startTime, String endTime, String dayStart, String datEnd, String phoneNumber, String gender) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayStart = dayStart;
        this.datEnd = datEnd;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.hostName = hostName;
    }

    public Event(String name, String hostName, String startTime, String endTime, int fee) {
        this.name = name;
        this.hostName = hostName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.fee = fee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getDatEnd() {
        return datEnd;
    }

    public void setDatEnd(String datEnd) {
        this.datEnd = datEnd;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



}
