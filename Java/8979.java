import java.io.*;
import java.util.*;
class Country {
    int num;
    int gold;
    int silver;
    int bronze;
    public Country(int num, int gold, int silver, int bronze) {
        this.num = num;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }
}

public class Main {
    public static boolean isSame(Country c1, Country c2) {
        return c1.gold == c2.gold && c1.silver == c2.silver && c1.bronze == c2.bronze;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        Country[] arr = new Country[n];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            
            arr[i] = new Country(num, gold, silver, bronze);
        }
        
        Arrays.sort(arr, new Comparator<Country>() {
            public int compare(Country o1, Country o2) {
                if(o1.gold > o2.gold) {
                    return -1;
                }else if(o1.gold < o2.gold) {
                    return 1;
                }else {
                    if(o1.silver > o2.silver) {
                        return -1;
                    }else if(o1.silver < o2.silver) {
                        return 1;
                    }else {
                        if(o1.bronze > o2.bronze) {
                            return -1;
                        }else if(o1.bronze < o2.bronze) {
                            return 1;
                        }else {
                            return 0;
                        }
                    }
                }
            }
        });
        
        int answer = -1;
        for(int i = 0; i < n; i++) {
            if(arr[i].num == k) {
                answer = i;
                for(int j = i - 1; j >= 0; j--) {
                    if(isSame(arr[i], arr[j])) {
                        answer = j;
                    }else {
                        break;
                    }
                }
                bw.write(String.valueOf(answer + 1));
                bw.flush();
                return;
            }
        }
        
        bw.close();
        br.close();
    }
}
