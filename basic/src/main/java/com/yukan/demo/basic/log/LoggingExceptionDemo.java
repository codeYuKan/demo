package com.yukan.demo.basic.log;

import lombok.extern.slf4j.Slf4j;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @author yukan
 * @date 2020/9/24
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class LoggingExceptionDemo {
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch(LoggingException e) {
            System.err.println("Caught " + e);
        }
        try {
            throw new LoggingException();
        } catch(LoggingException e) {
            System.err.println("Caught " + e);
        }
    }
}

class LoggingException extends Exception {
    private static final long serialVersionUID = 4693723141098817402L;
    private static Logger logger =
            Logger.getLogger("LoggingException");
    LoggingException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
