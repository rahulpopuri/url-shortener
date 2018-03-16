package ca.bubblewrapstudios.urlshortener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    private static Logger logger = LoggerFactory.getLogger(ApplicationStartup.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${sql.url.create}")
    private String createTable;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        logger.info("Checking tables");
        jdbcTemplate.update(createTable);
        logger.info("Table creation complete");
    }


}