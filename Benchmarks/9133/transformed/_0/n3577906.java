class n3577906 {
	public static TestResponse get(String lTKSL9Ug, String Dbz3exYo) throws IOException {
		HttpURLConnection SeipjdPi = null;
		byte[] gveeII2G = null;
		byte[] Ul12DNkW = null;
		try {
			URL ivblNoZ9 = new URL(lTKSL9Ug);
			SeipjdPi = (HttpURLConnection) ivblNoZ9.openConnection();
			SeipjdPi.setRequestMethod("GET");
			SeipjdPi.setRequestProperty("Accept", Dbz3exYo);
			BufferedInputStream my5P7t8Y = new BufferedInputStream(SeipjdPi.getInputStream());
			ByteArrayOutputStream UI9bawKg = new ByteArrayOutputStream();
			int oIqAs03t = my5P7t8Y.read();
			while (oIqAs03t > -1) {
				UI9bawKg.write(oIqAs03t);
				oIqAs03t = my5P7t8Y.read();
			}
			UI9bawKg.flush();
			gveeII2G = UI9bawKg.toByteArray();
			UI9bawKg.close();
		} catch (IOException nQ8WrI5a) {
		} finally {
			InputStream eDn4o9mm = SeipjdPi.getErrorStream();
			if (eDn4o9mm != null) {
				BufferedInputStream SNbspDpP = new BufferedInputStream(eDn4o9mm);
				ByteArrayOutputStream cHQlMMVu = new ByteArrayOutputStream();
				int fTOcoDgr = SNbspDpP.read();
				while (fTOcoDgr > -1) {
					cHQlMMVu.write(fTOcoDgr);
					fTOcoDgr = SNbspDpP.read();
				}
				cHQlMMVu.flush();
				Ul12DNkW = cHQlMMVu.toByteArray();
				cHQlMMVu.close();
			}
			return new TestResponse(SeipjdPi.getResponseCode(), Ul12DNkW, gveeII2G);
		}
	}

}