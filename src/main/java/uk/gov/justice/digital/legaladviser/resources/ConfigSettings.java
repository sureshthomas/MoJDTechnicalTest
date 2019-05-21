package uk.gov.justice.digital.legaladviser.resources;

/**
 * +
 * This is a utility class just to store default
 */
public class ConfigSettings {
    //This is a default value used only when it is not supplied as an argument
    private static String dbFile = "legal-providers.csv";

    public static String getDbFile() {
        return dbFile;
    }

    public static void setDbFile(String dbFile) {
        ConfigSettings.dbFile = dbFile;
    }

    public static final String crime = "crime";
    public static final String debt = "debt";
    public static final String housing = "housing";
    public static final String immigrationorasylum = "immigrationorasylum";
    public static final String welfarebenefits = "welfarebenefits";

    public static final String homePage = "" +
            "<html><body><h3>" +
            "Usage Examples</h3>" +
            "<h4>Find by ID\n</h4>" +
            "<a href=http://localhost:8080/legaladviser/1>legaladviser/1</a>\n" +
            "<h3>Find all \n</h3>" +
            "<a href=http://localhost:8080/legaladvisers>/legaladvisers</a>\n" +
            "<h3>Filer based on condition\n</h3>" +
            "<h4>Method 1, each wih categories spec\n</h4>" +
            "<br>1. <a href=http://localhost:8080/legaladvisers?categories=CriMe&categories=Debt>legaladvisers?categories=CriMe&categories=Debt</a>\n" +
            "<h4>Method 2, coma delimited\n</h4>" +
            "2. <a href=http://localhost:8080/legaladvisers?categories=CriMe,Debt>Filer-1</a><br>" +
            "3. <a href=http://localhost:8080/legaladvisers?categories=crime,debt,immigrationorasylum>Filer-2</a></br>" +
            "4. <a href=http://localhost:8080/legaladvisers?categories=crime,debt,housing,immigrationorasylum>Filer-3</a></br>" +
            "5. <a href=http://localhost:8080/legaladvisers?categories=crime,debt,housing,immigrationorasylum,welfarebenefits>Filer-4</a></br>";

}


