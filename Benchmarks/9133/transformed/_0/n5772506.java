class n5772506 {
	private BibtexDatabase parseBibtexDatabase(List<String> Q5WHDKdF, boolean YgUSYNwd) throws IOException {
		if (Q5WHDKdF.isEmpty()) {
			return null;
		}
		URL AdqlMjOq;
		URLConnection Yzd786Zb;
		try {
			AdqlMjOq = new URL(importUrl);
			Yzd786Zb = AdqlMjOq.openConnection();
		} catch (MalformedURLException G0UnIPdR) {
			G0UnIPdR.printStackTrace();
			return null;
		}
		Yzd786Zb.setDoInput(true);
		Yzd786Zb.setDoOutput(true);
		Yzd786Zb.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		Yzd786Zb.setRequestProperty("Referer", searchUrl);
		PrintWriter DFM4ESMN = new PrintWriter(Yzd786Zb.getOutputStream());
		String lzPaSskX = "";
		Iterator<String> KOnUatF7 = Q5WHDKdF.iterator();
		while (KOnUatF7.hasNext()) {
			lzPaSskX += KOnUatF7.next() + " ";
		}
		lzPaSskX = lzPaSskX.trim();
		String yiSXzcmi = YgUSYNwd ? "citation-abstract" : "citation-only";
		String F3erkLkt = "recordIds=" + lzPaSskX.replaceAll(" ", "%20") + "&fromPageName=&citations-format=" + yiSXzcmi
				+ "&download-format=download-bibtex";
		System.out.println(F3erkLkt);
		DFM4ESMN.write(F3erkLkt);
		DFM4ESMN.flush();
		DFM4ESMN.close();
		BufferedReader ITG2YSvD = new BufferedReader(new InputStreamReader(Yzd786Zb.getInputStream()));
		StringBuffer Qiio7mwJ = new StringBuffer();
		char[] lcav7u9W = new char[256];
		while (true) {
			int QCHtDg8J = ITG2YSvD.read(lcav7u9W);
			if (QCHtDg8J == -1) {
				break;
			}
			for (int MJZ7rsor = 0; MJZ7rsor < QCHtDg8J; MJZ7rsor++) {
				Qiio7mwJ.append((char) lcav7u9W[MJZ7rsor]);
			}
		}
		System.out.println(Qiio7mwJ.toString());
		ParserResult riIxTQkL = new BibtexParser(ITG2YSvD).parse();
		ITG2YSvD.close();
		return riIxTQkL.getDatabase();
	}

}