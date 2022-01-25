package dto;

public class ConversionDTO {
    private int amount;
    private String from;
    private String to;

    public ConversionDTO(int amount, String from, String to) {
        this.amount = amount;
        this.from = from;
        this.to = to;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
