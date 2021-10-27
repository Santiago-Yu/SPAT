class n19235553{
    protected BufferedImage handleNLIBException() {
        if (params.uri.startsWith("http://digar.nlib.ee/otsing/") || params.uri.startsWith("http://digar.nlib.ee/show")) try {
            String url = "http://digar.nlib.ee/gmap/nd" + params.uri.substring(params.uri.indexOf(":") + 1, params.uri.lastIndexOf("&")) + "-tiles/z0x0y0.jpeg";
            URLConnection connection = new URL(url).openConnection();
            return processNewUri(connection);
        } catch (Exception e) {
            try {
                if (params.uri.startsWith("http://digar.nlib.ee/show")) params.uri = "http://digar.nlib.ee/otsing/?pid=" + params.uri.substring(params.uri.lastIndexOf("/") + 1) + "&show";
                URLConnection connection = new URL(params.uri).openConnection();
                String url = params.uri;
                if (url.endsWith("&show")) url = url.substring(0, url.length() - 5);
                int index = url.lastIndexOf("?");
                url = "stream" + url.substring(index);
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String aux = null;
                while ((aux = reader.readLine()) != null) {
                    index = aux.indexOf(url);
                    if (index != -1) {
                        url = "http://digar.nlib.ee/otsing/" + aux.substring(index);
                        index = url.indexOf('>');
                        if (index == -1) index = url.indexOf("\"");
                        url = url.substring(0, index);
                        break;
                    }
                }
                connection = new URL(url).openConnection();
                return processNewUri(connection);
            } catch (Exception e2) {
            }
        }
        return null;
    }

}