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
        //TODO : to be implemented
        return false;
    }

    public Department(String departmentId, String departmentName) {
        if (validateDepartmentName(departmentName)) {
            this.departmentId = departmentId;
            this.departmentName = departmentName;
        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }
}
