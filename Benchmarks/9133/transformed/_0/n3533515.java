class n3533515 {
	public boolean saveVideoXMLOnWebserver(String FdJV558Q) {
		boolean XuHrSsA9 = false;
		FTPClient yxXHZehn = new FTPClient();
		try {
			int c9SHZQtA;
			yxXHZehn.connect(this.getWebserver().getUrl());
			System.out.println("Connected to " + this.getWebserver().getUrl() + ".");
			System.out.print(yxXHZehn.getReplyString());
			c9SHZQtA = yxXHZehn.getReplyCode();
			if (!FTPReply.isPositiveCompletion(c9SHZQtA)) {
				yxXHZehn.disconnect();
				System.err.println("FTP server refused connection.");
				return false;
			}
			if (!yxXHZehn.login(this.getWebserver().getFtpBenutzer(), this.getWebserver().getFtpPasswort())) {
				System.err.println("FTP server: Login incorrect");
			}
			String N7ELPzdn = this.getSeminarID();
			if (N7ELPzdn == null)
				N7ELPzdn = "unbekannt";
			try {
				yxXHZehn.changeWorkingDirectory(
						this.getWebserver().getDefaultPath() + "/" + N7ELPzdn + "/lectures/" + this.getId() + "/data");
			} catch (Exception tzMsHrvU) {
				yxXHZehn.makeDirectory(
						this.getWebserver().getDefaultPath() + "/" + N7ELPzdn + "/lectures/" + this.getId() + "/data");
				yxXHZehn.changeWorkingDirectory(
						this.getWebserver().getDefaultPath() + "/" + N7ELPzdn + "/lectures/" + this.getId() + "/data");
			}
			yxXHZehn.setFileType(FTP.BINARY_FILE_TYPE);
			ByteArrayInputStream g4RG2LMj = new ByteArrayInputStream(FdJV558Q.getBytes());
			yxXHZehn.enterLocalPassiveMode();
			yxXHZehn.storeFile("video.xml", g4RG2LMj);
			g4RG2LMj.close();
			yxXHZehn.logout();
			yxXHZehn.disconnect();
		} catch (IOException ZalyQZLi) {
			System.err.println("Job " + this.getId() + ": Datei video.xml konnte nicht auf Webserver kopiert werden.");
			XuHrSsA9 = true;
			ZalyQZLi.printStackTrace();
		} finally {
			if (yxXHZehn.isConnected()) {
				try {
					yxXHZehn.disconnect();
				} catch (IOException zFsxy2ZX) {
				}
			}
		}
		return XuHrSsA9;
	}

}