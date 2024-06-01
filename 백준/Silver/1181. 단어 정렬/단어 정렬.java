import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[])throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<String> strs = new ArrayList<>();
        String str;
        for (int i = 0; i<n; i++){
            str = br.readLine();
            strs.add(str);
        }


        Comparator<String> bylength = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int c =Integer.compare(s1.length(), s2.length());
                if(c == 0){
                    return s1.compareTo(s2);
                }

                return c;
            }
        };

        Collections.sort(strs, bylength);

        Set<String> set = new LinkedHashSet<>(strs);
        for (String s : set){
            bw.write(s+"\n");
        }

        bw.flush();
        bw.close();
//        System.out.println(strs);

    }
}
