package com.yukan.demo.basic.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yukan
 * @date 2020/9/25
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class DynamicFieldsDemo {
    private Object[][] fields;

    public DynamicFieldsDemo(int initialSize) {
        fields = new Object[initialSize][2];
        for (int i = 0; i < initialSize; i++)
            fields[i] = new Object[]{null, null};
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object[] obj : fields) {
            result.append(obj[0]);
            result.append(": ");
            result.append(obj[1]);
            result.append("\n");
        }
        return result.toString();
    }

    private int hasField(String id) {
        for (int i = 0; i < fields.length; i++)
            if (id.equals(fields[i][0]))
                return i;
        return -1;
    }

    private int getFieldNumber(String id)
            throws NoSuchFieldException {
        int fieldNum = hasField(id);
        if (fieldNum == -1)
            throw new NoSuchFieldException();
        return fieldNum;
    }

    private int makeField(String id) {
        for (int i = 0; i < fields.length; i++)
            if (fields[i][0] == null) {
                fields[i][0] = id;
                return i;
            }
// No empty fields. Add one:
        Object[][] tmp = new Object[fields.length + 1][2];
        for (int i = 0; i < fields.length; i++)
            tmp[i] = fields[i];
        for (int i = fields.length; i < tmp.length; i++)
            tmp[i] = new Object[]{null, null};
        fields = tmp;
// Recursive call with expanded fields:
        return makeField(id);
    }

    public Object
    getField(String id) throws NoSuchFieldException {
        return fields[getFieldNumber(id)][1];
    }

    public Object setField(String id, Object value)
            throws DynamicFieldsException {
        if (value == null) {
// Most exceptions don't have a "cause"
// constructor. In these cases you must use
// initCause(), available in all
// Throwable subclasses.
            DynamicFieldsException dfe =
                    new DynamicFieldsException();
            dfe.initCause(new NullPointerException());
            throw dfe;
        }
        int fieldNumber = hasField(id);
        if (fieldNumber == -1)
            fieldNumber = makeField(id);
        Object result = null;
        try {
            result = getField(id); // Get old value
        } catch (NoSuchFieldException e) {
// Use constructor that takes "cause":
            throw new RuntimeException(e);
        }
        fields[fieldNumber][1] = value;
        return result;
    }

    public static void main(String[] args) {
        DynamicFieldsDemo df = new DynamicFieldsDemo(3);
        System.out.println(df);
        try {
            df.setField("d", "A value for d");
            df.setField("number", 47);
            df.setField("number2", 48);
            System.out.println(df);
            df.setField("d", "A new value for d");
            df.setField("number3", 11);
            System.out.println("df: " + df);
            System.out.println("df.getField(\"d\") : "
                    + df.getField("d"));
            Object field =
                    df.setField("d", null); // Exception
        } catch (NoSuchFieldException |
                DynamicFieldsException e) {
            e.printStackTrace(System.out);
        }
    }
}

class DynamicFieldsException extends Exception {}
