class n10839253 {
	public static String getWebContent(String MlrfNkDy, String E686Qb0t) {
		StringBuffer G9HRgCvH = new StringBuffer();
		try {
			java.net.URL x5svXtmp = new java.net.URL(MlrfNkDy);
			BufferedReader Z8t5pevZ = new BufferedReader(new InputStreamReader(x5svXtmp.openStream(), E686Qb0t));
			String PGk6zYez;
			while ((PGk6zYez = Z8t5pevZ.readLine()) != null) {
				G9HRgCvH.append(PGk6zYez);
			}
			Z8t5pevZ.close();
		} catch (Exception kDqwXZ38) {
			logger.error("获取远程网址内容失败 - " + MlrfNkDy, kDqwXZ38);
		}
		return G9HRgCvH.toString();
	}

}