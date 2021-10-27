class n8660836{
    public void transform(String style, String spec, OutputStream out) throws IOException {
        URL url = new URL(rootURL, spec);
        InputStream in = new PatchXMLSymbolsStream(new StripDoctypeStream(url.openStream()));
        transform(style, in, out);
        in.close();
    }

}