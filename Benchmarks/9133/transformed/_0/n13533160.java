class n13533160 {
	public String[] getFile() {
		List<String> hwNeVk0o = new ArrayList<String>();
		FTPClient QoTeq8LH = new FTPClient();
		try {
			int UzXvrpg5;
			FTPClientConfig eSYQc24E = new FTPClientConfig(FTPClientConfig.SYST_UNIX);
			QoTeq8LH.configure(eSYQc24E);
			QoTeq8LH.connect(host, port);
			System.out.println("Connected to " + host + ".");
			System.out.print(QoTeq8LH.getReplyString());
			UzXvrpg5 = QoTeq8LH.getReplyCode();
			if (!FTPReply.isPositiveCompletion(UzXvrpg5)) {
				QoTeq8LH.disconnect();
				System.err.println("FTP server refused connection.");
			}
			QoTeq8LH.login(user, password);
			UzXvrpg5 = QoTeq8LH.getReplyCode();
			if (!FTPReply.isPositiveCompletion(UzXvrpg5)) {
				QoTeq8LH.disconnect();
				System.err.println("FTP server refused login.");
			}
			InputStream DvCfBNSy = QoTeq8LH.retrieveFileStream(remotedir + "/" + remotefile);
			InputStreamReader badtgCaL = new InputStreamReader(DvCfBNSy);
			BufferedReader yQNueM2r = new BufferedReader(badtgCaL);
			String Q6OFEH17 = null;
			while ((Q6OFEH17 = yQNueM2r.readLine()) != null) {
				if (!Q6OFEH17.equals("")) {
					hwNeVk0o.add(Q6OFEH17);
				}
			}
			yQNueM2r.close();
			badtgCaL.close();
			DvCfBNSy.close();
			QoTeq8LH.logout();
		} catch (IOException gfOdHJ44) {
			gfOdHJ44.printStackTrace();
		} finally {
			if (QoTeq8LH.isConnected()) {
				try {
					QoTeq8LH.disconnect();
				} catch (IOException HR83xjBL) {
					HR83xjBL.printStackTrace();
				}
			}
		}
		return hwNeVk0o.toArray(new String[0]);
	}

}