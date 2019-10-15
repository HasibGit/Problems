import java.util.*;
public class Uva_350 {
    static class Node{
        int id;
        Node next;
        Node(int id){
            this.id = id;
            this.next = null;
        }
    }
    static Node cycleDetect(Node start){
        Node hare = start;
        Node tortoise = start;
        Node meetingPoint = null;
        while (hare.next != null && tortoise.next != null){
            hare = hare.next;
            hare = hare.next;
            tortoise = tortoise.next;

            if(hare.id == tortoise.id){
                meetingPoint = hare;
                return meetingPoint;
            }
        }
        return meetingPoint;
    }

    static Node findM(Node start,Node meetingPoint){
        Node tortoise = meetingPoint;
        Node tortoise2 = start;
        while (tortoise.id != tortoise2.id){
            tortoise = tortoise.next;
            tortoise2 = tortoise2.next;
        }
        return tortoise;
    }

    static int findLength(Node start){
        int count = 0;
        int id = start.id;
        while (true){
            start = start.next;
            count++;
            if(start.id == id){
                return count;
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cs = 1;
        while (true){
            int constant = input.nextInt();
            int increment = input.nextInt();
            int mod = input.nextInt();
            int seed = input.nextInt();
            if(constant == 0 && increment == 0 && mod == 0 && seed == 0)
                break;
            else{
                boolean[] created = new boolean[10000];
                Node start = new Node(seed);
                created[seed] = true;
                Node prev = null;
                int p = 0;
                int id = 0;
                Node cyclePoint = null;
                while (true){
                    if(p == 0){
                        id = ((constant * (int)start.id) + increment) % mod;
                    }
                    else{
                        id = ((constant * (int)prev.id) + increment) % mod;
                    }
                    Node a = new Node(id);
                   // System.out.println(a.id + " ");
                    if(created[a.id] == true){
                        //System.out.println(a.id);
                        cyclePoint = start;
                        while (cyclePoint.id != a.id){
                            cyclePoint = cyclePoint.next;
                        }
                        prev.next = cyclePoint;
                        break;
                    }
                    else if(p == 0){
                        created[start.id] = true;
                        start.next = a;
                        prev = a;
                    }
                    else{
                        prev.next = a;
                        prev = a;
                        created[a.id] = true;
                    }
                    p++;
                }
                int count = 0;
                int startId = cyclePoint.id;
                while (true){
                    cyclePoint = cyclePoint.next;
                    count++;
                    if(cyclePoint.id == startId)
                        break;
                }

//                Node meetingPoint = cycleDetect(start);
//                System.out.println(meetingPoint.id);
//                Node M = findM(start,meetingPoint);
//                int length = findLength(M);
                System.out.print("Case " + cs + ": ");
                System.out.println(count);
            }
            cs++;
        }
    }
}
