/**
 * Created by tpusers on 2016/12/28.
 */

public class EnumTest {
    public static void main(String[] args){

        TrafficLight tl = TrafficLight.Green;
        Peason p = new Peason();

        System.out.println(tl.name());
        System.out.println();
        System.out.println(tl.name());
    }


    public enum TrafficLight{
        Red(1),Yellow(2),Green(3);

        private TrafficLight(int value){
            this.value = value;
       }
        private int value;
    }












}