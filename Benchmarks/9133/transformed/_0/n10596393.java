class n10596393 {
	public static String BaiKe(String laIHV7pS) {
		String G0QymX41 = "";
		long gSGTtUzM = System.currentTimeMillis();
		long nby8dBJv;
		try {
			String L19ioqMW = "\\#(.+)\\#";
			String dMvQuA7u = "";
			Pattern blDLnoRZ = Pattern.compile(L19ioqMW);
			Matcher Ot0g3qMq = blDLnoRZ.matcher(laIHV7pS);
			if (Ot0g3qMq.find()) {
				dMvQuA7u = Ot0g3qMq.group(1);
			}
			System.out.println("searchText :  " + dMvQuA7u);
			G0QymX41 = URLEncoder.encode(dMvQuA7u, "UTF-8");
			String oEmTpqhe = "http://www.hudong.com/wiki/" + G0QymX41;
			HttpURLConnection mHJJ48Wi = (HttpURLConnection) (new URL(oEmTpqhe)).openConnection();
			mHJJ48Wi.setConnectTimeout(10000);
			Parser dZx1Odqq = new Parser(mHJJ48Wi);
			dZx1Odqq.setEncoding(dZx1Odqq.getEncoding());
			NodeFilter D9EeL6eV = new TagNameFilter("DIV");
			NodeList nnrVjqoX = dZx1Odqq.extractAllNodesThatMatch(D9EeL6eV);
			String sl12BPMP = "";
			if (nnrVjqoX != null) {
				for (int sY5MzDof = 0; sY5MzDof < nnrVjqoX.size(); sY5MzDof++) {
					Node Jrxb9S8L = (Node) nnrVjqoX.elementAt(sY5MzDof);
					if ("div class=\"summary\"".equals(Jrxb9S8L.getText())) {
						String iLwQP8U6 = Jrxb9S8L.toPlainTextString();
						sl12BPMP += iLwQP8U6 + "\n";
					}
				}
			}
			String EL8DsN3G = Replace(sl12BPMP, dMvQuA7u);
			nby8dBJv = System.currentTimeMillis();
			String j3TKaDiV = "搜索[" + dMvQuA7u + "]用时:" + (nby8dBJv - gSGTtUzM) / 1000.0 + "s";
			System.out.println(EL8DsN3G);
			return j3TKaDiV + "\r\n" + EL8DsN3G;
		} catch (Exception VELq8cLr) {
			VELq8cLr.printStackTrace();
			return "大姨妈来了";
		}
	}

}