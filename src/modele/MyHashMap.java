package modele;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//JAVADOC A FAIRE

public class MyHashMap<K, V> extends HashMap<K, V> {

    /**
     * Numéro de serial Version.
     */
    private static final long serialVersionUID = 3195739454305712213L;

    public MyHashMap() {
        super();

    }

    public Object getFirstKey() {

        Iterator<Map.Entry<K, V>> iterator = this.entrySet().iterator();

        if (iterator.hasNext()) {
            Map.Entry<K, V> mapEntry = iterator.next();
            return mapEntry.getKey();
        } else {
            System.out.println("Plus de clef dans la map");
            return null;
        }

    }

    public int getSize() {
        Iterator<Map.Entry<K, V>> iterator = this.entrySet().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Map.Entry<K, V> mapEntry = iterator.next();
            i++;
        }
        return i;

    }

}
