class n2770143{
    protected static String readAFewChars(URL url) throws IOException {
        StringBuffer buf = new StringBuffer(10);
        Reader reader = new InputStreamReader(url.openStream());
        for (int i = 0; i < 10; i++) {
            int c = reader.read();
            if (c == -1) {
                break;
            }
            buf.append((char) c);
        }
        reader.close();
        return buf.toString();
    }

}