class n1026390 {
	public boolean login(String YEoV2sks, String d5u3qFXh, String FIKwAO7w) throws ApplicationException {
		String w5ZjT7Iq = "-----------------------------";
		String Uo89awQe = "\r\n";
		String NtapCMCO = "--";
		String rNyEA2o3 = YEoV2sks;
		String Div821Za = null;
		List rekIvqpz = new ArrayList();
		List B3r2Yx3x = new ArrayList();
		String pgTbGY18 = null;
		String GTPKANxm = null;
		StringBuffer dAfkh9QN = new StringBuffer();
		List Xv9fQhgv = new ArrayList();
		final String P3n9EY2h = String.valueOf(System.currentTimeMillis());
		URL f7QSqv9C = null;
		URLConnection pMuFOgm7 = null;
		BufferedReader toe6gQJE = null;
		DataOutputStream TKneuCSr = null;
		boolean sdS7Dvf8 = false;
		rekIvqpz.add(new HtmlFormText("loginName", d5u3qFXh));
		rekIvqpz.add(new HtmlFormText("loginPwd", FIKwAO7w));
		rekIvqpz.add(new HtmlFormText("navMode", "I"));
		rekIvqpz.add(new HtmlFormText("action", "login"));
		try {
			f7QSqv9C = new URL(rNyEA2o3);
			pMuFOgm7 = f7QSqv9C.openConnection();
			((HttpURLConnection) pMuFOgm7).setRequestMethod("POST");
			pMuFOgm7.setDoInput(true);
			pMuFOgm7.setDoOutput(true);
			pMuFOgm7.setUseCaches(false);
			pMuFOgm7.setRequestProperty("Content-Type",
					"multipart/form-data, boundary=" + "---------------------------" + P3n9EY2h);
			if (Div821Za != null) {
				String V0kh5efs = "Basic " + new sun.misc.BASE64Encoder().encode(Div821Za.getBytes());
				pMuFOgm7.setRequestProperty("Authorization", V0kh5efs);
			}
			TKneuCSr = new DataOutputStream(pMuFOgm7.getOutputStream());
			TKneuCSr.write((w5ZjT7Iq + P3n9EY2h + Uo89awQe).getBytes());
			for (int dJZqqabi = 0; dJZqqabi < rekIvqpz.size(); dJZqqabi++) {
				HtmlFormText PkhUUUUY = (HtmlFormText) rekIvqpz.get(dJZqqabi);
				TKneuCSr.write(PkhUUUUY.getTranslated());
				if (dJZqqabi + 1 < rekIvqpz.size()) {
					TKneuCSr.write((w5ZjT7Iq + P3n9EY2h + Uo89awQe).getBytes());
				} else if (B3r2Yx3x.size() > 0) {
					TKneuCSr.write((w5ZjT7Iq + P3n9EY2h + Uo89awQe).getBytes());
				}
			}
			TKneuCSr.write((w5ZjT7Iq + P3n9EY2h + "--" + Uo89awQe).getBytes());
			TKneuCSr.flush();
			toe6gQJE = new BufferedReader(new InputStreamReader(pMuFOgm7.getInputStream()));
			String YiwlZChu = pMuFOgm7.getHeaderField(HEADER_SETCOOKIE);
			if (YiwlZChu != null) {
				cookie = YiwlZChu.substring(0, YiwlZChu.indexOf(";"));
			}
			String W8ODZOzM;
			int a30e4tzc = 0;
			while (null != ((W8ODZOzM = toe6gQJE.readLine()))) {
				if (!W8ODZOzM.equals("")) {
					if ("window.location.replace(\"/Home.do\");"
							.indexOf(dAfkh9QN.append(formatLine(W8ODZOzM)).toString()) != -1) {
						sdS7Dvf8 = true;
						break;
					}
					a30e4tzc++;
				}
			}
			rekIvqpz.clear();
			B3r2Yx3x.clear();
		} catch (Exception YUtOA1nJ) {
			log.error(YUtOA1nJ, YUtOA1nJ);
			throw new ApplicationException(FormErrorConstant.DB_APP_BASE_URL_ERROR);
		} finally {
			try {
				TKneuCSr.close();
			} catch (Exception p6OzEDgo) {
			}
			try {
				toe6gQJE.close();
			} catch (Exception dxYpMXE7) {
			}
		}
		return sdS7Dvf8;
	}

}