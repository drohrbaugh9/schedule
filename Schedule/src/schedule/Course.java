package schedule;

public class Course {
    
    private final Course[] PREREQS; private String PREREQS_STRING;
    private final Course[] COREQS; private String COREQS_STRING;
    private final Course[] LINKED_COURSES; private String LINKED_COURSES_STRING; // ?
    private final String NUMBER;
    private final String NAME;
    private final int CREDITS;
    // times
    
    public Course(String num, String nam, int cred, Course[] p, Course[] c, Course[] l) {
        NUMBER = num;
        NAME = nam;
        CREDITS = cred;
        
        PREREQS = p;
        COREQS = c;
        LINKED_COURSES = l;
        
        createStrings();
    }
    
    public Course(String num) { this(num, "", 0, new Course[0], new Course[0], new Course[0]); }
    
    public Course(String num, String nam) { this(num, nam, 0, new Course[0], new Course[0], new Course[0]); }
    
    public Course(String num, String nam, int cred) { this(num, nam, cred, new Course[0], new Course[0], new Course[0]); }
  
    private void createStrings() {
        String temp = "None, ";
        for (int i = 0; i < PREREQS.length; i++) {
            if (i == 0) temp = "";
            
            temp = temp + PREREQS[i].getNumber() + ", ";
        }
        PREREQS_STRING = new String(temp.substring(0, temp.length() - 2));
        
        temp = "None, ";
        for (int i = 0; i < COREQS.length; i++) {
            if (i == 0) temp = "";
            
            temp = temp + COREQS[i].getNumber() + ", ";
        }
        COREQS_STRING = new String(temp.substring(0, temp.length() - 2));
        
        temp = "None, ";
        for (int i = 0; i < LINKED_COURSES.length; i++) {
            if (i == 0) temp = "";
            
            temp = temp + LINKED_COURSES[i].getNumber() + ", ";
        }
        LINKED_COURSES_STRING = new String(temp.substring(0, temp.length() - 2));
    }
    
    public String getNumber() {
        return NUMBER;
    }
    
    /*public String parsePreReqs() { // can't remember what I wanted to do with this method
        String r = "";
        String[] p = PREREQS_STRING.split(" ");
        int size = 0;
        
        for (String s : p) {
            if (s.equals("AND") || s.equals("OR")) continue;
            size++;
        }
        
        return r;
    }*/
  
    public String toString() {
        return NUMBER + "\n" + NAME + "\n" + CREDITS + " credits\nPrerequisites: " + PREREQS_STRING + "\nCorequisites: " + COREQS_STRING;
    }
    
    public static void main(String[] args) {
        Course MATH261 = new Course("MATH261", "Calc III", 4, new Course[]{new Course("MATH161")}, new Course[0], new Course[0]);
        System.out.println(MATH261);
        
        System.out.println();
        
        Course CS165 = new Course("CS165", "Data Structures and Algorithms", 4, new Course[]{new Course("CS163"), new Course("CS164"), new Course("MATH160")}, new Course[]{new Course("MATH160")}, new Course[0]);
        System.out.println(CS165);
    }
}
