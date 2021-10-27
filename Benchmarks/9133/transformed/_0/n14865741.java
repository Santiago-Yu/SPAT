class n14865741 {
	public boolean login(URL bc8MXRSs, String IbLERwof, String yPQdxmuu, String cOTEYYqZ) throws Exception {
		String SzWISzpI = "-----------------------------";
		String TPDFpDPa = "\r\n";
		String EqZ88YUl = "--";
		URL ox84Kw6x = bc8MXRSs;
		String m93JPtZ1 = null;
		List AsfCDSro = new ArrayList();
		List LilZ9c0R = new ArrayList();
		String hplvwWGf = null;
		String r1fWc0V8 = null;
		StringBuffer COuGgC0f = new StringBuffer();
		List XxZ66yYc = new ArrayList();
		final String KmP6B70L = String.valueOf(System.currentTimeMillis());
		URL IFQqN78X = null;
		URLConnection SuWTwT3X = null;
		BufferedReader wTIlQlal = null;
		DataOutputStream l8OM69DE = null;
		boolean PUxXqO2K = false;
		AsfCDSro.add(new HtmlFormText("loginName", IbLERwof));
		AsfCDSro.add(new HtmlFormText("loginPwd", yPQdxmuu));
		AsfCDSro.add(new HtmlFormText("navMode", "I"));
		AsfCDSro.add(new HtmlFormText("action", "login"));
		try {
			IFQqN78X = new URL(ox84Kw6x, "/" + projectName + "/Login.do");
			SuWTwT3X = IFQqN78X.openConnection();
			((HttpURLConnection) SuWTwT3X).setRequestMethod("POST");
			SuWTwT3X.setDoInput(true);
			SuWTwT3X.setDoOutput(true);
			SuWTwT3X.setUseCaches(false);
			SuWTwT3X.setRequestProperty("Content-Type",
					"multipart/form-data, boundary=" + "---------------------------" + KmP6B70L);
			if (m93JPtZ1 != null) {
				String Nla9HBEy = "Basic " + new sun.misc.BASE64Encoder().encode(m93JPtZ1.getBytes());
				SuWTwT3X.setRequestProperty("Authorization", Nla9HBEy);
			}
			l8OM69DE = new DataOutputStream(SuWTwT3X.getOutputStream());
			l8OM69DE.write((SzWISzpI + KmP6B70L + TPDFpDPa).getBytes());
			for (int sQYiAdmU = 0; sQYiAdmU < AsfCDSro.size(); sQYiAdmU++) {
				HtmlFormText dZlBanrv = (HtmlFormText) AsfCDSro.get(sQYiAdmU);
				l8OM69DE.write(dZlBanrv.getTranslated());
				if (sQYiAdmU + 1 < AsfCDSro.size()) {
					l8OM69DE.write((SzWISzpI + KmP6B70L + TPDFpDPa).getBytes());
				} else if (LilZ9c0R.size() > 0) {
					l8OM69DE.write((SzWISzpI + KmP6B70L + TPDFpDPa).getBytes());
				}
			}
			l8OM69DE.write((SzWISzpI + KmP6B70L + "--" + TPDFpDPa).getBytes());
			l8OM69DE.flush();
			wTIlQlal = new BufferedReader(new InputStreamReader(SuWTwT3X.getInputStream()));
			String jdaixDO6;
			String rM94rUoG;
			int LsfRQqYf = 1;
			jdaixDO6 = SuWTwT3X.getHeaderFieldKey(LsfRQqYf);
			rM94rUoG = SuWTwT3X.getHeaderField(LsfRQqYf);
			System.out.println(rM94rUoG);
			if (Utility.isEmpty(rM94rUoG) || rM94rUoG.indexOf("JSESSIONID") < 0) {
				rM94rUoG = "JSESSIONID=" + cOTEYYqZ + "; Path=/" + projectName;
			}
			while (jdaixDO6 != null) {
				XxZ66yYc.add(rM94rUoG);
				LsfRQqYf++;
				jdaixDO6 = SuWTwT3X.getHeaderFieldKey(LsfRQqYf);
				rM94rUoG = SuWTwT3X.getHeaderField(LsfRQqYf);
			}
			String WCmNG2PW;
			int GV8CN8hI = 0;
			while (null != ((WCmNG2PW = wTIlQlal.readLine()))) {
				if (!WCmNG2PW.equals("")) {
					if ("window.location.replace(\"/eip/Home.do\");"
							.indexOf(COuGgC0f.append(formatLine(WCmNG2PW)).toString()) != -1) {
						PUxXqO2K = true;
						break;
					}
					GV8CN8hI++;
				}
			}
			AsfCDSro.clear();
			LilZ9c0R.clear();
		} catch (Exception bp3j8EtU) {
			bp3j8EtU.printStackTrace();
		} finally {
			try {
				l8OM69DE.close();
			} catch (Exception hxp9kVDn) {
			}
			try {
				wTIlQlal.close();
			} catch (Exception pc4WEqIq) {
			}
		}
		this.setHeadList(XxZ66yYc);
		return PUxXqO2K;
	}

}