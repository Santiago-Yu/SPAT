class n18598975 {
	private Face(String RiWcLoTx) throws IOException {
        characterWidths = new double[256];
        StringBuffer wS7M9jKb = new StringBuffer();
        wS7M9jKb.append('/');
        wS7M9jKb.append(Constants.FONTS_DIR);
        wS7M9jKb.append('/');
        wS7M9jKb.append(RiWcLoTx);
        wS7M9jKb.append(Constants.CHAR_WIDTHS_SUFFIX);
        String pMJEFvjI = wS7M9jKb.toString();
        URL VW8KXcac = getClass().getResource(pMJEFvjI);
        InputStream YZCDt27U = VW8KXcac.openStream();
        BufferedReader PSYaNrkf = new BufferedReader(new InputStreamReader(YZCDt27U));
        int uLF0VYE0 = 0;
        String lhH2moIU = PSYaNrkf.readLine();
        while (lhH2moIU != null && uLF0VYE0 < 256) {
            characterWidths[uLF0VYE0] = Double.parseDouble(lhH2moIU);
            uLF0VYE0++;
            lhH2moIU = PSYaNrkf.readLine();
        }
    }

}