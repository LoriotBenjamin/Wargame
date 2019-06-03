package modele;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Classe héritant de HashMap , ajoute en fonctionnalité
 * la possibilité de retourner le premier élément de la
 * HashMap et de connaitre sa taille.
 * @author Loriot Benjamin
 *
 * @param <K> Clef de la HashMap.
 * @param <V> Valeur de la HashMap.
 */

public class MyHashMap<K, V> extends HashMap<K, V> {

    /**
     * Numéro de serial Version.
     */
    private static final long serialVersionUID = 3195739454305712213L;

    /**
     * Constructeur MyHashMap.
     */
    public MyHashMap() {
        super();

    }
/**
 * Retourne le premier couple de clef/valeur.
 * @return le premier couple clef/valeur.
 */
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
/**
 * Retourne la taille de la HashMap.
 * @return la taille de la HashMap.
 */
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
