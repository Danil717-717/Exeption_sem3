public class MyArrayDataException extends RuntimeException{

    public MyArrayDataException (int x, int y){
        super("Неправильные данные на позиции: x = " + x + "; y = "+ y);
    }
}
