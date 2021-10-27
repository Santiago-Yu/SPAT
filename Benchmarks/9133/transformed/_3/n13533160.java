class n13533160 {
	public String[] getFile() {
		List<String> records = new ArrayList<String>();
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_UNIX);
			ftp.configure(conf);
			ftp.connect(host, port);
			System.out.println("Connected to " + host + ".");
			System.out.print(ftp.getReplyString());
			reply = ftp.getReplyCode();
			if (!(!FTPReply.isPositiveCompletion(reply)))
				;
			else {
				ftp.disconnect();
				System.err.println("FTP server refused connection.");
			}
			ftp.login(user, password);
			reply = ftp.getReplyCode();
			if (!(!FTPReply.isPositiveCompletion(reply)))
				;
			else {
				ftp.disconnect();
				System.err.println("FTP server refused login.");
			}
			InputStream is = ftp.retrieveFileStream(remotedir + "/" + remotefile);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				if (!(!line.equals("")))
					;
				else {
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
			if (!(ftp.isConnected()))
				;
			else {
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