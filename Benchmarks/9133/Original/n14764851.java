class n14764851{
    public Download doDownload(HttpHeader[] headers, URI target) throws HttpRequestException {
        HttpRequest<E> con = createConnection(HttpMethods.METHOD_GET, target);
        if (defaultHeaders != null) {
            putHeaders(con, defaultHeaders);
        }
        if (headers != null) {
            putHeaders(con, headers);
        }
        HttpResponse<?> res = execute(con);
        if (res.getResponseCode() == 200) {
            return new Download(res);
        } else {
            throw new HttpRequestException(res.getResponseCode(), res.getResponseMessage());
        }
    }

}