package schedule;

public class Course {
    
    public final Course[] PREREQS; public String PREREQS_STRING;
    public final Course[] COREQS; public String COREQS_STRING;
    public final Course[] LINKED_COURSES; public String LINKED_COURSES_STRING; // ?
    public final String NUMBER;
    public final String NAME;
    public final int CREDITS;
    // times
    
    public Course(String num, String nam, int cred, Course[] p, Course[] c, Course[] l) {
        NUMBER = num;
        NAME = nam;
        CREDITS = cred;
        
        PREREQS = p;
        COREQS = c;
        LINKED_COURSES = l;
    }
    
    public Course(String num) { this(num, "", 0, new Course[0], new Course[0], new Course[0]); }
    
    public Course(String num, String nam) { this(num, nam, 0, new Course[0], new Course[0], new Course[0]); }
    
    public Course(String num, String nam, int cred) { this(num, nam, cred, new Course[0], new Course[0], new Course[0]); }
    
    public String parsePreReqs() {
        String r = "";
        String[] p = PREREQS_STRING.split(" ");
        int size = 0;
        
        for (String s : p) {
            if (s.equals("AND") || s.equals("OR")) continue;
            size++;
        }
        
        return r;
    }
    
    public String toString() {
        return NUMBER + "\n" + NAME + "\n" + CREDITS + " credits\nPrerequisites: " + PREREQS_STRING;
    }
    
    public static void main(String[] args) {
        Course MATH261 = new Course("MATH261", "Calc III", 4, new Course[]{new Course("MATH161")}, new Course[0], new Course[0]);
        System.out.println(MATH261);
    }
}
