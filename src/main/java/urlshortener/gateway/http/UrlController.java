package urlshortener.gateway.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import urlshortener.domain.ShortUrl;
import urlshortener.domain.UrlJson;
import urlshortener.usecases.AddShortUrl;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by leonnardo on 21/04/17.
 */
@RestController
public class UrlController {

    private AddShortUrl addShortUrlService;

    @Autowired
    public UrlController(AddShortUrl addShortUrlService) {
        this.addShortUrlService = addShortUrlService;
    }

    @RequestMapping(value = "/", method = POST)
    public ShortUrl addShortUrl(@RequestBody UrlJson url) {
        return addShortUrlService.execute(url);
    }

}
