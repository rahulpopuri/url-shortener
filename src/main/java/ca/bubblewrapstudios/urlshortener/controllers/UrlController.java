package ca.bubblewrapstudios.urlshortener.controllers;

import ca.bubblewrapstudios.urlshortener.model.Url;
import ca.bubblewrapstudios.urlshortener.service.UrlShortenerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping("/url")
public class UrlController {

    @Inject
    private UrlShortenerService urlShortenerService;

    @RequestMapping(method = RequestMethod.GET, value = "/{url}")
    public Url getUrl(@PathVariable("url") String shortUrl) {
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Url shortenUrl(@RequestBody String url) {
        return urlShortenerService.simpleShortenUrl(url);
    }
}
