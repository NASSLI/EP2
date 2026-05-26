# EP2 - beurteilte Übung zu AB3.2

### Allgemeine Hinweise

* Die Lösung Ihrer Aufgabe muss im vorgegebenen Projekt und damit in den vorhandenen Dateien erfolgen.
* Sie dürfen zur Lösung dieser Aufgabe *nicht* auf das Java Collections Framework zurückgreifen.
* Verändern Sie weder die vorgegebenen Methodensignaturen noch die Signaturen der Konstruktoren.
* Alle Objektvariablen und etwaige von Ihnen zusätzlich erstellte Methoden oder Konstruktoren
  in vorgegebenen Klassen müssen `private` sein. Ausgenommen sind Methoden, die durch ein Interface gefordert sind,
  überschriebene öffentliche Methoden sowie die in dieser Aufgabenstellung ausdrücklich geforderten öffentlichen Methoden.
* Definieren Sie keine geschachtelten oder (anonymen) inneren Klassen.

## Information zur Domäne

Die Klasse [PhysicalPhysicalTreeMap.java](../src/PhysicalPhysicalTreeMap.java) aus `AB3.2`
soll einen zusätzlichen Iterator erhalten, der nur die Schlüssel von Knoten auf Ebene 2 des Baums liefert.
Die Wurzel befindet sich auf Ebene 0, ihre Kindknoten befinden sich auf Ebene 1, deren Kindknoten auf Ebene 2.

Die Traversierungsreihenfolge soll der bestehenden Baumiteration entsprechen.

Beispiel:

```text
          A          Ebene 0
        /   \
       B     C       Ebene 1
      / \   / \
     D   E F   G     Ebene 2
        /
       H             Ebene 3

levelTwoIterator:
D, E, F, G
```

Dazu bekommt die Klasse eine zusätzliche Methode `levelTwoIterator()`.
Die bisherige Methode `iterator()` soll nicht verändert werden.

## Zu bearbeitende Dateien

Die für diesen Test zu bearbeitenden Dateien sind:

* [PhysicalPhysicalTreeMap.java](../src/PhysicalPhysicalTreeMap.java)
* [PhysicalPhysicalTreeMapNode.java](../src/PhysicalPhysicalTreeMapNode.java)
* [PhysicalPhysicalTreeMapLevelTwoIterableNode.java](../src/PhysicalPhysicalTreeMapLevelTwoIterableNode.java)

Die Klasse [ApplicationUE3.java](../src/ApplicationUE3.java) kann zum Testen Ihrer Implementierung verwendet werden.

## Aufgabenstellung

1. Fügen Sie der Klasse [PhysicalPhysicalTreeMapNode](../src/PhysicalPhysicalTreeMapNode.java) folgende Getter-Methoden
   hinzu und implementieren Sie diese:

```java
/**
 * Returns the left child subtree of this node.
 *
 * <p>The returned subtree may be {@code null} if no left child exists.</p>
 *
 * @return the left child subtree, or {@code null}
 */
public PhysicalPhysicalTreeMapNode getLeft() {

    //TODO: implement method.
    return null;
}

/**
 * Returns the right child subtree of this node.
 *
 * <p>The returned subtree may be {@code null} if no right child exists.</p>
 *
 * @return the right child subtree, or {@code null}
 */
public PhysicalPhysicalTreeMapNode getRight() {

    //TODO: implement method.
    return null;
}

/**
 * Returns the key stored in this node.
 *
 * <p>If this node represents an empty subtree,
 * {@code null} is returned.</p>
 *
 * @return the stored key, or {@code null} if this node is empty
 */
public Physical getKey() {

    //TODO: implement method.
    return null;
}

/**
 * Returns the value associated with the key stored in this node.
 *
 * <p>If this node represents an empty subtree,
 * {@code null} is returned.</p>
 *
 * @return the associated value, or {@code null} if this node is empty
 */
public Physical getValue() {

    //TODO: implement method.
    return null;
}
```

2. Vervollständigen Sie die Klasse [PhysicalPhysicalTreeMapLevelTwoIterableNode.java](../src/PhysicalPhysicalTreeMapLevelTwoIterableNode.java)
   gemäß der Spezifikation. Jedes Objekt dieser Klasse „verpackt“ genau einen `PhysicalPhysicalTreeMapNode` (die Klasse
   ist eine Wrapper-Klasse für einen Baumknoten), speichert zusätzlich die Ebene dieses Knotens und bietet eine angepasste
   Version der Methode `iter` an. Die Klasse implementiert `PhysicalIterableTreeNode`.

3. Implementieren Sie eine neue Methode `levelTwoIterator()` in der Klasse
   [PhysicalPhysicalTreeMap.java](../src/PhysicalPhysicalTreeMap.java) gemäß folgender Spezifikation:

```java
/**
 * Returns an iterator over all keys stored in nodes at level 2 of this map.
 *
 * <p>The root node is considered to be at level 0. Children of the root
 * are at level 1, and their children are at level 2.</p>
 *
 * <p>The iterator traverses the underlying binary search tree in the same
 * order as the regular iterator of this map (obtained by {@code iterator()}).</p>
 *
 * <p>Only keys stored in nodes at level 2 are returned. Nodes at other
 * levels are traversed in order to continue the traversal, but their keys
 * are skipped.</p>
 *
 * <p>The returned iterator does not create an independent copy of all keys.
 * The traversal state is stored explicitly in the iterator.</p>
 *
 * <p>If this map contains no nodes at level 2, the returned iterator has
 * no elements.</p>
 *
 * @return an iterator over all keys stored in nodes at level 2
 */
public PhysicalIterator levelTwoIterator();
```

Die Implementierung darf keine zusätzliche Datenstruktur zur
Vorab-Speicherung aller Schlüssel verwenden. Der Iterator soll den Baum mithilfe
der neuen Klasse `PhysicalPhysicalTreeMapLevelTwoIterableNode` traversieren.