class n18784731{
    public static void downloadFromUrl(String url1, String fileName) {
        try {
            URL url = new URL(url1);
            File file = new File(fileName);
            URLConnection ucon = url.openConnection();
            InputStream is = ucon.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            ByteArrayBuffer baf = new ByteArrayBuffer(50);
            int current = 0;
            while ((current = bis.read()) != -1) {
                baf.append((byte) current);
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(baf.toByteArray());
            fos.close();
        } catch (IOException e) {
        }
    }

}