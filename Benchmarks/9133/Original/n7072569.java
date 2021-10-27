class n7072569{
    public StringBuffer get(URL url) throws IOException {
        StringBuffer pageContents = new StringBuffer();
        PDFReader reader = new PDFReader(url.openStream());
        reader.open();
        int pageCount = reader.getNumberOfPages();
        for (int i = 0; i < pageCount; i++) pageContents.append(new String(reader.extractTextFromPage(i).getBytes(), "UTF-8"));
        reader.close();
        return pageContents;
    }

}