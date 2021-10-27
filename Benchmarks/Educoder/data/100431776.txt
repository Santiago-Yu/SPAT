    @Override
    public List<SearchResult> search(String query, SortOrder order, int maxResults) throws Exception {
        if (query == null) {
            return null;
        }
        String encodedQuery = "";
        try {
            encodedQuery = URLEncoder.encode(query, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw e;
        }
        final int startAt = 0;
        final int pageNr = (startAt - 1) / 30;
        final String url = String.format(QUERYURL, encodedQuery, String.valueOf(pageNr), (order == SortOrder.BySeeders ? SORT_SEEDS : SORT_COMPOSITE));
        HttpParams httpparams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpparams, CONNECTION_TIMEOUT);
        HttpConnectionParams.setSoTimeout(httpparams, CONNECTION_TIMEOUT);
        DefaultHttpClient httpclient = new DefaultHttpClient(httpparams);
        httpclient.getParams().setParameter("http.useragent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
        HttpGet httpget = new HttpGet(url);
        HttpResponse response = httpclient.execute(httpget);
        InputStream instream = response.getEntity().getContent();
        String html = HttpHelper.ConvertStreamToString(instream);
        instream.close();
        return parseHtml(html);
    }
