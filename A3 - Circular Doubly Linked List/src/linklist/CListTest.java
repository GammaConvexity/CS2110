package linklist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CListTest {

    @Test
    /** Default test included in a3.pdf to test for empty list */
    void testToStringR() {
        CList<Integer> c= new CList<>();
        assertEquals("[]", c.toString());
        assertEquals("[]", c.toStringR());
        assertEquals(0, c.size());
    }

    @Test
    /** Default test included in a3.pdf to test Prepend and ToStringR for "CS2110" */
    public void testPrependAndToStringR() {
        CList<String> cl= new CList<>();
        cl.prepend("CS2110");
        assertEquals("[CS2110]", cl.toString());
        assertEquals("[CS2110]", cl.toStringR());
        assertEquals(1, cl.size());
    }

    @Test
    public void testChangeHeadToNext() {
        CList<String> cl= new CList<>();
        cl.prepend("World");
        cl.prepend("There");
        cl.prepend("Hello");
        cl.changeHeadToNext();
        assertEquals("[There, World, Hello]", cl.toString());
        assertEquals("[Hello, World, There]", cl.toStringR());
        assertEquals(3, cl.size());
        CList<String> cl2= new CList<>();
        cl2.changeHeadToNext();
        assertEquals("[]", cl2.toString());
        assertEquals("[]", cl2.toStringR());
        assertEquals(0, cl2.size());
        CList<String> cl3= new CList<>();
        cl3.prepend("1");
        cl3.changeHeadToNext();
        assertEquals("[1]", cl3.toString());
        assertEquals("[1]", cl3.toStringR());
        assertEquals(1, cl3.size());
    }

    @Test
    public void testAppend() {
        CList<String> cl= new CList<>();
        cl.append("Hello");
        cl.append("There");
        cl.append("World");
        assertEquals("[Hello, There, World]", cl.toString());
        assertEquals("[World, There, Hello]", cl.toStringR());
        assertEquals(3, cl.size());
        CList<Integer> cl2= new CList<>();
        cl2.append(null);
        cl2.append(1);
        assertEquals("[null, 1]", cl2.toString());
        assertEquals("[1, null]", cl2.toStringR());
        assertEquals(2, cl2.size());
        CList<String> cl3= new CList<>();
        cl3.append("");
        cl3.append("hi");
        assertEquals("[, hi]", cl3.toString());
        assertEquals("[hi, ]", cl3.toStringR());
        assertEquals(2, cl3.size());
    }

    @Test
    public void testGetNode() {
        CList<Integer> cl= new CList<>();
        cl.append(1);
        cl.append(2);
        cl.append(3);
        cl.append(4);
        cl.append(5);
        assertEquals(1, cl.getNode(0).data());
        assertEquals(2, cl.getNode(1).data());
        assertEquals(3, cl.getNode(2).data());
        assertEquals(4, cl.getNode(3).data());
        assertEquals(5, cl.getNode(4).data());
        CList<String> cl2= new CList<>();
        cl2.append("Hello");
        cl2.append("There");
        cl2.append("Big");
        cl2.append("Beautiful");
        cl2.append("Extravagant");
        cl2.append("World");
        assertEquals("Hello", cl2.getNode(0).data());
        assertEquals("There", cl2.getNode(1).data());
        assertEquals("Big", cl2.getNode(2).data());
        assertEquals("Beautiful", cl2.getNode(3).data());
        assertEquals("Extravagant", cl2.getNode(4).data());
        assertEquals("World", cl2.getNode(5).data());
        CList<String> cl3= new CList<>();
        cl3.append("");
        assertEquals("", cl3.getNode(0).data());
    }

    @Test
    public void testRemove() {
        CList<String> cl= new CList<>();
        cl.append("Hello");
        cl.append("There");
        cl.append("World");
        cl.remove(cl.getNode(0));
        assertEquals("[There, World]", cl.toString());
        assertEquals("[World, There]", cl.toStringR());
        assertEquals(2, cl.size());

    }

    @Test
    public void testInsertBefore() {
        CList<String> cl= new CList<>();
        cl.append("Hello");
        cl.append("There");
        cl.append("World");
        cl.insertBefore("hi", cl.getNode(0));
        assertEquals("[hi, Hello, There, World]", cl.toString());
        assertEquals("[World, There, Hello, hi]", cl.toStringR());
        assertEquals(4, cl.size());
        CList<String> cl2= new CList<>();
        cl2.append("Hello");
        cl2.append("There");
        cl2.append("World");
        cl2.insertBefore("hi", cl2.getNode(2));
        assertEquals("[Hello, There, hi, World]", cl2.toString());
        assertEquals("[World, hi, There, Hello]", cl2.toStringR());
        assertEquals(4, cl2.size());

    }
}
