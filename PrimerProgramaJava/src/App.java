public class App {

    static final double PI = 3.14;

    public static void main(String[] args) {
        String unTexto = "Hola mundo!!!";
        int unNum;
        unNum = 23;
        int otroNum = 56;

        // unNum = unNum + 4;
        unNum += 4;

        otroNum = unNum * 3;
        ++otroNum;
        --otroNum;

        unTexto = "¡¡¡" + unTexto;

        boolean isOk = true;
        boolean noOk = (3 == 5);


        System.out.println("unTexto: " + unTexto);
        System.out.println("unNum: " + unNum);
        System.out.println("otroNum: " + otroNum);
        System.out.println("PI: " + PI);
        System.out.println("isOk: " + isOk);
        System.out.println("noOk: " + noOk);
        System.out.println("isOK AND noOk: " + (isOk && noOk));
        System.out.println("isOK OR noOk: " + (isOk || noOk));
        System.out.println("NO isOK: " + (!isOk));
    }

}
