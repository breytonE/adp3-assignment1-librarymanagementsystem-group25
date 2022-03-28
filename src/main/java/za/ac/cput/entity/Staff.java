package za.ac.cput.entity;

public class Staff {
    private long staffMember_ID;
    private String firstName;
    private String lastName;
    private String homeAddress;
    private long cellPhone;

    public Staff(Builder b) {
        this.staffMember_ID = b.staffMember_ID;
        this.firstName = b.firstName;
        this.lastName = b.lastName;
        this.homeAddress = b.homeAddress;
        this.cellPhone = b.cellPhone;
    }


    public long getStaffMember_ID() {
        return staffMember_ID;
    }

    public void setStaffMember_ID(long staffMember_ID) {
        this.staffMember_ID = staffMember_ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public long getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(long cellPhone) {
        this.cellPhone = cellPhone;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffMember_ID=" + staffMember_ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", cellPhone=" + cellPhone +
                '}';
    }


    public static class Builder{
        private long staffMember_ID;
        private String firstName;
        private String lastName;
        private String homeAddress;
        private long cellPhone;

        public Builder setStaffMember_ID(long staffMember_ID) {
            this.staffMember_ID = staffMember_ID;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setHomeAddress(String homeAddress) {
            this.homeAddress = homeAddress;
            return this;
        }

        public Builder setCellPhone(long cellPhone) {
            this.cellPhone = cellPhone;
            return this;
        }

        public Builder copy(Staff s){
            this.staffMember_ID = s.staffMember_ID;
            this.firstName = s.firstName;
            this.lastName = s.lastName;
            this.homeAddress = s.homeAddress;
            this.cellPhone = s.cellPhone;
            return this;
        }

        public Staff build(){
            return new Staff(this);
        }

    }


}