class n3461964 {
	public String useService(HashMap<String, String> HR6Kkk3t) {
		String Prufmyva = "";
		if (HR6Kkk3t.size() < 1) {
			return "";
		}
		String tHFpwRvh = "";
		try {
			for (String SjYH3Ipv : HR6Kkk3t.keySet()) {
				tHFpwRvh += "&" + URLEncoder.encode(SjYH3Ipv, "UTF-8") + "="
						+ URLEncoder.encode(HR6Kkk3t.get(SjYH3Ipv), "UTF-8");
			}
			tHFpwRvh = tHFpwRvh.substring(1);
			URL VQEDDwBF = new URL(serviceUrl);
			URLConnection X1lfo7zA = VQEDDwBF.openConnection();
			X1lfo7zA.setDoOutput(true);
			OutputStreamWriter fVBqT7kE = new OutputStreamWriter(X1lfo7zA.getOutputStream());
			fVBqT7kE.write(tHFpwRvh);
			fVBqT7kE.flush();
			BufferedReader ghQf9J0D = new BufferedReader(new InputStreamReader(X1lfo7zA.getInputStream()));
			String KKCXDxQw;
			while ((KKCXDxQw = ghQf9J0D.readLine()) != null) {
				Prufmyva += KKCXDxQw;
			}
			fVBqT7kE.close();
			ghQf9J0D.close();
		} catch (Exception gMCK6ls7) {
			gMCK6ls7.printStackTrace();
		}
		return Prufmyva;
	}

}