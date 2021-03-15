package a1;

/** NetId: asw263. Time spent: 4 hours, 0 minutes. <br>
 * What I thought about this assignment: It was a challenging first project <br>
 * <br>
 * An instance maintains info about the Phd of a person. */
public class Phd {
    /** Name of the person with a Phd, a String of length > 0.‣ */
    private String name;
    /** year Phd was awarded. Must be > 1000.‣ */
    private int year;
    /** month Phd was awarded. In range 1..12 with 1 being January, etc.‣ */
    private int month;
    /** First advisor of this person —null if unknown.‣ */
    private Phd advisor1;
    /** Second advisor of this person —null if unknown or only one advisor.‣ */
    private Phd advisor2;
    /** number of Phd advisees of this person. */
    private int nAdvisees;

    /** Constructor: an instance for a person with name n, Phd year y, Phd month m. Its advisors are
     * unknown, and it has no advisees. Precondition: n has at least 1 char, y > 1000, and m is in
     * 1..12 */
    public Phd(String n, int y, int m) {
        assert n.length() >= 1;
        assert y > 1000;
        assert m >= 1 && m <= 12;
        name= n;
        year= y;
        month= m;
        advisor1= null;
        advisor2= null;
        nAdvisees= 0;
    }

    /** Constructor: a Phd with name n, Phd year y, Phd month m, first advisor a1, and second
     * advisor a2. Precondition: n has at least 1 char, y > 1000, m is in 1..12,a1 and a2 are not
     * null, and a1 and a2 are different. */
    public Phd(String n, int y, int m, Phd a1, Phd a2) {
        assert n.length() >= 1;
        assert y > 1000;
        assert m >= 1 && m <= 12;
        assert a1 != null;
        assert a2 != null;
        assert a1 != a2;
        name= n;
        year= y;
        month= m;
        setAdvisor1(a1);
        setAdvisor2(a2);
        nAdvisees= 0;
    }

    /** = the name of this person. */
    public String name() {
        return name;
    }

    /** = the date on which this person got the Phd. In the form "month/year", with no blanks, e.g.
     * "6/2007" */
    public String date() {
        return String.valueOf(month) + "/" + String.valueOf(year);
    }

    /** = the first advisor of this Phd (null if unknown). */
    public Phd advisor1() {
        return advisor1;
    }

    /** = the second advisor of this Phd (null if unknown or non-existent). */
    public Phd advisor2() {
        return advisor2;
    }

    /** = the number of Phd advisees of this person. */
    public int nAdvisees() {
        return nAdvisees;
    }

    /** Make p the first advisor of this person. Precondition: the first advisor is unknown and p is
     * not null. */
    void setAdvisor1(Phd p) {
        assert advisor1 == null;
        assert p != null;
        advisor1= p;
        advisor1.nAdvisees+= 1;
    }

    /** Make p the second advisor of this person. Precondition: The first advisor (of this person)
     * is known, the second advisor is unknown, p is not null, and p is different from the first
     * advisor. */
    void setAdvisor2(Phd p) {
        assert advisor1 != null;
        assert advisor2 == null;
        assert p != null;
        assert p != advisor1;
        advisor2= p;
        advisor2.nAdvisees+= 1;

    }

    /** = "this Phd has no advisees",i.e. true if this Phd has no advisees and false otherwise. */
    boolean hasNoAdvisees() {
        return nAdvisees == 0;
    }

    /** = "p is not null and this person got the Phd before p.” */
    boolean gotBefore(Phd p) {
        assert p != null;
        boolean isTrue= year < p.year || (year == p.year && month < p.month);
        return isTrue;
    }

    /** = "this person and p are intellectual siblings."Precondition: p is not null. */
    boolean areSibs(Phd p) {
        assert p != null;
        assert this != p;
        boolean isTrue= (advisor1 == p.advisor1 && advisor1 != null) ||
            (advisor1 == p.advisor2 && advisor1 != null) ||
            (advisor2 == p.advisor1 && advisor2 != null) ||
            (advisor2 == p.advisor2 && advisor2 != null);
        return isTrue;
    }

}