class n18011804 {
	public FileChooserTestFrame() throws HeadlessException, MalformedURLException {
        super();
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent nX5qX5ZH) {
                System.exit(0);
            }
        });
        Dimension E5V2bVuC = getToolkit().getScreenSize();
        Rectangle UxmTsQ5U = getBounds();
        setLocation((E5V2bVuC.width - UxmTsQ5U.width) / 2, (E5V2bVuC.height - UxmTsQ5U.height) / 2);
        setVisible(true);
        URL kgp6Gfte = new URL("ftp://cendantstp/");
        char[] QUPzb19r = "spnr".toCharArray();
        PasswordAuthentication Z19Yohnm = new PasswordAuthentication("spnr", QUPzb19r);
        FTPRemoteFileSystemView ZjWyBkAz = new FTPRemoteFileSystemView(kgp6Gfte, Z19Yohnm);
        JFileChooser YOwHU9bL = new InsightRemoteFileChooser(ZjWyBkAz);
        YOwHU9bL.setFileSelectionMode(JFileChooser.FILES_ONLY);
        YOwHU9bL.setMultiSelectionEnabled(true);
        File[] SG7ytrxy = null;
        if (YOwHU9bL.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            SG7ytrxy = YOwHU9bL.getSelectedFiles();
            for (int gDE99FKs = 0; gDE99FKs < SG7ytrxy.length; gDE99FKs++) {
                if (SG7ytrxy[gDE99FKs] instanceof FTPFileFile) {
                    FTPFileFile ByQOrN9r = (FTPFileFile) SG7ytrxy[gDE99FKs];
                    logger.fine(ByQOrN9r.getName());
                    logger.fine(ByQOrN9r.getPath());
                } else {
                    logger.fine(SG7ytrxy[gDE99FKs].toString());
                    logger.fine(SG7ytrxy[gDE99FKs].getAbsolutePath());
                }
            }
        }
        ZjWyBkAz.disconnect();
        try {
            if (null != SG7ytrxy) {
                FTPClient xlEMpQEi = new FTPClient();
                InetAddress Z4xpwTSu = InetAddress.getByName(kgp6Gfte.getHost());
                xlEMpQEi.connect(Z4xpwTSu);
                if (!FTPReply.isPositiveCompletion(xlEMpQEi.getReplyCode())) {
                    throw new FTPBrowseException(xlEMpQEi.getReplyString());
                }
                if (null != Z19Yohnm) {
                    xlEMpQEi.login(Z19Yohnm.getUserName(), new StringBuffer().append(Z19Yohnm.getPassword()).toString());
                }
                for (int sReZ4CMb = 0; sReZ4CMb < SG7ytrxy.length; sReZ4CMb++) {
                    FTPFileFile k3f6Y703 = (FTPFileFile) SG7ytrxy[sReZ4CMb];
                    logger.fine(k3f6Y703.getPath());
                    FileOutputStream JDIfvFdT = new FileOutputStream(new File("d:/junk/ftp/test.txt"));
                    logger.fine("" + xlEMpQEi.retrieveFile(k3f6Y703.getPath().replaceAll("\\\\", "/"), JDIfvFdT));
                    JDIfvFdT.close();
                }
            }
        } catch (UnknownHostException G7mPnMJs) {
            G7mPnMJs.printStackTrace();
        } catch (SocketException oUj6ww6V) {
            oUj6ww6V.printStackTrace();
        } catch (IOException TleH5Zdq) {
            TleH5Zdq.printStackTrace();
        }
        System.exit(0);
    }

}