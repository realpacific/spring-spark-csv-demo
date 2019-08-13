package com.realpacific.springsparkcsvdemo.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.Objects;

/**
 * DataList
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-08-12T15:16:14.802+05:45[Asia/Kathmandu]")

public class DataList {
    @JsonProperty("reference")
    private Integer reference;

    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("applicant")
    private ApplicantEnum applicant;
    @JsonProperty("beneficiary")
    private BeneficiaryEnum beneficiary;
    @JsonProperty("serviceType")
    private ServiceTypeEnum serviceType;
    @JsonProperty("dueDate")
    private String dueDate;
    @JsonProperty("paidDate")
    private String paidDate;
    @JsonProperty("currency")
    private CurrencyEnum currency;
    @JsonProperty("country")
    private CountryEnum country;

    public DataList reference(Integer reference) {
        this.reference = reference;
        return this;
    }

    @Min(0)
    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public DataList amount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public DataList applicant(ApplicantEnum applicant) {
        this.applicant = applicant;
        return this;
    }

    public ApplicantEnum getApplicant() {
        return applicant;
    }

    public void setApplicant(ApplicantEnum applicant) {
        this.applicant = applicant;
    }

    public DataList beneficiary(BeneficiaryEnum beneficiary) {
        this.beneficiary = beneficiary;
        return this;
    }

    public BeneficiaryEnum getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(BeneficiaryEnum beneficiary) {
        this.beneficiary = beneficiary;
    }

    public DataList serviceType(ServiceTypeEnum serviceType) {
        this.serviceType = serviceType;
        return this;
    }

    public ServiceTypeEnum getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceTypeEnum serviceType) {
        this.serviceType = serviceType;
    }

    public DataList dueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    @Pattern(regexp = "\\d{4}-\\d{1,2}-\\d{1,2}")
    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public DataList paidDate(String paidDate) {
        this.paidDate = paidDate;
        return this;
    }

    @Pattern(regexp = "\\d{4}-\\d{1,2}-\\d{1,2}")
    public String getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(String paidDate) {
        this.paidDate = paidDate;
    }

    public DataList currency(CurrencyEnum currency) {
        this.currency = currency;
        return this;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }

    public DataList country(CountryEnum country) {
        this.country = country;
        return this;
    }

    public CountryEnum getCountry() {
        return country;
    }

    public void setCountry(CountryEnum country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DataList dataList = (DataList) o;
        return Objects.equals(this.reference, dataList.reference) &&
                Objects.equals(this.amount, dataList.amount) &&
                Objects.equals(this.applicant, dataList.applicant) &&
                Objects.equals(this.beneficiary, dataList.beneficiary) &&
                Objects.equals(this.serviceType, dataList.serviceType) &&
                Objects.equals(this.dueDate, dataList.dueDate) &&
                Objects.equals(this.paidDate, dataList.paidDate) &&
                Objects.equals(this.currency, dataList.currency) &&
                Objects.equals(this.country, dataList.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference, amount, applicant, beneficiary, serviceType, dueDate, paidDate, currency, country);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataList {\n");

        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    applicant: ").append(toIndentedString(applicant)).append("\n");
        sb.append("    beneficiary: ").append(toIndentedString(beneficiary)).append("\n");
        sb.append("    serviceType: ").append(toIndentedString(serviceType)).append("\n");
        sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
        sb.append("    paidDate: ").append(toIndentedString(paidDate)).append("\n");
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    /**
     * Gets or Sets applicant
     */
    public enum ApplicantEnum {
        PROGRESSOFT("Progressoft"),

        CLUSUS("Clusus"),

        CG("CG"),

        MICROSOFT("Microsoft"),

        APPLE("Apple"),

        AMAZON("Amazon"),

        GOOGLE("Google"),

        LG("LG"),

        SAMSUNG("Samsung"),

        MOTOROLLA("Motorolla");

        private String value;

        ApplicantEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static ApplicantEnum fromValue(String value) {
            for (ApplicantEnum b : ApplicantEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }
    }


    /**
     * Gets or Sets beneficiary
     */
    public enum BeneficiaryEnum {
        NCIT("NCIT"),

        NEC("NEC"),

        TU("TU"),

        PU("PU"),

        NOKIA("Nokia"),

        GNOME("Gnome"),

        DEBIAN("Debian"),

        FEDORA("Fedora"),

        LINUX("Linux"),

        UBUNTU("Ubuntu");

        private String value;

        BeneficiaryEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static BeneficiaryEnum fromValue(String value) {
            for (BeneficiaryEnum b : BeneficiaryEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }
    }

    /**
     * Gets or Sets serviceType
     */
    public enum ServiceTypeEnum {
        INCOMING("incoming"),

        OUTGOING("outgoing"),

        IMPORTER("importer"),

        EXPORTER("exporter");

        private String value;

        ServiceTypeEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static ServiceTypeEnum fromValue(String value) {
            for (ServiceTypeEnum b : ServiceTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }
    }

    /**
     * Gets or Sets currency
     */
    public enum CurrencyEnum {
        NPR("NPR"),

        JOD("JOD"),

        USD("USD"),

        INR("INR"),

        AUD("AUD");

        private String value;

        CurrencyEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static CurrencyEnum fromValue(String value) {
            for (CurrencyEnum b : CurrencyEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }
    }

    /**
     * Gets or Sets country
     */
    public enum CountryEnum {
        NEPAL("Nepal"),

        JORDAN("Jordan"),

        USA("USA"),

        INDIA("India"),

        AUSTRALIA("Australia");

        private String value;

        CountryEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static CountryEnum fromValue(String value) {
            for (CountryEnum b : CountryEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }
    }
}

