        public HttpResponseExchange execute() throws Exception {
            HttpResponseExchange forwardResponse = null;
            int fetchSizeLimit = Config.getInstance().getFetchLimitSize();
            while (null != lastContentRange) {
                forwardRequest.setBody(new byte[0]);
                ContentRangeHeaderValue old = lastContentRange;
                long sendSize = fetchSizeLimit;
                if (old.getInstanceLength() - old.getLastBytePos() - 1 < fetchSizeLimit) {
                    sendSize = (old.getInstanceLength() - old.getLastBytePos() - 1);
                }
                if (sendSize <= 0) {
                    break;
                }
                lastContentRange = new ContentRangeHeaderValue(old.getLastBytePos() + 1, old.getLastBytePos() + sendSize, old.getInstanceLength());
                forwardRequest.setHeader(HttpHeaders.Names.CONTENT_RANGE, lastContentRange);
                forwardRequest.setHeader(HttpHeaders.Names.CONTENT_LENGTH, String.valueOf(sendSize));
                forwardResponse = syncFetch(forwardRequest);
                if (sendSize < fetchSizeLimit) {
                    lastContentRange = null;
                }
            }
            return forwardResponse;
        }
