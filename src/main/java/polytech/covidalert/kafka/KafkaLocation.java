package polytech.covidalert.kafka;

public class KafkaLocation {
    private String userEmail;
    private float longitude;
    private float latitude;

    public KafkaLocation(String userEmail, float longitude, float latitude) {
        this.userEmail = userEmail;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }
}
