class n3296961{
    public void fetchDataByID(String id) throws IOException, SAXException {
        URL url = new URL(urlHistoryStockPrice + id);
        URLConnection con = url.openConnection();
        con.setConnectTimeout(20000);
        InputStream is = con.getInputStream();
        byte[] bs = new byte[1024];
        int len;
        OutputStream os = new FileOutputStream(dataPath + id + ".csv");
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        os.flush();
        os.close();
        is.close();
        con = null;
        url = null;
    }

}