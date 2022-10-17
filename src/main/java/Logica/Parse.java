package Logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parse {
    public Parse (){}

    public String parseDocument(File file, String searching) throws FileNotFoundException {
        String mensaje = "";
        if (getFileExtension(file).equals(".txt")){
            mensaje = parseTxt(file,searching);
        }else if (getFileExtension(file).equals(".pdf")){
            mensaje = parsePdf(file);
        }else if (getFileExtension(file).equals(".docs")){
            mensaje = parseDocs(file);
        }else {
            System.out.println("Error en parse document");
        }
        return mensaje;
    }
    public String parseTxt(File file, String searching) throws FileNotFoundException {
        String mensaje = "-";
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()){
            if (searching.equals(String.valueOf(scanner.next()))){

                mensaje = "Encontrada";
                break;
            }else {
                mensaje = "No encontrada";
            }
        }
        scanner.close();
        return mensaje;
    }
    private String parsePdf(File file){
        return file.getAbsolutePath();
    }
    private String parseDocs(File file){
        return file.getAbsolutePath();
    }

    private String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf);
    }
}
