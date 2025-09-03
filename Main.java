import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== MOVIE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Movie");
            System.out.println("2. Show All Movies");
            System.out.println("3. Modify Movie");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int ch = Integer.parseInt(sc.nextLine());

            switch (ch) {
                case 1: {
                    System.out.print("Enter movie ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter movie name: ");
                    String mName = sc.nextLine();
                    System.out.print("Enter movie year: ");
                    int year = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter movie genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Enter producer name: ");
                    String pName = sc.nextLine();
                    System.out.print("Enter production company: ");
                    String pComp = sc.nextLine();
                    System.out.print("Enter director name: ");
                    String dName = sc.nextLine();
                    Production production = new Production(pName, pComp, dName);

                    System.out.print("Enter number of actors: ");
                    int count = Integer.parseInt(sc.nextLine());
                    String[] names = new String[count];
                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter actor " + (i + 1) + " name: ");
                        names[i] = sc.nextLine();
                    }
                    Actors actors = new Actors(count, names);

                    Movie m = new Movie(id, mName, year, genre, production, actors);

                    FileWriter fw = new FileWriter("movies.txt", true);
                    fw.write(m.getMovieId() + "," + m.getMovieName() + "," + m.getMovieYear() + "," + m.getMovieGenre() + "," +
                            m.getProduction().getProducerName() + "," +
                            m.getProduction().getProductionCompany() + "," +
                            m.getProduction().getDirectorName() + "," +
                            m.getActors().getActorCount() + ",");

                    for (int i = 0; i < m.getActors().getActorCount(); i++) {
                        fw.write(m.getActors().getActorNames()[i]);
                        if (i != m.getActors().getActorCount() - 1) fw.write("|");
                    }
                    fw.write("\n");
                    fw.close();
                    System.out.println("Movie added successfully!");
                    break;
                }

                case 2: {
                    File f = new File("movies.txt");
                    if (!f.exists()) {
                        System.out.println("No movies found.");
                        break;
                    }
                    BufferedReader br = new BufferedReader(new FileReader("movies.txt"));
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split(",");
                        System.out.println("---------------");
                        System.out.println("Movie ID: " + parts[0]);
                        System.out.println("Movie: " + parts[1]);
                        System.out.println("Year: " + parts[2]);
                        System.out.println("Genre: " + parts[3]);
                        System.out.println("Producer: " + parts[4]);
                        System.out.println("Production Company: " + parts[5]);
                        System.out.println("Director: " + parts[6]);
                        System.out.println("Actors:");
                        String[] actorArr = parts[8].split("\\|");
                        for (String actor : actorArr) {
                            System.out.println("- " + actor);
                        }
                    }
                    br.close();
                    break;
                }

                case 3: {
                    System.out.print("Enter Movie ID to modify: ");
                    String modId = sc.nextLine();

                    File f = new File("movies.txt");
                    if (!f.exists()) {
                        System.out.println("No movies found.");
                        break;
                    }

                    BufferedReader br = new BufferedReader(new FileReader("movies.txt"));
                    String[] allMovies = new String[100];
                    int n = 0;
                    String line;
                    while ((line = br.readLine()) != null) {
                        allMovies[n] = line;
                        n++;
                    }
                    br.close();

                    boolean found = false;
                    for (int i = 0; i < n; i++) {
                        String[] parts = allMovies[i].split(",");
                        if (parts[0].equals(modId)) {
                            found = true;
                            System.out.print("Enter new movie name: ");
                            String newName = sc.nextLine();
                            System.out.print("Enter new year: ");
                            int newYear = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter new genre: ");
                            String newGenre = sc.nextLine();
                            System.out.print("Enter new producer name: ");
                            String newP = sc.nextLine();
                            System.out.print("Enter new production company: ");
                            String newPC = sc.nextLine();
                            System.out.print("Enter new director: ");
                            String newD = sc.nextLine();
                            System.out.print("Enter number of actors: ");
                            int newCount = Integer.parseInt(sc.nextLine());
                            String[] newActors = new String[newCount];
                            for (int j = 0; j < newCount; j++) {
                                System.out.print("Enter actor " + (j + 1) + " name: ");
                                newActors[j] = sc.nextLine();
                            }

                            String newLine = modId + "," + newName + "," + newYear + "," + newGenre + "," +
                                    newP + "," + newPC + "," + newD + "," + newCount + ",";
                            for (int j = 0; j < newCount; j++) {
                                newLine += newActors[j];
                                if (j != newCount - 1) newLine += "|";
                            }
                            allMovies[i] = newLine;
                            break;
                        }
                    }

                    if (found) {
                        FileWriter fw = new FileWriter("movies.txt");
                        for (int i = 0; i < n; i++) {
                            fw.write(allMovies[i] + "\n");
                        }
                        fw.close();
                        System.out.println("Movie modified successfully!");
                    } else {
                        System.out.println("Movie ID not found.");
                    }
                    break;
                }

                case 4:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}