import java.util.Arrays;
import java.util.Random;

public class Dynamic {

        public static void main(String[] args){
            DynamicArray<Integer> DA = new DynamicArray<Integer>();

            Random ran = new Random();
            int num = ran.nextInt(20);
            for (int i = 0 ; i < 10; i++ ){
                DA.add(num);
            }
System.out.println(DA.toString());
            DA.removeAt(4);

            for (int i = 0 ; i < DA.size() ; i++ ){
                System.out.println(DA.get(i));
            }
        //    System.out.println(DA.toString());
        }

}
