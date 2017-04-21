package urlshortener.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;

/**
 * Created by leonnardo on 21/04/17.
 */

@Getter
public class ShortUrl {

    @Id
    private String id;

    private String shortUrl;

    private String redirectUrl;

    public ShortUrl(String shortUrl, String redirectUrl) {
        this.shortUrl = shortUrl;
        this.redirectUrl = redirectUrl;
    }
}
