package EventSystem;

public class Event {
    private String name;
    private String hostName;
    private String startTime;
    private String endTime;
    private int fee;

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


}
