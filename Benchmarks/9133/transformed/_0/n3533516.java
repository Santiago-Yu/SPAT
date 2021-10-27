class n3533516 {
	public boolean saveLecturerecordingsXMLOnWebserver() {
		boolean Pp3TNW2e = false;
		FTPClient AIJzK2M8 = new FTPClient();
		String L61Iocph = "";
		try {
			URL fLMWK7Zb = new URL("http://localhost:8080/virtPresenterVerwalter/lecturerecordings.jsp?seminarid="
					+ this.getSeminarID());
			HttpURLConnection vYc22fZB = (HttpURLConnection) fLMWK7Zb.openConnection();
			BufferedReader nVRqwsor = new BufferedReader(new InputStreamReader(vYc22fZB.getInputStream()));
			String MqDC9xuJ = "";
			while ((MqDC9xuJ = nVRqwsor.readLine()) != null) {
				L61Iocph += MqDC9xuJ + "\n";
			}
			nVRqwsor.close();
			vYc22fZB.disconnect();
		} catch (Exception DoF4QNJo) {
			System.err.println("Konnte lecturerecordings.xml nicht lesen.");
		}
		try {
			int qgA7LyOR;
			AIJzK2M8.connect(this.getWebserver().getUrl());
			System.out.println("Connected to " + this.getWebserver().getUrl() + ".");
			System.out.print(AIJzK2M8.getReplyString());
			qgA7LyOR = AIJzK2M8.getReplyCode();
			if (!FTPReply.isPositiveCompletion(qgA7LyOR)) {
				AIJzK2M8.disconnect();
				System.err.println("FTP server refused connection.");
				return false;
			}
			if (!AIJzK2M8.login(this.getWebserver().getFtpBenutzer(), this.getWebserver().getFtpPasswort())) {
				System.err.println("FTP server: Login incorrect");
			}
			String pJ2bu1j7 = this.getSeminarID();
			if (pJ2bu1j7 == null)
				pJ2bu1j7 = "unbekannt";
			try {
				AIJzK2M8.changeWorkingDirectory(this.getWebserver().getDefaultPath() + "/" + pJ2bu1j7 + "/lectures/");
			} catch (Exception uugrMLEi) {
				AIJzK2M8.makeDirectory(this.getWebserver().getDefaultPath() + "/" + pJ2bu1j7 + "/lectures/");
				AIJzK2M8.changeWorkingDirectory(this.getWebserver().getDefaultPath() + "/" + pJ2bu1j7 + "/lectures/");
			}
			AIJzK2M8.setFileType(FTP.BINARY_FILE_TYPE);
			ByteArrayInputStream uPaLU8lZ = new ByteArrayInputStream(L61Iocph.getBytes());
			System.err.println("FTP Verzeichnis: " + AIJzK2M8.printWorkingDirectory());
			AIJzK2M8.storeFile("lecturerecordings.xml", uPaLU8lZ);
			uPaLU8lZ.close();
			AIJzK2M8.logout();
			AIJzK2M8.disconnect();
		} catch (IOException lrzzwChH) {
			System.err.println(
					"Job " + this.getId() + ": Datei lecturerecordings.xml konnte nicht auf Webserver kopiert werden.");
			Pp3TNW2e = true;
			lrzzwChH.printStackTrace();
		} catch (NullPointerException GRaRE2D9) {
			System.err.println("Job " + this.getId()
					+ ": Datei lecturerecordings.xml konnte nicht auf Webserver kopiert werden. (Kein Webserver zugewiesen)");
			Pp3TNW2e = true;
		} finally {
			if (AIJzK2M8.isConnected()) {
				try {
					AIJzK2M8.disconnect();
				} catch (IOException vLfGiFEC) {
				}
			}
		}
		return Pp3TNW2e;
	}

}