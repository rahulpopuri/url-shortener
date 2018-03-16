package ca.bubblewrapstudios.urlshortener.controllers;

import ca.bubblewrapstudios.urlshortener.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/url")
public class UrlController {

    @Autowired
    private UrlShortenerService urlShortenerService;

    @RequestMapping(method = RequestMethod.GET, value = "/{url}")
    public String getUrl(@PathVariable("url") String shortUrl) {
        return urlShortenerService.retrieveUrl(shortUrl);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String shortenUrl(@RequestBody String url) {
        return urlShortenerService.shortenUrl(url);
    }
}
