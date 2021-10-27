class n5236700 {
	public static String getAnalysisServletOutput(String C0ePPN4p) {
		java.io.BufferedWriter DdXxVrmp = null;
		URLConnection iX4bAUo1 = null;
		String vgGnEyAQ = "";
		DdXxVrmp = null;
		iX4bAUo1 = null;
		String bHU2si7G = ServletConstant.ANALYSIS_SERVLET;
		String KGtdUXMf = "\nTHIS MESSAGE IS SENT FROM THE CLIENT APPLET   \n\r";
		try {
			URL YUx9As6W = new URL(bHU2si7G);
			iX4bAUo1 = (HttpURLConnection) YUx9As6W.openConnection();
			((HttpURLConnection) iX4bAUo1).setRequestMethod("POST");
			iX4bAUo1.setDoOutput(true);
			DdXxVrmp = new java.io.BufferedWriter(new java.io.OutputStreamWriter(iX4bAUo1.getOutputStream()));
			DdXxVrmp.write(KGtdUXMf);
			DdXxVrmp.flush();
			DdXxVrmp.close();
			java.io.BufferedReader fKGFqib9 = null;
			fKGFqib9 = new java.io.BufferedReader(new java.io.InputStreamReader(iX4bAUo1.getInputStream()));
			String qCwUWkr6;
			StringBuffer DRANfWnB = new StringBuffer();
			while ((qCwUWkr6 = fKGFqib9.readLine()) != null) {
				DRANfWnB.append(qCwUWkr6);
			}
			vgGnEyAQ = DRANfWnB.toString();
			fKGFqib9.close();
			((HttpURLConnection) iX4bAUo1).disconnect();
		} catch (java.io.IOException qBOP5wbP) {
			vgGnEyAQ += qBOP5wbP.toString();
		} finally {
			if (DdXxVrmp != null) {
				try {
					DdXxVrmp.close();
				} catch (Exception W87u2qJ7) {
					vgGnEyAQ += W87u2qJ7.toString();
				}
			}
			if (iX4bAUo1 != null) {
				try {
					((HttpURLConnection) iX4bAUo1).disconnect();
				} catch (Exception XinYvq5x) {
					vgGnEyAQ += XinYvq5x.toString();
				}
			}
		}
		return vgGnEyAQ;
	}

}