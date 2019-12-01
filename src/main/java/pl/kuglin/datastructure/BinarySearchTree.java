package pl.kuglin.datastructure;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class BinarySearchTree<E extends BinarySearchTree.Node<T>, T extends Comparable<T>> implements Tree<E, T> {

    protected E root;

    public abstract static class Node<S extends Comparable<S>> {
        protected Node<S> parent;
        protected Node<S> left;
        protected Node<S> right;
        protected S id;

        public Node(S id) {
            this.id = id;
        }

        public S getId() {
            return id;
        }

        public void setId(S id) {
            this.id = id;
        }

        Node<S> getParent() {
            return parent;
        }

        void setParent(Node<S> parent) {
            this.parent = parent;
        }

        Node<S> getLeft() {
            return left;
        }

        void setLeft(Node<S> left) {
            this.left = left;
        }

        Node<S> getRight() {
            return right;
        }

        void setRight(Node<S> right) {
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(parent, node.parent) &&
                    Objects.equals(left, node.left) &&
                    Objects.equals(right, node.right) &&
                    id.equals(node.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(parent, left, right, id);
        }

        @Override
        public String toString() {
            return "Node{" + "id=" + id +'}';
        }
    }

    public void insert(E node){
        E parentNode = null;
        E tempNode = root;

        while (tempNode != null){
            parentNode = tempNode;
            if(node.getId().compareTo(tempNode.getId()) < 0)
                tempNode = (E)tempNode.getLeft();
            else
                tempNode = (E)tempNode.getRight();
        }

        node.setParent(parentNode);

        if(parentNode == null)
            root = node;
        else if(node.getId().compareTo(parentNode.getId()) < 0)
            parentNode.setLeft(node);
        else
            parentNode.setRight(node);
    }

    public void delete(E node){
        if (node.getLeft() == null)
            transplant(node, (E)node.getRight());
        else if(node.getRight() == null)
            transplant(node, (E)node.getLeft());
        else {
            E minimumNode = minNode((E)node.getRight());
            if (!(minimumNode.getParent() == node)){
                transplant(minimumNode, (E)minimumNode.getRight());
                minimumNode.setRight(node.getRight());
                minimumNode.getRight().setParent(minimumNode);
            }
            transplant(node, minimumNode);
            minimumNode.setLeft(node.getLeft());
            minimumNode.getLeft().setParent(minimumNode);
        }
    }

    public E search(T nodeId){
        E x = root;
        while (x != null && nodeId != x.getId()) {
            if (nodeId.compareTo(x.getId()) < 0)
                x = (E)x.getLeft();
            else
                x = (E)x.getRight();
        }
        return x;
    }

    public E minTree(){
        return minNode(root);
    }

    public E maxTree(){
        return maxNode(root);
    }

    public E nextNode(E node){
        if(node.getRight() != null)
            return minNode((E)node.getRight());

        E parentNode = (E)node.getParent();
        E sonNode = node;

        while (parentNode != null && sonNode == parentNode.getRight()){
            sonNode = parentNode;
            parentNode = (E)parentNode.getParent();
        }

        return parentNode;
    }

    public E previousNode(E node){
        if(node.getLeft() != null)
            return maxNode((E)node.getLeft());

        E parentNode = (E)node.getParent();
        E sonNode = node;

        while (parentNode != null && sonNode == parentNode.getLeft()){
            sonNode = parentNode;
            parentNode = (E)parentNode.getParent();
        }

        return parentNode;
    }

    public List<E> inOrderList(){
        List<E> inOrderNodesList = new LinkedList<>();
        inOrderTreeWalk(root, inOrderNodesList);
        return inOrderNodesList;
    }

    @Override
    public String toString() {
        List<E> ascendingOrderNodes = inOrderList();

        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for(E node:ascendingOrderNodes)
            builder.append(node.toString()).append(", ");

        return builder.toString().substring(0, builder.length() - 2).concat("]");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinarySearchTree<?, ?> that = (BinarySearchTree<?, ?>) o;
        return root.equals(that.root);
    }

    @Override
    public int hashCode() {
        return Objects.hash(root);
    }

    protected E minNode(E node){
        E minNode = node;
        while (minNode.getLeft() != null)
            minNode = (E)minNode.getLeft();
        return minNode;
    }

    protected E maxNode(E node){
        E maxNode = node;
        while (maxNode.getRight() != null)
            maxNode = (E)maxNode.getRight();
        return maxNode;
    }

    protected void inOrderTreeWalk(E node, List<E> list){
        if (node != null){

            inOrderTreeWalk((E)node.getLeft(), list);
            list.add(node);
            inOrderTreeWalk((E)node.getRight(), list);
        }
    }

    private void transplant(E nodeA, E nodeB){
        if(nodeA.getParent() == null)
            root = nodeB;
        else if (nodeA == nodeA.getParent().getLeft())
            nodeA.getParent().setLeft(nodeB);
        else
            nodeA.getParent().setRight(nodeB);

        if(nodeB != null)
            nodeB.setParent(nodeA.getParent());
    }
}


