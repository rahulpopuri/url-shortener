package ca.bubblewrapstudios.urlshortener.service;

import ca.bubblewrapstudios.urlshortener.dao.UrlShortenerRepository;
import ca.bubblewrapstudios.urlshortener.util.UrlShortener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {

    @Autowired
    private UrlShortenerRepository urlShortenerRepository;

    @Override
    public String retrieveUrl(String shortUrl) {
        int id = UrlShortener.decode(shortUrl);
        if (id < 0) {
            return "URL not found";
        }
        return urlShortenerRepository.getUrl(id);
    }

    @Override
    public String shortenUrl(String url) {
        if (!ResourceUtils.isUrl(url)) {
            return "Not a valid url: " + url;
        }
        return UrlShortener.encode(urlShortenerRepository.addNewUrl(url));
    }

}
