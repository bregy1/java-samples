
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements ILogger {

    private BufferedWriter writer = null;
    private final String lineSep = System.lineSeparator();

    @Override
    public void println(String data) {
        try {
            this.writer.write(data + this.lineSep);
            this.writer.flush();
        } catch (IOException ex) {
            System.err.println("Failed to log to file. " + ex.getMessage() + "\nMessage: " + data);
        }
    }


    @Override
    public void errorln(String error) {
         try {
            this.writer.write("Error: " + error + this.lineSep);
            this.writer.flush();
        } catch (IOException ex) {
            System.err.println("Failed to log to file. " + ex.getMessage() + "\nError: " + error);
        }
    }

    public void close() {

        if(this.writer == null) {
            return;
        }

        try {
            this.writer.close();
        } catch (IOException e) {
            System.err.println("Failed to close Logger.." + e.getMessage());
        }
    }

    public FileLogger(String filename) {
        try {
            boolean append  = true;
            this.writer = new BufferedWriter(new FileWriter(filename, append));
        } catch (IOException e) {
            System.err.println("Failed to open log file." + e.getMessage());
        }
    }
}

