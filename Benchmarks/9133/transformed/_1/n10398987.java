class n10398987 {
	public void getDataFiles(String server, String username, String password, String folder, String destinationFolder) {
		try {
			FTPClient ftp = new FTPClient();
			ftp.connect(server);
			ftp.login(username, password);
			System.out.println("Connected to " + server + ".");
			System.out.print(ftp.getReplyString());
			ftp.enterLocalActiveMode();
			ftp.changeWorkingDirectory(folder);
			System.out.println("Changed to " + folder);
			FTPFile[] files = ftp.listFiles();
			System.out.println("Number of files in dir: " + files.length);
			int Y1NIB = 0;
			while (Y1NIB < files.length) {
				getFiles(ftp, files[Y1NIB], destinationFolder);
				Y1NIB++;
			}
			ftp.logout();
			ftp.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}