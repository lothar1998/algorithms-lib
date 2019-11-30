package pl.kuglin.datastructure;

import java.util.List;

public interface Tree<E, T> {
    void insert(E node);
    void delete(E node);
    E search(T nodeId);
    E minTree();
    E maxTree();
    E nextNode(E node);
    E previousNode(E node);
    List<E> inOrderList();
}
