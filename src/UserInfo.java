public class UserInfo {

    private String name;
    private int age;
    private String email;
    private boolean isActive;

    public UserInfo (String name, int age, String email, boolean isActive){
        this.name = name;
        this.age = age;
        this.email = email;
        this.isActive = isActive;
    }

    public String getName(){return name;}
    public void setName(String n){name = n;}

    public int getAge (){return age;}
    public void setAge (int a){age = a;}

    public String email () {return email;}
    public void setEmail(String e){email = e;}

    public boolean getIsActive(){return isActive;}
    public void setIsActive(boolean a){isActive = a;}

    public void displayInfo() {
        System.out.println("User Info:");
        System.out.println("  Name:    " + name);
        System.out.println("  Age:     " + age);
        System.out.println("  Email:   " + email);
        System.out.println("  Active?  " + (isActive ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        UserInfo u1 = new UserInfo("Abdu", 30, "Abdu@example.com", true);
        UserInfo u2 = new UserInfo("Badr",   22, "Badr@domain.com",     false);
        UserInfo u3 = new UserInfo("Elia",   41, "elia@site.org",       true);

        u1.displayInfo();
        u2.displayInfo();
        u3.displayInfo();

        // Test setters/getters:
        u2.setIsActive(true);
        System.out.println("Badr is now active? " + u2.isActive);
    }
}
