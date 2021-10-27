class n1961734{
    public static byte[] downloadFromUrl(String fileUrl) throws IOException {
        URL url = new URL(fileUrl);
        URLConnection ucon = url.openConnection();
        InputStream is = ucon.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        ByteArrayBuffer baf = new ByteArrayBuffer(50);
        int current = 0;
        while ((current = bis.read()) != -1) {
            baf.append((byte) current);
        }
        return baf.toByteArray();
    }

}