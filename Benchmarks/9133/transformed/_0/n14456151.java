class n14456151 {
	List HttpPost(URL A4v4sskx, List F682pKea) throws IOException {
		List KbpposTt = new ArrayList();
		URLConnection rdJyivWC;
		BufferedReader vK3gv82s;
		OutputStreamWriter bzCqsvxb;
		StringBuffer ejzdIpVD;
		String ljuNc9Hx;
		logInfo("HTTP POST: " + A4v4sskx);
		rdJyivWC = A4v4sskx.openConnection();
		rdJyivWC.setDoInput(true);
		rdJyivWC.setDoOutput(true);
		rdJyivWC.setUseCaches(false);
		rdJyivWC.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		bzCqsvxb = new OutputStreamWriter(rdJyivWC.getOutputStream());
		ejzdIpVD = new StringBuffer();
		for (int p4qOoUo3 = 0, bwgFej1Y = F682pKea.size(); p4qOoUo3 < bwgFej1Y; p4qOoUo3++) {
			if (p4qOoUo3 != 0)
				ejzdIpVD.append("&");
			ejzdIpVD.append(((HttpHeader) F682pKea.get(p4qOoUo3)).key);
			ejzdIpVD.append("=");
			if (((HttpHeader) F682pKea.get(p4qOoUo3)).unicode) {
				StringBuffer ZcyArhwk = new StringBuffer(200);
				byte[] GS0TFFHQ = ((HttpHeader) F682pKea.get(p4qOoUo3)).value.getBytes("UnicodeBigUnmarked");
				for (int nHGRFLLA = 0; nHGRFLLA < GS0TFFHQ.length; nHGRFLLA++)
					ZcyArhwk.append(Integer.toHexString(GS0TFFHQ[nHGRFLLA]).length() == 1
							? "0" + Integer.toHexString(GS0TFFHQ[nHGRFLLA])
							: Integer.toHexString(GS0TFFHQ[nHGRFLLA]));
				ejzdIpVD.append(ZcyArhwk.toString().replaceAll("ff", ""));
			} else
				ejzdIpVD.append(((HttpHeader) F682pKea.get(p4qOoUo3)).value);
		}
		bzCqsvxb.write(ejzdIpVD.toString());
		bzCqsvxb.flush();
		bzCqsvxb.close();
		vK3gv82s = new BufferedReader(new InputStreamReader((rdJyivWC.getInputStream())));
		while ((ljuNc9Hx = vK3gv82s.readLine()) != null)
			KbpposTt.add(ljuNc9Hx);
		vK3gv82s.close();
		return KbpposTt;
	}

}