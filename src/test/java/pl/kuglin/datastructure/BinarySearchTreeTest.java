package pl.kuglin.datastructure;

import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    private static final int TESTED_EXAMPLES = 100000;
    private static final int ARRAY_MAX_SIZE = 100;
    private static final int MAX_ARRAY_VALUE = 100;

    private static class ObjectToTest extends BinarySearchTree.Node<Integer>{
        ObjectToTest(Integer id) {
            super(id);
        }

        @Override
        public String toString() {
            return this.getId().toString();
        }

        @Override
        public boolean equals(Object o) {
            return super.equals(o);
        }
    }

    private Random random = new Random();
    private ObjectToTest[] objectsToTest = new ObjectToTest[ARRAY_MAX_SIZE];

    @Test
    public void orderTreeTest() {
        for (int j = 0; j < TESTED_EXAMPLES; j++) {
            for(int i = 0; i < ARRAY_MAX_SIZE; i++)
                objectsToTest[i] = new ObjectToTest(random.nextInt(MAX_ARRAY_VALUE));

            BinarySearchTree<ObjectToTest, Integer> bst = new BinarySearchTree<>();

            for (ObjectToTest object : objectsToTest)
                bst.insert(object);

            List<ObjectToTest> result = bst.inOrderList();

            boolean isProperOrder = true;

            int previous = result.get(0).getId();

            for (int i = 1; i < result.size(); i++) {

                if (result.get(i).getId() < previous)
                    isProperOrder = false;

                previous = result.get(i).getId();
            }

            assertTrue(isProperOrder);
        }
    }

    @Test
    public void deleteTest() {
        for (int j = 0; j < TESTED_EXAMPLES; j++) {
            for(int i = 0; i < ARRAY_MAX_SIZE; i++)
                objectsToTest[i] = new ObjectToTest(random.nextInt(MAX_ARRAY_VALUE));

            Tree<ObjectToTest, Integer> bst = new BinarySearchTree<>();

            for (ObjectToTest object : objectsToTest)
                bst.insert(object);

            bst.delete(objectsToTest[random.nextInt(MAX_ARRAY_VALUE)]);

            List<ObjectToTest> result = bst.inOrderList();

            boolean isProperOrder = true;

            int previous = result.get(0).getId();

            for (int i = 1; i < result.size(); i++) {

                if (result.get(i).getId() < previous)
                    isProperOrder = false;

                previous = result.get(i).getId();
            }

            assertTrue(isProperOrder);
        }
    }

    @Test
    public void searchTest() {
        for (int j = 0; j < TESTED_EXAMPLES; j++) {

            for(int i = 0; i < ARRAY_MAX_SIZE; i++)
                objectsToTest[i] = new ObjectToTest(random.nextInt());

            Tree<ObjectToTest, Integer> bst = new BinarySearchTree<>();

            for (ObjectToTest object : objectsToTest)
                bst.insert(object);

            for (ObjectToTest object : objectsToTest){
                assertNotNull(bst.search(object.getId()));
            }
        }
    }

    @Test
    public void minTreeTest() {
        for (int j = 0; j < TESTED_EXAMPLES; j++) {
            for(int i = 0; i < ARRAY_MAX_SIZE; i++)
                objectsToTest[i] = new ObjectToTest(random.nextInt(MAX_ARRAY_VALUE));

            Tree<ObjectToTest, Integer> bst = new BinarySearchTree<>();

            int min = objectsToTest[0].getId();

            for (ObjectToTest object : objectsToTest) {
                bst.insert(object);
                if (object.getId() < min)
                    min = object.getId();
            }

            assertEquals(Integer.valueOf(min), bst.minTree().getId());
        }
    }

    @Test
    public void maxTreeTest() {
        for (int j = 0; j < TESTED_EXAMPLES; j++) {
            for (int i = 0; i < ARRAY_MAX_SIZE; i++)
                objectsToTest[i] = new ObjectToTest(random.nextInt(MAX_ARRAY_VALUE));
            Tree<ObjectToTest, Integer> bst = new BinarySearchTree<>();

            int max = objectsToTest[0].getId();

            for (ObjectToTest object : objectsToTest) {
                bst.insert(object);
                if (object.getId() > max)
                    max = object.getId();
            }

            assertEquals(Integer.valueOf(max), bst.maxTree().getId());
        }
    }

    @Test
    public void nextNodeTest() {
        for (int j = 0; j < TESTED_EXAMPLES; j++) {
            for (int i = 0; i < ARRAY_MAX_SIZE; i++)
                objectsToTest[i] = new ObjectToTest(random.nextInt(MAX_ARRAY_VALUE));

            Tree<ObjectToTest, Integer> bst = new BinarySearchTree<>();

            for (ObjectToTest object : objectsToTest)
                bst.insert(object);

            List<ObjectToTest> sortedList = bst.inOrderList();

            int index = random.nextInt(sortedList.size() );

            ObjectToTest node = sortedList.get(index);

            if(index + 1 > sortedList.size() - 1)
                assertNull(bst.nextNode(node));
            else
                assertEquals(sortedList.get(index + 1), bst.nextNode(node));
        }
    }

    @Test
    public void previousNodeTest() {
        for (int j = 0; j < TESTED_EXAMPLES; j++) {
            for (int i = 0; i < ARRAY_MAX_SIZE; i++)
                objectsToTest[i] = new ObjectToTest(random.nextInt(MAX_ARRAY_VALUE));

            Tree<ObjectToTest, Integer> bst = new BinarySearchTree<>();

            for (ObjectToTest object : objectsToTest)
                bst.insert(object);

            List<ObjectToTest> sortedList = bst.inOrderList();

            int index = random.nextInt(sortedList.size() - 1);

            ObjectToTest node = sortedList.get(index);

            if(index - 1 < 0)
                assertNull(bst.previousNode(node));
            else
                assertEquals(sortedList.get(index -1), bst.previousNode(node));
        }
    }
}