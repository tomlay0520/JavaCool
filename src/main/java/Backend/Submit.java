package main.java.Backend;

import Judger.compile.Compiler;
import Judger.run.Runner;
import util.FileHelper;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

public class Submit {
    private final static Logger logger = Logger.getLogger("Submit");

    public static String go(long time, int index, String code) {
        // TODO
        // 验证index是否小于总题数
        try {
            Path folderPath = FileHelper.getDataPath().resolve(String.valueOf(time));
            if (FileHelper.createFolder(folderPath)) {
                if (FileHelper.createFile(folderPath, code, "java")) {
                    Path compilePath = folderPath.resolve("Main.java");
                    String compileResult = Compiler.compile(compilePath);
                    // 查看是否有.class文件
                    Path classPath = folderPath.resolve("Main.class");
                    if (FileHelper.isExist(classPath)) {
                        return Runner.run(classPath);
                    } else {
                        return compileResult;
                    }
                }
            }
//            if (FileHelper.createFolder(time)) {
//                if (FileHelper.createFile(time, code, "java")) {
//                    Path compilePath=FileHelper.getDataPath().resolve(time).resolve()
//                    return Compiler.compile()
//                }
//            }
        } catch (IOException e) {
            logger.warning("Failed to create Folder or File: " + e.getMessage());
        }
        return "Inner Error!";
    }
}
