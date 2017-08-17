package educationCenterCollection;

import educationCenterCollection.model.Student;

import java.util.Comparator;

/**
 * Used to sort Student data.
 */
public class idComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getId() > o2.getId())
            return 1;
        if (o1.getId() < o2.getId())
            return -1;
        else
            return 0;
    }
}
