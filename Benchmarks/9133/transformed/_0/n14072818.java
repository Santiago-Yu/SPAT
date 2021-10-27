class n14072818 {
	public osid.shared.Id ingest(String SEfhYbY9, String fDUnwgsU, String jovTpbxC, File wwRDRqjL, Properties D27ufliZ)
			throws osid.dr.DigitalRepositoryException, java.net.SocketException, java.io.IOException,
			osid.shared.SharedException, javax.xml.rpc.ServiceException {
		long fX3STMDH = System.currentTimeMillis();
		if (DEBUG)
			System.out.println("INGESTING FILE TO FEDORA:fileName =" + SEfhYbY9 + "fileType =" + jovTpbxC + "t = 0");
		String fWI2gQT0 = FedoraUtils.getFedoraProperty(this, "admin.ftp.address");
		String WqIdMvHU = FedoraUtils.getFedoraProperty(this, "admin.ftp.url");
		int pyz2awjr = Integer.parseInt(FedoraUtils.getFedoraProperty(this, "admin.ftp.port"));
		String OKBlKBPu = FedoraUtils.getFedoraProperty(this, "admin.ftp.username");
		String SveKt4ef = FedoraUtils.getFedoraProperty(this, "admin.ftp.password");
		String QeYdAzjW = FedoraUtils.getFedoraProperty(this, "admin.ftp.directory");
		FTPClient uEBVx9FQ = new FTPClient();
		uEBVx9FQ.connect(fWI2gQT0, pyz2awjr);
		uEBVx9FQ.login(OKBlKBPu, SveKt4ef);
		uEBVx9FQ.changeWorkingDirectory(QeYdAzjW);
		uEBVx9FQ.setFileType(FTP.BINARY_FILE_TYPE);
		uEBVx9FQ.storeFile(SEfhYbY9, new FileInputStream(wwRDRqjL.getAbsolutePath().replaceAll("%20", " ")));
		uEBVx9FQ.logout();
		uEBVx9FQ.disconnect();
		if (DEBUG)
			System.out.println(
					"INGESTING FILE TO FEDORA: Writting to FTP Server:" + (System.currentTimeMillis() - fX3STMDH));
		SEfhYbY9 = WqIdMvHU + SEfhYbY9;
		int vyHi1ynm = 10240;
		StringBuffer O9zqNYJ2 = new StringBuffer();
		String iQBg4VAK = new String();
		BufferedInputStream udcioP5m = new BufferedInputStream(
				new FileInputStream(new File(getResource(fDUnwgsU).getFile().replaceAll("%20", " "))));
		byte[] Cd9zS9Rb = new byte[vyHi1ynm];
		int mGxrTnms;
		int rrlPkJ1f;
		while ((rrlPkJ1f = udcioP5m.read(Cd9zS9Rb)) > 0) {
			iQBg4VAK = iQBg4VAK + new String(Cd9zS9Rb);
		}
		udcioP5m.close();
		if (DEBUG)
			System.out.println("INGESTING FILE TO FEDORA: Read Mets File:" + (System.currentTimeMillis() - fX3STMDH));
		String L8eurqf9 = updateMetadata(iQBg4VAK, SEfhYbY9, wwRDRqjL.getName(), jovTpbxC, D27ufliZ);
		if (DEBUG)
			System.out
					.println("INGESTING FILE TO FEDORA: Resplaced Metadata:" + (System.currentTimeMillis() - fX3STMDH));
		File u6lhYslT = File.createTempFile("vueMETSMap", ".xml");
		FileOutputStream YBQYaL5j = new FileOutputStream(u6lhYslT);
		YBQYaL5j.write(L8eurqf9.getBytes());
		YBQYaL5j.close();
		if (DEBUG)
			System.out.println("INGESTING FILE TO FEDORA: Ingest complete:" + (System.currentTimeMillis() - fX3STMDH));
		String jpvYnRxa = "Method Not Supported any more";
		System.out.println(" METSfile= " + u6lhYslT.getPath() + " PID = " + jpvYnRxa);
		return new PID(jpvYnRxa);
	}

}