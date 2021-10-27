class n9170572 {
	public static Observacion load() {
		Observacion t2JE14kh = new Observacion(new Date());
		FTPClient C9aLXQLc = new FTPClient();
		SimpleDateFormat xOYXNPHz = new SimpleDateFormat("yyyyMMdd");
		final String E9XFAYLR = xOYXNPHz.format(new Date());
		String jGVar1lB = String.format(PATHNAME_PATTERN, E9XFAYLR);
		try {
			InetAddress zpzwYC0n = InetAddress.getByName(HOST);
			C9aLXQLc.connect(zpzwYC0n);
			C9aLXQLc.login(USERNAME, PASSWORD);
			FTPFile[] VV0krSps = C9aLXQLc.listFiles(jGVar1lB, new FTPFileFilter() {

				@Override
				public boolean accept(FTPFile Dzjv7dD8) {
					return Dzjv7dD8.getName().startsWith(E9XFAYLR);
				}
			});
			FTPFile pz2azt9N = VV0krSps[VV0krSps.length - 1];
			C9aLXQLc.setFileTransferMode(FTPClient.BINARY_FILE_TYPE);
			boolean kahKQzac = false;
			String Pk6WOdWQ = jGVar1lB + "/" + pz2azt9N.getName();
			if (kahKQzac) {
				File qaeFkAGn = new File("/home/randres/Desktop/" + pz2azt9N.getName());
				FileOutputStream zdFvxNgl = new FileOutputStream(qaeFkAGn);
				zdFvxNgl.flush();
				zdFvxNgl.close();
			} else {
				GZIPInputStream oDSMW8eZ = new GZIPInputStream(C9aLXQLc.retrieveFileStream(Pk6WOdWQ));
				LineNumberReader mkjTBQ9Z = new LineNumberReader(new InputStreamReader(oDSMW8eZ, "Cp1250"));
				String LiXsxMyw = null;
				while ((LiXsxMyw = mkjTBQ9Z.readLine()) != null) {
					t2JE14kh.addEstacion(AemetRetriever.processLine(LiXsxMyw));
				}
				mkjTBQ9Z.close();
			}
			C9aLXQLc.disconnect();
		} catch (Exception LJCSyFHc) {
			LOGGER.log(Level.WARNING, "Cannot retrieve data from FTP", LJCSyFHc);
		}
		return t2JE14kh;
	}

}