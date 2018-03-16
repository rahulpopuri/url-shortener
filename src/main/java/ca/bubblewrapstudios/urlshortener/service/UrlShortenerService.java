package ca.bubblewrapstudios.urlshortener.service;

public interface UrlShortenerService {

    /**
     * Method to retrieve original url from short url
     * 1. Decode string to integer id
     * 2. Look up id in db and return if found
     *
     * @param @String shortUrl
     * @return 'Long' url
     */
    String retrieveUrl(String shortUrl);

    /**
     * Method to shorten url
     * 1. Insert 'long' url in db, retrieve auto-increment id
     * 2. Encode generated id and return string
     *
     * @param url
     * @return 'short' url
     */
    String shortenUrl(String url);

}
