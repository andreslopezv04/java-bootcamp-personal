# 📘 DÍA 5: PROGRAMACIÓN ORIENTADA A OBJETOS (POO)

---

## 🎯 OBJETIVOS DEL DÍA
Al final de hoy sabrás:
- Crear tus propias clases (blueprints)
- Instanciar objetos
- Encapsulamiento (private, getters, setters)
- Constructores
- `this` keyword
- Métodos de instancia vs métodos estáticos
- **Crear un sistema completo con objetos**

---

## 🌍 ¿Qué es POO y por qué existe?


```java
// Crear una clase Book (plantilla/blueprint)
public class Book {
    private String title;
    private String author;
    private int year;
    private boolean available;
    
    // Constructor
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
    }
    
    // Método
    public void borrow() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully");
        } else {
            System.out.println("Book not available");
        }
    }
}

// Usar la clase
Book book1 = new Book("Clean Code", "Robert Martin", 2008);
book1.borrow();  // ¡Todo en un solo objeto!
```

**Ventajas:**
✅ Datos relacionados están juntos
✅ Imposible desincronizar
✅ Representa el mundo real
✅ Código más limpio y mantenible
✅ Reutilizable

---

## 📚 Conceptos Fundamentales de POO

### **1. CLASE (Class)** - El blueprint/plantilla

Una **clase** es como un plano arquitectónico. Define QUÉ es algo.

```java
public class Car {
    // Atributos (características)
    private String brand;
    private String model;
    private int year;
    
    // Constructor (cómo crear un carro)
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    
    // Métodos (comportamientos)
    public void start() {
        System.out.println("The " + brand + " is starting...");
    }
}
```

### **2. OBJETO (Object)** - La instancia real

Un **objeto** es una instancia específica de una clase. Es el carro REAL.

```java
// Crear objetos (instancias)
Car myCar = new Car("Toyota", "Corolla", 2020);
Car yourCar = new Car("Honda", "Civic", 2019);

// Cada objeto tiene sus propios valores
myCar.start();   // "The Toyota is starting..."
yourCar.start(); // "The Honda is starting..."
```

**Analogía:**
- **Clase** = Plano de una casa 📋
- **Objeto** = Casa real construida 🏠

---

## 🔐 ENCAPSULAMIENTO (Encapsulation)

### **¿Qué es?**
Ocultar los detalles internos y exponer solo lo necesario.

### **Modificadores de acceso:**

| Modificador | Acceso desde |
|-------------|--------------|
| `public` | Cualquier lugar ✅ |
| `private` | Solo dentro de la clase ❌ |
| `protected` | Clase y subclases (veremos después) |
| (sin modificador) | Mismo paquete (default) |

### **Regla de oro:**
- **Atributos:** SIEMPRE `private`
- **Getters/Setters:** `public` para acceder a atributos
- **Métodos públicos:** `public`
- **Métodos auxiliares:** `private`

### **Ejemplo:**

```java
public class BankAccount {
    // ❌ MAL: atributos públicos
    public double balance;  // Cualquiera puede modificar
    
    // ✅ BIEN: atributos privados
    private double balance;
    
    // Getters y Setters para acceso controlado
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {  // Validación
            balance += amount;
        }
    }
    
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

// Uso
BankAccount account = new BankAccount();
account.deposit(1000);
// account.balance = -500;  // ❌ No se puede! Es private
System.out.println(account.getBalance());  // ✅ Acceso controlado
```

---

## 🏗️ CONSTRUCTORES (Constructors)

### **¿Qué es un constructor?**
Un método especial que se ejecuta cuando creas un objeto.

### **Características:**
- Mismo nombre que la clase
- No tiene tipo de retorno (ni siquiera `void`)
- Se llama automáticamente con `new`

### **Tipos de constructores:**

#### **1. Constructor por defecto (si no creas ninguno):**
```java
public class Person {
    private String name;
}

// Java crea automáticamente:
// public Person() { }

Person p = new Person();  // Funciona, pero name será null
```

#### **2. Constructor con parámetros:**
```java
public class Person {
    private String name;
    private int age;
    
    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

Person p = new Person("John", 25);  // Objeto con valores iniciales
```

#### **3. Múltiples constructores (Sobrecarga):**
```java
public class Person {
    private String name;
    private int age;
    
    // Constructor 1: Solo nombre
    public Person(String name) {
        this.name = name;
        this.age = 0;  // Edad por defecto
    }
    
    // Constructor 2: Nombre y edad
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

Person p1 = new Person("John");        // Usa constructor 1
Person p2 = new Person("Jane", 25);    // Usa constructor 2
```

---

## 🔑 LA PALABRA CLAVE `this`

### **¿Qué es `this`?**
Referencia al objeto actual (la instancia).

### **Usos principales:**

#### **1. Diferenciar atributo de parámetro:**
```java
public class Student {
    private String name;  // Atributo
    
    public Student(String name) {  // Parámetro con mismo nombre
        this.name = name;  // this.name es el atributo
                          // name es el parámetro
    }
}
```

#### **2. Llamar a otro constructor:**
```java
public class Person {
    private String name;
    private int age;
    
    public Person(String name) {
        this(name, 0);  // Llama al otro constructor
    }
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

#### **3. Pasar el objeto actual como parámetro:**
```java
public class Book {
    public void registerInLibrary(Library library) {
        library.addBook(this);  // Pasa este libro
    }
}
```

---

## 💻 EJEMPLO COMPLETO: Sistema de Estudiantes con POO---

## 🔍 ANÁLISIS LÍNEA POR LÍNEA

### **Definición de la clase:**
```java
class Student {
    private String name;  // Atributo privado
```
**Explicación:**
- `class Student` crea una nueva clase (blueprint)
- `private` hace que el atributo solo sea accesible dentro de la clase
- Cada objeto Student tendrá su propio `name`

### **Constructor:**
```java
public Student(String name, int age, double grade, String major) {
    this.name = name;  // this.name = atributo, name = parámetro
    this.age = age;
}
```
**¿Qué hace?**
1. Se ejecuta automáticamente al crear objeto con `new`
2. `this.name` = atributo de la clase
3. `name` = parámetro del constructor
4. Asigna los valores iniciales al objeto

### **Getter:**
```java
public String getName() {
    return name;  // Retorna el valor del atributo privado
}
```
**¿Por qué?**
- `name` es `private`, no se puede acceder directamente
- El getter permite LEER el valor de forma controlada

### **Setter:**
```java
public void setGrade(double grade) {
    if (grade >= 0.0 && grade <= 5.0) {  // VALIDACIÓN
        this.grade = grade;
    }
}
```
**Ventaja:** Puedes validar ANTES de modificar

### **Crear objeto:**
```java
Student student1 = new Student("John", 20, 4.5, "CS");
```
**¿Qué pasa?**
1. `new Student(...)` llama al constructor
2. Se crea un nuevo objeto en memoria
3. El constructor inicializa los atributos
4. `student1` guarda la referencia al objeto

### **Usar métodos del objeto:**
```java
student1.displayInfo();  // Llama al método del objeto
```
**Nota:** Cada objeto tiene sus propios métodos y atributos


---

## ✏️ EJERCICIO 1: Crear clase Product

**Objetivo:** Crear tu primera clase desde cero

**Requerimientos:**

Crea una clase `Product` con:

**Atributos (private):**
- `String name`
- `double price`
- `int stock`
- `String category`

**Constructores:**
- Constructor con todos los parámetros
- Constructor sin stock (por defecto 0)

**Getters y Setters:**
- Todos los atributos deben tener getters
- Setters con validación:
    - `price` debe ser > 0
    - `stock` debe ser >= 0
    - `name` no debe estar vacío

**Métodos:**
- `boolean isAvailable()` - retorna true si stock > 0
- `void sell(int quantity)` - reduce stock si hay suficiente
- `void restock(int quantity)` - aumenta stock
- `double getTotalValue()` - retorna price * stock
- `void displayInfo()` - muestra toda la información
- `String toString()` - representación en texto

**Crea también una clase Main:**
- Crea 3 productos
- Prueba todos los métodos
- Usa un ArrayList de productos

**Crea el archivo `Product.java` en `dia-05/`**

---
