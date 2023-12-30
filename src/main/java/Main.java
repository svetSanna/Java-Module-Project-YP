import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float price;

        System.out.println("На сколько человек необходимо разделить счет?");
        int number = getIntInput();

        Calculator calculator = new Calculator(number);

        do{
            System.out.println("Введите название товара:");
            String name = scanner.next();
            System.out.println("Введите стоимость товара:");
            //??? не понятно, нужно ли просить водить именно в формате xx.xx,
            // и если да, то как это сделать?
            while(true){
                if(!scanner.hasNextFloat()){
                    System.out.println("Ошибка: Необходимо ввести стоимость товара в формате 'рубли,копейки' или 'рубли':");
                    scanner.next();
                }
                else {
                    price = scanner.nextFloat();
                    if (price < 0)
                        System.out.println("Ошибка: стоимость должна быть >=0!");
                    else break;
                }
            }
            calculator.AddProducts(name, price);

            System.out.println("Вы можете продолжить ввод товаров или завершить. Для завершения введите \"Завершить\":");
            if(scanner.next().equalsIgnoreCase("Завершить")) {
                System.out.println("Добавленные товары:\n" + calculator.products);
                double sum = calculator.sumPrice/calculator.numPerson;
                System.out.printf("Каждый человек должен заплатить " + "%.2f %s.%n", sum, GetYearStr(sum));
                break;
            }
        } while(true);
        scanner.close();
    }

    // получить от пользователя целое число >1
    private static int getIntInput(){
        Scanner scanner = new Scanner(System.in);
        int result;

        while(true){
            if(!scanner.hasNextInt()) {
                System.out.println("Ошибка: необходимо ввести целое число!");
                scanner.next();
            }
            else {
                result = scanner.nextInt();
                if (result<=1)
                    System.out.println("Ошибка: число должно быть >1!");
                else
                    // ??? почему возникает ошибка, если я здесь добавлю scanner.close()?
                    return result;
            }
        }
    }
    private static String GetYearStr(double sum)
    {
        int s = (int)Math.floor(sum);
        s = s%10;

        if (s==1)
            return "рубль";
        else if ((s>1)&&(s<5)){
            return "рубля";
        }
        else return "рублей";

    }
}