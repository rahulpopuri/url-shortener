package ca.bubblewrapstudios.urlshortener.dao;

public interface UrlShortenerRepository {

    int addNewUrl(String url);

    String getUrl(int id);
}
