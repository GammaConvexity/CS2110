package a1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PhdTest {

    @Test
    void testConstructor1() {
        Phd test= new Phd("Arthur", 2021, 10);
        assertEquals("Arthur", test.name());
        assertEquals("10/2021", test.date());
        assertEquals(null, test.advisor1());
        assertEquals(null, test.advisor2());
        assertEquals(0, test.nAdvisees());
    }

    @Test
    void testConstructor2() {
        Phd advisee= new Phd("Arthur", 1999, 5);
        Phd advisor1= new Phd("Jim", 2000, 1);
        Phd advisor2= new Phd("John", 2001, 2);
        advisee.setAdvisor1(advisor1);
        advisee.setAdvisor2(advisor2);
        assertEquals(advisor1, advisee.advisor1());
        assertEquals(1, advisor1.nAdvisees());
        assertEquals(advisor2, advisee.advisor2());
        assertEquals(1, advisor2.nAdvisees());
    }

    @Test
    void testConstructor3() {
        Phd advisora= new Phd("Jim", 2000, 1);
        Phd advisorb= new Phd("John", 2001, 2);
        Phd advisee1= new Phd("Arthur", 2021, 10, advisora, advisorb);
        assertEquals("Arthur", advisee1.name());
        assertEquals("10/2021", advisee1.date());
        assertEquals(advisora, advisee1.advisor1());
        assertEquals(advisorb, advisee1.advisor2());
        assertEquals(0, advisee1.nAdvisees());
        assertEquals(1, advisora.nAdvisees());
        assertEquals(1, advisorb.nAdvisees());

    }

    @Test
    void testConstructor4() {
        /* hasNoAdvisees test */
        Phd advisorg= new Phd("Jim", 2000, 1);
        assertEquals(true, advisorg.hasNoAdvisees());
        /* gotBefore test */
        /* q's year is the same as p's */
        Phd feb77= new Phd("feb77", 1977, 2);
        Phd jun77= new Phd("jun77", 1977, 6);
        assertEquals(true, feb77.gotBefore(jun77));
        Phd feb77_2= new Phd("feb77_2", 1977, 2);
        Phd feb77_3= new Phd("feb77_3", 1977, 2);
        assertEquals(false, feb77_2.gotBefore(feb77_3));
        Phd jun77_2= new Phd("jun77_2", 1977, 6);
        Phd feb77_4= new Phd("feb77_4", 1977, 2);
        assertEquals(false, jun77_2.gotBefore(feb77_4));
        /* q's year is before p's */
        Phd feb70= new Phd("feb70", 1970, 2);
        Phd jun71= new Phd("jun71", 1971, 6);
        assertEquals(true, feb70.gotBefore(jun71));
        Phd feb70_2= new Phd("feb70_2", 1970, 2);
        Phd feb71= new Phd("feb71", 1971, 2);
        assertEquals(true, feb70_2.gotBefore(feb71));
        Phd jun70= new Phd("jun70", 1970, 6);
        Phd feb71_2= new Phd("feb71_2", 1971, 2);
        assertEquals(true, jun70.gotBefore(feb71_2));
        /* q's year is after p's */
        Phd feb80= new Phd("feb80", 1980, 2);
        Phd jun79= new Phd("jun79", 1979, 6);
        assertEquals(false, feb80.gotBefore(jun79));
        Phd feb80_2= new Phd("feb80", 1980, 2);
        Phd feb79= new Phd("feb79", 1979, 2);
        assertEquals(false, feb80_2.gotBefore(feb79));
        Phd jun80= new Phd("jun80", 1980, 6);
        Phd feb79_2= new Phd("feb79_2", 1979, 2);
        assertEquals(false, jun80.gotBefore(feb79_2));
        /* areSibs test */
        Phd t1= new Phd("Jim", 2000, 1);
        Phd t2= new Phd("John", 1977, 2);
        assertEquals(false, t1.areSibs(t2));
        Phd t3= new Phd("Jim", 2000, 5);
        Phd t4= t3;
        t3.setAdvisor1(t2);
        try {
            assertEquals(true, t3.areSibs(t4));
        } catch (AssertionError e) {
            System.out.println("t4 and t3 are the same object! Cannot be siblings.");
        }
        Phd t5= new Phd("James", 2000, 1);
        t5.setAdvisor1(t2);
        Phd t6= new Phd("Joe", 1977, 2);
        t6.setAdvisor1(t2);
        assertEquals(true, t5.areSibs(t6));
        Phd t7= new Phd("Jim", 2000, 1, t3, t2);
        Phd t8= new Phd("John", 1977, 2, t5, t2);
        assertEquals(true, t7.areSibs(t8));
        Phd t9= new Phd("Jim", 2000, 1);
        t9.setAdvisor1(t2);
        Phd t10= new Phd("John", 1977, 2, t3, t2);
        assertEquals(true, t9.areSibs(t10));
        Phd t11= new Phd("Jim", 2000, 1, t2, t3);
        Phd t12= new Phd("John", 1977, 2, t5, t6);
        assertEquals(false, t11.areSibs(t12));
        Phd t13= new Phd("Jim", 2000, 1, t5, t2);
        Phd t14= new Phd("John", 1977, 2, t6, t3);
        assertEquals(false, t13.areSibs(t14));

    }

    void assertTesting() {
        /* blank name*/
        assertThrows(AssertionError.class, () -> { Phd z1= new Phd("", 2000, 1); });
        /* year < 1000 */
        assertThrows(AssertionError.class, () -> { Phd z2= new Phd("John", 100, 1); });
        /* month > 12 */
        assertThrows(AssertionError.class, () -> { Phd z3= new Phd("John", 2000, 13); });
        /* month < 1 */
        assertThrows(AssertionError.class, () -> { Phd z4= new Phd("John", 2000, 0); });
        /* give null for both advisors */
        assertThrows(AssertionError.class, () -> { Phd z5= new Phd("John", 2000, 1, null, null); });
    }

}
