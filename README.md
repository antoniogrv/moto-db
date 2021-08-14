# MotoDB
## [Download](https://github.com/v1enna/moto-db/archive/master.zip)

**MotoDB is a generator of graphical applications in Java for the project of the class of Databases** of the three-year course of Computer Science at University of Salerno, Italy. 
The software, in order to work, needs exclusively the queries of the desired operations (defined within the user's own _reality of interest_), and nothing else. 
The application has been designed for all those people who, for any reason, do not have the will or the time to create the Java program required for the **Point VII** of the official requirements of the project. In particular, the modus operandi reflects the delivery of the project required by the teachers G. Tortora and M. Risi of the Department of Computer Science for the passing of the exam of Databases.

For any doubt you can consult the [project documentation](https://github.com/v1enna/moto-db/wiki) which is written in Italian.

![Preview](https://i.gyazo.com/73db8d0a271f8773fc0554efd770fe1e.png)

Assuming that the user already has the necessary set-up, that is the documentation from Point I (*description of the reality of interest*) 
to Point VI (*definition of operations on the reality of interest*), **MotoDB allows you to create a complete and functional GUI in 10 minutes**, 
leading to the completion of all the requirements of the project, making it presentable and deliverable to the teachers. In addition, if desired, the source code is completely editable to your liking, although this may result in the malfunction of the application itself.

All that is required of the user is the **compilation of very few lines of configuration** in one of the program files, 
as well as **formatting the operation queries** to fit the program logic. If you have the slightest idea of what you are doing and are able to move nimbly in a Java environment,
your custom GUI should be ready in no time. 

## Download and installation

To get MotoDB, simply download the [latest stable version](https://github.com/v1enna/moto-db/archive/master.zip). Alternatively, users can directly clone the respository from the `master` branch via `git clone https://github.com/v1enna/moto-db.git` 
to have the entire source code available immediately. Note that the identifier (as well as a brief changelog) of the latest stable version of the software is on the right side of this page, under *Releases*.

The content of the archive is a folder containing the Java program to be imported into an IDE or executed from a terminal. 
In particular, the program has been designed to be launched easily on [Eclipse](https://www.eclipse.org/) and [Visual Studio Code](https://code.visualstudio.com/).

The archive looks as follows:


```html
<moto-db-master.zip>
  <moto-db-master>
    <lib>
      // MySQL driver
    <src>
      // Java program
    <sql>
      // SQL demo
    .classpath
    .gitignore
```

The `.gitignore` file is irrelevant and can be deleted.

#### Eclipse IDE

Once the archive is unpacked, create a project via **File > New > Java Project** and name it whatever you like. 
It is not suggested to enter a `module-info.java`, as it is often automatically prompted by the program (so click **Don't Create**). The IDE will create a new workspace on the left where you will find, usually, only the `src` directory.
It's enough, now, to copy and paste the contents of `moto-db-master` (i.e. the folders `lib`, `src`, `sql`, `.classpath`, `.gitginore`) *into the project root* in Eclipse, and not into `src`.
In fact, the `src` folder of the MotoDB archive must completely overwrite the default `src` folder.
It is also fundamental not to paste the files in `src`, but in the `root` of the project, which usually coincides with the name of the Java project defined at creation.

When copying the program, Eclipse may ask if you want to copy or link the files: proceed to **Copy files and folders** and **Overwrite all**. Pay attention to this step: importing files incorrectly will cause the program to fail.


#### Visual Studio Code

MotoDB was created on Visual Studio Code. The [Java Extension Pack](https://code.visualstudio.com/docs/languages/java) was used to compile the files.
Regardless of the extension used, simply copy and paste the entire folder in the archive into a directory or workspace. 
No further configuration is required to compile the program correctly.


A correct installation on both environments looks like this:

![Import](https://i.gyazo.com/e9aa38b23bda39b8c24751b63ba64c1f.png)

## Configuration

Once the files are imported, try to compile (by pressing `F5` on Visual Studio Code or `Run` on Eclipse) the file `src/<default package>/App.java`.

To start MotoDB just compile and run the **App** class contained in the `App.java` file. If the installation was successful, a debug window will open. 
At the very first startup, MotoDB will warn about the inability to connect to the database, choosing the data (username, password, dbname) it is using (by default, these are example values).
It's all normal: to use MotoDB correctly, you need to compile some lines of the configuration file located in `config/Config.java`. 

### Database connection

Of the **Config** class, which is quite large and complex, you must compulsorily modify the database connection data.

```java
 public static final String PROJECT_NAME = "My Project"; // Modifying this field is optional!
        
 public static final String DB_NAME = "example_database"; // Mandatory
 public static final String DB_USERNAME = "example_username"; // Mandatory
 public static final String DB_PASSWORD = "example_password"; // Mandatory
```

**Please do not use the MySQL Workbench root user** but, rather, **generate a user in the database creation script** via `CREATE USER` and `GRANT PERMISSIONS`.
You can find a working example in the [documentation](https://github.com/v1enna/moto-db/wiki).

Once you have entered the data, recompile App and make sure that the debug window notifies you that you have connected to the database. 
In this case, the main frame should open and the user interaction will take place. 

### Operations

Initially, the application is populated with demo operations which, clearly, will return errors upon execution, since the user does not have the tables and data exploited in the operations themselves.
In any case, if you want to try the MotoDB demo consult the [documentation](https://github.com/v1enna/moto-db/wiki).

The last step of the configuration is the definition of the Operations. You will be faced with a situation like this:

```java
public static ArrayList<Operation> Operations = new ArrayList<Operation>(Arrays.asList(

   // Operation 1
   new Operation("SELECT * FROM example_table", 
       "Select all example data."),

   // Operation 2
   new Operation("SELECT name FROM example_table WHERE id = {ID Example}"
      "Selects only the column 'name' from the example data, based on the ID."),

   // Operation 3
   new Operation("SELECT id FROM example_table WHERE first name = \"{First Name}" AND last name = \"{Surname}""
       "Select only the 'id' column from the example data, based on first name and last name."),

   // Operation 4
   new Operation("DELETE FROM example_table", 
       "Empty the example table.")
       
));
```

MotoDB automatically generates GUIs and query execution routines based on the operations that are added to the *Operations* list.
Specifically, `Operations` is an `ArrayList<Operation>` that is populated at the instant of its declaration. The arraylist is passed an `Array` in the form of a `List` (`Arrays.asList` is in fact a casting) 
that allows to add - without particular difficulties - new instances of `Operation`.

```java
public static ArrayList<Operation> = new ArrayList<Operation>(Arrays.asList(

  // My operations
  new Operation(query, description),
  new Operation(query, description)
  ..
  
);
```

**Operation** is the operation definition class and is constructed from a string representing the query, and a string representing the description of the operation.

```java
new Operation(String query, String description)
```

For example, if in my reality of interest I have an operation of the type "*Select all students in the school*", namely `"SELECT * FROM students"`, then I will have a situation like this:

```java
public static ArrayList<Operation> Operations = new ArrayList<Operation>(Arrays.asList(

  // Operation 1
  new Operation("SELECT * FROM students",
      "Select all students in the school.")

));
```

Both query and description must necessarily be strings, but the contents of those strings can actually be anything. This means that if the user (i.e., the person who is converting their reality of interest operations to MotoDB operations) makes a formatting error, the debug window or console will promptly warn them.
It is clearly recommended to adopt a comfortable and clean spacing, perhaps respecting the proposed examples, but it is not strictly necessary to make the software work. Obviously, in case of a syntax error, MotoDB will fail the compilation almost instantly, since **the configuration file is loaded at App startup**.


After every operation, except for the very last one, a comma is required.

```java
public static ArrayList<Operation> Operations = new ArrayList<Operation>(Arrays.asList(

  // Operazione 3
  new Operation("SELECT id FROM example_table WHERE nome = \"{Nome}\" AND cognome = \"{Cognome}\"",
      "Select the ID column where columns 'nome' and 'surname' are equal to something."), // <--- Not the last operation, needs a comma

  // Operazione 4
  new Operation("DELETE FROM example_table", 
      "Empty the example table.") // <-- Last operation, doesn't need a comma

));

```


Note that a comma is required after each Operation, except for the last one in the list.

```java
public static ArrayList<Operation> Operations = new ArrayList<Operation>(Arrays.asList(

  // Operation 3
  new Operation("SELECT id FROM example_table WHERE name = \"{FirstName}" AND lastName = \"{Surname}""
      "Select only the 'id' column from the example data, based on first name and last name."), // <--- Not the last operation, comma

  // Operation 4
  new Operation("DELETE FROM example_table", 
      "Empty the example table.") // <--- Last operation, no comma

));

```

### Alias

Now that it's clear how, roughly, Operations are defined, it's crucial to talk about **Alias**.

An **Alias** is a value required as input. Let's assume a common case scenario:
- You have an operation like "*Select all students in the indicated class (section, year) "*.
- The database has a table `students` and a table `classes`.
- The table `classes` has as fields `section` and `year`.
- `year` is an integer, while `section` is a string (i.e. `varchar`, `char` and so on)
- `students` and `classes` are related, meaning that `year` and `section` in a generic student tuple actually refer to an existing tuple in `classes`
- The table `students` has as fields `matriculation`, `name`, `surname`, `section`, `year`.

The query requested will therefore be `"SELECT * FROM students WHERE section = InputUser1 AND year = InputUser2`".

The point of the program is to: **launch queries based on certain input data from the user**. 
Now, **MotoDB uses *Alias* to determine what will be queried from the user**. The parsing logic will take care of generating the inputs and the query; what is required of the user is to replace the values they want the user to be asked for with Aliases.

![Preview](https://i.gyazo.com/cdf457b01f0ede8a1be300eeb5ad17b2.png)

An Alias looks something like this: `{InputUser}`. 

- An Alias begins and ends with a curly bracket, *always*.
- The internal content of an Alias can be anything. The text in question will be shown on the screen when the user tries to perform that operation. An Alias can be empty, such as `{}`, but it is still recommended to add informative text.

Given this, the query to insert in the `new Operation()` will be `"SELECT * FROM students WHERE section = '{Section}' AND year = {Year}"`.
This query will generate a graphical window in which two input fields will be requested, namely section and year.

```java
  new Operation("SELECT * FROM students WHERE section = '{Section}' AND year = {Year}",
      "Select all students in the indicated class (section, year)");
```

A GUI generated with this query and the description provided above will look something like this:
```html
 Selects all students in the class (section, year) indicated
 
 Section: [input]
 Year: [input]
 
 Run] button.
```

But, as we said before, the **content of an Alias can be any text**. For example, if the query had been ``SELECT * FROM students WHERE section = '{The SeZiOnE}' AND year = {I'm an Alias}` a GUI like this would have been generated:
```html
 Selects all students in the indicated class (section, year)
 
 The SeZiOnE: [input].
 I am an Alias: [input]
 
 [Run] button.
```

Finally, please note the use of superscripts and double superscripts. As we mentioned, `section` is a character, while `year` is an integer. In SQL, integers do not require superscripts, while strings and characters do. It means that `SELECT * FROM section = A` will not compile, while `SELECT * FROM section = 'A'` will. Therefore, if you deal with values such as strings and dates (*yyyy-mm-dd*), the Alias should be encapsulated in superscripts or double superscripts. If double quotes are used, it will be mandatory to break out the string term as shown above.

### Debug Mode

MotoDB is equipped with a complete and discursive debug mode, which allows you to sift through every action performed by the software's systems to identify possible problems. It is recommended to leave the debug mode active until the project is submitted.

![Preview](https://i.gyazo.com/98367f4738dadd2c192bac93b090a7b4.png)

However, you can disable debug mode at any time in the configuration file:

```java
  public static final boolean DEBUG_MODE = true;
```


## Build & Deploy

MotoDB was created entirely in Java, respecting the minimum coding requirements of the project. The graphical interfaces were built using [Swing](https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html). This repository hosts the source code of MotoDB, as well as that of the [landing page](https://v1enna.github.io/moto-db/#/). Specifically, the repository is divided into three branches, namely `master`, `gh-pages-dev` and `gh-pages`.

### `branch: master`
It hosts the Java source code for MotoDB. When you download MotoDB, you are in effect downloading the contents of the `master` branch. For a detailed description of the program code, please see the [project documentation](https://github.com/v1enna/moto-db/wiki) in depth.

### `branch: gh-pages-dev`
It hosts the source code of the landing page, which is a static single-page site developed in [React](https://it.reactjs.org/). The web application is designed to be hosted on GitHub Pages via the deployment scripts of [gh-pages](https://www.npmjs.com/package/gh-pages) and [npm](https://www.npmjs.com/). Templates are built in [JSX](https://facebook.github.io/jsx/).

### `branch: gh-pages`
This branch contains the static build (markup, stylization, JavaScript interactivity) produced by the parent content in `gh-pages-dev`. What is actually shown in the landing pages is the content of this branch. While `gh-pages-dev` can be considered as the development version, `gh-pages` is evaluated instead as the production version, i.e. the website itself released publicly.


## References

- [MotoDB Landing Page](https://v1enna.github.io/moto-db/#/)
- [MotoDB Wiki](https://github.com/v1enna/moto-db/wiki)

