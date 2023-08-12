/**
 * @author Douglas Reis e Lucas Aquino
 */

public class TestPerson {
    public static void main(String[] args) {
        Person classPerson = new Person("Douglas", "Av Ana Costa");

        System.out.println(classPerson.toString());
        System.out.println(classPerson.getName());
        classPerson.setAddress("Rua Maria");
        System.out.println(classPerson.getAddress());

    }
}