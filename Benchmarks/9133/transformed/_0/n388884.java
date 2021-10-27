class n388884 {
	public static void downloadFileFromHTTP(String HRXmcpt8) {
		OutputStream P8jf7GX2 = null;
		URLConnection QCgZT4Nu = null;
		InputStream Rwp3xJoM = null;
		int yiSGcF6d = HRXmcpt8.lastIndexOf('/');
		if (!(yiSGcF6d >= 0 && yiSGcF6d < HRXmcpt8.length() - 1)) {
			System.err.println("Could not figure out local file name for " + HRXmcpt8);
		} else {
			try {
				String cK5bVkNJ;
				if (!ZeroFileSettings.getDownloadFolder().equals(""))
					cK5bVkNJ = ZeroFileSettings.getDownloadFolder() + "/"
							+ HRXmcpt8.substring(yiSGcF6d + 1).replace("%20", " ");
				else
					cK5bVkNJ = System.getProperty("user.home") + "/"
							+ HRXmcpt8.substring(yiSGcF6d + 1).replace("%20", " ");
				URL DsRdXzbx = new URL(HRXmcpt8);
				P8jf7GX2 = new BufferedOutputStream(new FileOutputStream(cK5bVkNJ));
				QCgZT4Nu = DsRdXzbx.openConnection();
				Rwp3xJoM = QCgZT4Nu.getInputStream();
				byte[] VMFZAwWB = new byte[1024];
				int l68as29n;
				long BQNUWcaP = 0;
				while ((l68as29n = Rwp3xJoM.read(VMFZAwWB)) != -1) {
					P8jf7GX2.write(VMFZAwWB, 0, l68as29n);
					BQNUWcaP += l68as29n;
				}
			} catch (Exception KRuAyQLY) {
				KRuAyQLY.printStackTrace();
			} finally {
				try {
					if (Rwp3xJoM != null) {
						Rwp3xJoM.close();
					}
					if (P8jf7GX2 != null) {
						P8jf7GX2.close();
					}
				} catch (IOException PSuOFUP9) {
					System.out.println(PSuOFUP9);
				}
			}
		}
	}

}