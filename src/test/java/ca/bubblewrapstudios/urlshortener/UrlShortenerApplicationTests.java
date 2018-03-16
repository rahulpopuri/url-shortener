package ca.bubblewrapstudios.urlshortener;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UrlShortenerApplicationTests {

    @LocalServerPort
    private int port;

    private URL base;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/url");
    }

    @Autowired
    private TestRestTemplate template;

    @Test
    public void testShortener() throws Exception {
        String original = "http://www.google.com";

        String shortUrl = template.postForEntity(base.toString(), original, String.class).getBody();

        assertThat(shortUrl).isNotBlank();

        String responseUrl = template.getForEntity(base.toString() + "/" + shortUrl, String.class).getBody();
        assertThat(responseUrl).isNotBlank();

        assertEquals(responseUrl, original);

    }

}
