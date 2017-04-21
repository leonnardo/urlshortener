package urlshortener.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urlshortener.gateway.mongo.UrlRepository;

/**
 * Created by leonnardo on 21/04/17.
 */
@Service
public class RedirectUrl {

    UrlRepository repository;

    @Autowired
    public RedirectUrl(UrlRepository repository) {
        this.repository = repository;
    }
}
