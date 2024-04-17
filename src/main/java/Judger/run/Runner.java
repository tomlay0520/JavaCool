package Judger.run;

import util.CMD;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class Runner {
    private final static Logger logger = Logger.getLogger("Runner");

    public static String run(Path path) {
        logger.info("Running " + path.toString());
        String className = "Main";
        Path folderPath = path.getParent();
        String classPath = Paths.get("").toAbsolutePath().relativize(folderPath).toString();
        String[] runCMD = {"java", "-cp", classPath, className};
        return CMD.execute(runCMD);
    }

//    public static String run(Path path, String[] args) {
//        logger.info("Running " + path.toString());
//        String className = "Main";
//        Path folderPath = path.getParent();
//        String classPath = Paths.get("").toAbsolutePath().relativize(folderPath).toString();
//        String[] runCMD = new String[args.length + 4];
//        runCMD[0] = "java";
//        runCMD[1] = "-cp";
//        runCMD[2] = classPath;
//        runCMD[3] = className;
//        System.arraycopy(args, 0, runCMD, 4, args.length);
//        return CMD.execute(runCMD);
//    }
}
