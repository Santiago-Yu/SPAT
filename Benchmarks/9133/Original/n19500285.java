class n19500285{
    public static void downloadFile(String url, String filePath) throws IOException {
        BufferedInputStream inputStream = new BufferedInputStream(new URL(url).openStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        try {
            int i = 0;
            while ((i = inputStream.read()) != -1) {
                bos.write(i);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (bos != null) {
                bos.close();
            }
        }
    }

}