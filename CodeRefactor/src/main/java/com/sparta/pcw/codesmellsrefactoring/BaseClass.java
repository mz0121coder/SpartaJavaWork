package com.sparta.pcw.codesmellsrefactoring;

// Class to represent a Person
public class BaseClass
{
    private final String fn;
    private final String lastName;
    private int age;
    private String hobbies;
    private int houseNo = 0;
    private String street = "";
    private String town = "";

    public BaseClass(String fName, String lName)
    {
        this.fn = fName;
        this.lastName = lName;
    }

    public BaseClass(String fName, String lName, int hNo, String street, String town) {
        this(fName, lName);
        this.houseNo = hNo;
        this.street = street;
        this.town = town;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }

    public String getFullName() {
        return fn + " " + lastName;
    }

    public String move() {
        return "Walking along";
  //      System.out.println("Can't get here");
    }

    @Override
    public  String toString() {
        var addressString = "Address: " + houseNo + " " + street + ", "  + town;

        if (addressString.equals("Address: 0 , ")) {
            addressString = "Address: <no address set>";
        }

        return String.format("%s Name: %s  %s Age: %s. %s",
                             super.toString(),
                             fn,
                             lastName,
                             age,
                             addressString);
}

//    public int stupidMethod()
//    {
//        return 3;
//    }
}