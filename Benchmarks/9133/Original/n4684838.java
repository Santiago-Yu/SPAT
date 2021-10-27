class n4684838{
    public static Vector<String> readFileFromURL(URL url) {
        Vector<String> text = new Vector<String>();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = in.readLine()) != null) {
                text.add(line);
            }
            in.close();
        } catch (Exception e) {
            return null;
        }
        return text;
    }

}