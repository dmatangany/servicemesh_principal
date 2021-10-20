package be.g00glen00b.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import be.g00glen00b.dto.ProviderDTO;
import be.g00glen00b.entity.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Service
public class ProviderServiceImpl {
    public List<ProviderDTO> providerList = new ArrayList<>();;

    public ProviderServiceImpl(){
        if((providerList.isEmpty())||(providerList==null)){
            providerList = new ArrayList<>();
        }
    }

    public List<ProviderDTO> reset() {
        providerList.clear();
        return providerList;
    }

    public List<ProviderDTO> findAll() {
        return providerList;
    }

    public ProviderDTO create(ProviderDTO provider) {
        ProviderDTO newProvider = new ProviderDTO();
        if(provider.getDescription().toLowerCase().equals("consent")) {
            newProvider = new ProviderDTO();
            newProvider.setId(1L);
            provider.setId(1L);
            newProvider.setDescription("Debit-Order-1");
            provider.setDescription("Debit-Order-1");
            newProvider.setAccountName("Mike-Naledi-62355004400");
            provider.setAccountName("Mike-Naledi-62355004400");
            newProvider.setCompleted(provider.isCompleted());
            providerList.add(newProvider);
            newProvider = new ProviderDTO();
            newProvider.setId(2L);
            provider.setId(2L);
            newProvider.setDescription("Debit-Order-1");
            provider.setDescription("Debit-Order-1");
            newProvider.setAccountName("Mike-Naledi-62355004400");
            provider.setAccountName("Mike-Naledi-62355004400");
            newProvider.setCompleted(provider.isCompleted());
            providerList.add(newProvider);
        }else{
            Long newID = Long.valueOf((providerList.size()+1));
            String orderName = "Debit-Order-" + newID;
            newProvider = new ProviderDTO();
            newProvider.setId(newID);
            provider.setId(newID);
            newProvider.setDescription(provider.getDescription());
            provider.setDescription(provider.getDescription());
            newProvider.setAccountName("Mike-Naledi-62355004400");
            provider.setAccountName("Mike-Naledi-62355004400");
            newProvider.setCompleted(provider.isCompleted());
            providerList.add(provider);
        }
        return newProvider;
    }

    public ProviderDTO update(Long id, ProviderDTO provider) {
        ProviderDTO entity = findOneSafe(id);
        entity.setDescription(provider.getDescription());
        entity.setAccountName("Mike-Naledi-62355004400");
        entity.setCompleted(provider.isCompleted());
        return new ProviderDTO(entity.getId(), entity.getDescription(), entity.getAccountName(), entity.isCompleted());
    }

    public void updateLiveStatus(ProviderDTO providerDTO) {
        providerList.stream().filter(i -> i.getId().equals(providerDTO.getId())).findAny().orElseThrow(IllegalArgumentException::new)
                .setLiveStatus(providerDTO.getLiveStatus());
    }

    public void delete(Long id) {
        Predicate<ProviderDTO> predicate = e -> e.getId().equals(id);
        providerList.removeIf(predicate);
    }

    private ProviderDTO findOneSafe(Long id) {
        ProviderDTO providerDTO =providerList.stream().filter(provider -> provider.getId().equals(id)).findAny().orElse(null);
        if (providerDTO == null) {
            throw new ProviderNotFoundException();
        } else {
            return providerDTO;
        }
    }
}
