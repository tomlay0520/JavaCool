package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class CMD {
    private final static Logger logger = Logger.getLogger("CMD");

    public static String execute(String[] cmd) {
        StringBuilder result = new StringBuilder();
        int exitCode = -1;
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            try (BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
                 BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
                String s;
                while ((s = stdInput.readLine()) != null) {
                    result.append(s).append("\n");
                }
                while ((s = stdError.readLine()) != null) {
                    result.append(s).append("\n");
                }
                exitCode = process.waitFor();
            }
        } catch (Exception e) {
            throw new RuntimeException("CMD: " + cmd + " error: " + e.getMessage(), e);
        }
        if (exitCode != 0) {
            logger.warning("CMD: " + cmd + " exit code: " + exitCode);
        }
        return result.toString();
    }
}
