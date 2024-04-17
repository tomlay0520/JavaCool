package util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.logging.Logger;

public class FileHelper {
    private static final Logger logger = Logger.getLogger("FileHelper");

    // 检查路径是否为空
    private static void checkPath(Path path) throws IllegalArgumentException {
        if (path == null) {
            throw new IllegalArgumentException("Path cannot be null");
        }
    }

    // 查看文件或目录是否存在
    public static boolean isExist(Path path) {
        checkPath(path);
        return Files.exists(path);
    }

    public static boolean createFolder(Path path) throws IOException {
        checkPath(path);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
        return true;
    }

    public static boolean createFile(Path path, String code, String suffix) throws IOException {
        checkPath(path);
        Path filePath = path.resolve("Main" + "." + suffix);
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }
        Files.write(filePath, Arrays.asList(code), StandardCharsets.UTF_8);
        return true;
    }

    private static Path getRootPath() {
        return Paths.get("").toAbsolutePath();
    }

    public static Path getDataPath() {
        return getRootPath().resolve("data");
    }

}
