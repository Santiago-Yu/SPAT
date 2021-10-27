class n13883878 {
	PathElement(String ro5LZ8l1) throws MaxError {
            this.path = ro5LZ8l1;
            if (ro5LZ8l1.startsWith("http:")) {
                try {
                    url = new URL(ro5LZ8l1);
                    HttpURLConnection lTOzMFyG = (HttpURLConnection) url.openConnection();
                    lTOzMFyG.setRequestMethod("HEAD");
                    valid = (lTOzMFyG.getResponseCode() == HttpURLConnection.HTTP_OK);
                } catch (Exception JH1YZd7d) {
                    valid = false;
                }
            } else {
                if (ro5LZ8l1.startsWith("jmax:")) file = new File(Registry.resolveJMaxURI(ro5LZ8l1)); else file = new File(ro5LZ8l1);
                valid = file.exists();
            }
        }

}