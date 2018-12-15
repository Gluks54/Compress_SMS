import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Paginator {

    private  final int SMS_LENGHT;

    Paginator(int lenght){
        SMS_LENGHT = lenght;
    }
    public String[] paginate(String text){

        int endIndex = SMS_LENGHT;
        int startIndex = 0;

        String substring;
        List<String> stringList = new ArrayList<>();
        int numberOfIteration = text.length()/SMS_LENGHT + 1;
        for(int i = 0; i < numberOfIteration; i++){

            substring = text.substring(startIndex,endIndex);
            stringList.add(substring);
            startIndex = endIndex;

            endIndex += SMS_LENGHT;

            if(endIndex > text.length()){
               endIndex = text.length();
               if(endIndex == startIndex){
                   break;
               }
            }
        }
        String [] rezult = stringList
                .stream()
                .toArray(String []:: new);
        return rezult;
    }
}
