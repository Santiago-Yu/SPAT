class n20394588{
    public static Font createTrueTypeFont(URL url, int style, float size) {
        Font f = null;
        try {
            f = Font.createFont(Font.TRUETYPE_FONT, url.openStream());
        } catch (IOException e) {
            System.err.println("ERROR: " + url + " is not found or can not be read");
            f = new Font("Verdana", 0, 0);
        } catch (FontFormatException e) {
            System.err.println("ERROR: " + url + " is not a valid true type font");
            f = new Font("Verdana", 0, 0);
        }
        return f.deriveFont(style, size);
    }

}