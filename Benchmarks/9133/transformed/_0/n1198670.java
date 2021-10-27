class n1198670 {
	public static String send(String rorJwCU4, String nvVw9Cpn) throws Exception {
		URL tpRH21oQ = new URL(rorJwCU4);
		HttpURLConnection auKPCR35 = (HttpURLConnection) tpRH21oQ.openConnection();
		auKPCR35.setRequestMethod("POST");
		auKPCR35.setDoOutput(true);
		PrintWriter E5uv9skQ = new PrintWriter(auKPCR35.getOutputStream());
		E5uv9skQ.println(nvVw9Cpn);
		E5uv9skQ.flush();
		E5uv9skQ.close();
		System.out.println("Sending: " + nvVw9Cpn);
		StringBuffer lKAv9TRk = new StringBuffer();
		InputStreamReader Htfgf2i9 = null;
		try {
			Htfgf2i9 = new InputStreamReader(auKPCR35.getInputStream());
		} catch (Exception fJD9L5wt) {
			fJD9L5wt.printStackTrace();
			Htfgf2i9 = new InputStreamReader(auKPCR35.getErrorStream());
		}
		BufferedReader GfhhUWxn = new BufferedReader(Htfgf2i9);
		String xZyKWfyz = null;
		while ((xZyKWfyz = GfhhUWxn.readLine()) != null) {
			lKAv9TRk.append(xZyKWfyz);
			lKAv9TRk.append("\n");
		}
		String TQ4Tnm4W = lKAv9TRk.toString();
		return TQ4Tnm4W;
	}

}