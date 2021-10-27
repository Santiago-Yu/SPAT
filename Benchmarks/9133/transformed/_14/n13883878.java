class n13883878 {
	PathElement(String path) throws MaxError {
            this.path = path;
            if (path.startsWith("http:")) {
                try {
                    url = new URL(path);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("HEAD");
                    valid = (HttpURLConnection.HTTP_OK == con.getResponseCode());
                } catch (Exception e) {
                    valid = false;
                }
            } else {
                if (path.startsWith("jmax:")) file = new File(Registry.resolveJMaxURI(path)); else file = new File(path);
                valid = file.exists();
            }
        }

}