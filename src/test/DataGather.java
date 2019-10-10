package test;

import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

public class DataGather {
	
	private static final String path = "src/resource/123.txt";

    public static final String openFileStyle = "r";

    public static final String fieldLimitChar = ",";

    public static final int fieldAllCount = 3;

    private int count;

    private String classname;

    private String classteacher;

    private String classplace;


    /*

     * ���ܣ������ı��ļ�

     */

    public void loadFile() {

        try {

            RandomAccessFile raf = new RandomAccessFile(path, openFileStyle);

            String line_record = raf.readLine();

            while (line_record != null) {

                // ����ÿһ����¼

                parseRecord(line_record);

                line_record = raf.readLine();

            }

            System.out.println("���кϷ��ļ�¼" + count + "��");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

 

    /*

 * ���ܣ��������ÿһ����¼������������Ӻܶ�Լ�¼�Ľ����ж����������Ƿ�Ϊ��ĸ��

* ���֡�email�ȡ�

     */

    private void parseRecord(String line_record) throws Exception {

     //��ּ�¼

        String[] fields = line_record.split(fieldLimitChar);

        if (fields.length == fieldAllCount) {

        	classname = tranStr(fields[0]);

            classteacher = tranStr(fields[1]);

            classplace = tranStr(fields[2]);

            
            System.out.println(classname + " " + classteacher + " " + classplace);

            InsertDB db = new InsertDB();

            db.insertDB(classname, classteacher, classplace);

            count++;

        }

    }

 

    private String tranStr(String oldstr) {

        String newstr = "";

        try {

            //newstr = new String(oldstr.getBytes("ISO-8859-1"), "GBK");
            newstr = new String(oldstr.getBytes("ISO-8859-1"), "UTF-8");

        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();

        }

        return newstr;

    }

}
