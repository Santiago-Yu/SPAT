class n6744825 {
	private static String getTextFromURL(HttpServletRequest E3kjUc2M, String QeFujHug) {
		StringBuffer AwQ4aOMY = new StringBuffer();
		if (!QeFujHug.startsWith("http")) {
			String R8nKy0Jg = E3kjUc2M.getRequestURL().toString();
			QeFujHug = R8nKy0Jg.substring(0, R8nKy0Jg.lastIndexOf("/")) + QeFujHug;
		}
		try {
			URL kKRSAsyQ = new URL(QeFujHug);
			BufferedReader EyPs3qSW = new BufferedReader(new InputStreamReader(kKRSAsyQ.openStream()));
			String cOwgBmh7 = "";
			while ((cOwgBmh7 = EyPs3qSW.readLine()) != null) {
				AwQ4aOMY.append(cOwgBmh7);
				AwQ4aOMY.append(Constants.LF);
			}
		} catch (FileNotFoundException NmltJKSh) {
			log.error("File not found: " + QeFujHug, NmltJKSh);
		} catch (Exception tEku00lR) {
			log.error("Exception while reading file: " + QeFujHug, tEku00lR);
		}
		return AwQ4aOMY.toString();
	}

}