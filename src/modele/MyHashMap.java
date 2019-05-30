package modele;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//JAVADOC A FAIRE

public class MyHashMap<K, V> extends HashMap<K, V> {

    public MyHashMap() {
        super();

    }

    public Object getFirstKey() {

        Iterator<Entry<K, V>> iterator = this.entrySet().iterator();

        if (iterator.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) iterator.next();
            return mapEntry.getKey();
        } else {
            System.out.println("Plus de clef dans la map");
            return null;
        }

    }

    public int getSize() {
        Iterator<Entry<K, V>> iterator = this.entrySet().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) iterator.next();
            i++;
        }
        return i;

    }

}
