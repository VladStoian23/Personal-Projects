package domain;

public class Weather {
    int starting_hours;
    int end_hours;
    int temperature;
    int precipitation_probability;
    String description;

    public Weather(int starting_hours, int end_hours, int temperature, int precipitation_probability, String description) {
        this.starting_hours = starting_hours;
        this.end_hours = end_hours;
        this.temperature = temperature;
        this.precipitation_probability = precipitation_probability;
        this.description = description;
    }

    public int getStarting_hours() {
        return starting_hours;
    }

    public void setStarting_hours(int starting_hours) {
        this.starting_hours = starting_hours;
    }

    public int getEnd_hours() {
        return end_hours;
    }

    public void setEnd_hours(int end_hours) {
        this.end_hours = end_hours;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getPrecipitation_probability() {
        return precipitation_probability;
    }

    public void setPrecipitation_probability(int precipitation_probability) {
        this.precipitation_probability = precipitation_probability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{" +
                "starting_hours=" + starting_hours +
                ", end_hours=" + end_hours +
                ", temperature=" + temperature +
                ", precipitation_probability=" + precipitation_probability +
                ", description='" + description + '\'' +
                '}';
    }
}
