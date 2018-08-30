package glitch.api;

import java.lang.reflect.ParameterizedType;

public class Router<R> {
    private final BaseURL url;
    private final HttpMethod method;
    private final Class<R> responseType;

    @SuppressWarnings("unchecked")
    public Router(HttpMethod method, BaseURL url) {
        this.method = method;
        this.url = url;
        this.responseType = (Class<R>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Router(HttpMethod method, BaseURL url, Class<R> responseType) {
        this.method = method;
        this.url = url;
        this.responseType = responseType;
    }

    public HttpRequest<R> request(Object... parameters) {
        return new HttpRequest<>(method, url.generate(parameters), responseType);
    }
}