class n10135488{
    @Override
    public void run() {
        try {
            long pos = begin;
            byte[] buf = new byte[1024];
            URLConnection cn = url.openConnection();
            Utils.setHeader(cn);
            cn.setRequestProperty("Range", "bytes=" + begin + "-" + end);
            BufferedInputStream bis = new BufferedInputStream(cn.getInputStream());
            int len;
            while ((len = bis.read(buf)) > 0) {
                synchronized (file) {
                    file.seek(pos);
                    file.write(buf, 0, len);
                }
                pos += len;
                Statics.getInstance().addComleted(len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        latch.countDown();
    }

}