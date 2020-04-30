package com.yukan.demo.component.io;

import com.yukan.demo.component.process.Estimate;
import com.yukan.demo.component.process.Executor;
import com.yukan.demo.component.process.ThrowingFunction;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author yukan
 * @date 2020/4/27
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class FileUtils {

    public FileInputStream openInputStream(File file) throws IOException {
        if (file.exists()) {
            Estimate.negateEstimate(File::isDirectory, file, () -> new IOException("File '" + file + "' exists but is a directory"));
            Estimate.estimate(File::canRead, file, () -> new IOException("File '" + file + "' cannot be read"));
        } else {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        }
        return new FileInputStream(file);
    }

    @SuppressWarnings("Convert2Lambda")
    public FileOutputStream openOutputStream(File file) throws IOException {
        // 判断文件是否存在 不存在则需要判断 是否需要创建上级目录
        if (file.exists()) {
            Estimate.estimate(File::isDirectory, file, () -> new IOException("File '" + file + "' exists but is a directory"));
            Estimate.negateEstimate(File::canWrite, file, () -> new IOException("File '" + file + "' cannot be written to"));
        } else {
            File parentFile = file.getParentFile();
            Executor.executeWhen(
                    Objects::nonNull,
                    parentFile,
                    new Function<File, Void>() {
                        @Override
                        @SneakyThrows
                        public Void apply(File f) {
                            Executor.executeWithResultCheck(() -> !f.mkdirs() && !f.isDirectory(), () -> new IOException("Directory '" + f + "' could not be created"));
                            return null;
                        }
                    }
            );
        }
        return new FileOutputStream(file);
    }

    @SuppressWarnings("Convert2Lambda")
    public FileOutputStream openOutputStream2(File file) throws IOException {
        // 判断文件是否存在 不存在则需要判断 是否需要创建上级目录
        if (file.exists()) {
            Estimate.estimate(File::isDirectory, file, () -> new IOException("File '" + file + "' exists but is a directory"));
            Estimate.negateEstimate(File::canWrite, file, () -> new IOException("File '" + file + "' cannot be written to"));
        } else {
            File parentFile = file.getParentFile();
            Executor.executeWhenWithThrow(
                    Objects::nonNull,
                    parentFile,
                    f -> {
                        Executor.executeWithResultCheck(() -> !f.mkdirs() && !f.isDirectory(), () -> new IOException("Directory '" + f + "' could not be created"));
                        return null;
                    }
            );
        }
        return new FileOutputStream(file);
    }
}
