package CW.lessons_1.getAll;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GetAllPersonals getPersonals = new GetAllPersonals();
        List<Personnals> personnals =  getPersonals.getAllPersonals();

        for (Personnals allPersolals : personnals){
            if(allPersolals.getPosition_id() == 3 ){
                System.out.println(allPersolals);
            }
        }
    }
}
