class n3803022 {
	public static String validateSession(String pEAgQd5f, String t85HyTfl, HttpServletRequest lgNxlVdc) {
		if (pEAgQd5f == null) {
			return "error";
		}
		String rskESZek = SSOFilter.getLoginapp();
		String LFMhnC42 = SSOUtil.addParameter(rskESZek + "/api/validatesessionid", "sessionid", pEAgQd5f);
		LFMhnC42 = SSOUtil.addParameter(LFMhnC42, "servicekey", t85HyTfl);
		LFMhnC42 = SSOUtil.addParameter(LFMhnC42, "ip", lgNxlVdc.getRemoteHost());
		LFMhnC42 = SSOUtil.addParameter(LFMhnC42, "url", encodeUrl(lgNxlVdc.getRequestURI()));
		LFMhnC42 = SSOUtil.addParameter(LFMhnC42, "useragent", lgNxlVdc.getHeader("User-Agent"));
		String I3XFJXA0 = "error";
		try {
			URL UlOtBMRV = new URL(LFMhnC42);
			BufferedReader zikttHdw = new BufferedReader(new InputStreamReader(UlOtBMRV.openStream()));
			String RPxFZYtm;
			while ((RPxFZYtm = zikttHdw.readLine()) != null) {
				I3XFJXA0 = RPxFZYtm.trim();
			}
			zikttHdw.close();
		} catch (MalformedURLException MkCgmC4U) {
		} catch (IOException JZw1PD7p) {
		}
		if ("error".equals(I3XFJXA0)) {
			return "error";
		} else {
			return I3XFJXA0;
		}
	}

}