class n20492893{
    public static String loadUrlContentAsString(URL url) throws IOException {
        char[] buf = new char[2048];
        StringBuffer ret = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        for (int chars = reader.read(buf); chars != -1; chars = reader.read(buf)) {
            ret.append(buf, 0, chars);
        }
        reader.close();
        return ret.toString();
    }

}