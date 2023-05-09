import java.io.*;
import java.util.*;
class Member implements Comparable<Member> {
    int age;
    String name;
    int join;
    Member(int age, String name, int join) {
        this.age = age;
        this.name = name;
        this.join = join;
    }
    public int compareTo(Member m) {
        if(this.age == m.age) {
            return this.join - m.join;
        }
        return this.age - m.age;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        ArrayList<Member> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Member(age, name, i + 1));
        }
        
        Collections.sort(list);
        
        for(int i = 0; i < list.size(); i++) {
            Member mb = list.get(i);
            bw.append(String.valueOf(mb.age) + " " + mb.name + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
