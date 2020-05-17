package test;

import java.io.*;

/**
 * @author lei.X
 * @date 2020/2/10
 */
public class MyTestClassLoader extends ClassLoader {


    private String classLoaderName;
    private String fileExtension = ".class";

    public MyTestClassLoader(String classLoaderName){
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyTestClassLoader(ClassLoader classLoader,String classLoaderName){
        super(classLoader);
        this.classLoaderName = classLoaderName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassData(name);
        return this.defineClass(name,data,0,data.length);
    }


    private byte[] loadClassData(String name){
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        try {
            this.classLoaderName = this.classLoaderName.replace(".","/");
            is = new FileInputStream(new File(name + this.fileExtension));
            baos = new ByteArrayOutputStream();

            int  ch = 0;
            while (-1 != (ch = is.read())){
                baos.write(ch);
            }

            data = baos.toByteArray();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return data;

    }

}
