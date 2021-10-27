    @Override
    protected <T> T execute(final HttpMethod method, final String url, Parameters parameters, final Handler<T> handler) throws FoursquareException {
        HttpURLConnection connection = null;
        try {
            switch(method) {
                case GET:
                    connection = openConnection(url.concat("?").concat(formEncode(parameters)));
                    connection.setRequestMethod("GET");
                    connection.connect();
                    break;
                case POST:
                    connection = openConnection(url);
                    connection.setRequestMethod("POST");
                    connection.setDoOutput(true);
                    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    connection.connect();
                    final OutputStream out = connection.getOutputStream();
                    out.write(formEncode(parameters).getBytes());
                    out.flush();
                    out.close();
                    break;
            }
            final int statusCode = connection.getResponseCode();
            if (statusCode / 100 != 2) {
                final Error error = parseBody(connection.getErrorStream(), new ErrorHandler());
                if (error == null) throw new FoursquareException(connection.getResponseMessage()); else if ("error".equals(error.getType())) throw new FoursquareException(error.getMessage()); else if ("unauthorized".equals(error.getType())) throw new AuthenticationException(error.getMessage()); else if ("ratelimited".equals(error.getType())) throw new RateLimitingException(error.getMessage()); else throw new FoursquareException(connection.getResponseMessage());
            }
            return parseBody(connection.getInputStream(), handler);
        } catch (final IOException e) {
            throw new FoursquareException(e);
        } catch (final ParserConfigurationException e) {
            throw new FoursquareException(e);
        } catch (final SAXException e) {
            throw new FoursquareException(e);
        } finally {
            if (connection != null) connection.disconnect();
        }
    }
