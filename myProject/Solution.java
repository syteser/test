import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        switch (args[0]) {
//        -bd - дата рождения в следующем формате 15/04/1990
//        -с - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
//        -c name1 sex1 bd1 name2 sex2 bd2 ...
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; ) {
                        String name = args[i++];
                        String sex = args[i++];
                        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(args[i++]);
                        addToList(name, sex, date);
                    }
                    break;
                }
//        -u - обновляет соответствующие данные людей с заданными id
//        -u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; ) {
                        String id = args[i++];
                        String name= args[i++];
                        String sex = args[i++];
                        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(args[i++]);
                        updateList(id, name, sex, date);
                    }
                    break;
                }
//        -d - производит логическое удаление человека с id, заменяет все его данные на null
//        -d id1 id2 id3 id4 ...
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        deleteFromList(Integer.parseInt(args[i]));
                    }
                    break;
                }
//        -i - выводит на экран информацию о всех людях с заданными id: name sex bd
//        -i id1 id2 id3 id4 ...
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        infoFromList(Integer.parseInt(args[i]));
                    }
                    break;
                }
        }
    }

    private static void updateList(String id, String name, String sex, Date date){
        Person person = null;
        if(sex.equals("м")) {
            person = Person.createMale(name, date);
        }
        else if(sex.equals("ж")) {
            person = Person.createFemale(name, date);
        }
        allPeople.set(Integer.parseInt(id), person);
    }

    private static void addToList(String name, String sex, Date date) {
        if (sex.equals("м")) {
            allPeople.add(Person.createMale(name, date));
        }
        if (sex.equals("ж")) {
            allPeople.add(Person.createFemale(name, date));
        }
        System.out.println(allPeople.size() - 1);
    }

    private static void infoFromList(int i) throws ParseException {
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String sex="";
        if (allPeople.size() > i) {
            if(allPeople.get(i).getSex().equals(Sex.MALE)) sex = "м";
            if(allPeople.get(i).getSex().equals(Sex.FEMALE)) sex = "ж";
            String data = dateFormat2.format(allPeople.get(i).getBirthDate());
            System.out.printf("%s %s %s\n", allPeople.get(i).getName(), sex, data);
        }
    }

    private static void deleteFromList(int i) {
        Person nullPerson = Person.createMale(null, null);
        nullPerson.setSex(null);
        System.out.println(i);
        if (allPeople.size() > i) {
            allPeople.set(i, nullPerson);
        }
    }

}
