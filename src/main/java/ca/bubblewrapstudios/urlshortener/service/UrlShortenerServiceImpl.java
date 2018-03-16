package ca.bubblewrapstudios.urlshortener.service;

import ca.bubblewrapstudios.urlshortener.model.Url;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {
    private static Long simpleCounter = 0L;


    /**
     * Simple 'shortener' - returns a url ending with an auto incremented counter
     *
     * @param urlToShorten
     * @return Url
     */
    @Override
    public Url simpleShortenUrl(String urlToShorten) {
        simpleCounter++;
        Url url = new Url();
        url.setUrl(urlToShorten);
        url.setShortUrl(getBaseEnvLinkURL() + "/" + simpleCounter);
        return url;
    }

    private String getBaseEnvLinkURL() {
        String baseEnvLinkURL;
        HttpServletRequest currentRequest =
                ((ServletRequestAttributes) RequestContextHolder.
                        currentRequestAttributes()).getRequest();
        // lazy about determining protocol but can be done too
        baseEnvLinkURL = "http://" + currentRequest.getLocalName();
        if (currentRequest.getLocalPort() != 80) {
            baseEnvLinkURL += ":" + currentRequest.getLocalPort();
        }
        if (!StringUtils.isEmpty(currentRequest.getContextPath())) {
            baseEnvLinkURL += currentRequest.getContextPath();
        }
        return baseEnvLinkURL;
    }
}
