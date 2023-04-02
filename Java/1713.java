import java.io.*;
import java.util.*;
class Student {
    int idx; // 번호
    int cnt; // 추천수
    int time; // 추천받은 순서
    boolean isPosted; // 게시되었는지
    public Student(int idx, int cnt, int time, boolean isPosted) {
        this.idx = idx;
        this.cnt = cnt;
        this.time = time;
        this.isPosted = isPosted;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        List<Student> list = new ArrayList<>();
        Student[] student = new Student[101];
        for(int i = 0; i < t; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            // 추천받은 학생
            if(student[num] == null) {
                student[num] = new Student(num, 0, 0, false);
            }
            
            // 게시된적 있는지
            if(student[num].isPosted) {
                student[num].cnt++;
            }else {
                if(list.size() == n) {
                    // 추천수가 적은순 -> 추천수가 같으면, 오래된 순으로 정렬
                    Collections.sort(list, new Comparator<Student>() {
                        public int compare(Student o1, Student o2) {
                            if(o1.cnt == o2.cnt) {
                                return o1.time - o2.time;
                            }
                            return o1.cnt - o2.cnt;
                        }
                    });
                    list.get(0).isPosted = false;
                    list.remove(0);
                }
                student[num].cnt = 1;
                student[num].time = i;
                student[num].isPosted = true;
                list.add(student[num]);
            }
        }
        
        // 번호순으로 정렬
        Collections.sort(list, (o1, o2) -> o1.idx - o2.idx);
        for(int i = 0; i < list.size(); i++) {
            bw.write(String.valueOf(list.get(i).idx) + " ");
            bw.flush();
        }
        
        bw.close();
        br.close();
    }
}
