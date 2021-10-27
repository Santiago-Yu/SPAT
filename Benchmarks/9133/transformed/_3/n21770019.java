class n21770019 {
	protected NetQuery(String serviceURL, String query, byte queryType, String defaultGraph, int timeout) {
        String urlString = null;
        try {
            queryString = query;
            char delim = serviceURL.indexOf('?') == -1 ? '?' : '&';
            if (!(queryType == Query.UPDATE_TYPE)) {
				urlString = serviceURL + delim + "query=" + URLEncoder.encode(query, "UTF-8");
				delim = '&';
				if (defaultGraph != null)
					urlString += delim + "default-graph-uri=" + defaultGraph;
			} else
				urlString = serviceURL;
            URL url = new URL(urlString);
            conn = (HttpURLConnection) url.openConnection();
            configureConnection(query, queryType, timeout, defaultGraph);
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.toString());
            e.printStackTrace();
            System.exit(-1);
        } catch (MalformedURLException e) {
            System.err.println(e.toString() + " for URL: " + urlString);
            System.err.println(serviceURL);
            e.printStackTrace();
            System.exit(-1);
        } catch (IOException e) {
            System.err.println(e.toString());
            e.printStackTrace();
            System.exit(-1);
        }
    }

}