package uk.gov.justice.digital.legaladviser.persistence;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.justice.digital.legaladviser.domain.LegalAdviser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/***
 * This class load the file resource legal providers
 */
public class FileDataReader implements DataReader {

    private static final Logger logger = LoggerFactory.getLogger(FileDataReader.class);
    //Only CSV files are supported now
    private final String fileName;

    FileDataReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<LegalAdviser> Read() {

        InputStream stream = getClass().getClassLoader().getResourceAsStream(fileName);
        assert stream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        Pattern pattern = Pattern.compile(",");
        try (BufferedReader in = new BufferedReader(reader)) {
            //Skip header line
            return in.lines().skip(1).map(line -> {
                String[] columns = pattern.split(line.replace("\"", ""));
                return new LegalAdviser(Integer.parseInt(columns[0]), columns[1], columns[2], columns[3], columns[4], columns[5],
                        columns[6], columns[7].equals("1"), columns[8].equals("1"), columns[9].equals("1"), columns[10].equals("1"), columns[11].equals("1")
                );
            }).collect(Collectors.toList());
            // processing code here
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}


