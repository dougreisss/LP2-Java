/**
 * @author Douglas Reis e Lucas Aquino
 */

public class TestStaff {
    public static void main(String[] args) {
        Staff classStaff = new Staff("Douglas", "Avenida Brasilia", "IFSP", 0);

        System.out.println(classStaff.toString());

        classStaff.setSchool("Cubatao");
        classStaff.setPay(1000);

        System.out.println(classStaff.toString());
        System.out.println(classStaff.getSchool());

    }
}
