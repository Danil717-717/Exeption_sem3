// Напишите метод, на вход которого подаётся двумерный строковый массив
// размером 4х4. При подаче массива другого размера необходимо бросить
// исключение MyArraySizeException.
// Далее метод должен пройтись по всем элементам массива, преобразовать
// в int и просуммировать. Если в каком-то элементе массива преобразование
// не удалось (например, в ячейке лежит символ или текст вместо числа),
// должно быть брошено исключение MyArrayDataException с детализацией,
// в какой именно ячейке лежат неверные данные.
// В методе main() вызвать полученный метод, обработать возможные исключения
// MyArraySizeException и MyArrayDataException и вывести результат расчета
// (сумму элементов, при условии что подали на вход корректный массив).

public class Ex_03 {


    public static void main(String[] args){
        String [][] array = {
                {"1","2","3","7"},
                {"2","3","3","5"},
                {"3","4","3","6"},
                {"0","5","6","8"}};

        try {
            checkSizeOfArray(array);
            System.out.printf("%d - сумма всех элементов массива", summElem(array));
        }catch (MyArraySizeException | MyArrayDataException e){
            System.out.println(e.getMessage());
        }
    }

    public static int summElem(String[][] array) throws MyArrayDataException{
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try{
                    result += Integer.parseInt(array[i][j]);
                }catch (Exception e){
                    throw new MyArrayDataException(i,j);
                }
            }
        }
        return result;
    }

    public static void checkSizeOfArray (String[][] array) throws MyArraySizeException{
        if(array.length == 4){
            for (int i = 0; i < array.length; i++) {
                if(array[i].length != 4){
                    throw new MyArraySizeException();
                }
            }
            System.out.println("Размер правильный");
        }else {
            throw new MyArraySizeException();
        }
    }
}
