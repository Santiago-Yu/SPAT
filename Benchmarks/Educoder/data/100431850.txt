    @Override
    public byte[] download(URI uri) throws NetworkException {
        log.info("download: " + uri);
        HttpGet httpGet = new HttpGet(uri.toString());
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            return EntityUtils.toByteArray(httpResponse.getEntity());
        } catch (IOException e) {
            throw new NetworkException(e);
        } finally {
            httpGet.abort();
        }
    }
