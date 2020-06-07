package db;

import com.hannesdorfmann.sqlbrite.objectmapper.annotation.Column;
import com.hannesdorfmann.sqlbrite.objectmapper.annotation.ObjectMappable;

@ObjectMappable
public class Profile {


        public static final String TABLE_NAME = "Profile";
        public static final String COL_ID = "id";
        public static final String COL_NAME = "name";
        public static final String COL_MOBILENO = "mobileno";
        public static final String COL_GENDER = "gender";


        public Profile(int id, String name, String mobileNo, boolean gender) {
                this.id = id;
                this.name = name;
                this.mobileNo = mobileNo;
                this.gender = gender;
        }

        @Column(COL_ID)
        int id;

        @Column(COL_NAME)
        String name;

        @Column(COL_MOBILENO)
        String mobileNo;

        @Column(COL_GENDER)
        boolean gender;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getMobileNo() {
                return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
                this.mobileNo = mobileNo;
        }

        public boolean isGender() {
                return gender;
        }

        public void setGender(boolean gender) {
                this.gender = gender;
        }
}