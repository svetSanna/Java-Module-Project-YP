public class Calculator {
    // строка с  названиями продуктов
    String products;
    // количество человек
    int numPerson;
    // общая стоимость товаров
    float sumPrice;
    // Конструктор
    Calculator(int numPerson){
        this.numPerson = numPerson;
        products = "";
        sumPrice = 0;
    }
    // добавить продукт, product - название товара, price  - цена
    void AddProducts(String product, float price)
    {
        products += (product + '\n');
        sumPrice += price;
    }
}
