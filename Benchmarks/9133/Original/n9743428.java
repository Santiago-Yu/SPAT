class n9743428{
    public static void saveNetFile(String destUrl, String fileName) throws IOException {
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        HttpURLConnection httpUrl = null;
        int BUFFER_SIZE = 2048;
        URL url = null;
        byte[] buf = new byte[BUFFER_SIZE];
        int size = 0;
        url = new URL(destUrl);
        httpUrl = (HttpURLConnection) url.openConnection();
        httpUrl.connect();
        bis = new BufferedInputStream(httpUrl.getInputStream());
        java.io.File dest = new java.io.File(fileName).getParentFile();
        if (!dest.exists()) dest.mkdirs();
        fos = new FileOutputStream(fileName);
        while ((size = bis.read(buf)) != -1) fos.write(buf, 0, size);
        fos.close();
        bis.close();
        httpUrl.disconnect();
    }

}