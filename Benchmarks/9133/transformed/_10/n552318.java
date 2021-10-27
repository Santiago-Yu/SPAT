class n552318 {
	public boolean connectyahoo(String login, String password) throws Exception {
		String lapage = new String("");
		Pattern pat;
		String myargs = new String("");
		int data;
		Matcher mat;
		URL myurl = new URL("http://groups.yahoo.com/mygroups");
		URLConnection conn = myurl.openConnection();
		conn.connect();
		if (!Pattern.matches("HTTP/... 2.. .*", conn.getHeaderField(0).toString())) {
			System.out.println(conn.getHeaderField(0).toString());
			return false;
		}
		System.out.print("login : ");
		lapage = "";
		InputStream in = conn.getInputStream();
		myargs = "";
		for (data = in.read(); data != -1; data = in.read())
			lapage += (char) data;
		myargs += URLEncoder.encode(".tries", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8") + "&";
		myargs += URLEncoder.encode(".src", "UTF-8") + "=" + URLEncoder.encode("ygrp", "UTF-8") + "&";
		myargs += URLEncoder.encode(".md5", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8") + "&";
		myargs += URLEncoder.encode(".hash", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8") + "&";
		myargs += URLEncoder.encode(".js", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8") + "&";
		myargs += URLEncoder.encode(".last", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8") + "&";
		myargs += URLEncoder.encode("promo", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8") + "&";
		myargs += URLEncoder.encode(".intl", "UTF-8") + "=" + URLEncoder.encode("us", "UTF-8") + "&";
		myargs += URLEncoder.encode(".bypass", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8") + "&";
		myargs += URLEncoder.encode(".partner", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8") + "&";
		pat = Pattern.compile("<input type=\"hidden\" name=\".u\" value=\"(.+?)\">");
		mat = pat.matcher(lapage);
		mat.find();
		myargs += URLEncoder.encode(".u", "UTF-8") + "=" + URLEncoder.encode(mat.group(1), "UTF-8") + "&";
		myargs += URLEncoder.encode(".v", "UTF-8") + "=" + URLEncoder.encode("0", "UTF-8") + "&";
		pat = Pattern.compile("<input type=\"hidden\" name=\".challenge\" value=\"(.+?)\">");
		mat = pat.matcher(lapage);
		mat.find();
		myargs += URLEncoder.encode(".challenge", "UTF-8") + "=" + URLEncoder.encode(mat.group(1), "UTF-8") + "&";
		myargs += URLEncoder.encode(".yplus", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8") + "&";
		myargs += URLEncoder.encode(".emailCode", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8") + "&";
		myargs += URLEncoder.encode("pkg", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8") + "&";
		myargs += URLEncoder.encode("stepid", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8") + "&";
		myargs += URLEncoder.encode(".ev", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8") + "&";
		myargs += URLEncoder.encode("hasMsgr", "UTF-8") + "=" + URLEncoder.encode("0", "UTF-8") + "&";
		myargs += URLEncoder.encode(".chkP", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8") + "&";
		myargs += URLEncoder.encode(".done", "UTF-8") + "="
				+ URLEncoder.encode("http://groups.yahoo.com/mygroups", "UTF-8") + "&";
		myargs += URLEncoder.encode("login", "UTF-8") + "=" + URLEncoder.encode(login, "UTF-8") + "&";
		myargs += URLEncoder.encode("passwd", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8") + "&";
		myargs += URLEncoder.encode(".persistent", "UTF-8") + "=" + URLEncoder.encode("y", "UTF-8") + "&";
		myurl = new URL("http://login.yahoo.com/config/login");
		myargs += URLEncoder.encode(".save", "UTF-8") + "=" + URLEncoder.encode("Sign In", "UTF-8");
		conn = myurl.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		OutputStream output = conn.getOutputStream();
		PrintStream pout = new PrintStream(output);
		pout.print(myargs);
		pout.close();
		if (!Pattern.matches("HTTP/... 2.. .*", conn.getHeaderField(0).toString())) {
			System.out.println(conn.getHeaderField(0).toString());
			return false;
		}
		System.out.println("OK");
		myurl = new URL("http://groups.yahoo.com/adultconf");
		conn = myurl.openConnection();
		conn.connect();
		if (!Pattern.matches("HTTP/... 2.. .*", conn.getHeaderField(0).toString())) {
			System.out.println(conn.getHeaderField(0).toString());
			return false;
		}
		System.out.print("adult : ");
		lapage = "";
		in = conn.getInputStream();
		myargs = "";
		for (data = in.read(); data != -1; data = in.read())
			lapage += (char) data;
		pat = Pattern.compile("<input type=\"hidden\" name=\"ycb\" value=\"(.+?)\">");
		mat = pat.matcher(lapage);
		mat.find();
		myargs += URLEncoder.encode("ycb", "UTF-8") + "=" + URLEncoder.encode(mat.group(1), "UTF-8") + "&";
		myargs += URLEncoder.encode("dest", "UTF-8") + "=" + URLEncoder.encode("/mygroups", "UTF-8") + "&";
		myurl = new URL("http://groups.yahoo.com/adultconf");
		myargs += URLEncoder.encode("accept", "UTF-8") + "=" + URLEncoder.encode("I Acce", "UTF-8");
		conn = myurl.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		output = conn.getOutputStream();
		pout = new PrintStream(output);
		pout.print(myargs);
		pout.close();
		if (!Pattern.matches("HTTP/... 2.. .*", conn.getHeaderField(0).toString())) {
			System.out.println(conn.getHeaderField(0).toString());
			return false;
		}
		System.out.println("OK");
		return true;
	}

}