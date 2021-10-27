class n8894166{
    public static void saveFileFromURL(URL url, File destinationFile) throws IOException {
        FileOutputStream fo = new FileOutputStream(destinationFile);
        InputStream is = url.openStream();
        byte[] data = new byte[1024];
        int bytecount = 0;
        do {
            fo.write(data, 0, bytecount);
            bytecount = is.read(data);
        } while (bytecount > 0);
        fo.flush();
        fo.close();
    }

}