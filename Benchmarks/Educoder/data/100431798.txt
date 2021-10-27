    private BingResponse queryBing(BingRequest request) throws BingException {
        try {
            if (logger.isDebugEnabled()) {
                logger.debug("Searching through bing...");
            }
            String query = request.getQuery();
            query = URLEncoder.encode(query, "UTF-8");
            URL url = new URL("http://api.bing.net/json.aspx?" + "AppId=" + request.getAppId() + "&Query=" + query + "&Sources=" + request.getType().toString());
            URLConnection connection = null;
            if (useProxy) {
                if (proxyType == null) {
                    throw new BingException("Please set a proxy first before trying to connect through a proxy", new Throwable());
                }
                connection = ProxyWrapper.getURLConnection(url.toString(), proxyType.toString(), proxyHost, proxyPort);
            } else {
                connection = new URL(url.toString()).openConnection();
            }
            String line;
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            String response = builder.toString();
            ResponseParser parser = new ResponseParser();
            parser.getError(response);
            return parser.getResults(response);
        } catch (MalformedURLException e) {
            logger.error(e);
            throw new ConnectionException("Could not connect to host", e);
        } catch (IOException e) {
            logger.error(e);
            throw new ConnectionException("Could not connect to host", e);
        }
    }
