import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        try (FileReader reader = new FileReader("src/input.txt")){
            String str = new String();
            ArrayList<String> fruits = new ArrayList<>();
            HashMap<String,Integer> fruitsCounter = new HashMap<>();
            int i = reader.read();
            str = str + (char)i;
            while (i != -1){
                i = reader.read();
                if ((char)i != ' '){
                    str = str + (char)i;
                }
                else{
                    if (str.length() != 0){
                        fruits.add(str.toLowerCase());
                        str = "";
                    }
                }
            }
            reader.close();
            int len = 0;
            String fruitLongestWord = "";
            for (String fruit: fruits){
                if (fruit.length() > len){
                    len = fruit.length();
                    fruitLongestWord = fruit;
                }
            }
            for (String fruit:fruits){
                fruitsCounter.put(fruit,0);
            }
            for (String fruit:fruits){
                Integer count = fruitsCounter.get(fruit);
                count++;
                fruitsCounter.put(fruit, count);
            }
            System.out.println("Сколько всего фруктов");
            System.out.println(fruits.size());
            System.out.println("Самое длинное название продукта:");
            System.out.println(fruitLongestWord);
            System.out.println("Сколько упоминаний конкретного продукта:");
            System.out.println(fruitsCounter);

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
