class n9965674 {
	public String ask(String s) {
		System.out.println("asking ---> " + s);
		try {
			String result = null;
			URL url = new URL(
					"http://www.google.com/search?hl=en&rls=GGLR,GGLR:2005-50,GGLR:en&sa=X&oi=spell&resnum=0&ct=result&cd=1&q="
							+ URLEncoder.encode(s, "UTF-8"));
			URLConnection connection = url.openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
			connection.setDoOutput(false);
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				int textPos = inputLine.indexOf("Web definitions for ");
				if (textPos >= 0) {
					int ltrPos = inputLine.indexOf("<font size=-1>", textPos + 18);
					if (ltrPos >= 0) {
						int closePos = inputLine.indexOf("<", ltrPos + 14);
						result = (closePos >= 0) ? inputLine.substring(ltrPos + 14, closePos) : result;
					}
				} else {
					int ltrPos = inputLine.indexOf("&#8212; Location: ");
					if (ltrPos >= 0) {
						int closePos = inputLine.indexOf("<br", ltrPos + 18);
						result = (closePos >= 0) ? inputLine.substring(ltrPos + 18, closePos) : result;
					}
				}
			}
			in.close();
			if (result != null) {
				result = result.replaceAll("<b>", "");
				result = result.replaceAll("</b>", "");
				result = result.replaceAll("(&quot;|&#39;)", "'");
				System.out.println("result ---> " + result);
			} else {
				System.out.println("result ---> none!");
				String ss = s.toUpperCase();
				if (ss.startsWith("WHAT IS ")) {
					String toSearch = ss.substring(8).trim();
					try {
						String str = getResultStr("http://www.google.com/search?hl=en&q=define%3A" + toSearch);
						str = cutAfter(str, "on the Web");
						str = cutAfter(str, "<li>");
						str = getBefore(str, "<br>");
						result = str.replaceAll("\n", "");
					} catch (Exception ee) {
					}
				}
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}