class n18598975 {
	private Face(String font) throws IOException {
        StringBuffer sb = new StringBuffer();
        characterWidths = new double[256];
        sb.append('/');
        sb.append(Constants.FONTS_DIR);
        sb.append('/');
        sb.append(font);
        sb.append(Constants.CHAR_WIDTHS_SUFFIX);
        String path = sb.toString();
        URL url = getClass().getResource(path);
        InputStream is = url.openStream();
        int pos = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String width = br.readLine();
        while (width != null && pos < 256) {
            characterWidths[pos] = Double.parseDouble(width);
            width = br.readLine();
            pos++;
        }
    }

}