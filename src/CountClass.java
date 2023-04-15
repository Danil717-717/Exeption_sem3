// Создайте класс Счетчик, у которого есть метод add(),
// увеличивающий значение внутренней int переменной на 1.
// Сделайте так, чтобы с объектом такого типа можно было
// работать в блоке try-with-resources. Подумайте, что должно происходить
// при закрытии этого ресурса? Напишите метод для проверки, закрыт ли ресурс.
// При попытке вызвать add() у закрытого ресурса, должен выброситься IOException


import java.io.IOException;

public class CountClass implements AutoCloseable{

    private int iterator;

    public int add(){
        return this.iterator++;
    }

    @Override
    public void close() throws Exception{
        this.iterator = 0;
    }

    public static void main(String[] args) {

        try(CountClass countClass = new CountClass()){
            countClass.add();

        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e ){
            throw new RuntimeException(e);
        }
    }

}
