package sample;

public class Personnel {
    private String name;
    private int personnelCode;
    private String password;

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getPersonnelCode() {
        return personnelCode;
    }

    public Personnel(String n, int pc , String ps){
        name = n;
        personnelCode = pc;
        password = ps;

    }



}
