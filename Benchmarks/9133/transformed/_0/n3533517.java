class n3533517 {
	public String loadGeneratorXML() {
		FTPClient Q0ujy0Xl = new FTPClient();
		try {
			int HaM504p0;
			Q0ujy0Xl.connect(this.getFolienKonvertierungsServer().getUrl());
			System.out.println("Connected to " + this.getFolienKonvertierungsServer().getUrl() + ".");
			System.out.print(Q0ujy0Xl.getReplyString());
			HaM504p0 = Q0ujy0Xl.getReplyCode();
			if (!FTPReply.isPositiveCompletion(HaM504p0)) {
				Q0ujy0Xl.disconnect();
				System.err.println("FTP server refused connection.");
				return null;
			}
			if (!Q0ujy0Xl.login(this.getFolienKonvertierungsServer().getFtpBenutzer(),
					this.getFolienKonvertierungsServer().getFtpPasswort())) {
				System.err.println("FTP server: Login incorrect");
			}
			String xYsHksvu;
			if (this.getFolienKonvertierungsServer().getDefaultPath().length() > 0) {
				xYsHksvu = "/" + this.getFolienKonvertierungsServer().getDefaultPath() + "/" + this.getId() + "/";
			} else {
				xYsHksvu = "/" + this.getId() + "/";
			}
			if (!Q0ujy0Xl.changeWorkingDirectory(xYsHksvu))
				System.err.println("Konnte Verzeichnis nicht wechseln: " + xYsHksvu);
			System.err.println("Arbeitsverzeichnis: " + Q0ujy0Xl.printWorkingDirectory());
			Q0ujy0Xl.setFileType(FTP.BINARY_FILE_TYPE);
			Q0ujy0Xl.enterLocalPassiveMode();
			InputStream HFtEAbKT = Q0ujy0Xl.retrieveFileStream("generator.xml");
			if (HFtEAbKT == null) {
				System.err.println("Job " + this.getId() + ": Datei generator.xml wurde nicht gefunden");
				return null;
			}
			BufferedReader n1LUMIBy = new BufferedReader(new InputStreamReader(HFtEAbKT));
			generatorXML = "";
			String rR0VC4My = "";
			while ((rR0VC4My = n1LUMIBy.readLine()) != null) {
				generatorXML += rR0VC4My + "\n";
			}
			n1LUMIBy.close();
			Q0ujy0Xl.logout();
			Q0ujy0Xl.disconnect();
		} catch (IOException RZVWKAFR) {
			System.err.println(
					"Job " + this.getId() + ": Datei generator.xml konnte nicht vom Webserver kopiert werden.");
			RZVWKAFR.printStackTrace();
		} catch (Exception nrXrKTvW) {
			System.err.println(
					"Job " + this.getId() + ": Datei generator.xml konnte nicht vom Webserver kopiert werden.");
			nrXrKTvW.printStackTrace();
		} finally {
			if (Q0ujy0Xl.isConnected()) {
				try {
					Q0ujy0Xl.disconnect();
				} catch (IOException M5tri4SW) {
				}
			}
		}
		if (generatorXML != null && generatorXML.length() == 0) {
			generatorXML = null;
		}
		return generatorXML;
	}

}