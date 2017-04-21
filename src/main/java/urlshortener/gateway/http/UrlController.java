package urlshortener.gateway.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import urlshortener.domain.ShortUrl;
import urlshortener.domain.UrlJson;
import urlshortener.usecases.AddShortUrl;
import urlshortener.usecases.RedirectUrl;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by leonnardo on 21/04/17.
 */
@RestController
public class UrlController {

    private AddShortUrl addShortUrlService;

    private RedirectUrl redirectUrl;

    @Autowired
    public UrlController(AddShortUrl addShortUrlService, RedirectUrl redirectUrl) {
        this.addShortUrlService = addShortUrlService;
        this.redirectUrl = redirectUrl;
    }

    @RequestMapping(value = "/", method = POST)
    public ShortUrl addShortUrl(@RequestBody UrlJson url) {
        return addShortUrlService.execute(url);
    }

    @RequestMapping(value = "/{url}")
    public void redirect(HttpServletResponse response, @PathVariable("url") String url) throws IOException {
        ShortUrl shortUrl = redirectUrl.execute(url);
        response.sendRedirect(shortUrl.getRedirectUrl());
    }

}
