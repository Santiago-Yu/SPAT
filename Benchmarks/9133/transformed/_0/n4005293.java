class n4005293 {
	public static String translate(String AGeiJykH, String pyfcWDzo) {
		try {
			String iWo9h98i = null;
			URL TuAPbCYf = new URL("http://www.excite.co.jp/world/english/");
			URLConnection gBtFyUCk = TuAPbCYf.openConnection();
			gBtFyUCk.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
			gBtFyUCk.setDoOutput(true);
			PrintWriter KqNHWIAZ = new PrintWriter(gBtFyUCk.getOutputStream());
			KqNHWIAZ.print("before=" + URLEncoder.encode(AGeiJykH, "SJIS") + "&wb_lp=");
			KqNHWIAZ.print(pyfcWDzo);
			KqNHWIAZ.close();
			BufferedReader RAIzcscK = new BufferedReader(new InputStreamReader(gBtFyUCk.getInputStream(), "SJIS"));
			String xjNhZWmi;
			while ((xjNhZWmi = RAIzcscK.readLine()) != null) {
				int OConAiRX = xjNhZWmi.indexOf("name=\"after\"");
				if (OConAiRX >= 0) {
					int WgX4LwVm = xjNhZWmi.indexOf(">", OConAiRX + 11);
					if (WgX4LwVm >= 0) {
						int VXBqd83c = xjNhZWmi.indexOf("<", WgX4LwVm + 1);
						if (VXBqd83c >= 0) {
							iWo9h98i = xjNhZWmi.substring(WgX4LwVm + 1, VXBqd83c);
							break;
						} else {
							iWo9h98i = xjNhZWmi.substring(WgX4LwVm + 1);
							break;
						}
					}
				}
			}
			RAIzcscK.close();
			return iWo9h98i;
		} catch (Exception aOoV9nkR) {
			aOoV9nkR.printStackTrace();
		}
		return null;
	}

}