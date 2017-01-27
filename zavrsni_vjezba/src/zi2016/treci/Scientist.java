package zi2016.treci;

import java.time.LocalDate;

public class Scientist {

    private String name;
    private String surname;
    private long mbz;
    private LocalDate birth;

    public Scientist(String name, String surname, long mbz, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.name = name;
        this.surname = surname;
        this.mbz = mbz;
        this.birth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public long getMbz() {
        return mbz;
    }

    public LocalDate getBirth() {
        return birth;
    }
}