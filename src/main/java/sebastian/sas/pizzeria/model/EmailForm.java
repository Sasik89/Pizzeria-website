package sebastian.sas.pizzeria.model;

public class EmailForm {
    private String recipientEmail;
    private String message;

    public EmailForm() {
        // Pusty konstruktor potrzebny dla obsługi formularzy przez Spring
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}