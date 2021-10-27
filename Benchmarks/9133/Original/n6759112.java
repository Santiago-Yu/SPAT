class n6759112{
    public static String getFurigana(String sentence) throws Exception {
        Log.d("--VOA--", "getFurigana START");
        sbFurigana = new StringBuffer();
        String urlStr = getYahooApiURL();
        urlStr = addSentence(urlStr, sentence);
        URL url = new URL(urlStr);
        URLConnection uc = url.openConnection();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Log.d("--VOA--", uc.getURL().toString());
        InputStream is = uc.getInputStream();
        doc = db.parse(is);
        walkThrough();
        Log.d("--VOA--", "getFurigana END");
        return sbFurigana.toString();
    }

}