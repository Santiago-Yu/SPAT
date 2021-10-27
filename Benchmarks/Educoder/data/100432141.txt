    public static byte[] loadURLToBuffer(URL url) throws IOException {
        byte[] buf = new byte[4096];
        byte[] data = null;
        byte[] temp = null;
        int iCount = 0;
        int iTotal = 0;
        BufferedInputStream in = new BufferedInputStream(url.openStream(), 20480);
        while ((iCount = in.read(buf, 0, buf.length)) != -1) {
            if (iTotal == 0) {
                data = new byte[iCount];
                System.arraycopy(buf, 0, data, 0, iCount);
                iTotal = iCount;
            } else {
                temp = new byte[iCount + iTotal];
                System.arraycopy(data, 0, temp, 0, iTotal);
                System.arraycopy(buf, 0, temp, iTotal, iCount);
                data = temp;
                iTotal = iTotal + iCount;
            }
        }
        in.close();
        return data;
    }
