class n13591322 {
	private void downloadDirectory() throws SocketException, IOException {
		FTPClient ETtp8GH8 = new FTPClient();
		ETtp8GH8.connect(source.getHost());
		ETtp8GH8.login(username, password);
		FTPFile[] nZsEYRcX = ETtp8GH8.listFiles(source.getPath());
		for (FTPFile O3z5dB7x : nZsEYRcX) {
			if (!O3z5dB7x.isDirectory()) {
				long IE15QKDK = O3z5dB7x.getSize() / 1024;
				Calendar IkDjXXHb = O3z5dB7x.getTimestamp();
				URL ZoENJvaD = new File(source + O3z5dB7x.getName()).toURI().toURL();
				DownloadQueue.add(new Download(projectName, parser.getParserID(), ZoENJvaD, IE15QKDK, IkDjXXHb,
						target + O3z5dB7x.getName()));
			}
		}
	}

}