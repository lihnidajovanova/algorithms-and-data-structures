package laboratory_exercise_7_hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MapEntry<K extends Comparable<K>, E> implements Comparable<K> {

    K key;
    E value;

    public MapEntry(K key, E val) {
        this.key = key;
        this.value = val;
    }

    public int compareTo(K that) {
        @SuppressWarnings("unchecked")
        MapEntry<K, E> other = (MapEntry<K, E>) that;
        return this.key.compareTo(other.key);
    }

    public String toString() {
        return "<" + key + "," + value + ">";
    }
}

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class CBHT<K extends Comparable<K>, E> {
    private SLLNode<MapEntry<K, E>>[] buckets;

    @SuppressWarnings("unchecked")
    public CBHT(int m) {
        buckets = (SLLNode<MapEntry<K, E>>[]) new SLLNode[m];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public SLLNode<MapEntry<K, E>> search(K targetKey) {
        int b = hash(targetKey);
        for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
                return curr;
        }
        return null;
    }

    public void insert(K key, E val) {
        MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
        int b = hash(key);
        for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
                curr.element = newEntry;
                return;
            }
        }
        buckets[b] = new SLLNode<MapEntry<K, E>>(newEntry, buckets[b]);
    }

    public void delete(K key) {
        int b = hash(key);
        for (SLLNode<MapEntry<K, E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
                if (pred == null)
                    buckets[b] = curr.succ;
                else
                    pred.succ = curr.succ;
                return;
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            for (SLLNode<MapEntry<K, E>> curr = buckets[i]; curr != null; curr = curr.succ) {
                temp += curr.element.toString() + " ";
            }
            temp += "\n";
        }
        return temp;
    }
}

public class RoutingHashJava {
    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            int numRouters = Integer.parseInt(bf.readLine());

            CBHT<String, String[]> routingTable = new CBHT<>(20);

            // Populate the routing table
            for (int i = 0; i < numRouters; i++) {
                String routerIP = bf.readLine();
                String[] networkAddresses = bf.readLine().split(",");
                routingTable.insert(routerIP, networkAddresses);
            }

            int numAttempts = Integer.parseInt(bf.readLine());

            // Perform routing attempts
            for (int i = 0; i < numAttempts; i++) {
                String targetRouter = bf.readLine();

                // Check if the router exists in the routing table
                SLLNode<MapEntry<String, String[]>> routerEntry = routingTable.search(targetRouter);
                if (routerEntry == null) {
                    System.out.println("ne postoi");
                    bf.readLine();
                    continue;
                }

                String targetAddress = bf.readLine();
                boolean found = false;

                // Check if the target address exists in the router's network addresses
                for (String networkAddress : routerEntry.element.value) {
                    String[] splitRouterAddress = networkAddress.split("\\.");
                    String[] splitTargetAddress = targetAddress.split("\\.");

                    if (splitRouterAddress[0].equals(splitTargetAddress[0]) &&
                            splitRouterAddress[1].equals(splitTargetAddress[1]) &&
                            splitRouterAddress[2].equals(splitTargetAddress[2])) {
                        found = true;
                        System.out.println("postoi");
                        break;
                    }
                }

                if (!found) {
                    System.out.println("ne postoi");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}