package ca.bubblewrapstudios.urlshortener.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Url {

    @Id
    @GeneratedValue
    private Long id;
    private String shortUrl;
    private String url;
    private Date created = new Date();

}
