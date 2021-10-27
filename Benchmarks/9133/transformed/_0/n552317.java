class n552317 {
	public void listgroups() throws Exception {
		String nhV9XAo1 = new String("");
		Pattern l8e8zPYU;
		Matcher qc5Jk54l;
		int aKGcq94U;
		URL Zs6qm8jV = new URL("http://groups.yahoo.com/mygroups");
		URLConnection CoEyNldg;
		URI Bur3nHpH = new URI("http://groups.yahoo.com/mygroups");
		YahooInfo mvciQbZc;
		clearAll();
		System.out.print("http://groups.yahoo.com/mygroups : ");
		do {
			Zs6qm8jV = new URL(Zs6qm8jV.toString());
			CoEyNldg = Zs6qm8jV.openConnection();
			CoEyNldg.connect();
			if (!Pattern.matches("HTTP/... 2.. .*", CoEyNldg.getHeaderField(0).toString())) {
				System.out.println(CoEyNldg.getHeaderField(0).toString());
				return;
			}
			System.out.print(".");
			InputStream ZutfUzXY = CoEyNldg.getInputStream();
			nhV9XAo1 = "";
			for (aKGcq94U = ZutfUzXY.read(); aKGcq94U != -1; aKGcq94U = ZutfUzXY.read())
				nhV9XAo1 += (char) aKGcq94U;
			l8e8zPYU = Pattern.compile("<td class=\"grpname selected\"><a href=\"(.+?)\".*?><em>(.+?)</em></a>");
			qc5Jk54l = l8e8zPYU.matcher(nhV9XAo1);
			while (qc5Jk54l.find()) {
				mvciQbZc = new YahooInfo(qc5Jk54l.group(2), "", "",
						Bur3nHpH.resolve(HTMLDecoder.decode(qc5Jk54l.group(1))).toURL().toString());
				UrlList.add(mvciQbZc);
			}
			l8e8zPYU = Pattern.compile("<a href=\"(.+?)\">Next &gt;</a>");
			qc5Jk54l = l8e8zPYU.matcher(nhV9XAo1);
			Zs6qm8jV = null;
			if (qc5Jk54l.find()) {
				Zs6qm8jV = Bur3nHpH.resolve(HTMLDecoder.decode(qc5Jk54l.group(1))).toURL();
			}
		} while (Zs6qm8jV != null);
		System.out.println("");
	}

}