public class CantGoThatWayException extends RuntimeException{
    public CantGoThatWayException(String error){
        super(error);
    }
}


//Program can Throw an exception when it detects an error.

//throw new CantGoThatWayException("wrong way");

//Program can catch exceptions to prevent program from crashing using try-catch block.
/* 
try{
    code that may trigger an exception
} 
catch(CantGoThatWayException ex){
    code that deals with the exception
}
*/