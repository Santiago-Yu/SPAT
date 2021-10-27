class n3739492{
    public static boolean downloadFile(String url, String destination) {
        BufferedInputStream bi = null;
        BufferedOutputStream bo = null;
        File destfile;
        try {
            java.net.URL fileurl;
            try {
                fileurl = new java.net.URL(url);
            } catch (MalformedURLException e) {
                return false;
            }
            bi = new BufferedInputStream(fileurl.openStream());
            destfile = new File(destination);
            if (!destfile.createNewFile()) {
                destfile.delete();
                destfile.createNewFile();
            }
            bo = new BufferedOutputStream(new FileOutputStream(destfile));
            int readedbyte;
            while ((readedbyte = bi.read()) != -1) {
                bo.write(readedbyte);
            }
            bo.flush();
        } catch (IOException ex) {
            return false;
        } finally {
            try {
                bi.close();
                bo.close();
            } catch (Exception ex) {
            }
        }
        return true;
    }

}