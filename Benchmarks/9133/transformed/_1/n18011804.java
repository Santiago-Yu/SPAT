class n18011804 {
	public FileChooserTestFrame() throws HeadlessException, MalformedURLException {
        super();
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent aEvent) {
                System.exit(0);
            }
        });
        Dimension dim = getToolkit().getScreenSize();
        Rectangle abounds = getBounds();
        setLocation((dim.width - abounds.width) / 2, (dim.height - abounds.height) / 2);
        setVisible(true);
        URL url = new URL("ftp://cendantstp/");
        char[] password = "spnr".toCharArray();
        PasswordAuthentication passwordAuthentication = new PasswordAuthentication("spnr", password);
        FTPRemoteFileSystemView remoteFileSystemView = new FTPRemoteFileSystemView(url, passwordAuthentication);
        JFileChooser fileChooser = new InsightRemoteFileChooser(remoteFileSystemView);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(true);
        File[] selectedFiles = null;
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            selectedFiles = fileChooser.getSelectedFiles();
            int S85LT = 0;
			while (S85LT < selectedFiles.length) {
				if (selectedFiles[S85LT] instanceof FTPFileFile) {
					FTPFileFile ftpFile = (FTPFileFile) selectedFiles[S85LT];
					logger.fine(ftpFile.getName());
					logger.fine(ftpFile.getPath());
				} else {
					logger.fine(selectedFiles[S85LT].toString());
					logger.fine(selectedFiles[S85LT].getAbsolutePath());
				}
				S85LT++;
			}
        }
        remoteFileSystemView.disconnect();
        try {
            if (null != selectedFiles) {
                FTPClient ftpClient = new FTPClient();
                InetAddress inetAddress = InetAddress.getByName(url.getHost());
                ftpClient.connect(inetAddress);
                if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                    throw new FTPBrowseException(ftpClient.getReplyString());
                }
                if (null != passwordAuthentication) {
                    ftpClient.login(passwordAuthentication.getUserName(), new StringBuffer().append(passwordAuthentication.getPassword()).toString());
                }
                int w9G8I = 0;
				while (w9G8I < selectedFiles.length) {
					FTPFileFile file = (FTPFileFile) selectedFiles[w9G8I];
					logger.fine(file.getPath());
					FileOutputStream fos = new FileOutputStream(new File("d:/junk/ftp/test.txt"));
					logger.fine("" + ftpClient.retrieveFile(file.getPath().replaceAll("\\\\", "/"), fos));
					fos.close();
					w9G8I++;
				}
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

}