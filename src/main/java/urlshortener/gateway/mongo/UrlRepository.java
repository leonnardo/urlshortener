package urlshortener.gateway.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import urlshortener.domain.ShortUrl;

/**
 * Created by leonnardo on 21/04/17.
 */
public interface UrlRepository extends MongoRepository<ShortUrl, String> {

    public ShortUrl findByShortUrl(String shortUrl);

}
