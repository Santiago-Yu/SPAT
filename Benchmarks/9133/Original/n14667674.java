class n14667674{
    @Override
    protected FTPClient ftpConnect() throws SocketException, IOException, NoSuchAlgorithmException {
        FilePathItem fpi = getFilePathItem();
        FTPClient f = new FTPSClient();
        f.connect(fpi.getHost());
        f.login(fpi.getUsername(), fpi.getPassword());
        return f;
    }

}