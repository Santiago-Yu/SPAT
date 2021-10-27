class n9036637 {
	public static boolean reportException(Throwable fNNxGbCm, HashMap<String, String> EkrnjFC1) {
		if (Activator.getDefault().getPreferenceStore().getBoolean(PreferenceConstants.P_CRASH_REPORTING)) {
			logger.debug("Report exception to devs...");
			String eI51DEK3 = "reportType=exception&" + "message=" + fNNxGbCm.getMessage();
			eI51DEK3 += "&build="
					+ Platform.getBundle("de.uni_mannheim.swt.codeconjurer").getHeaders().get("Bundle-Version");
			int ZVoJudR2 = 0;
			for (StackTraceElement s5FbsINd : fNNxGbCm.getStackTrace()) {
				eI51DEK3 += "&st_line_" + ++ZVoJudR2 + "=" + s5FbsINd.getClassName() + "#" + s5FbsINd.getMethodName()
						+ "<" + s5FbsINd.getLineNumber() + ">";
			}
			eI51DEK3 += "&lines=" + ZVoJudR2;
			eI51DEK3 += "&Suppl-Description=" + fNNxGbCm.toString();
			eI51DEK3 += "&Suppl-Server="
					+ Activator.getDefault().getPreferenceStore().getString(PreferenceConstants.P_SERVER);
			eI51DEK3 += "&Suppl-User="
					+ Activator.getDefault().getPreferenceStore().getString(PreferenceConstants.P_USERNAME);
			if (EkrnjFC1 != null) {
				for (String YoON15E9 : EkrnjFC1.keySet()) {
					eI51DEK3 += "&Suppl-" + YoON15E9 + "=" + EkrnjFC1.get(YoON15E9);
				}
			}
			try {
				URL JOMlPkx2 = new URL("http://www.merobase.com:7777/org.code_conjurer.udc/CrashReport");
				URLConnection LWSCYRvP = JOMlPkx2.openConnection();
				LWSCYRvP.setDoOutput(true);
				OutputStreamWriter ooJnsSx6 = new OutputStreamWriter(LWSCYRvP.getOutputStream());
				ooJnsSx6.write(eI51DEK3);
				ooJnsSx6.flush();
				StringBuffer EzS3T8NN = new StringBuffer();
				BufferedReader Wets8mqv = new BufferedReader(new InputStreamReader(LWSCYRvP.getInputStream()));
				String hgBdGwUW;
				while ((hgBdGwUW = Wets8mqv.readLine()) != null) {
					EzS3T8NN.append(hgBdGwUW + "\r\n");
				}
				ooJnsSx6.close();
				Wets8mqv.close();
				logger.debug(EzS3T8NN.toString());
			} catch (Exception sgUjcqYH) {
				logger.debug("Could not report exception");
				return false;
			}
			return true;
		} else {
			logger.debug("Reporting not wished!");
			return false;
		}
	}

}