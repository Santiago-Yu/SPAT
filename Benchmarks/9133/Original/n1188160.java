class n1188160{
    public static String urlContentToString(URL url, String encoding) throws IOException {
        String out = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), Constants.ENCODING));
        String line;
        while ((line = in.readLine()) != null) {
            out += line;
        }
        in.close();
        return out;
    }

}