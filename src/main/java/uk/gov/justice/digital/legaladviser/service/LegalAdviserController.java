package uk.gov.justice.digital.legaladviser.service;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.justice.digital.legaladviser.domain.LegalAdviser;
import uk.gov.justice.digital.legaladviser.persistence.LegalAdviserPersistenceService;

import java.util.List;

import static uk.gov.justice.digital.legaladviser.resources.ConfigSettings.homePage;

/**
 * +
 * The service is injected by Spring - autowiring
 * #TODO Paging is to be implemented , but not done due to time limits.
 */
@RestController
public class LegalAdviserController {
    private final LegalAdviserPersistenceService service;

    public LegalAdviserController(LegalAdviserPersistenceService service) {
        this.service = service;
    }

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String help() {
        return homePage;
    }

    @GetMapping(path = "/legaladviser/{id}", produces = "application/uk.gov.justice.digital.legaladviser.service-v1+json")
    public LegalAdviser getProvider(@PathVariable int id) {

        return service.findById(id);
    }

    @GetMapping(path = "/legaladvisers", produces = "application/uk.gov.justice.digital.legaladviser.service-v1+json")
    public List<LegalAdviser> getLegalAdvisersByCategory(@RequestParam(required = false) String[] categories) {

        return service.findByCategories(categories);
    }


}