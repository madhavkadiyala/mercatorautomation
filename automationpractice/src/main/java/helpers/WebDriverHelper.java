package helpers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import static helpers.Props.loadRunConfigProps;


public class WebDriverHelper {
    private static final Logger LOG = LoggerFactory
            .getLogger(WebDriverHelper.class);
    private static WebDriver REAL_DRIVER = null;
    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
            REAL_DRIVER.quit();
        }
    };
    private static String BROWSER;
    private static String PLATFORM;
    private static String DRIVER_PATH;
    private static String FILE_SEPARATOR;
      private static final String DRIVER_ROOT = File.separator + "tools";

    static {
        loadRunConfigProps();
        FILE_SEPARATOR = System.getProperty("file.separator");
        PLATFORM = System.getProperty("os.name").toLowerCase().trim();
        BROWSER = System.getProperty("browser").toLowerCase();

        try {

            switch (BROWSER) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", getDriverPath());
                    startChromeDriver();
                    break;
                case "firefox":
                    break;
                case "iexplore":
                    break;

                default:
                    throw new IllegalArgumentException("Browser " + BROWSER + " or Platform "
                            + PLATFORM + " type not supported");

            }

        } catch (IllegalStateException e) {
            LOG.error(e.getMessage() + ". " + "FIX path for  " + DRIVER_ROOT
                    + " Browser parameter " + BROWSER + " Platform parameter " + PLATFORM
                    + " type not supported");
        }
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

    public static WebDriver getWebDriver() {
        return REAL_DRIVER;
    }

    private static String getDriverPath() {
        String userDir, path = "";
        userDir = System.getProperty("user.dir");
             try {
            if (BROWSER.equals("chrome") && PLATFORM.contains("mac")) {
                DRIVER_PATH = DRIVER_ROOT + FILE_SEPARATOR + "chromedriver"
                        + FILE_SEPARATOR + "mac" + FILE_SEPARATOR
                        + "chromedriver";
            } else if (BROWSER.equals("chrome") && PLATFORM.contains("windows")) {
                DRIVER_PATH = DRIVER_ROOT + FILE_SEPARATOR + "chromedriver"
                        + FILE_SEPARATOR + "win32" + FILE_SEPARATOR
                        + "chromedriver.exe";
            }
        } catch (Exception e) {
            LOG.error(e.getMessage() + ". " + "There is a problem in finding/executing the driver " +
                    "at the path:" + userDir + path);
        }
        return path;
    }


    private static void startChromeDriver() {
        ChromeOptions options = getChromeOptions();
        REAL_DRIVER = new ChromeDriver(options);
        REAL_DRIVER.manage().window().maximize();
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");
        options.addArguments("disable-infobars");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return options;
    }


}
