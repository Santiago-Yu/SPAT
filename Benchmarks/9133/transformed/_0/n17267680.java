class n17267680 {
	private String transferWSDL(String sfsbPjKn, String cmmnSSgj) throws WiseConnectionException {
		String k8QhCK7L = null;
		try {
			URL NVzfqycf = new URL(sfsbPjKn);
			HttpURLConnection PFHHD3Ot = (HttpURLConnection) NVzfqycf.openConnection();
			PFHHD3Ot.setDoOutput(false);
			PFHHD3Ot.setDoInput(true);
			PFHHD3Ot.setUseCaches(false);
			PFHHD3Ot.setRequestMethod("GET");
			PFHHD3Ot.setRequestProperty("Accept",
					"text/xml,application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
			PFHHD3Ot.setRequestProperty("Connection", "close");
			if (cmmnSSgj != null) {
				PFHHD3Ot.setRequestProperty("Authorization",
						"Basic " + (new BASE64Encoder()).encode(cmmnSSgj.getBytes()));
			}
			InputStream eFOwxJGU = null;
			if (PFHHD3Ot.getResponseCode() == 200) {
				eFOwxJGU = PFHHD3Ot.getInputStream();
			} else {
				eFOwxJGU = PFHHD3Ot.getErrorStream();
				InputStreamReader JkZ63U2d = new InputStreamReader(eFOwxJGU);
				StringWriter sUETn24D = new StringWriter();
				char[] IG4CmdXz = new char[200];
				int mna5kKlA = 0;
				while (mna5kKlA != -1) {
					mna5kKlA = JkZ63U2d.read(IG4CmdXz);
					sUETn24D.write(IG4CmdXz);
				}
				throw new WiseConnectionException("Remote server's response is an error: " + sUETn24D.toString());
			}
			File ke27QjxV = new File(tmpDeployDir,
					new StringBuffer("Wise").append(IDGenerator.nextVal()).append(".xml").toString());
			OutputStream l1EFNvwF = new BufferedOutputStream(new FileOutputStream(ke27QjxV));
			IOUtils.copyStream(l1EFNvwF, eFOwxJGU);
			l1EFNvwF.close();
			eFOwxJGU.close();
			k8QhCK7L = ke27QjxV.getPath();
		} catch (WiseConnectionException UKdQEtCv) {
			throw UKdQEtCv;
		} catch (Exception AySk7vkD) {
			throw new WiseConnectionException("Wsdl download failed!", AySk7vkD);
		}
		return k8QhCK7L;
	}

}