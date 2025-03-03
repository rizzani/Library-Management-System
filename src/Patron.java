//import java.util.Random;
//
//public class Patron {
//    private String name;
//    private String cardNumber;
//    private LinkedList books;
//    private String password;
//
//    public Patron(String name, String cardNumber, String password) {
//        this.name = name;
//        this.cardNumber = cardNumber;
//        this.books = null;
//        this.password = generatePassword();
//    }
//
//
//
//
//    public static String generatePassword() {
//        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//        Random random = new Random();
//        StringBuilder password = new StringBuilder(8);
//
//        for (int i = 0; i < 8; i++) {
//            int index = random.nextInt(characters.length());
//            password.append(characters.charAt(index));
//        }
//
//        return password.toString();
//    }
//}
