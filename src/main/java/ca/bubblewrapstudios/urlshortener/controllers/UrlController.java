package ca.bubblewrapstudios.urlshortener.controllers;

import ca.bubblewrapstudios.urlshortener.service.UrlShortenerService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping("/url")
public class UrlController {

    @Inject
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
