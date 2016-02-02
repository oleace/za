package com.boya.commons;

import com.github.moor.ActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Created in CYG on 14-1-25.
 *
 * @author blj
 */
public class ResLocationAction {
    public void s() throws Exception {
        HttpServletRequest req = ActionContext.getContext().getRequest();
        String res = ActionContext.getContext().getConfiguration().getString(Constant.Storage.PUBLIC) + req.getRequestURI().replaceFirst(req.getContextPath() + "/s", "");

        OutputStream os = ActionContext.getContext().getResponse().getOutputStream();
        File target = new File(res);
        if (!target.exists()) {
            os.write(("File " + res + " not found!").getBytes());
            return;
        }
        WritableByteChannel out = Channels.newChannel(os);

        ByteBuffer buf = ByteBuffer.allocate(1024);

        FileChannel fs = new FileInputStream(res).getChannel();
        while (fs.read(buf) != -1) {
            buf.flip();
            out.write(buf);
            buf.clear();
        }

        fs.close();
        os.flush();
        out.close();
    }

    public void img() throws Exception {
        HttpServletRequest r = ActionContext.getContext().getRequest();
        HttpServletResponse re = ActionContext.getContext().getResponse();
        String surl = r.getParameter("url");

        URL url = new URL(URLDecoder.decode(surl, "utf-8"));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.connect();
        InputStream rlt = con.getInputStream();
        ByteBuffer buf = ByteBuffer.allocate(512);
        ReadableByteChannel rch = Channels.newChannel(rlt);
        WritableByteChannel wch = Channels.newChannel(ActionContext.getContext().getResponse().getOutputStream());
        while (rch.read(buf) != -1) {
            buf.flip();
            wch.write(buf);
            buf.clear();
        }
        re.setHeader("Content-Type", "image/jpeg");
        re.setContentType("image/jpeg");
        rch.close();
        wch.close();
    }
}
