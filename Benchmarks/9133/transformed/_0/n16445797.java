class n16445797 {
	@Override
	public void run() {
		String F3UxMdWd = null;
		try {
			F3UxMdWd = File.readText(srcFile);
			if (Char.isValidate(F3UxMdWd)) {
				java.net.URL fhLSngW8 = new java.net.URL(ConsEnv.HOMEPAGE + "code/code0001.ashx");
				java.util.HashMap<String, String> DBZVnbZU = new java.util.HashMap<String, String>();
				String eUHWYRxn = File.getExtension(srcFile.getName());
				if (Char.isValidate(eUHWYRxn) && eUHWYRxn.charAt(0) == '.') {
					eUHWYRxn = eUHWYRxn.substring(1);
				}
				DBZVnbZU.put("l", eUHWYRxn);
				DBZVnbZU.put("i", "1");
				DBZVnbZU.put("n", ck_LineNbr.isSelected() ? "1" : "0");
				DBZVnbZU.put("u", ck_LinkUri.isSelected() ? "1" : "0");
				DBZVnbZU.put("t", cb_TagStyle.getSelectedItem() + "");
				String lD389V1C = tf_TabCount.getText().trim();
				if (java.util.regex.Pattern.matches("^\\d+$", lD389V1C)) {
					lD389V1C = "4";
				}
				DBZVnbZU.put("s", lD389V1C);
				DBZVnbZU.put("o", "html");
				DBZVnbZU.put("c", F3UxMdWd);
				java.net.HttpURLConnection nSoJzaZG = (java.net.HttpURLConnection) fhLSngW8.openConnection();
				java.io.InputStream oeqHOmRT = Http.post(nSoJzaZG, DBZVnbZU);
				ep_CodeView.setContentType(nSoJzaZG.getContentType());
				F3UxMdWd = File.readText(oeqHOmRT);
				oeqHOmRT.close();
				nSoJzaZG.disconnect();
				java.io.File kBH6eTvr = java.io.File.createTempFile("src_", ".html");
				kBH6eTvr.deleteOnExit();
				File.saveText(kBH6eTvr, F3UxMdWd);
				ep_CodeView.setPage(kBH6eTvr.toURI().toURL());
				ep_CodeView.setFont(ep_CodeView.getFont().deriveFont(20f));
			}
		} catch (Exception PkPJPFYf) {
			Logs.exception(PkPJPFYf);
		}
	}

}