public class Event extends Task{
    protected String time;

    public Event(String description, String time) {
        super(description);
        this.time = time;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (" + time + ")";
    }

    @Override
    public String writeToFile() {
        return "E|" + status + "|" + description + "|" + this.time;
    }
}
