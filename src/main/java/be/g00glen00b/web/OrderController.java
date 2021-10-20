package be.g00glen00b.web;

import java.util.List;
import java.util.Locale;
import javax.validation.Valid;
import be.g00glen00b.dto.MessageDTO;
import be.g00glen00b.dto.OrderDTO;
import be.g00glen00b.dto.ProviderDTO;
import be.g00glen00b.service.ProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private ProviderServiceImpl service;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public List<ProviderDTO> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/reset",method = RequestMethod.GET)
    public List<ProviderDTO> Reset() {
        return service.reset();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ProviderDTO create(@Valid @RequestBody ProviderDTO dto) {
        return service.create(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ProviderDTO update(@PathVariable Long id, @Valid @RequestBody ProviderDTO dto) {
        return service.update(id, dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public MessageDTO handleValidationException(MethodArgumentNotValidException ex) {
        Locale locale = LocaleContextHolder.getLocale();
        String code = ex.getBindingResult().getFieldError().getDefaultMessage();
        return new MessageDTO(messageSource.getMessage(code, null, locale));
    }
}