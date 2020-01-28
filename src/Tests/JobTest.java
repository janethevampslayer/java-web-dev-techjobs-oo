package Tests;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.launchcode.techjobs_oo.*;


public class JobTest {
    Job testJob1;
    Job testJob2;
    Job testJob3;
    Job testJob4;

    @Before
    public void createJobObjects() {
        testJob1 = new Job();
        testJob2 = new Job();
        testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test

    public void testSettingJobId() {
        assertFalse(testJob1.getId() == testJob2.getId());
    }

    public void testJobIdSequence() {
        assertEquals(testJob1.getId(), testJob2.getId(), 1);
    }

    public void testJobConstructorTestsAllFields() {
        assertTrue(testJob3 instanceof Job);
        assertTrue(testJob3.getName().equals("Product tester"));
        assertTrue(testJob3.getEmployer().equals("ACME"));
        assertTrue(testJob3.getLocation().equals("Desert"));
        assertTrue(testJob3.getPositionType().equals("Quality control"));
        assertTrue(testJob3.getCoreCompetency().equals("Persistence"));
    }

    public void testJobsForEquality() {
        assertFalse(testJob3.equals(testJob4));
    }
}
