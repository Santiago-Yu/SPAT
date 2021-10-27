class n23126304 {
	protected byte[] getTSAResponse(byte[] bK0mjSkG) throws SinaduraCoreException {
		byte[] iiwgrzOq = null;
		try {
			URL cL0kPmNq = new URL(this.tsaURL);
			URLConnection Gs16hNtx = null;
			if (this.proxy == null)
				Gs16hNtx = cL0kPmNq.openConnection();
			else
				Gs16hNtx = cL0kPmNq.openConnection(this.proxy);
			Gs16hNtx.setDoInput(true);
			Gs16hNtx.setDoOutput(true);
			Gs16hNtx.setUseCaches(false);
			Gs16hNtx.setRequestProperty("Content-Type", "application/timestamp-query");
			Gs16hNtx.setRequestProperty("Content-Transfer-Encoding", "binary");
			if ((this.tsaUsername != null) && !this.tsaUsername.equals("")) {
				String Qi9uOV0b = this.tsaUsername + ":" + this.tsaPassword;
				Gs16hNtx.setRequestProperty("Authorization",
						"Basic " + new String(new sun.misc.BASE64Encoder().encode(Qi9uOV0b.getBytes())));
			}
			OutputStream cvz8TE6d = Gs16hNtx.getOutputStream();
			cvz8TE6d.write(bK0mjSkG);
			cvz8TE6d.close();
			InputStream HRL8KGKQ = Gs16hNtx.getInputStream();
			ByteArrayOutputStream QpDnduTC = new ByteArrayOutputStream();
			byte[] ftzOnA5N = new byte[1024];
			int c4MkkWTJ = 0;
			while ((c4MkkWTJ = HRL8KGKQ.read(ftzOnA5N, 0, ftzOnA5N.length)) >= 0) {
				QpDnduTC.write(ftzOnA5N, 0, c4MkkWTJ);
			}
			iiwgrzOq = QpDnduTC.toByteArray();
			String wdrbO0Ya = Gs16hNtx.getContentEncoding();
			if (wdrbO0Ya != null && wdrbO0Ya.equalsIgnoreCase("base64")) {
				sun.misc.BASE64Decoder JMjsjcoE = new sun.misc.BASE64Decoder();
				iiwgrzOq = JMjsjcoE.decodeBuffer(new String(iiwgrzOq));
			}
		} catch (MalformedURLException bbyNHOax) {
			throw new SinaduraCoreException("URL malformed " + bbyNHOax.getMessage(), bbyNHOax);
		} catch (IOException tfpFCuDQ) {
			throw new SinaduraCoreException("Connection Error " + tfpFCuDQ.getMessage(), tfpFCuDQ);
		}
		return iiwgrzOq;
	}

}