package uk.gov.justice.digital.legaladviser.domain;

/**
 * +
 * POJO domain object representing legal adviser
 */
public class LegalAdviser {
    private final int id;
    private final String name;
    private final String address1;
    private final String city;
    private final String postCode;
    private final String phone;
    private final String orgType;
    private final boolean catCrime;
    private final boolean catDebt;
    private final boolean catHousing;
    private final boolean catImmigrationOrAsylum;
    private final boolean catWelfareBenefits;

    public LegalAdviser(int id, String name, String address1, String city, String postCode, String phone, String orgType,
                        boolean catCrime, boolean catDebt, boolean catHousing, boolean catImmigrationOrAsylum, boolean catWelfareBenefits) {
        this.id = id;
        this.name = name;
        this.address1 = address1;
        this.city = city;
        this.postCode = postCode;
        this.phone = phone;
        this.orgType = orgType;
        this.catCrime = catCrime;
        this.catDebt = catDebt;
        this.catHousing = catHousing;
        this.catImmigrationOrAsylum = catImmigrationOrAsylum;
        this.catWelfareBenefits = catWelfareBenefits;
    }

    @Override
    public String toString() {
        return "LegalProvider{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address1='" + address1 + '\'' +
                ", city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                ", phone='" + phone + '\'' +
                ", orgType='" + orgType + '\'' +
                ", catCrime=" + catCrime +
                ", catDebt=" + catDebt +
                ", catHousing=" + catHousing +
                ", catImmigrationOrAsylum=" + catImmigrationOrAsylum +
                ", catWelfareBenefits=" + catWelfareBenefits +
                '}';
    }

    /***
     * Note that some of the unused getters are needed for Spring
     * @return ID
     */
    public int getId() {
        return id;
    }

    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public String getAddress1() {
        return address1;
    }

    @SuppressWarnings("unused")
    public String getCity() {
        return city;
    }

    @SuppressWarnings("unused")
    public String getPostCode() {
        return postCode;
    }

    @SuppressWarnings("unused")
    public String getPhone() {
        return phone;
    }

    @SuppressWarnings("unused")
    public String getOrgType() {
        return orgType;
    }

    /**
     *
     * @return crime advisor ?
     */
    public boolean isCatCrime() {
        return catCrime;
    }
    /**
     *
     * @return debt advisor ?
     */
    public boolean isCatDebt() {
        return catDebt;
    }

    /**
     *
     * @return Housing advisor ?
     */
    public boolean isCatHousing() {
        return catHousing;
    }

    /**
     *
     * @return ImmigrationOrAsylum advisor ?
     */
    public boolean isCatImmigrationOrAsylum() {
        return catImmigrationOrAsylum;
    }

    /**
     *
     * @return Welfare advisor ?
     */

    public boolean isCatWelfareBenefits() {
        return catWelfareBenefits;
    }
}


