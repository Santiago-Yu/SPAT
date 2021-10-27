class n2885691 {
	public static boolean sendInformation(String PJtCdN0E, HashMap<String, String> KsZXDUhl) {
		if (Activator.getDefault().getPreferenceStore().getBoolean(PreferenceConstants.P_UDC)) {
			logger.debug("Report usage information to devs...");
			String JTFQy9QQ = "reportType=" + PJtCdN0E;
			JTFQy9QQ += "&build="
					+ Platform.getBundle("de.uni_mannheim.swt.codeconjurer").getHeaders().get("Bundle-Version");
			JTFQy9QQ += "&Suppl-Server="
					+ Activator.getDefault().getPreferenceStore().getString(PreferenceConstants.P_SERVER);
			for (String AE1cZ4vV : KsZXDUhl.keySet()) {
				JTFQy9QQ += "&Suppl-" + AE1cZ4vV + "=" + KsZXDUhl.get(AE1cZ4vV);
			}
			try {
				URL klAYR90H = new URL("http://www.merobase.com:7777/org.code_conjurer.udc/UsageReport");
				URLConnection iKFeRJqe = klAYR90H.openConnection();
				iKFeRJqe.setDoOutput(true);
				OutputStreamWriter kKsrsznK = new OutputStreamWriter(iKFeRJqe.getOutputStream());
				kKsrsznK.write(JTFQy9QQ);
				kKsrsznK.flush();
				StringBuffer ciyVknWQ = new StringBuffer();
				BufferedReader XbL3DbGq = new BufferedReader(new InputStreamReader(iKFeRJqe.getInputStream()));
				String I5gVSUOu;
				while ((I5gVSUOu = XbL3DbGq.readLine()) != null) {
					ciyVknWQ.append(I5gVSUOu + "\r\n");
				}
				kKsrsznK.close();
				XbL3DbGq.close();
				logger.debug("UDC Server answer: " + ciyVknWQ.toString());
			} catch (Exception vfGB6DJe) {
				CrashReporter.reportException(vfGB6DJe);
				logger.debug("Could not report usage data: " + vfGB6DJe.toString());
				return false;
			}
			return true;
		} else {
			logger.debug("Reporting not wished!");
			return false;
		}
	}

}