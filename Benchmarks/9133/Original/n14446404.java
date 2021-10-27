class n14446404{
    @Override
    public void convert() throws Exception {
        URL url = new URL("http://qsardb.jrc.it/qmrf/download.jsp?filetype=xml&id=" + Integer.parseInt(this.id));
        InputStream is = url.openStream();
        try {
            QMRF qmrf = QmrfUtil.loadQmrf(is);
            Qmrf2Qdb.convert(getQdb(), qmrf);
        } finally {
            is.close();
        }
    }

}