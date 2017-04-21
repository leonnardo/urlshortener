package urlshortener.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by leonnardo on 21/04/17.
 */
@Getter
@NoArgsConstructor
public class UrlJson {

    private String url;

    public UrlJson(String url) {
        this.url = url;
    }
}
