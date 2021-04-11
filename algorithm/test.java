import java.util.*;
public class test{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()) {
            ArrayList<String> list = new ArrayList();
            String[] mess = scan.nextLine().split(" ");
            for (int i = 0; i < mess.length; i++) {
                list.add(mess[i]);
            }
            list.sort(new Comparator<String>(){
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            for (int i = 0; i < list.size() - 1; i++) {
                System.out.print(list.get(i));
                System.out.print(" ");
            }
            System.out.println(list.get(list.size() - 1));
        }
    }
}