class n9918348 {
	public static ArrayList[] imageSearch(String InXWqp9I, int Mx7JSttr) {
		try {
			InXWqp9I = URLEncoder.encode(InXWqp9I, "UTF-8");
		} catch (UnsupportedEncodingException lkPDJHRB) {
			lkPDJHRB.printStackTrace();
		}
		String qf59XYT1 = new String();
		qf59XYT1 += "http://images.google.com/images?gbv=1&start=" + Mx7JSttr + "&q=" + InXWqp9I;
		String kBZzETUw = "";
		try {
			URL xaKoCSEX = new URL(qf59XYT1);
			HttpURLConnection rA3cAHZD = (HttpURLConnection) xaKoCSEX.openConnection();
			rA3cAHZD.setInstanceFollowRedirects(true);
			rA3cAHZD.setRequestProperty("User-Agent", "");
			rA3cAHZD.connect();
			BufferedReader vDqHlrNL = new BufferedReader(new InputStreamReader(rA3cAHZD.getInputStream()));
			StringBuffer gvQ2O411 = new StringBuffer();
			char[] TQt73jn4 = new char[1024];
			while (true) {
				int sQfqjcs8 = vDqHlrNL.read(TQt73jn4);
				if (sQfqjcs8 == -1) {
					break;
				}
				gvQ2O411.append(TQt73jn4, 0, sQfqjcs8);
			}
			vDqHlrNL.close();
			kBZzETUw = gvQ2O411.toString();
		} catch (Exception xdIMsCD9) {
			xdIMsCD9.printStackTrace();
		}
		ArrayList<String> pR0gWrWZ = new ArrayList<String>();
		ArrayList<String> nedIZh23 = new ArrayList<String>();
		Matcher qQg8Qhc9 = imgBlock.matcher(kBZzETUw);
		while (qQg8Qhc9.find()) {
			String F0KgDAdY = qQg8Qhc9.group();
			Matcher BGwBtLnT = imgurl.matcher(F0KgDAdY);
			BGwBtLnT.find();
			String VUyuLZaf = BGwBtLnT.group(1);
			Matcher nDDoRDmi = imgsrc.matcher(F0KgDAdY);
			nDDoRDmi.find();
			String nGM9kg5W = nDDoRDmi.group(1);
			pR0gWrWZ.add(nGM9kg5W);
			nedIZh23.add(VUyuLZaf);
		}
		return new ArrayList[] { pR0gWrWZ, nedIZh23 };
	}

}