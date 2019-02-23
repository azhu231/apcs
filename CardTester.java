public class CardTester
{
    public static void main(String[] args) {
        Card hello = new Card("5", 5);
        System.out.println(hello);
        hello.setFaceUp(true);
        System.out.println(hello);
        
        Card bye = new Card("10", 10);
        System.out.println(bye);
        bye.setFaceUp(true);
        System.out.println(bye);
        System.out.println(bye.getSymbol() + " " + bye.getValue());
        
        Card same = new Card("K", 5);
        if (!hello.equals(bye)){
            System.out.println(hello.compareTo(bye));
        }
        
        
    }
}
