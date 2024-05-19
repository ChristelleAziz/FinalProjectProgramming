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
        if (postalCode == null || postalCode.length() != 6 && postalCode.length() != 7) {
            return false;
        }

        postalCode = postalCode.toLowerCase();

        if (postalCode.length() == 6) {
            for (int i = 0; i < postalCode.length(); i++) {
                char c = postalCode.charAt(i);
                if (i % 2 == 0 && !Character.isLetter(c)) {
                    return false;
                } else if (i % 2 != 0 && !Character.isDigit(c)) {
                    return false;
                }
            }

            return true;
        } else if (postalCode.length() == 7) {
            for (int i = 0; i < postalCode.length(); i++) {
                char c = postalCode.charAt(i);
                if (i == 3 && c != ' ') {
                    return false;
                } else if (i % 2 == 0 && !Character.isLetter(c)) {
                    return false;
                } else if (i % 2 != 0 && !Character.isDigit(c)) {
                    return false;
                }
            }

            return true;
        }

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
