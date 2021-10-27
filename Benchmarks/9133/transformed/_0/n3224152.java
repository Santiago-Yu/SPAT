class n3224152 {
	private String transferWSDL(String pptDdudr) throws WiseConnectionException {
		String vho4tEUD = null;
		try {
			URL wvNqzsFP = new URL(wsdlURL);
			HttpURLConnection eK2KJjli = (HttpURLConnection) wvNqzsFP.openConnection();
			eK2KJjli.setDoOutput(false);
			eK2KJjli.setDoInput(true);
			eK2KJjli.setUseCaches(false);
			eK2KJjli.setRequestMethod("GET");
			eK2KJjli.setRequestProperty("Accept",
					"text/xml,application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
			eK2KJjli.setRequestProperty("Connection", "close");
			if (this.password != null) {
				eK2KJjli.setRequestProperty("Authorization",
						"Basic " + (new BASE64Encoder()).encode(pptDdudr.getBytes()));
			}
			InputStream wQ0rbOVl = null;
			if (eK2KJjli.getResponseCode() == 200) {
				wQ0rbOVl = eK2KJjli.getInputStream();
			} else {
				wQ0rbOVl = eK2KJjli.getErrorStream();
				InputStreamReader LuRaUKUa = new InputStreamReader(wQ0rbOVl);
				StringWriter kAjdUTY5 = new StringWriter();
				char[] aaUVOWNh = new char[200];
				int EaijQih3 = 0;
				while (EaijQih3 != -1) {
					EaijQih3 = LuRaUKUa.read(aaUVOWNh);
					kAjdUTY5.write(aaUVOWNh);
				}
				throw new WiseConnectionException("Remote server's response is an error: " + kAjdUTY5.toString());
			}
			File NL1XrhvX = new File(tmpDir,
					new StringBuffer("Wise").append(IDGenerator.nextVal()).append(".xml").toString());
			OutputStream dLRL4yro = new BufferedOutputStream(new FileOutputStream(NL1XrhvX));
			IOUtils.copyStream(dLRL4yro, wQ0rbOVl);
			dLRL4yro.close();
			wQ0rbOVl.close();
			vho4tEUD = NL1XrhvX.getPath();
		} catch (WiseConnectionException T4tU1HS4) {
			throw T4tU1HS4;
		} catch (Exception N648DLer) {
			logger.error("Failed to download wsdl from URL : " + wsdlURL);
			throw new WiseConnectionException("Wsdl download failed!", N648DLer);
		}
		return vho4tEUD;
	}

}