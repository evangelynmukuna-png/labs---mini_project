public class PersonDemo {
    public static void main(String[] args) {
        Person p1 = new Person("Evangelyn", new Address("712 Rockands", "Macheke"));
        System.out.println(p1.name + " lives in " + p1.address.city);

        Person p2 = new Person("Faith", null);
        try{
            System.out.println(p2.address.city);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: address is null");
        }
    }
}
