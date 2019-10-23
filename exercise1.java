import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public class exercise1 {
    public static void main(String[] args) {       
        readFullDirectory(args[0]);
    }

    //Pre-condition: Use quotation marks if your path has a space in it. Accepts full path
    public static void readFullDirectory(String path) {
        try (Stream<Path> paths = Files.walk(Paths.get(path))) {
            paths.sorted(Comparator.comparing(f -> f.toFile().length(), Comparator.reverseOrder())).forEach(
                filePath -> {
                    try{
                    System.out.print(filePath + " ");
                    System.out.println(Files.size(filePath) + "b");
                    }catch (IOException e){
                        System.out.println(e);
                    }
                }
            );
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}