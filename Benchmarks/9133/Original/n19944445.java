class n19944445{
        protected boolean hasOsmTileETag(String eTag) throws IOException {
            URL url;
            url = new URL(tile.getUrl());
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            prepareHttpUrlConnection(urlConn);
            urlConn.setRequestMethod("HEAD");
            urlConn.setReadTimeout(30000);
            String osmETag = urlConn.getHeaderField("ETag");
            if (osmETag == null) return true;
            return (osmETag.equals(eTag));
        }

}