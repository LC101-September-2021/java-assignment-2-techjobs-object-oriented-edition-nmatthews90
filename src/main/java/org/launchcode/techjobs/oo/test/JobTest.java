package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.CoreCompetency;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.Job;
import org.launchcode.techjobs.oo.PositionType;
import org.launchcode.techjobs.oo.Location;


/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job first_test_job = new Job();
        Job second_test_job = new Job();

        Assert.assertEquals(first_test_job.getId(), second_test_job.getId(), 1);
        Assert.assertNotEquals(first_test_job.getId(), second_test_job.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {

       Job full_test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

//        Assert.assertNotNull(full_test_job.getName());
//        Assert.assertNotNull(full_test_job.getEmployer());
//        Assert.assertNotNull(full_test_job.getLocation());
//        Assert.assertNotNull(full_test_job.getPositionType());
//        Assert.assertNotNull(full_test_job.getCoreCompetency());

        Assert.assertEquals("Product tester", full_test_job.getName());
        Assert.assertEquals("ACME", full_test_job.getEmployer().getValue());
        Assert.assertEquals("Desert", full_test_job.getLocation().getValue());
        Assert.assertEquals("Quality control", full_test_job.getPositionType().getValue());
        Assert.assertEquals("Persistence", full_test_job.getCoreCompetency().getValue());

        Assert.assertTrue(full_test_job.getName() instanceof String);
        Assert.assertTrue(full_test_job.getEmployer() instanceof Employer);
        Assert.assertTrue(full_test_job.getLocation() instanceof Location);
        Assert.assertTrue(full_test_job.getPositionType() instanceof PositionType);
        Assert.assertTrue(full_test_job.getCoreCompetency() instanceof CoreCompetency);

    }

    @Test
    public void testJobsForEquality() {
        Job full_test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job second_full_test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Assert.assertFalse(full_test_job .equals(second_full_test_job));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job full_test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Assert.assertEquals('\n',full_test_job.toString().charAt(0));
        Assert.assertEquals('\n', full_test_job.toString().charAt(full_test_job.toString().length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job full_test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Assert.assertEquals("\nID: " + full_test_job.getId() + "\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n" , full_test_job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job empty_field_test_job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        Assert.assertEquals("\nID: " + empty_field_test_job.getId() + "\nName: Data not available\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Data not available\nCore Competency: Data not available\n" , empty_field_test_job.toString());
    }

}
