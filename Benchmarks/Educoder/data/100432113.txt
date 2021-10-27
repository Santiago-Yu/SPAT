    protected BufferedImage handleFCLAException() {
        if (params.uri.startsWith("http://image11.fcla.edu/cgi")) try {
            params.uri = params.uri.substring(params.uri.indexOf("q1=") + 3);
            params.uri = params.uri.substring(0, params.uri.indexOf("&"));
            params.uri = "http://image11.fcla.edu/m/map/thumb/" + params.uri.substring(params.uri.length() - 3, params.uri.length() - 2) + "/" + params.uri.substring(params.uri.length() - 2, params.uri.length() - 1) + "/" + params.uri.substring(params.uri.length() - 1, params.uri.length()) + "/" + params.uri + ".jpg";
            URL url = new URL(params.uri);
            URLConnection connection = url.openConnection();
            return processNewUri(connection);
        } catch (Exception e) {
        }
        return null;
    }
