package pl.kuglin.algorithm;

import pl.kuglin.datastructure.BinarySearchTree;

import java.util.Collections;
import java.util.List;

public class TreeSort<E extends BinarySearchTree.Node<T>, T extends Comparable<T>>{

    public void sort(E[] array) {
        BinarySearchTree<E, T> bst = new BinarySearchTree<>();
        for(E element:array)
            bst.insert(element);

        Object[] result =  bst.inOrderList().toArray();

        System.arraycopy(result, 0, (Object[])array, 0, array.length);
    }

    public void sort(List<E> list) {
        BinarySearchTree<E, T> bst = new BinarySearchTree<>();
        for(E element:list)
            bst.insert(element);

        Collections.copy(list, bst.inOrderList());
    }
}
