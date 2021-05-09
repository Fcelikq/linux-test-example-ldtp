package Tests;

import com.cobra.ldtp.Ldtp;
import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ScreenShot {

    public static File getScreenshot(Ldtp ldtp){
        String temp = ldtp.imageCapture(0,0,1920,1080);
        File source = new File(temp);
        File dest = new File(System.getProperty("user.dir")+"/Screenshots/"+temp.substring(10,20)+".png");

        try{
            Files.copy(source.toPath(),dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.delete(source.toPath());
        }catch (Exception e){
            e.printStackTrace();
        }
        return dest;
    }
    public static String encodeFileToBase64Binary(File file){
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encodedfile;
    }
}
