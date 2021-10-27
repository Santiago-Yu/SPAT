class n552318 {
	public boolean connectyahoo(String Q6gqFo2T, String ELNRfLWk) throws Exception {
		String ejBgekWk = new String("");
		String dOS6VZsR = new String("");
		Pattern Uk805iHj;
		Matcher UBhMWg7L;
		int McBGIB4L;
		URL iTn01TAo = new URL("http://groups.yahoo.com/mygroups");
		URLConnection gJk6QEKO = iTn01TAo.openConnection();
		gJk6QEKO.connect();
		if (!Pattern.matches("HTTP/... 2.. .*", gJk6QEKO.getHeaderField(0).toString())) {
			System.out.println(gJk6QEKO.getHeaderField(0).toString());
			return false;
		}
		System.out.print("login : ");
		InputStream Xw27x0nE = gJk6QEKO.getInputStream();
		ejBgekWk = "";
		for (McBGIB4L = Xw27x0nE.read(); McBGIB4L != -1; McBGIB4L = Xw27x0nE.read())
			ejBgekWk += (char) McBGIB4L;
		dOS6VZsR = "";
		dOS6VZsR += URLEncoder.encode(".tries", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8") + "&";
		dOS6VZsR += URLEncoder.encode(".src", "UTF-8") + "=" + URLEncoder.encode("ygrp", "UTF-8") + "&";
		dOS6VZsR += URLEncoder.encode(".md5", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8") + "&";
		dOS6VZsR += URLEncoder.encode(".hash", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8") + "&";
		dOS6VZsR += URLEncoder.encode(".js", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8") + "&";
		dOS6VZsR += URLEncoder.encode(".last", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8") + "&";
		dOS6VZsR += URLEncoder.encode("promo", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8") + "&";
		dOS6VZsR += URLEncoder.encode(".intl", "UTF-8") + "=" + URLEncoder.encode("us", "UTF-8") + "&";
		dOS6VZsR += URLEncoder.encode(".bypass", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8") + "&";
		dOS6VZsR += URLEncoder.encode(".partner", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8") + "&";
		Uk805iHj = Pattern.compile("<input type=\"hidden\" name=\".u\" value=\"(.+?)\">");
		UBhMWg7L = Uk805iHj.matcher(ejBgekWk);
		UBhMWg7L.find();
		dOS6VZsR += URLEncoder.encode(".u", "UTF-8") + "=" + URLEncoder.encode(UBhMWg7L.group(1), "UTF-8") + "&";
		dOS6VZsR += URLEncoder.encode(".v", "UTF-8") + "=" + URLEncoder.encode("0", "UTF-8") + "&";
		Uk805iHj = Pattern.compile("<input type=\"hidden\" name=\".challenge\" value=\"(.+?)\">");
		UBhMWg7L = Uk805iHj.matcher(ejBgekWk);
		UBhMWg7L.find();
		dOS6VZsR += URLEncoder.encode(".challenge", "UTF-8") + "=" + URLEncoder.encode(UBhMWg7L.group(1), "UTF-8")
				+ "&";
		dOS6VZsR += URLEncoder.encode(".yplus", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8") + "&";
		dOS6VZsR += URLEncoder.encode(".emailCode", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8") + "&";
		dOS6VZsR += URLEncoder.encode("pkg", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8") + "&";
		dOS6VZsR += URLEncoder.encode("stepid", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8") + "&";
		dOS6VZsR += URLEncoder.encode(".ev", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8") + "&";
		dOS6VZsR += URLEncoder.encode("hasMsgr", "UTF-8") + "=" + URLEncoder.encode("0", "UTF-8") + "&";
		dOS6VZsR += URLEncoder.encode(".chkP", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8") + "&";
		dOS6VZsR += URLEncoder.encode(".done", "UTF-8") + "="
				+ URLEncoder.encode("http://groups.yahoo.com/mygroups", "UTF-8") + "&";
		dOS6VZsR += URLEncoder.encode("login", "UTF-8") + "=" + URLEncoder.encode(Q6gqFo2T, "UTF-8") + "&";
		dOS6VZsR += URLEncoder.encode("passwd", "UTF-8") + "=" + URLEncoder.encode(ELNRfLWk, "UTF-8") + "&";
		dOS6VZsR += URLEncoder.encode(".persistent", "UTF-8") + "=" + URLEncoder.encode("y", "UTF-8") + "&";
		dOS6VZsR += URLEncoder.encode(".save", "UTF-8") + "=" + URLEncoder.encode("Sign In", "UTF-8");
		iTn01TAo = new URL("http://login.yahoo.com/config/login");
		gJk6QEKO = iTn01TAo.openConnection();
		gJk6QEKO.setDoInput(true);
		gJk6QEKO.setDoOutput(true);
		OutputStream RFc0MpC3 = gJk6QEKO.getOutputStream();
		PrintStream KNwuhuYC = new PrintStream(RFc0MpC3);
		KNwuhuYC.print(dOS6VZsR);
		KNwuhuYC.close();
		if (!Pattern.matches("HTTP/... 2.. .*", gJk6QEKO.getHeaderField(0).toString())) {
			System.out.println(gJk6QEKO.getHeaderField(0).toString());
			return false;
		}
		System.out.println("OK");
		iTn01TAo = new URL("http://groups.yahoo.com/adultconf");
		gJk6QEKO = iTn01TAo.openConnection();
		gJk6QEKO.connect();
		if (!Pattern.matches("HTTP/... 2.. .*", gJk6QEKO.getHeaderField(0).toString())) {
			System.out.println(gJk6QEKO.getHeaderField(0).toString());
			return false;
		}
		System.out.print("adult : ");
		Xw27x0nE = gJk6QEKO.getInputStream();
		ejBgekWk = "";
		for (McBGIB4L = Xw27x0nE.read(); McBGIB4L != -1; McBGIB4L = Xw27x0nE.read())
			ejBgekWk += (char) McBGIB4L;
		dOS6VZsR = "";
		Uk805iHj = Pattern.compile("<input type=\"hidden\" name=\"ycb\" value=\"(.+?)\">");
		UBhMWg7L = Uk805iHj.matcher(ejBgekWk);
		UBhMWg7L.find();
		dOS6VZsR += URLEncoder.encode("ycb", "UTF-8") + "=" + URLEncoder.encode(UBhMWg7L.group(1), "UTF-8") + "&";
		dOS6VZsR += URLEncoder.encode("dest", "UTF-8") + "=" + URLEncoder.encode("/mygroups", "UTF-8") + "&";
		dOS6VZsR += URLEncoder.encode("accept", "UTF-8") + "=" + URLEncoder.encode("I Acce", "UTF-8");
		iTn01TAo = new URL("http://groups.yahoo.com/adultconf");
		gJk6QEKO = iTn01TAo.openConnection();
		gJk6QEKO.setDoInput(true);
		gJk6QEKO.setDoOutput(true);
		RFc0MpC3 = gJk6QEKO.getOutputStream();
		KNwuhuYC = new PrintStream(RFc0MpC3);
		KNwuhuYC.print(dOS6VZsR);
		KNwuhuYC.close();
		if (!Pattern.matches("HTTP/... 2.. .*", gJk6QEKO.getHeaderField(0).toString())) {
			System.out.println(gJk6QEKO.getHeaderField(0).toString());
			return false;
		}
		System.out.println("OK");
		return true;
	}

}