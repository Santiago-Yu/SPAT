    public Document index() throws CrawlingException {
        log.debug("BEGINIG indexing page [code=" + getCode() + "] ...");
        URL url = null;
        InputStream in = null;
        String contentType = null;
        try {
            url = new URL(getServer().getProtocol() + "://" + getServer().getHost() + ":" + getServer().getPort() + getPath());
            HttpURLConnection pageContent = (HttpURLConnection) url.openConnection();
            if (pageContent.getResponseCode() != HttpURLConnection.HTTP_OK) {
                log.debug("page pk[" + getCode() + "," + url.toExternalForm() + "] is invalid");
                return null;
            }
            String redireccion = pageContent.getHeaderField("location");
            if (redireccion != null) {
                log.debug("Page " + url.toExternalForm() + " redirected to " + redireccion);
                recordLink(redireccion);
                return null;
            }
            contentType = pageContent.getContentType();
            in = new BufferedInputStream(pageContent.getInputStream(), 32768);
        } catch (MalformedURLException e) {
            log.error("Invalid page address", e);
        } catch (ConnectException e) {
            if (getServer() != null) {
                log.error("Unable to connect to page: " + getServer().getProtocol() + "://" + getServer().getHost() + ":" + getServer().getPort() + getPath(), e);
            }
        } catch (UnknownHostException uhe) {
            log.warn("Unknow host indexing page " + getURL(), uhe);
        } catch (IOException e) {
            log.warn("Unable to index page " + getURL(), e);
        }
        Document doc = generateDocument(contentType, in);
        log.debug("END indexing page [code=" + getCode() + "]");
        return doc;
    }
