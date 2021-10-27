class n5243677{
    public static void main(String[] args) throws Exception {
        dataList = new ArrayList<String>();
        System.setProperty("http.agent", Phex.getFullPhexVendor());
        URL url = new URL(listUrl);
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();
        readData(inputStream);
        System.out.println("Total data read: " + dataList.size());
        inputStream.close();
        writeToOutputFile();
    }

}