class n3401153 {
	private String getHTML(String qmjAc8i9, String MSUYlSX5, String T9DUTPm9) throws IOException {
		StringBuilder ISIQPAdI = new StringBuilder();
		HttpURLConnection mA8cxKsx = null;
		try {
			URL t5ibP6BV = new URL(qmjAc8i9);
			mA8cxKsx = (HttpURLConnection) t5ibP6BV.openConnection();
			mA8cxKsx.setRequestProperty("User-Agent", "MSIE 7.0");
			mA8cxKsx.connect();
			BufferedReader bf6b0YeR = new BufferedReader(new InputStreamReader(mA8cxKsx.getInputStream(), MSUYlSX5));
			String JdpGjeFr = null;
			while ((JdpGjeFr = bf6b0YeR.readLine()) != null) {
				ISIQPAdI.append(JdpGjeFr);
				ISIQPAdI.append("\r\n");
			}
		} catch (Exception xrFUwpYJ) {
			xrFUwpYJ.printStackTrace();
		} finally {
			mA8cxKsx.disconnect();
		}
		if (T9DUTPm9 != null) {
			File r2CfvtKk = new File(T9DUTPm9);
			BufferedWriter pFBpYNxw = new BufferedWriter(new FileWriter(r2CfvtKk));
			pFBpYNxw.write(ISIQPAdI.toString());
			pFBpYNxw.close();
		}
		return ISIQPAdI.toString();
	}

}