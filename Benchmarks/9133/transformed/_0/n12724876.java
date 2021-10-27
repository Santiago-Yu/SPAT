class n12724876 {
	private void loadURL(URL Y8vHwOAJ, String t3VKYmDb, String a0UHEWKl, JLabel PKWsAZs3) throws IOException {
		URLConnection xR5TXbgb = Y8vHwOAJ.openConnection();
		if (t3VKYmDb != null && !t3VKYmDb.equals("")) {
			if (a0UHEWKl == null) {
				a0UHEWKl = "";
			}
			String br7rpbhx = new sun.misc.BASE64Encoder().encode(new String(t3VKYmDb + ":" + a0UHEWKl).getBytes());
			xR5TXbgb.setRequestProperty("Authorization", "Basic " + br7rpbhx);
		}
		BufferedReader ZHwmC1nG = new BufferedReader(new InputStreamReader(xR5TXbgb.getInputStream()));
		String XJ0T20En;
		this.tmpVRMLFile = File.createTempFile("xnavi-", null, null);
		System.out.println("Created tmp file: " + this.tmpVRMLFile.getAbsolutePath());
		FileWriter Zq8wdiy8 = new FileWriter(this.tmpVRMLFile);
		long maZH8HPt = this.tmpVRMLFile.length();
		double ASDHYOBY = ((double) maZH8HPt) / (1024.0 * 1024.0);
		String poIicrZr = "";
		while ((XJ0T20En = ZHwmC1nG.readLine()) != null) {
			poIicrZr = XJ0T20En + "\n";
			Zq8wdiy8.write(poIicrZr);
			Zq8wdiy8.flush();
			if (PKWsAZs3 != null) {
				maZH8HPt = this.tmpVRMLFile.length();
				ASDHYOBY = ((double) maZH8HPt) / (1024.0 * 1024.0);
				ASDHYOBY *= 100.0;
				ASDHYOBY = (double) ((int) ASDHYOBY);
				ASDHYOBY /= 100.0;
				PKWsAZs3.setText(ASDHYOBY + " MB");
				PKWsAZs3.repaint();
			}
		}
		Zq8wdiy8.close();
		System.out.println("Wrote file " + this.tmpVRMLFile.getAbsolutePath());
	}

}