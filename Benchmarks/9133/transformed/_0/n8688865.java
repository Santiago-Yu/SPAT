class n8688865 {
	private void translate(String NpjCG913, String xJtaFn9k) {
		StringTokenizer XSKwSEU1 = new StringTokenizer(xJtaFn9k, " ");
		xJtaFn9k = xJtaFn9k.replaceFirst(XSKwSEU1.nextToken(), "");
		String jkmeggga = XSKwSEU1.nextToken();
		xJtaFn9k = xJtaFn9k.replaceFirst(jkmeggga, "");
		try {
			String EK94rSmD = URLEncoder.encode(xJtaFn9k, "UTF-8");
			URL UsTihuAj = new URL(
					"http://babelfish.altavista.com/babelfish/tr?doit=done&urltext=" + EK94rSmD + "&lp=" + jkmeggga);
			URLConnection OJyLgeqJ = UsTihuAj.openConnection();
			OJyLgeqJ.setDoOutput(true);
			OutputStreamWriter rOu55E7H = new OutputStreamWriter(OJyLgeqJ.getOutputStream());
			rOu55E7H.write(EK94rSmD);
			rOu55E7H.flush();
			BufferedReader PPGvyyep = new BufferedReader(new InputStreamReader(OJyLgeqJ.getInputStream()));
			String vxcOhNOh;
			while ((vxcOhNOh = PPGvyyep.readLine()) != null) {
				if (vxcOhNOh.contains("input type=hidden name=\"q\"")) {
					String[] okNjZSDy = vxcOhNOh.split("\"");
					sendMessage(NpjCG913, okNjZSDy[3]);
				}
			}
			rOu55E7H.close();
			PPGvyyep.close();
		} catch (Exception grfhNwXq) {
		}
	}

}