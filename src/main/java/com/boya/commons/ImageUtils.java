package com.boya.commons;

import com.github.moor.ActionContext;
import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ImageUtils {

    public static String createImage(String base64str, String filepath,
                                     String name) throws IOException {

//		String attachPath = InitializerServlet.getContextBean().getString(
//				"attachPath");
        //String path = Conf.storagepath;
        byte[] bs = Base64.decodeBase64(base64str);
        File f = new File(filepath);
        if (!f.exists())
            f.mkdirs();
        OutputStream out = new FileOutputStream(filepath + File.separator + name);
        out.write(bs);
        out.flush();
        out.close();

        return filepath + File.separator + name;
    }

    public static void createImage(String base64str, String fileUrl) throws IOException {
        byte[] bs = Base64.decodeBase64(base64str);
        File file = new File(fileUrl);
        if (!new File(file.getParent()).exists()) {
            new File(file.getParent()).mkdirs();
        }
        // FileUtils.writeStringToFile(new File(fileUrl),base64str,"UTF-8",false);
        OutputStream out = new FileOutputStream(fileUrl);
        out.write(bs);
        out.flush();
        out.close();
    }

    public static String createImage(byte[] bs, String filepath,
                                     String name) throws IOException {

        String attachPath = (String) ActionContext.getContext().getConfiguration().get("attachPath");
        File f = new File(attachPath + File.separator + filepath);
        if (!f.exists())
            f.mkdirs();
        OutputStream out = new FileOutputStream(attachPath + File.separator
                + filepath + File.separator + name);
        out.write(bs);
        out.flush();
        out.close();

        return filepath + File.separator + name;
    }

    public static void deleteImage(String filepath,
                                   String name) throws IOException {
        String attachPath = (String) ActionContext.getContext().getConfiguration().get("attachPath");
        File file = new File(attachPath + File.separator + filepath + File.separator + name);
        if (file.exists()) {
            file.delete();
        }
    }

    public static void deleteImage(String files) throws IOException {
        String attachPath = (String) ActionContext.getContext().getConfiguration().get("root");
        File file = new File(attachPath + files);
        if (file.exists()) {
            file.delete();
        }
    }
}
