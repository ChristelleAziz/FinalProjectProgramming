package org.christelle;

import lombok.*;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId;

    /**
     * takes a department name and checks if it is valid or not
     * @param departmentName the input department name
     * @return if it is valid or nod
     */
    public static boolean validateDepartmentName(String departmentName) {
        for (char c : departmentName.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }

        return true;
    }

    public Department(String departmentId, String departmentName) {
        if (validateDepartmentName(departmentName)) {
            this.departmentId = "D" + departmentId;
            this.departmentName = departmentName;
        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }
}
