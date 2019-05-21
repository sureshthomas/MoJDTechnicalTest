package uk.gov.justice.digital.legaladviser.persistence;

import uk.gov.justice.digital.legaladviser.domain.LegalAdviser;

import java.util.List;

/**
 * +
 * Abstract default class for reader, this can be implemented for a db reader , say from Mongo DB. This is for file only
 */
interface DataReader {
    default List<LegalAdviser> Read() {
        return null;
    }
}
