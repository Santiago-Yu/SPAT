class n23241520{
    private FeedIF retrieveFeed(String uri) throws FeedManagerException {
        try {
            URL urlToRetrieve = new URL(uri);
            URLConnection conn = null;
            try {
                conn = urlToRetrieve.openConnection();
                if (conn instanceof HttpURLConnection) {
                    HttpURLConnection httpConn = (HttpURLConnection) conn;
                    httpConn.setInstanceFollowRedirects(true);
                    HttpHeaderUtils.setUserAgent(httpConn, "Informa Java API");
                    logger.debug("retr feed at url " + uri + ": ETag" + HttpHeaderUtils.getETagValue(httpConn) + " if-modified :" + HttpHeaderUtils.getLastModified(httpConn));
                    this.httpHeaders.setETag(HttpHeaderUtils.getETagValue(httpConn));
                    this.httpHeaders.setIfModifiedSince(HttpHeaderUtils.getLastModified(httpConn));
                }
            } catch (java.lang.ClassCastException e) {
                conn = null;
                logger.warn("problem cast to HttpURLConnection " + uri, e);
                throw new FeedManagerException(e);
            } catch (NullPointerException e) {
                logger.error("problem NPE " + uri + " conn=" + conn, e);
                conn = null;
                throw new FeedManagerException(e);
            }
            ChannelIF channel = null;
            channel = FeedParser.parse(getChannelBuilder(), conn.getInputStream());
            this.timeToExpire = getTimeToExpire(channel);
            this.feed = new Feed(channel);
            Date currDate = new Date();
            this.feed.setLastUpdated(currDate);
            this.feed.setDateFound(currDate);
            this.feed.setLocation(urlToRetrieve);
            logger.info("feed retrieved " + uri);
        } catch (IOException e) {
            logger.error("IOException " + feedUri + " e=" + e);
            e.printStackTrace();
            throw new FeedManagerException(e);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new FeedManagerException(e);
        }
        return this.feed;
    }

}