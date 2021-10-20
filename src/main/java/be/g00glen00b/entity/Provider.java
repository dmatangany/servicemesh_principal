package be.g00glen00b.entity;

public class Provider {
    private Long id;
    private String description;
    private String accountName;
    private boolean completed;

    public Provider(Long id, String description, boolean completed) {
        this.id = id;
        this.description = description;
        this.completed = completed;
    }

    public Provider() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String value) {
        this.accountName = value;
    }

    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
