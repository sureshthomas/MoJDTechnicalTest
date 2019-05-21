package uk.gov.justice.digital.legaladviser.persistence;

import org.springframework.stereotype.Component;
import uk.gov.justice.digital.legaladviser.domain.LegalAdviser;
import uk.gov.justice.digital.legaladviser.exception.LegalAdviserNotFoundException;
import uk.gov.justice.digital.legaladviser.resources.ConfigSettings;
import java.util.List;
import java.util.stream.Collectors;

/***
 * This is the service implementation class
 */
@Component
public class LegalAdviserPersistenceService {
    private static  List<LegalAdviser> legalAdvisers;
    static {
        DataReader fileReader = new FileDataReader(ConfigSettings.getDbFile());
            legalAdvisers = fileReader.Read();
    }

    /**
     * Get all advisors
     * @return all legal advisors
     */
    private List<LegalAdviser> findAll() {
        return legalAdvisers;
    }

    /***
     * Get by UD
     * @param id is the ID of the advisor
     * @return an advisor
     */
    public LegalAdviser findById(int id) {
        for (LegalAdviser provider : legalAdvisers) {
            if (provider.getId() == id) {
                return provider;
            }
        }
        throw new LegalAdviserNotFoundException("id= "+id);
    }

    /** +
     * #TODO The switch statement is an anti pattern, this can be replaced with reflection. Oh ! This is a one hour exercise, so its a compramise
     * @param searchString This is the search string such as categories = [crime,debt,immigrationorasylum,....]
     * @return filtered list of advisors
     */
    public List<LegalAdviser> findByCategories(String[] searchString) {
        /*
        searchString is optional - if it is null means no filter , return everything
        This will also work for invalid category
        */
        if (searchString == null) return findAll();
        if (searchString.length > 0) {

            List<LegalAdviser> filteredList = legalAdvisers;

            for (String category : searchString) {
                switch (category.toLowerCase()) {
                    case ConfigSettings.crime:
                        filteredList = filteredList.stream()
                                .filter(LegalAdviser::isCatCrime)
                                .collect(Collectors.toList());

                        break;
                    case ConfigSettings.debt:
                        filteredList = filteredList.stream()
                                .filter(LegalAdviser::isCatDebt)
                                .collect(Collectors.toList());
                        break;
                    case ConfigSettings.housing:
                        filteredList = filteredList.stream()
                                .filter(LegalAdviser::isCatHousing)
                                .collect(Collectors.toList());
                        break;
                    case ConfigSettings.immigrationorasylum:
                        filteredList = filteredList.stream()
                                .filter(LegalAdviser::isCatImmigrationOrAsylum)
                                .collect(Collectors.toList());
                        break;
                    case ConfigSettings.welfarebenefits:
                        filteredList = filteredList.stream()
                                .filter(LegalAdviser::isCatWelfareBenefits)
                                .collect(Collectors.toList());
                        break;
                    default:
                        break;

                }
            }
            if(filteredList.isEmpty()) throw new LegalAdviserNotFoundException("No agency matching the criteria");
            return filteredList;
        }
        return findAll();
    }
}
