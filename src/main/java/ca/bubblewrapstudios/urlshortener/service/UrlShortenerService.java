package ca.bubblewrapstudios.urlshortener.service;

import ca.bubblewrapstudios.urlshortener.model.Url;

public interface UrlShortenerService {

    Url simpleShortenUrl(String url);

}
