import java.util.Random;

class Person {

    public String FirstName;
    public String LastName;
    public String FatherName;
    public int YearsOld;
    public String Gender;
    public String DateOfBirth;
    public String City;
    public int Index = new Random().nextInt(900000) + 100000;
    public String Country;
    public String Region = Constants.DISTRICTS[new Random().nextInt(Constants.DISTRICTS.length)];
    public String Street;
    public int Apartment = new Random().nextInt(300);
    public int ApartmentNumber = new Random().nextInt(300);

    public String[] GetStringArray(){
        return new String[] {LastName, FirstName, FatherName,
                String.valueOf(YearsOld), ChangeGenderOutput(Gender), DateOfBirth,
                ChangeCityOutput(City), String.valueOf(Index), Country, Region,
                ChangeCityOutput(City), ChangeStreetOutput(Street),
                String.valueOf(Apartment), String.valueOf(ApartmentNumber)};
    }

    private String ChangeGenderOutput(String gender){
        if (gender.equals("Мужчина")){
            return "МУЖ";
        }
        else{
            return "ЖЕН";
        }
    }

    private String ChangeCityOutput(String city){
        return city.replace("г. ", "");
    }

    private String ChangeStreetOutput(String region){
        return region.replaceAll("( ул.| пер.|ул.)", "");
    }
}