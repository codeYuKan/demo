package com.yukan.demo.component.tools;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author yukan
 * @date 2020/5/29
 * @email yukan.cn.mail@gmail.com
 */
public final class Directory {
    public Directory() {
    }

    public static File[] local(File dir, String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern;

            {
                this.pattern = Pattern.compile(regex);
            }

            public boolean accept(File dir, String name) {
                return this.pattern.matcher((new File(name)).getName()).matches();
            }
        });
    }

    public static File[] local(String path, String regex) {
        return local(new File(path), regex);
    }

    public static TreeInfo walk(String start, String regex) {
        return recurseDirs(new File(start), regex);
    }

    public static TreeInfo walk(File start, String regex) {
        return recurseDirs(start, regex);
    }

    public static TreeInfo walk(File start) {
        return recurseDirs(start, ".*");
    }

    public static TreeInfo walk(String start) {
        return recurseDirs(new File(start), ".*");
    }

    static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        File[] var6;
        int var5 = (var6 = startDir.listFiles()).length;

        for(int var4 = 0; var4 < var5; ++var4) {
            File item = var6[var4];
            if (item.isDirectory()) {
                result.dirs.add(item);
                result.addAll(recurseDirs(item, regex));
            } else if (item.getName().matches(regex)) {
                result.files.add(item);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(walk("."));
        } else {
            String[] var4 = args;
            int var3 = args.length;

            for(int var2 = 0; var2 < var3; ++var2) {
                String arg = var4[var2];
                System.out.println(walk(arg));
            }
        }

    }

    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList();
        public List<File> dirs = new ArrayList();

        public TreeInfo() {
        }

        public Iterator<File> iterator() {
            return this.files.iterator();
        }

        void addAll(TreeInfo other) {
            this.files.addAll(other.files);
            this.dirs.addAll(other.dirs);
        }

        public String toString() {
            return "dirs: " + PPrint.pformat(this.dirs) + "\n\nfiles: " + PPrint.pformat(this.files);
        }
    }
}

