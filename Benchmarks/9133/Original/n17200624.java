class n17200624{
    public void run() {
        runCounter++;
        try {
            LOGGER.info("Fetching feed [" + runCounter + "] " + _feedInfo);
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpContext localContext = new BasicHttpContext();
            disableSSLCertificateChecking(httpClient);
            if (_proxy != null && _feedInfo.getUseProxy()) {
                LOGGER.info("Configuring proxy " + _proxy);
                httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, _proxy);
            }
            if (_feedInfo.getUsername() != null) {
                Credentials credentials;
                if (_feedInfo.getUsername().contains("/")) {
                    String username = _feedInfo.getUsername().substring(_feedInfo.getUsername().indexOf("/") + 1);
                    String domain = _feedInfo.getUsername().substring(0, _feedInfo.getUsername().indexOf("/"));
                    String workstation = InetAddress.getLocalHost().getHostName();
                    LOGGER.info("Configuring NT credentials : username=[" + username + "] domain=[" + domain + "] workstation=[" + workstation + "]");
                    credentials = new NTCredentials(username, _feedInfo.getPassword(), workstation, domain);
                    httpClient.getAuthSchemes().register("ntlm", new NTLMSchemeFactory());
                    httpClient.getCredentialsProvider().setCredentials(AuthScope.ANY, credentials);
                } else {
                    credentials = new UsernamePasswordCredentials(_feedInfo.getUsername(), _feedInfo.getPassword());
                    LOGGER.info("Configuring Basic credentials " + credentials);
                    httpClient.getCredentialsProvider().setCredentials(AuthScope.ANY, credentials);
                }
            }
            if (_feedInfo.getCookie() != null) {
                BasicClientCookie cookie = new BasicClientCookie(_feedInfo.getCookie().getName(), _feedInfo.getCookie().getValue());
                cookie.setVersion(0);
                if (_feedInfo.getCookie().getDomain() != null) cookie.setDomain(_feedInfo.getCookie().getDomain());
                if (_feedInfo.getCookie().getPath() != null) cookie.setPath(_feedInfo.getCookie().getPath());
                LOGGER.info("Adding cookie " + cookie);
                CookieStore cookieStore = new BasicCookieStore();
                cookieStore.addCookie(cookie);
                localContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
            }
            HttpGet httpget = new HttpGet(_feedInfo.getUrl());
            HttpResponse response = httpClient.execute(httpget, localContext);
            LOGGER.info("Response Status : " + response.getStatusLine());
            LOGGER.debug("Headers : " + Arrays.toString(response.getAllHeaders()));
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                LOGGER.error("Request was unsuccessful for " + _feedInfo + " : " + response.getStatusLine());
            } else {
                SyndFeedInput input = new SyndFeedInput();
                XmlReader reader = new XmlReader(response.getEntity().getContent());
                SyndFeed feed = input.build(reader);
                if (feed.getTitle() != null) _feedInfo.setTitle(feed.getTitle());
                LOGGER.debug("Feed : " + new SyndFeedOutput().outputString(feed));
                LOGGER.info("Feed [" + feed.getTitle() + "] contains " + feed.getEntries().size() + " entries");
                @SuppressWarnings("unchecked") List<SyndEntry> entriesList = feed.getEntries();
                Collections.sort(entriesList, new SyndEntryPublishedDateComparator());
                for (SyndEntry entry : entriesList) {
                    if (VisitedEntries.getInstance().isAlreadyVisited(entry.getUri())) {
                        LOGGER.debug("Already received " + entry.getUri());
                    } else {
                        _feedInfo.addEntry(entry);
                        LOGGER.debug("New entry " + entry.toString());
                        _entryDisplay.displayEntry(feed, entry, firstRun);
                    }
                }
                LOGGER.info("Completing entries for feed " + feed.getTitle());
                if (firstRun) firstRun = false;
            }
        } catch (IllegalArgumentException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (FeedException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (KeyManagementException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

}