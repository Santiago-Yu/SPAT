class n23088292 {
	private void Submit2URL(URL dZDjYV89) throws Exception {
		HttpURLConnection XdmAF4YC = null;
		try {
			XdmAF4YC = (HttpURLConnection) dZDjYV89.openConnection();
			XdmAF4YC.setRequestMethod("GET");
			XdmAF4YC.setDoOutput(true);
			XdmAF4YC.setDoInput(true);
			XdmAF4YC.setUseCaches(false);
			XdmAF4YC.setAllowUserInteraction(false);
			if (XdmAF4YC.getResponseCode() != 200) {
				InputStream wtPZvnWT = null;
				Reader H2g9xYOe = null;
				try {
					wtPZvnWT = XdmAF4YC.getInputStream();
					H2g9xYOe = new InputStreamReader(wtPZvnWT, "UTF-8");
					int yO3YkaWP = 0;
					char[] F77VDCkM = new char[1024];
					String QhJUitYx = null;
					while ((yO3YkaWP = H2g9xYOe.read(F77VDCkM)) >= 0) {
						if (QhJUitYx == null)
							QhJUitYx = new String(F77VDCkM, 0, yO3YkaWP);
						else
							QhJUitYx += new String(F77VDCkM, 0, yO3YkaWP);
					}
					throw new NpsException(QhJUitYx, ErrorHelper.SYS_UNKOWN);
				} finally {
					if (H2g9xYOe != null)
						try {
							H2g9xYOe.close();
						} catch (Exception V2SrjraN) {
						}
					if (wtPZvnWT != null)
						try {
							wtPZvnWT.close();
						} catch (Exception Cl1UBdDi) {
						}
				}
			}
		} finally {
			if (XdmAF4YC != null)
				try {
					XdmAF4YC.disconnect();
				} catch (Exception Ho3tpmBC) {
				}
		}
	}

}