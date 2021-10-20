package be.g00glen00b.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import be.g00glen00b.dto.OrderDTO;
import be.g00glen00b.dto.ProviderDTO;
import be.g00glen00b.service.ProviderServiceImpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlertServiceImpl {
    public ProviderDTO alertProvider;
    @Autowired
    private ProviderServiceImpl service;

    public AlertServiceImpl(){
        alertProvider = new ProviderDTO();
    }

    public void setAlertInstance(ProviderDTO providerDTO) {
        alertProvider = providerDTO;
    }

    public ProviderDTO getAlertInstance() {
        return alertProvider;
    }

    public ProviderDTO setProviderStatus(ProviderDTO providerDTO) {
        System.out.println("recieved: " + providerDTO.getId() + "|" + providerDTO.getDescription() + "|" + providerDTO.getAccountName() + "|" + providerDTO.getLiveStatus());
        //alertProvider.setLiveStatus(providerDTO);
        return providerDTO;
    }
}
