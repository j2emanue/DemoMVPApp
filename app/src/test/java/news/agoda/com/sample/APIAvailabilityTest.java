package news.agoda.com.sample;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class APIAvailabilityTest {

    @Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {
    }


    @Test
    public void testAvailability() throws Exception {

        URLConnection connection = new URL("http://www.mocky.io/v2/573c89f31100004a1daa8adb").openConnection();
        InputStream response = connection.getInputStream();

        StringBuffer buffer = new StringBuffer();
        BufferedReader reader = null;
        try {

            reader = new BufferedReader(new InputStreamReader(response, Charset.defaultCharset()));
            for (String line; (line = reader.readLine()) != null; ) {
                buffer.append(line);
            }
        } catch (Exception e) {
        } finally {
            if (reader != null)
                reader.close();

            assert buffer.length() > 0;
        }
    }
}
