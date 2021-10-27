class n11450174 {
	private void publishPage(URL CazphTTm, String XykYJDhO, File VaUbXPlU) throws IOException {
		if (debug) {
			System.out.println("      publishing page: " + XykYJDhO);
			System.out.println("        url == " + CazphTTm);
			System.out.println("        file == " + VaUbXPlU);
		}
		StringBuffer Gvn5s5oh = new StringBuffer();
		try {
			InputStream HUfanQC0 = CazphTTm.openStream();
			InputStreamReader IIZ3LWxr = new InputStreamReader(HUfanQC0);
			BufferedReader Kh3j3h1C = new BufferedReader(IIZ3LWxr);
			boolean nExtmkvr = true;
			String fy2tElaZ;
			do {
				fy2tElaZ = Kh3j3h1C.readLine();
				if (fy2tElaZ != null) {
					if (!nExtmkvr)
						Gvn5s5oh.append("\n");
					else
						nExtmkvr = false;
					Gvn5s5oh.append(fy2tElaZ);
				}
			} while (fy2tElaZ != null);
			Kh3j3h1C.close();
		} catch (IOException AjpDuVK3) {
			String Yu6Zhzh6 = VaUbXPlU.toString() + ": " + AjpDuVK3.getMessage();
			errors.add(Yu6Zhzh6);
		}
		FileOutputStream ek4bOEd8 = new FileOutputStream(VaUbXPlU);
		OutputStreamWriter gX5o8rnb = new OutputStreamWriter(ek4bOEd8);
		gX5o8rnb.write(Gvn5s5oh.toString());
		gX5o8rnb.close();
		if (prepareArchive)
			archiveFiles.add(new ArchiveFile(XykYJDhO, VaUbXPlU));
	}

}