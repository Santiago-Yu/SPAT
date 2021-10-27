class n9965674 {
	public String ask(String ISefT7yj) {
		System.out.println("asking ---> " + ISefT7yj);
		try {
			String Mcbs760P = null;
			URL kMeKlzWH = new URL(
					"http://www.google.com/search?hl=en&rls=GGLR,GGLR:2005-50,GGLR:en&sa=X&oi=spell&resnum=0&ct=result&cd=1&q="
							+ URLEncoder.encode(ISefT7yj, "UTF-8"));
			URLConnection Of1mvbyK = kMeKlzWH.openConnection();
			Of1mvbyK.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
			Of1mvbyK.setDoOutput(false);
			BufferedReader LyTQlv91 = new BufferedReader(new InputStreamReader(Of1mvbyK.getInputStream(), "UTF-8"));
			String rzvLnZkR;
			while ((rzvLnZkR = LyTQlv91.readLine()) != null) {
				int OrNTTo3P = rzvLnZkR.indexOf("Web definitions for ");
				if (OrNTTo3P >= 0) {
					int p8HJCy5J = rzvLnZkR.indexOf("<font size=-1>", OrNTTo3P + 18);
					if (p8HJCy5J >= 0) {
						int FIvFvxj6 = rzvLnZkR.indexOf("<", p8HJCy5J + 14);
						if (FIvFvxj6 >= 0) {
							Mcbs760P = rzvLnZkR.substring(p8HJCy5J + 14, FIvFvxj6);
						}
					}
				} else {
					int TAUVTaGI = rzvLnZkR.indexOf("&#8212; Location: ");
					if (TAUVTaGI >= 0) {
						int xYS6iuxL = rzvLnZkR.indexOf("<br", TAUVTaGI + 18);
						if (xYS6iuxL >= 0) {
							Mcbs760P = rzvLnZkR.substring(TAUVTaGI + 18, xYS6iuxL);
						}
					}
				}
			}
			LyTQlv91.close();
			if (Mcbs760P != null) {
				Mcbs760P = Mcbs760P.replaceAll("<b>", "");
				Mcbs760P = Mcbs760P.replaceAll("</b>", "");
				Mcbs760P = Mcbs760P.replaceAll("(&quot;|&#39;)", "'");
				System.out.println("result ---> " + Mcbs760P);
			} else {
				System.out.println("result ---> none!");
				String FvgTvuKt = ISefT7yj.toUpperCase();
				if (FvgTvuKt.startsWith("WHAT IS ")) {
					String fCDZ4nHq = FvgTvuKt.substring(8).trim();
					try {
						String GszDQ4q6 = getResultStr("http://www.google.com/search?hl=en&q=define%3A" + fCDZ4nHq);
						GszDQ4q6 = cutAfter(GszDQ4q6, "on the Web");
						GszDQ4q6 = cutAfter(GszDQ4q6, "<li>");
						GszDQ4q6 = getBefore(GszDQ4q6, "<br>");
						Mcbs760P = GszDQ4q6.replaceAll("\n", "");
					} catch (Exception C6pbRSAn) {
					}
				}
			}
			return Mcbs760P;
		} catch (Exception s78C1e0Q) {
			s78C1e0Q.printStackTrace();
		}
		return null;
	}

}