package org.christelle;

import lombok.*;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Address {
    private int streetNo;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;

    /**
     * Takes a postal code and checks if it is valid or not
     * @param postalCode the input postal code
     * @return if it is valid or not
     */
    public static boolean isPostalCodeValid(String postalCode) {
        //TODO : to be implemented
        return false;
    }

    public Address(int streetNo, String street, String city, String province, String postalCode, String country) {
        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode.toUpperCase();
            this.country = country;
        } else {
            this.streetNo = -1;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
            this.country = null;
        }
    }
}
