class n13533160 {
	public String[] getFile() {
		FTPClient ftp = new FTPClient();
		List<String> records = new ArrayList<String>();
		try {
			FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_UNIX);
			int reply;
			ftp.configure(conf);
			ftp.connect(host, port);
			System.out.println("Connected to " + host + ".");
			System.out.print(ftp.getReplyString());
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				System.err.println("FTP server refused connection.");
			}
			ftp.login(user, password);
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				System.err.println("FTP server refused login.");
			}
			InputStream is = ftp.retrieveFileStream(remotedir + "/" + remotefile);
			InputStreamReader isr = new InputStreamReader(is);
			String line = null;
			BufferedReader br = new BufferedReader(isr);
			while ((line = br.readLine()) != null) {
				if (!line.equals("")) {
					records.add(line);
				}
			}
			br.close();
			isr.close();
			is.close();
			ftp.logout();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
		return records.toArray(new String[0]);
	}

}