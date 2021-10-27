class n3298294 {
	public static String upload_file(String MGqLP3lR, String UlzOK5BV, String QlJNrPat) {
		String xRECB5Dm = "If you see this message, there is some problem inside the function:upload_file()";
		String eo0W1BZC = UlzOK5BV;
		String kF5f8ekB = "https://s2.cloud.cm/rpc/json/?session_id=" + MGqLP3lR + "&c=Storage&m=upload_file&tag="
				+ QlJNrPat;
		String wjGrshWy = "\r\n";
		String gwIaQqJ4 = "--";
		String TRRus4ZK = "******";
		try {
			URL aZmsnef8 = new URL(kF5f8ekB);
			HttpURLConnection jQaR3b5B = (HttpURLConnection) aZmsnef8.openConnection();
			jQaR3b5B.setDoInput(true);
			jQaR3b5B.setDoOutput(true);
			jQaR3b5B.setUseCaches(false);
			jQaR3b5B.setRequestMethod("POST");
			jQaR3b5B.setRequestProperty("Connection", "Keep-Alive");
			jQaR3b5B.setRequestProperty("Charset", "UTF-8");
			jQaR3b5B.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + TRRus4ZK);
			DataOutputStream YAvrjViJ = new DataOutputStream(jQaR3b5B.getOutputStream());
			YAvrjViJ.writeBytes(gwIaQqJ4 + TRRus4ZK + wjGrshWy);
			YAvrjViJ.writeBytes("Content-Disposition: form-data; name=\"file\"; filename=\""
					+ eo0W1BZC.substring(eo0W1BZC.lastIndexOf("/") + 1) + "\"" + wjGrshWy);
			YAvrjViJ.writeBytes(wjGrshWy);
			FileInputStream TDHU2h57 = new FileInputStream(eo0W1BZC);
			byte[] cTWHKiTF = new byte[8192];
			int TUScFeRd = 0;
			while ((TUScFeRd = TDHU2h57.read(cTWHKiTF)) != -1) {
				YAvrjViJ.write(cTWHKiTF, 0, TUScFeRd);
			}
			TDHU2h57.close();
			YAvrjViJ.writeBytes(wjGrshWy);
			YAvrjViJ.writeBytes(gwIaQqJ4 + TRRus4ZK + gwIaQqJ4 + wjGrshWy);
			YAvrjViJ.flush();
			InputStream s5yOsxOa = jQaR3b5B.getInputStream();
			InputStreamReader RYsZCYEC = new InputStreamReader(s5yOsxOa, "utf-8");
			BufferedReader l06C1CXy = new BufferedReader(RYsZCYEC);
			xRECB5Dm = l06C1CXy.readLine();
			YAvrjViJ.close();
			s5yOsxOa.close();
			return xRECB5Dm;
		} catch (Exception rRdjYubT) {
			rRdjYubT.printStackTrace();
		}
		return xRECB5Dm;
	}

}