package org.christelle;

import lombok.*;
import org.christelle.util.Util;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId = 1;

    /**
     * takes a department name and checks if it is valid or not
     * @param departmentName the input department name
     * @return if the department name is valid or not
     */
    public static boolean validateDepartmentName(String departmentName) {
        for (char c : departmentName.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }

        return true;
    }

    public Department(String departmentName) {
        if (validateDepartmentName(departmentName)) {
            this.departmentId = "D" + String.format("%02d", nextId++);
            this.departmentName = Util.toTitleCase(departmentName);
        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }
}
