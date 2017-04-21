package urlshortener.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urlshortener.domain.ShortUrl;
import urlshortener.domain.UrlJson;
import urlshortener.gateway.mongo.UrlRepository;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

/**
 * Created by leonnardo on 21/04/17.
 */
@Service
public class AddShortUrl {

    private UrlRepository repository;

    @Autowired
    public AddShortUrl(UrlRepository repository) {
        this.repository = repository;
    }

    public ShortUrl execute(final UrlJson url) {
        final String shortUrl = randomAlphanumeric(6);
        ShortUrl newShortUrl = new ShortUrl(shortUrl, url.getUrl());
        return repository.save(newShortUrl);
    }
}
