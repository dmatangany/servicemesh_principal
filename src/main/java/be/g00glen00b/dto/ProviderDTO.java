package be.g00glen00b.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProviderDTO {
    private Long id;
    @NotNull(message = "NotNull.providerDTO.description")
    @Size(min = 1, max = 64, message = "Size.providerDTO.description")
    private String description;
    private String accountName;
    private String liveStatus;
    private boolean completed;

    public ProviderDTO() {
    }

    public ProviderDTO(Long id, String description, String accountName, boolean completed) {
        this.id = id;
        this.description = description;
        this.accountName = accountName;
        this.completed = completed;
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

    public String getLiveStatus() {
        return liveStatus;
    }
    public void setLiveStatus(String value) {
        this.liveStatus = value;
    }

    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
