package ArbolBinario;

public class ArbolBinario<T extends Comparable<T>> {
    private ArbolBinarioNodo<T> root;

    public void BinaryTree() {
        this.root = null;
    }
    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean contains(T element) {
        return this.contains(element, this.root);
    }

    private boolean contains(T element, ArbolBinarioNodo<T> node) {
        if (node == null) {
            return false;
        } else {
            int compareResult = element.compareTo(node.element);
            if (compareResult < 0)
                return contains(element, node.left);
            else if (compareResult > 0)
                return contains(element, node.right);
            else
                return true;
        }
    }

    private ArbolBinarioNodo<T> findMin(ArbolBinarioNodo<T> node) {
        if (node == null)
            return null;
        else if (node.left == null)
            return node;
        else
            return findMin(node.left);
    }
    private ArbolBinarioNodo<T> findMax(ArbolBinarioNodo<T> node) {
        if (node!= null)
            while (node.right != null) {
                node = node.right;
            }
        return node;
    }

    ///preguntar a adrian
    private ArbolBinarioNodo<T> insert(T element, ArbolBinarioNodo<T> current) {
        if (current == null)
            return new ArbolBinarioNodo<T>(element, null, null);
        int compareResult = element.compareTo(current.element);
        if (compareResult < 0)
            current.left = this.insert(element, current.left);
        else if (compareResult > 0)
            current.right = this.insert(element, current.right);
        return current;
    }

    public void insert(T element) {
        this.root = this.insert(element, this.root);
    }

    ////preguntar a adrian
    public ArbolBinarioNodo remove(T element, ArbolBinarioNodo<T> node) {
        if (node == null)
            return node;
        int compareResult = element.compareTo(node.element);
        if (compareResult < 0)
            node.left= remove(element, node.left);
        else if (compareResult > 0)
            node.right = remove(element, node.right);
        else if (node.left != null && node.right != null){
            node.element = findMin(node.right).element;
            node.right = remove(node.element, node.right);
        } else {
            node = node.left != null ? node.left : node.right;
        }
        return node;
    }

}
