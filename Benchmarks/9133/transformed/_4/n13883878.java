class n13883878 {
	PathElement(String path) throws MaxError {
            this.path = path;
            if (path.startsWith("http:")) {
                try {
                    url = new URL(path);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("HEAD");
                    valid = (con.getResponseCode() == HttpURLConnection.HTTP_OK);
                } catch (Exception e) {
                    valid = false;
                }
            } else {
                file = (path.startsWith("jmax:")) ? new File(Registry.resolveJMaxURI(path)) : new File(path);
                valid = file.exists();
            }
        }

}