package Tests;
import org.junit.Assert;
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

    @Test
    public void testJobIdSequence() {
        assertEquals(testJob1.getId(), testJob2.getId(), 1);
    }

    @Test
    public void testJobConstructorTestsAllFields() {
        assertTrue(testJob3 instanceof Job);
        assertEquals(testJob3.getName(), "Product tester");
        assertEquals(testJob3.getEmployer().getValue(),"ACME");
        assertEquals(testJob3.getLocation().getValue(), "Desert");
        assertEquals(testJob3.getPositionType().getValue(), "Quality control");
        assertEquals(testJob3.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(testJob3.equals(testJob4));
    }

    @Test
    public void testJobToStringBlankLineBeforeJobInformation() {
        String toStringTestJob = testJob4.toString();
        assertTrue(toStringTestJob.startsWith("\n"));
    }

    @Test
    public void testJobToStringBlankLineAfterJobInformation() {
        String toStringTestJob = testJob4.toString();
        assertTrue(toStringTestJob.endsWith("\n"));
    }

    @Test
    public void testJobToStringContainsLabels() {
        String toStringTestJob = testJob4.toString();
        assertTrue(toStringTestJob.contains("Name: Product tester\n"));
        assertTrue(toStringTestJob.contains("Employer: ACME\n"));
        assertTrue(toStringTestJob.contains("Location: Desert\n"));
        assertTrue(toStringTestJob.contains("Position Type: Quality control\n"));
        assertTrue(toStringTestJob.contains("Core Competency: Persistence\n"));
    }

    @Test
    public void testJobToStringDataNotAvailable() {
        testJob4.getEmployer().setValue("");
        testJob4.getCoreCompetency().setValue("");
        String output = String.format("\n ID: %d\n Name: %s\n Employer: Data not available\n Location: %s\n Position Type: %s\n Core Competency: Data not available\n",
                testJob4.getId(), testJob4.getName(), testJob4.getLocation(), testJob4.getPositionType());
        assertEquals(output, testJob4.toString());
    }

}
