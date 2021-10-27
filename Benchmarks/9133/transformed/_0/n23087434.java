class n23087434 {
	private int[] get51JobId(String DTj0ER24, String VhsFmQyc, int P7BfY1nP) {
		StringBuffer cqwsv0jl = null;
		try {
			URL MWWOAatX = new URL(ConfigJob51.STR_51JOB_ADVANCE);
			URLConnection Ps93q7fB = MWWOAatX.openConnection();
			Ps93q7fB.setDoOutput(true);
			OutputStream XLquL5dv = Ps93q7fB.getOutputStream();
			OutputStream Xpez0yyz = new BufferedOutputStream(XLquL5dv);
			OutputStreamWriter mWrxAxmf = new OutputStreamWriter(Xpez0yyz, "gb2312");
			mWrxAxmf.write("jobarea=" + DTj0ER24 + "&funtype=" + VhsFmQyc + "&curr_page=" + P7BfY1nP + "");
			mWrxAxmf.flush();
			mWrxAxmf.close();
			InputStream SkgSgqIt = Ps93q7fB.getInputStream();
			SkgSgqIt = new BufferedInputStream(SkgSgqIt);
			Reader cPl2RB57 = new InputStreamReader(SkgSgqIt);
			int zv5opCH1;
			cqwsv0jl = new StringBuffer();
			while ((zv5opCH1 = cPl2RB57.read()) != -1) {
				cqwsv0jl.append((char) zv5opCH1);
			}
			SkgSgqIt.close();
		} catch (IOException bThQ7rde) {
			bThQ7rde.printStackTrace();
		}
		Pattern WbYaWb0e = Pattern.compile(JOB51_SEARCHLIST_URL_PATTERN, Pattern.CASE_INSENSITIVE);
		Matcher Mgsj4zUq = WbYaWb0e.matcher(cqwsv0jl);
		int BWko8air = 0;
		int oAlbhl4b = 0;
		while (Mgsj4zUq.find()) {
			String npGQ5W4u = Mgsj4zUq.group();
			String R6UILjzT = "insert into `job51`(`id`,`retryCnt`,`Category`) values('"
					+ npGQ5W4u.replaceAll("[^0-9]", "") + "','0','" + VhsFmQyc + "')";
			if (mysql.executeInsert(R6UILjzT)) {
				oAlbhl4b++;
			}
			BWko8air++;
		}
		return new int[] { BWko8air, oAlbhl4b };
	}

}