package com.freedy.tree;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author Freedy
 * @date 2021/6/9 23:35
 */
public class RedBlackTree<K extends Comparable<K>, V> implements Map<K, V>, Iterable<Map.Entry<K, V>> {
    /**
     * 头节点
     */
    private Node<K, V> root;
    /**
     * 红色节点常量
     */
    private final boolean RED = false;
    /**
     * 黑色节点常量
     */
    private final boolean BLACK = true;
    /**
     * 节点左侧
     */
    private final boolean LEFT = true;
    /**
     * 节点右侧
     */
    private final boolean RIGHT = false;
    /**
     * 红黑树的大小
     */
    private int size;
    /**
     * entrySet的缓存对象
     */
    private Set<Map.Entry<K, V>> cachedEs;
    /**
     * entrySet的缓存对象
     */
    private Set<K> cachedKs;
    /**
     * entrySet的缓存对象
     */
    private Collection<V> cachedVal;
    /**
     * 迭代其的缓存对象
     */
    private EntryIterator cachedItr;

    /**
     * 红黑树的节点类
     */
    static class Node<K, V> implements Map.Entry<K, V> {
        Node<K, V> parent;
        Node<K, V> left;
        Node<K, V> right;
        boolean color;
        K key;
        V value;

        Node(Node<K, V> parent, Node<K, V> left, Node<K, V> right, boolean color, K key, V value) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.color = color;
            this.key = key;
            this.value = value;
        }

        Node(Node<K, V> parent, K key, V value) {
            this.parent = parent;
            this.key = key;
            this.value = value;
        }

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        private Node<K, V> cloneNode() {
            return new Node<>(key, value);
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
                    .add("key=" + key)
                    .add("value=" + value)
                    .toString();
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        m.forEach(this::put);
    }

    /**
     * 单节点插入
     */
    public V singlePut(K value) {
        return put(value, null);
    }

    @Override
    public V put(K key, V value) {
        if (key == null) throw new NullPointerException("key can't be null");
        Node<K, V> parent;
        if ((parent = root) == null) {
            root = new Node<>(null, null, null, BLACK, key, value);
            size++;
            return null;
        }
        // 寻找插入位置,并创建节点
        Node<K, V> newNode;
        for (int cmp; ; ) {
            cmp = key.compareTo(parent.key);
            if (cmp < 0) {
                if (parent.left == null) {
                    newNode = new Node<>(parent, key, value);
                    parent.left = newNode;
                    size++;
                    break;
                }
                parent = parent.left;
            } else if (cmp > 0) {
                if (parent.right == null) {
                    newNode = new Node<>(parent, key, value);
                    parent.right = newNode;
                    size++;
                    break;
                }
                parent = parent.right;
            } else {
                return parent.setValue(value);
            }
        }
        adjustNodesAfterPut(newNode);
        return null;
    }

    /**
     * 对新加入的节点进行调整（旋转+变色）
     *
     * @param newNode 新加入的节点
     */
    private void adjustNodesAfterPut(Node<K, V> newNode) {
        Node<K, V> parent, grandParent, uncle;
        if ((parent = parentOf(newNode)) == null) {
            if (colorOf(newNode) == RED) { // 是头节点且是红色
                newNode.color = BLACK;
                return;
            }
            throw new NullPointerException("this node or parent node is null");
        }
        newNode.color = RED;
        if (parent.color == RED) { // 只有挂在红色节点下面才需要调整
            if ((grandParent = parentOf(parent)) != null && parent == grandParent.left) {
                if ((uncle = grandParent.right) == null || uncle.color == BLACK) {//没有叔叔节点
                    if (parent.right == newNode) {
                        newNode.color = BLACK;
                        grandParent.color = RED;
                        leftRotate(parent);
                        rightRotate(grandParent);
                    } else if (parent.left == newNode) {
                        rightRotate(grandParent); // 右旋
                        parent.color = BLACK;
                        grandParent.color = RED;
                    } else throw new RuntimeException("parent dose not include child node");
                } else {
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    grandParent.color = RED;
                    adjustNodesAfterPut(grandParent);
                }
            } else if (grandParent != null && parent == grandParent.right) {
                if ((uncle = grandParent.left) == null || uncle.color == BLACK) {//没有叔叔节点
                    if (parent.right == newNode) {
                        leftRotate(grandParent); // 左旋
                        parent.color = BLACK;
                        grandParent.color = RED;
                    } else if (parent.left == newNode) {
                        newNode.color = BLACK;
                        grandParent.color = RED;
                        rightRotate(parent);
                        leftRotate(grandParent);
                    } else throw new RuntimeException("parent dose not include child node");
                } else {
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    grandParent.color = RED;
                    adjustNodesAfterPut(grandParent);
                }
            }
        }
    }

    @Override
    public V remove(Object key) {
        Node<K, V> node;
        if ((node = getNode(key)) == null) return null;
        V oldValue = node.getValue();
        removeNode(node);
        return oldValue;
    }

    /**
     * 获取指定key的node
     */
    private Node<K, V> getNode(Object key) {
        if (root == null || key == null) return null;
        @SuppressWarnings("unchecked")
        K k = (K) key;
        Node<K, V> temp = root;
        for (int cmp; temp != null; ) {
            cmp = k.compareTo(temp.key);
            if (cmp > 0) {
                temp = temp.right;
            } else if (cmp < 0) {
                temp = temp.left;
            } else {
                return temp;
            }
        }
        return null;
    }

    /**
     * 删除指定的节点
     */
    private void removeNode(Node<K, V> node) {
        if (node == null) return;
        if (node.left != null && node.right != null) { // 既有左子树又有右子树
            Node<K, V> successorNode = successor(node);
            transferNodeInfo(successorNode, node);
            node = successorNode;  // 指定要删除的元素
        }
        if (isLeafNode(node)) {
            // 要删除的元素只可能在最后两层
            if (node == root) {
                root = null;
            } else {
                adjustNodesAfterRemove1(node); // 调整红黑树
                setParentChild(node, null);
            }
        } else {  // 此时删除必定对应234树中的3节点或者4节点
            Node<K, V> leftNode, childNode = (leftNode = node.left) != null ? leftNode : node.right;
            childNode.parent = node.parent;
            setParentChild(node, childNode);
            if (node.parent == null) root = childNode;
            childNode.color = BLACK;  // 此时只需要将变为黑色 就平衡了
        }
        node.parent = node.right = node.left = null; // help gc
        size--;
    }

    /**
     * 删除节点后进行调整，使其继续保持为红黑树
     * 只有在其对应的234树中是双节点的叶子节点时才需要调整
     * 另外一种删除方式可能有bug
     *
     * @param node 删除的节点
     */
    @Deprecated
    private void adjustNodesAfterRemove(Node<K, V> node) {
        if (node == null) return;
        if (node.color == RED) {
            setParentChild(node, null);
            return;
        }
        if (node == root) {
            root = null;
            return;
        }
        Node<K, V> parent = node.parent, brother;
        boolean brotherSide; //true left  false right
        if (nodeSideOfParent(node) == LEFT) {
            brother = parent.right;
            brotherSide = RIGHT;
        } else {
            brother = parent.left;
            brotherSide = LEFT;
        }
        if (brother.color == RED) {
            // 此时获取的不是234树中对应的兄弟节点，需要调整
            brother.color = BLACK;
            parent.color = RED;
            if (brotherSide == LEFT) {   // rotate
                rightRotate(parent);
                brother = parent.left;
            } else {
                leftRotate(parent);
                brother = parent.right;
            }
        }
        if (isLeafNode(brother)) { //兄弟节点不能借
            setParentChild(node, null);
            boolean shouldBreak = false;
            while (true) {
                if (parent.color == RED || parent == root) shouldBreak = true;
                if (brother.color == RED) {
                    parent.color = RED;
                    brother.color = BLACK;
                    if (brotherSide == LEFT) {   // rotate
                        rightRotate(parent);
                        brother = parent.left;
                    } else {
                        leftRotate(parent);
                        brother = parent.right;
                    }
                } else {
                    Node<K, V> brotherChild;
                    if (brotherSide == LEFT) {
                        if (colorOf(brotherChild = brother.right) == RED) {
                            brother.parent = parent.parent;
                            setParentChild(parent, brother);
                            parent.left = brotherChild.right;
                            brotherChild.right.parent = parent;
                            brotherChild.right = parent;
                            parent.parent = brotherChild;
                        } else {
                            rightRotate(parent);
                        }
                    } else {
                        if (colorOf(brotherChild = brother.left) == RED) {
                            brother.parent = parent.parent;
                            setParentChild(parent, brother);
                            parent.right = brotherChild.left;
                            brotherChild.left.parent = parent;
                            brotherChild.left = parent;
                            parent.parent = brotherChild;
                        } else {
                            leftRotate(parent);
                        }
                    }
                    adjustNodesAfterPut(parent);
                    if (shouldBreak) break;
                    node = parent.parent;
                    parent = node.parent;
                    if (nodeSideOfParent(node) == LEFT) {
                        brother = parent.right;
                        brotherSide = RIGHT;
                    } else {
                        brother = parent.left;
                        brotherSide = LEFT;
                    }
                }
            }
        } else { //兄弟节点可以借
            transferNodeInfo(parent, node);
            Node<K, V> nephew;
            if (brotherSide == RIGHT) {
                if ((nephew = brother.left) != null) {  //直接替换
                    transferNodeInfo(nephew, parent);
                    brother.left = null;
                } else {
                    nephew = brother.right;
                    transferNodeInfo(brother, parent);
                    transferNodeInfo(nephew, brother);
                    brother.right = null;
                }
            } else {
                if ((nephew = brother.right) != null) {  //直接替换
                    transferNodeInfo(nephew, parent);
                    brother.right = null;
                } else {
                    nephew = brother.left;
                    transferNodeInfo(brother, parent);
                    transferNodeInfo(nephew, brother);
                    brother.left = null;
                }
            }
        }
    }

    /**
     * 删除节点后进行调整，使其继续保持为红黑树
     * 只有在其对应的234树中是双节点的叶子节点时才需要调整
     *
     * @param node 删除的节点
     */
    private void adjustNodesAfterRemove1(Node<K, V> node) {
        if (node == null) return;
        Node<K, V> parent = node.parent, brother;
        if (node.color == RED || node == root) {
            node.color = BLACK;
            return;
        }
        if (nodeSideOfParent(node) == LEFT) {
            brother = parent.right;
            if (brother == null) {
                System.out.println(node.key);
                System.out.println(this);
                throw new RuntimeException();
            }
            if (brother.color == RED) {
                // 此时获取的不是234树中对应的兄弟节点，需要调整
                brother.color = BLACK;
                parent.color = RED;
                leftRotate(parent);
                brother = parent.right;
            }
            if (colorOf(leftOf(brother)) == BLACK && colorOf(rightOf(brother)) == BLACK) { //兄弟节点不能借
                brother.color = RED;
                node = parent;
                adjustNodesAfterRemove1(node);
            } else { //兄弟节点可以借
                if (colorOf(brother.right) == BLACK) {  //直接替换
                    brother.left.color = BLACK;
                    brother.color = RED;
                    rightRotate(brother);
                    brother = parent.right;
                }
                brother.color = parent.color;
                parent.color = BLACK;
                brother.right.color = BLACK;
                leftRotate(parent);
            }
        } else {
            brother = parent.left;
            if (brother == null) {
                System.out.println(node.key);
                System.out.println(this);
                throw new RuntimeException();
            }
            if (brother.color == RED) {
                brother.color = BLACK;
                parent.color = RED;
                rightRotate(parent);
                brother = parent.left;
            }
            if (colorOf(leftOf(brother)) == BLACK && colorOf(rightOf(brother)) == BLACK) { //兄弟节点不能借
                brother.color = RED;
                node = parent;
                adjustNodesAfterRemove1(node);
            } else { //兄弟节点可以借
                if (colorOf(brother.left) == BLACK) {  //直接替换
                    brother.right.color = BLACK;
                    brother.color = RED;
                    leftRotate(brother);
                    brother = parent.left;
                }
                brother.color = parent.color;
                parent.color = BLACK;
                brother.left.color = BLACK;
                rightRotate(parent);
            }
        }
    }


    /**
     * 获取参照节点的前驱节点
     *
     * @param node 参照节点
     */
    private Node<K, V> predecessor(Node<K, V> node) {
        if (node == null) return null;
        Node<K, V> tempNode, nextNode;
        if ((tempNode = node.left) != null) {
            while ((nextNode = tempNode.right) != null) {
                tempNode = nextNode;
            }
            return tempNode;
        } else { // 没有左子树
            if ((tempNode = node.parent).right == node) {
                return tempNode;
            }
            while ((nextNode = tempNode.parent) != null && nextNode.left == tempNode) {
                tempNode = nextNode;
            }
            return nextNode;
        }
    }

    /**
     * 获取参照节点的后继节点
     *
     * @param node 参照节点
     */
    private Node<K, V> successor(Node<K, V> node) {
        if (node == null) return null;
        Node<K, V> tempNode, nextNode;
        if ((tempNode = node.right) != null) {
            while ((nextNode = tempNode.left) != null) {
                tempNode = nextNode;
            }
            return tempNode;
        } else {
            if ((tempNode = node.parent).left == node) {
                return tempNode;
            }
            while ((nextNode = tempNode.parent) != null && nextNode.right == tempNode) {
                tempNode = nextNode;
            }
            return nextNode;
        }
    }

    /**
     * @return 给定节点的左孩子
     */
    private Node<K, V> leftOf(Node<K, V> node) {
        return (node == null) ? null : node.left;
    }

    /**
     * @return 给定节点的右孩子
     */
    private Node<K, V> rightOf(Node<K, V> node) {
        return (node == null) ? null : node.right;
    }

    /**
     * @return 给定节点的父节点
     */
    private Node<K, V> parentOf(Node<K, V> node) {
        return (node == null) ? null : node.parent;
    }

    /**
     * 判断给定节点的颜色
     */
    private boolean colorOf(Node<K, V> node) {
        return (node == null) ? BLACK : node.color;
    }

    /**
     * 判断给定的节点是否是叶子节点
     *
     * @param node 给定的节点
     * @return true 是叶子节点 false 不是叶子节点
     */
    private boolean isLeafNode(Node<K, V> node) {
        return node != null && node.left == null && node.right == null;
    }

    /**
     * 设置<b>参考节点</b>的父节点的(对应那一边的)孩子
     *
     * @param reference 参考节点
     * @param child     要被设置的孩子节点
     */
    private void setParentChild(Node<K, V> reference, Node<K, V> child) {
        Node<K, V> greatGrandParent;
        if (reference != null && (greatGrandParent = reference.parent) != null) {
            if (greatGrandParent.left == reference) //p在p的父节点的左子树
                greatGrandParent.left = child;
            else if (greatGrandParent.right == reference) //p在p的父节点的右子树
                greatGrandParent.right = child;
            else throw new RuntimeException("parent dose not include child node");
        }
    }

    /**
     * 交换两个节点key value
     */
    private void exchangeNodeInfo(Node<K, V> first, Node<K, V> second) {
        Node<K, V> tempNode = second.cloneNode();
        transferNodeInfo(first, second);
        transferNodeInfo(tempNode, first);
    }

    /**
     * 转移第一个节点信息给第二个节点 (从 first->second)
     *
     * @param first  第一个节点
     * @param second 第二个节点
     */
    private void transferNodeInfo(Node<K, V> first, Node<K, V> second) {
        second.key = first.key;
        second.value = first.value;
    }

    /**
     * 判断指定node在父节点的方向
     *
     * @return left->true right->false
     */
    private boolean nodeSideOfParent(Node<K, V> node) {
        Node<K, V> parent;
        if (node == null || (parent = node.parent) == null)
            throw new NullPointerException("this node or parent node is null");
        if (parent.left == node) {
            return LEFT;
        }
        if (parent.right == node) {
            return RIGHT;
        }
        throw new RuntimeException("parent dose not include child node");
    }

    /**
     * 围绕 p节点左旋
     * ******* p *********************** pr (newHead) <br/>
     * ****** / \ ********************* / \           <br/>
     * ***** pl  pr (newHead)  ===>    p   rr         <br/>
     * ******** / \ ***************** / \             <br/>
     * ****** rl***rr ************** pl***rl
     */
    private void leftRotate(Node<K, V> p) {
        if (p != null && p.right != null) {
            Node<K, V> newHead = p.right;
            if ((p.right = newHead.left) != null)
                p.right.parent = p;
            if ((newHead.left = p).parent == null) {
                root = newHead;
                newHead.parent = null;
            } else {
                newHead.parent = p.parent;
                setParentChild(p, newHead);
            }
            p.parent = newHead;
        }
    }

    /**
     * 围绕 p节点右旋
     */
    private void rightRotate(Node<K, V> p) {
        if (p != null && p.left != null) {
            Node<K, V> newHead = p.left;
            if ((p.left = newHead.right) != null)
                p.left.parent = p;
            if ((newHead.right = p).parent == null) {
                root = newHead;
                newHead.parent = null;
            } else {
                newHead.parent = p.parent;
                setParentChild(p, newHead);
            }
            p.parent = newHead;
        }
    }

    /**
     * 中序遍历map
     *
     * @param node     从此节点开始遍历
     * @param consumer 遍历过程中产生的每个node
     */
    private void infixOrder(Node<K, V> node, Consumer<Node<K, V>> consumer) {
        if (leftOf(node) != null) {
            infixOrder(node.left, consumer);
        }
        consumer.accept(node);
        if (rightOf(node) != null) {
            infixOrder(node.right, consumer);
        }
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {
        infixOrder(root, node -> action.accept(node.getKey(), node.getValue()));
    }


    @Override
    public void clear() {
        root = null; // help GC
        size = 0;
        cachedEs = null;
        cachedItr = null;
        cachedKs = null;
        cachedVal = null;
    }

    @Override
    public Set<K> keySet() {
        Set<K> ks;
        return (ks = cachedKs) == null ? (cachedKs = new KeySet()) : ks;
    }

    class KeySet extends AbstractSet<K> {
        private final KeyIterator itr = new KeyIterator();

        @Override
        public Iterator<K> iterator() {
            return itr.reset();
        }

        @Override
        public int size() {
            return size;
        }
    }

    @Override
    public Collection<V> values() {
        Collection<V> val;
        return (val = cachedVal) == null ? (cachedVal = new Values()) : val;
    }

    class Values extends AbstractCollection<V> {
        private final ValueIterator itr = new ValueIterator();

        @Override
        public Iterator<V> iterator() {
            return itr.reset();
        }

        @Override
        public int size() {
            return size;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return getNode(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        return values().contains(value);
    }

    @Override
    public V get(Object key) {
        Node<K, V> node;
        return (node = getNode(key)) == null ? null : node.getValue();
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> es;
        return (es = cachedEs) == null ? (cachedEs = new EntrySet()) : es;
    }

    class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        private final EntryIterator itr = new EntryIterator();

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return itr.reset();
        }

        @Override
        public int size() {
            return size;
        }
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        EntryIterator itr;
        return (itr = cachedItr) == null ? (cachedItr = new EntryIterator()) : itr.reset();
    }

    @Override
    public Spliterator<Entry<K, V>> spliterator() {
        throw new UnsupportedOperationException();
    }

    /**
     * 迭代器类,采用非递归方式遍历数组（因为此种方式可以暂定遍历，而递归则很难实现）
     */
    abstract class AbstractIterator {
        private final Stack<Node<K, V>> stack = new Stack<>();
        private Node<K, V> nextNode = root;

        public boolean hasNext() {
            return !stack.isEmpty() || nextNode != null;
        }

        /**
         * 采用非递归方式遍历树
         */
        public Node<K, V> nextNode() {
            Stack<Node<K, V>> sk = stack;
            while (nextNode != null) {
                sk.push(nextNode);
                nextNode = nextNode.left;
            }
            if (!sk.isEmpty()) {
                Node<K, V> node = sk.pop();
                nextNode = node.right;
                return node;
            }
            return null;
        }


        public void resetItr() {
            stack.removeAllElements();
            nextNode = root;
        }

        public void remove() {
            removeNode(nextNode.parent);
        }
    }

    public final class EntryIterator extends AbstractIterator implements Iterator<Entry<K, V>> {
        @Override
        public Entry<K, V> next() {
            return nextNode();
        }

        public EntryIterator reset() {
            resetItr();
            return this;
        }
    }

    public final class KeyIterator extends AbstractIterator implements Iterator<K> {
        @Override
        public K next() {
            return nextNode().getKey();
        }

        public KeyIterator reset() {
            resetItr();
            return this;
        }
    }

    public final class ValueIterator extends AbstractIterator implements Iterator<V> {
        @Override
        public V next() {
            return nextNode().getValue();
        }

        public ValueIterator reset() {
            resetItr();
            return this;
        }
    }

    /**
     * 用于检测红黑树是否合法（所有层次应为相同值）
     */
    public boolean check() {
        LinkedList<WrapNode> list = new LinkedList<>();
        ArrayList<WrapNode> lastLayer = new ArrayList<>();
        if (root != null) {
            WrapNode node = new WrapNode(root, 0);
            list.add(node);
        }
        while (!list.isEmpty()) {
            WrapNode pop = list.pop();
            if (pop.left != null)
                list.add(new WrapNode(pop.left, pop.left.color == BLACK ? pop.flore + 1 : pop.flore));
            if (pop.right != null)
                list.add(new WrapNode(pop.right, pop.right.color == BLACK ? pop.flore + 1 : pop.flore));
            if (pop.left == null && pop.right == null) {
                lastLayer.add(pop);
            }
        }
        int flore = lastLayer.get(0).flore;
        for (WrapNode node : lastLayer) {
            if (node.flore != flore) {
                return false;
            }
        }
        return true;
    }

    /**
     * node的包装类 用于记录当前节点的层次
     */
    private class WrapNode extends Node<K, V> {
        private final int flore;

        WrapNode(Node<K, V> node, int flore) {
            super(node.parent, node.left, node.right, node.color, node.key, node.value);
            this.flore = flore;
        }
    }

    @Override
    public String toString() {
        if (root == null) return null;
        StringBuilder sb = new StringBuilder();
        sb.append("\033[1;93;34m" + "root<")
                .append(root.key)
                .append(",")
                .append(root.value)
                .append("> color:")
                .append(root.color ? "黑" : "红")
                .append("\n");
        infixOrder(root, node -> sb.append(node.color ? "\033[38m" : "\033[31m")
                .append("node<")
                .append(node.key)
                .append(",")
                .append(node.value)
                .append("> color:")
                .append(node.color ? "黑" : "红")
                .append("\n"));
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
