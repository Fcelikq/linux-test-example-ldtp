package Tests;

import com.cobra.ldtp.Ldtp;
import org.testng.annotations.*;

public class TestExample {
    protected static Ldtp ldtp;


    @BeforeTest
    public void Setup() {
            try {
                ldtp = new Ldtp("*-appName");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

   @Test
   public void test1() throws InterruptedException {
    clickElementByLocation(200,300);
    sendKeyboardKey("ENTER");
    sendKeys("selam");
    getScreenShot();
   }

    @AfterSuite
    public void tearDown() {
    ldtp.closeWindow("appName");
    }






    static void clickElementByLocation(int x , int y) throws InterruptedException {
        Thread.sleep(1000);
        ldtp.generateMouseEvent(x,y,"b1c");
    }

    static void sendKeys(String data) throws InterruptedException {
        Thread.sleep(1000);
        ldtp.enterString(data);
    }
    static void sendKeyboardKey(String key) throws InterruptedException {
        Thread.sleep(1000);
        ldtp.keyRelease("<"+key+">");
        ldtp.keyPress("<"+key+">");
    }

    static void getScreenShot() {
        String encodstring = ScreenShot.encodeFileToBase64Binary(ScreenShot.getScreenshot(ldtp));
    }

}
