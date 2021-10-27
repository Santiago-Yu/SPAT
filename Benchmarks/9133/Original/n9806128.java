class n9806128{
    private void _readValuesFromNetwork() {
        if (_intrinsicValuesByAttribute == null) {
            NSMutableDictionary<String, Object> values = new NSMutableDictionary<String, Object>(3);
            values.setObjectForKey(Boolean.FALSE, "NetworkFailure");
            try {
                URLConnection connection = url().openConnection();
                if (connection instanceof HttpURLConnection) {
                    HttpURLConnection httpconnect = (HttpURLConnection) connection;
                    httpconnect.setRequestMethod("HEAD");
                    switch(httpconnect.getResponseCode()) {
                        case HttpURLConnection.HTTP_OK:
                        case HttpURLConnection.HTTP_MOVED_PERM:
                        case HttpURLConnection.HTTP_MOVED_TEMP:
                        case HttpURLConnection.HTTP_NOT_MODIFIED:
                            values.setObjectForKey(Boolean.TRUE, MD.FSExists);
                            break;
                        default:
                            values.setObjectForKey(Boolean.FALSE, MD.FSExists);
                    }
                    LOG.info("_readValuesFromNetwork: " + httpconnect.toString());
                    values.setObjectForKey(new NSTimestamp(httpconnect.getLastModified()), MD.FSContentChangeDate);
                    values.setObjectForKey(new Integer(httpconnect.getContentLength()), MD.FSSize);
                } else {
                    values.setObjectForKey(Boolean.FALSE, MD.FSExists);
                }
            } catch (Exception x) {
                values.setObjectForKey(Boolean.FALSE, MD.FSExists);
                values.setObjectForKey(Boolean.TRUE, "NetworkFailure");
            }
            _intrinsicValuesByAttribute = values;
        }
    }

}