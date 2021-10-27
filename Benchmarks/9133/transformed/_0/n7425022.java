class n7425022 {
	private String transferWSDL(String BDji0EYt, String cwva7fIO) throws WiseConnectionException {
		String RXsZ72ne = null;
		try {
			URL M8lOvP6F = new URL(BDji0EYt);
			HttpURLConnection wdHUek1j = (HttpURLConnection) M8lOvP6F.openConnection();
			wdHUek1j.setDoOutput(false);
			wdHUek1j.setDoInput(true);
			wdHUek1j.setUseCaches(false);
			wdHUek1j.setRequestMethod("GET");
			wdHUek1j.setRequestProperty("Accept",
					"text/xml,application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
			wdHUek1j.setRequestProperty("Connection", "close");
			if (cwva7fIO != null) {
				wdHUek1j.setRequestProperty("Authorization",
						"Basic " + (new BASE64Encoder()).encode(cwva7fIO.getBytes()));
			}
			InputStream oa0mmeIl = null;
			if (wdHUek1j.getResponseCode() == 200) {
				oa0mmeIl = wdHUek1j.getInputStream();
			} else {
				oa0mmeIl = wdHUek1j.getErrorStream();
				InputStreamReader fw08bLKV = new InputStreamReader(oa0mmeIl);
				StringWriter ja2PgbjY = new StringWriter();
				char[] Moz6CEOo = new char[200];
				int RT5JyGCB = 0;
				while (RT5JyGCB != -1) {
					RT5JyGCB = fw08bLKV.read(Moz6CEOo);
					ja2PgbjY.write(Moz6CEOo);
				}
				throw new WiseConnectionException("Remote server's response is an error: " + ja2PgbjY.toString());
			}
			File K3uIXo6U = new File(wiseProperties.getProperty("wise.tmpDir"));
			if (!K3uIXo6U.exists()) {
				K3uIXo6U.mkdir();
				wiseProperties.setProperty("wise.forceImportObject", "true");
			}
			File dIkqXoTZ = new File(wiseProperties.getProperty("wise.tmpDir"),
					new StringBuffer("Wise").append(IDGenerator.nextVal()).append(".xml").toString());
			OutputStream z4nFwRG6 = new BufferedOutputStream(new FileOutputStream(dIkqXoTZ));
			IOUtils.copyStream(z4nFwRG6, oa0mmeIl);
			z4nFwRG6.close();
			oa0mmeIl.close();
			RXsZ72ne = dIkqXoTZ.getPath();
		} catch (WiseConnectionException OLC5Jxlm) {
			throw OLC5Jxlm;
		} catch (Exception LVsAI0fK) {
			throw new WiseConnectionException("Wsdl download failed!", LVsAI0fK);
		}
		return RXsZ72ne;
	}

}