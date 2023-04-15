public class NullArrayIndexException extends IndexOutOfBoundsException{

    public NullArrayIndexException(){
        super("Элемент массива null");
    }

    public NullArrayIndexException(String s){
        super(s);
    }
}
