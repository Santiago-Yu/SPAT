class n16707050{
    public RandomAccessFileOrArray(URL url) throws IOException {
        InputStream is = url.openStream();
        try {
            this.arrayIn = InputStreamToArray(is);
        } finally {
            try {
                is.close();
            } catch (IOException ioe) {
            }
        }
    }

}