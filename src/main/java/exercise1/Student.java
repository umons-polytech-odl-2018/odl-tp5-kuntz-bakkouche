package exercise1;

import java.util.*;

/**
 * Represents a student.
 * A Student is identified by its registration number.
 * A student gets scored in different courses.
 * These scores are expressed as integers on a scale from 0 to 20.
 */
public class Student {

    private String name;
    private String registrationNumber;

    HashMap<String,Integer> cours = new HashMap <String, Integer>();


    /**
     * Creates a new Student.
     *
     * @throws NullPointerException if one of the parameter is null.
     */

    public Student(String name, String registrationNumber) {
        this.name = name;
        this.registrationNumber = registrationNumber;
    }

    /**
     * Sets the score of this student for the given course.
     * If the score is set twice for the same course, the new score replaces the previous one.
     *
     * @throws NullPointerException if the course name is null.
     * @throws IllegalArgumentException if the score is less than 0 or greater than 20.
     */
    public void setScore(String course, int score) {

        cours.put(course,score);

    }

    /**
     * Returns the score for the given course.
     *
     * @return the score if found, <code>OptionalInt#empty()</code> otherwise.
     */
    public OptionalInt getScore(String course) {

        Integer score = cours.get(course);
        return score != null ? OptionalInt.of(score) : OptionalInt.empty();
    }

    /**
     * Returns the average score.
     *
     * @return the average score or 0 if there is none.
     */
    public double averageScore() {

        double somme = 0;
        Collection<Integer> tmp = cours.values();
        Iterator it = tmp.iterator();
        while(it.hasNext())
        {
            int tmp2 = (int) it.next();
            somme += tmp2;
        }
        somme /= cours.size();
        return somme;
    }

    /**
     * Returns the course with the highest score.
     *
     * @return the best scored course or <code>Optional#empty()</code> if there is none.
     */
    public Optional<String> bestCourse() {

        int tmp = bestScore();


        return null;
    }

    /**
     * Returns the highest score.
     *
     * @return the highest score or 0 if there is none.
     */
    public int bestScore() {

        int score = 0;
        Collection<Integer> tmp = cours.values();
        Iterator it = tmp.iterator();
        while(it.hasNext())
        {
            int tmp2 = (int) it.next();
            if(score<tmp2)
                score = tmp2;
        }

        return score;
    }

    /**
     * Returns the set of failed courses sorted by decreasing score.
     * A course is considered as passed if its score is higher than 12.
     */
    public Set<String> failedCourses() {
        return null;
    }

    /**
     * Returns <code>true</code> if the student has an average score greater than or equal to 12.0 and has less than 3 failed courses.
     */
    public boolean isSuccessful() {
        return false;
    }

    /**
     * Returns the set of courses for which the student has received a score, sorted by course name.
     */
    public Set<String> attendedCourses() { return null; }

    public String getName() {
        return name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getName());
        sb.append(" (").append(getRegistrationNumber()).append(")");
        return sb.toString();
    }

    public static void main(String args[])
    {
        Student kuntz = new Student("kuntz","171265");
        kuntz.setScore("Anum",10);
        kuntz.setScore("Méca",18);
        System.out.println(kuntz.averageScore());
        System.out.println(kuntz.bestScore());
    }
}

