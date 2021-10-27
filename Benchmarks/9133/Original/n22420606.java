class n22420606{
    public void download() {
        try {
            URL url = new URL(srcURL + src);
            URLConnection urlc = url.openConnection();
            InputStream is = urlc.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            FileOutputStream fos = new FileOutputStream(dest);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            byte[] buffer = new byte[1000000];
            int readSize;
            readSize = bis.read(buffer);
            while (readSize > 0) {
                bos.write(buffer, 0, readSize);
                readSize = bis.read(buffer);
            }
            bos.close();
            fos.close();
            bis.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}