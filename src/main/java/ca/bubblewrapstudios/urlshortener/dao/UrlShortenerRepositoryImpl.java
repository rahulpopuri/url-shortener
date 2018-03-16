package ca.bubblewrapstudios.urlshortener.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UrlShortenerRepositoryImpl implements UrlShortenerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${sql.url.select}")
    private String getUrl;

    @Override
    public int addNewUrl(String url) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("url", url);
        return new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("urls")
                .usingGeneratedKeyColumns("id")
                .executeAndReturnKey(parameters).intValue();
    }

    @Override
    public String getUrl(int id) {
        List<String> result = jdbcTemplate.query(getUrl, new Object[]{id}, (rs, rowNum) -> rs.getString("url"));
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }
}
