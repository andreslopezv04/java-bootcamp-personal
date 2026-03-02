package dia_05;

// ===== CLASE STUDENT =====
class Student {
    // ATRIBUTOS (private para encapsulamiento)
    private String name;
    private int age;
    private double grade;
    private String major;

    // CONSTRUCTOR 1: Todos los parámetros
    public Student(String name, int age, double grade, String major) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.major = major;
    }

    // CONSTRUCTOR 2: Sin nota (por defecto 0)
    public Student(String name, int age, String major) {
        this(name, age, 0.0, major);  // Llama al otro constructor
    }

    // GETTERS (para leer atributos privados)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    public String getMajor() {
        return major;
    }

    // SETTERS (para modificar atributos con validación)
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public void setAge(int age) {
        if (age > 0 && age < 120) {
            this.age = age;
        }
    }

    public void setGrade(double grade) {
        if (grade >= 0.0 && grade <= 5.0) {
            this.grade = grade;
        }
    }

    public void setMajor(String major) {
        this.major = major;
    }

    // MÉTODOS DE COMPORTAMIENTO
    public boolean hasPassed() {
        return grade >= 3.0;
    }

    public String getStatus() {
        if (grade >= 4.5) {
            return "Excellent";
        } else if (grade >= 4.0) {
            return "Good";
        } else if (grade >= 3.0) {
            return "Passed";
        } else {
            return "Failed";
        }
    }

    public void study(double hours) {
        System.out.println(name + " is studying " + hours + " hours");
        // Simulamos que estudiar mejora la nota
        if (grade < 5.0) {
            grade = Math.min(5.0, grade + (hours * 0.1));
        }
    }

    // MÉTODO toString() - Representación en texto del objeto
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                ", major='" + major + '\'' +
                '}';
    }

    // MÉTODO para mostrar información formateada
    public void displayInfo() {
        System.out.println("\n━━━ Student Information ━━━");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Major: " + major);
        System.out.println("Grade: " + grade);
        System.out.println("Status: " + getStatus());
        System.out.println("Passed: " + (hasPassed() ? "Yes ✅" : "No ❌"));
    }
}

// ===== CLASE MAIN PARA PROBAR =====
public class StudentSystemOOP_Example {
    public static void main(String[] args) {

        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║     STUDENT SYSTEM - OOP VERSION      ║");
        System.out.println("╚════════════════════════════════════════╝");

        // ===== CREAR OBJETOS (Instancias) =====
        System.out.println("\n==== Creating Students ====");

        Student student1 = new Student("John Smith", 20, 4.5, "Computer Science");
        Student student2 = new Student("Jane Doe", 19, 3.8, "Engineering");
        Student student3 = new Student("Bob Johnson", 21, 2.5, "Mathematics");
        Student student4 = new Student("Alice Williams", 22, "Physics");  // Sin nota

        System.out.println("✅ 4 students created");

        // ===== ACCEDER A INFORMACIÓN CON GETTERS =====
        System.out.println("\n==== Accessing Information ====");

        System.out.println("Student 1 name: " + student1.getName());
        System.out.println("Student 1 grade: " + student1.getGrade());
        System.out.println("Student 1 status: " + student1.getStatus());

        // ===== MODIFICAR CON SETTERS =====
        System.out.println("\n==== Modifying Student 4 ====");

        System.out.println("Before: Grade = " + student4.getGrade());
        student4.setGrade(4.2);
        System.out.println("After: Grade = " + student4.getGrade());

        // ===== USAR MÉTODOS DEL OBJETO =====
        System.out.println("\n==== Using Object Methods ====");

        System.out.println(student1.getName() + " passed? " + student1.hasPassed());
        System.out.println(student3.getName() + " passed? " + student3.hasPassed());

        // ===== MeTODO study() =====
        System.out.println("\n==== Student 3 Studies ====");

        System.out.println("Before studying: " + student3.getGrade());
        student3.study(5);  // Estudia 5 horas
        System.out.println("After studying: " + student3.getGrade());

        // ===== MOSTRAR INFORMACIÓN COMPLETA =====
        System.out.println("\n==== Displaying All Students ====");

        student1.displayInfo();
        student2.displayInfo();
        student3.displayInfo();
        student4.displayInfo();

        // ===== toString() =====
        System.out.println("\n==== Using toString() ====");

        System.out.println(student1.toString());
        System.out.println(student2);  // toString() se llama automáticamente

        // ===== TRABAJAR CON ARRAY DE OBJETOS =====
        System.out.println("\n==== Array of Students ====");

        Student[] students = {student1, student2, student3, student4};

        System.out.println("Total students: " + students.length);

        // Calcular promedio
        double totalGrade = 0;
        for (Student student : students) {
            totalGrade += student.getGrade();
        }
        double average = totalGrade / students.length;
        System.out.println("Class average: " + String.format("%.2f", average));

        // Contar aprobados
        int passed = 0;
        for (Student student : students) {
            if (student.hasPassed()) {
                passed++;
            }
        }
        System.out.println("Students passed: " + passed + "/" + students.length);

        // ===== ARRAYLIST DE OBJETOS =====
        System.out.println("\n==== ArrayList of Students ====");

        java.util.ArrayList<Student> studentList = new java.util.ArrayList<>();

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);

        // Agregar más estudiantes
        studentList.add(new Student("Charlie Brown", 20, 4.0, "Biology"));

        System.out.println("Total in list: " + studentList.size());

        // Buscar estudiantes por estado
        System.out.println("\nExcellent students:");
        for (Student student : studentList) {
            if (student.getStatus().equals("Excellent")) {
                System.out.println("  - " + student.getName() + " (" + student.getGrade() + ")");
            }
        }

        // ===== COMPARACIÓN: ANTES vs DESPUÉS DE POO =====
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║              BEFORE vs AFTER OOP                   ║");
        System.out.println("╚════════════════════════════════════════════════════╝");

        System.out.println("\n❌ BEFORE (without OOP):");
        System.out.println("ArrayList<String> names = ...");
        System.out.println("ArrayList<Integer> ages = ...");
        System.out.println("ArrayList<Double> grades = ...");
        System.out.println("// Easy to desync, hard to maintain");

        System.out.println("\n✅ AFTER (with OOP):");
        System.out.println("Student student = new Student(\"John\", 20, 4.5, \"CS\");");
        System.out.println("// All related data together!");
        System.out.println("// Impossible to desync!");
        System.out.println("// Clean and maintainable!");

        // ===== VALIDACIÓN DE SETTERS =====
        System.out.println("\n==== Setter Validation ====");

        Student testStudent = new Student("Test", 20, 3.0, "Test");

        System.out.println("Trying to set invalid grade (-5):");
        testStudent.setGrade(-5);  // No cambia porque es inválido
        System.out.println("Grade: " + testStudent.getGrade());  // Sigue siendo 3.0

        System.out.println("\nTrying to set valid grade (4.5):");
        testStudent.setGrade(4.5);
        System.out.println("Grade: " + testStudent.getGrade());  // Cambió a 4.5

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   OOP Concepts Demonstrated! ✅        ║");
        System.out.println("╚════════════════════════════════════════╝");
    }
}