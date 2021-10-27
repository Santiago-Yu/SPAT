    public HttpResponse fetch(HttpServletRequest request) throws IOException {
        GUI = SwingUI.getApplicatoin();
        DefaultHttpClient httpclient = new DefaultHttpClient();
        CookieSpecFactory csf = new CookieSpecFactory() {

            public CookieSpec newInstance(HttpParams params) {
                return new BrowserCompatSpec() {

                    @Override
                    public void validate(Cookie cookie, CookieOrigin origin) throws MalformedCookieException {
                    }
                };
            }
        };
        if (Helper.useProxy()) {
            HttpHost proxy = new HttpHost(Helper.getProxyServer(), Helper.getProxyPort());
            httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
        }
        httpclient.getCookieSpecs().register("easy", csf);
        httpclient.getParams().setParameter(ClientPNames.COOKIE_POLICY, "easy");
        String currentRemoteGAEHost = Helper.getRemoteServer();
        try {
            HttpUriRequest httpRequest = createRequest(request);
            addHeader(request, httpRequest);
            HttpResponse response = httpclient.execute(httpRequest);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_FORBIDDEN) {
                challengeProxy(currentRemoteGAEHost);
            }
            logger.info(Helper.count.incrementAndGet() + " Response received from " + request.getRequestURL().toString() + ", status is " + response.getStatusLine());
            GUI.updateFetchCount();
            return response;
        } catch (ClientProtocolException e) {
            logger.error("Fetch ClientProtocol Error", e);
            throw e;
        } catch (IOException e) {
            logger.error("Fetch IO Error", e);
            throw e;
        }
    }
