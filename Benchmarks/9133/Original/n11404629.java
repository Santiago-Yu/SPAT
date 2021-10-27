class n11404629{
    public static File downloadFromUrl(String urlString, String ext) throws Exception {
        URL url = new URL(urlString);
        InputStream is = url.openStream();
        byte bytes[] = new byte[20480];
        File result = File.createTempFile("temp_", ext);
        FileOutputStream fos = new FileOutputStream(result);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int nbread = 0;
        int loops = 0;
        while ((nbread = is.read(bytes)) > -1) {
            bos.write(bytes, 0, nbread);
            loops++;
            System.out.println(loops);
        }
        bos.close();
        return result;
    }

}