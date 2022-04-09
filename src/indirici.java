
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class indirici {
    arayuz ara = new arayuz();
    public String format(String link) {
        
        ProcessBuilder pb = new ProcessBuilder();//%(title)s-%(id)s.%(ext)s
        pb.command("cmd.exe", "/c", "youtube-dl -F "+link);
        String a="";
        try {
            
            Process p = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            int i=0;
            while ((line = reader.readLine()) != null) {
                i++;
                System.out.println(line);
                a +="\n"+line;
                
            }
            int exitCode = p.waitFor();
            System.out.println("\nExited with error code : " + exitCode);
        } catch (IOException | InterruptedException e) {
        }
        return a;
        
    }
    public void indirme(String cod,String ling){
       
        
        ProcessBuilder pb = new ProcessBuilder();

        pb.command("cmd.exe", "/c", "youtube-dl -f "+cod+" "+ling );
        try {
            Process p = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                
                ara.barstr(line);
                System.out.println(line);
            }
            int exitCode = p.waitFor();
            System.out.println("\nExited with error code : " + exitCode);
        } catch (IOException | InterruptedException e) {
        }
        
        
    }
    public void indirme(String cod,String ling,String yol){
       
        
        ProcessBuilder pb = new ProcessBuilder();

        pb.command("cmd.exe", "/c", "youtube-dl -f "+cod+" "+ling+" "+"-o"+" "+yol+"/"+"%(title)s-%(id)s.%(ext)s" );
        try {
            Process p = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                
                ara.barstr(line);
                System.out.println(line);
            }
            int exitCode = p.waitFor();
            System.out.println("\nExited with error code : " + exitCode);
        } catch (IOException | InterruptedException e) {
        }
        
        
    }
}
