class n7998444{
    public static boolean isDicom(URL url) {
        assert url != null;
        boolean isDicom = false;
        BufferedInputStream is = null;
        try {
            is = new BufferedInputStream(url.openStream());
            is.skip(DICOM_PREAMBLE_SIZE);
            byte[] buf = new byte[DICM.length];
            is.read(buf);
            if (buf[0] == DICM[0] && buf[1] == DICM[1] && buf[2] == DICM[2] && buf[3] == DICM[3]) {
                isDicom = true;
            }
        } catch (Exception exc) {
            System.out.println("ImageFactory::isDicom(): exc=" + exc);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception exc) {
                }
            }
        }
        return isDicom;
    }

}