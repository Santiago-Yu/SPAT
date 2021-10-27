class n21808207 {
	public static void test() {
		addToCounter("computeracces.html");
		try {
			JFrame rII6YMV8 = new JFrame("Webconnect");
			URL f0UbDEmW = new URL("http://apps.sourceforge.net/piwik/lyricscatcher/piwik.php?idsite=1");
			JEditorPane NMsjeOzI = new JEditorPane();
			rII6YMV8.add(NMsjeOzI);
			String GwrD5woq = "http://apps.sourceforge.net/piwik/lyricscatcher/piwik.php?url=http%3a%2f%2flyricscatcher.sourceforge.net%2fpiwik.php&action_name=&idsite=1&res=1440x900&h=";
			Calendar yM8FmeD9 = Calendar.getInstance();
			GwrD5woq += yM8FmeD9.get(Calendar.HOUR_OF_DAY);
			GwrD5woq += "&m=";
			GwrD5woq += yM8FmeD9.get(Calendar.MINUTE);
			GwrD5woq += "&s=";
			GwrD5woq += yM8FmeD9.get(Calendar.SECOND);
			GwrD5woq += "&fla=1&dir=1&qt=1&realp=1&pdf=1&wma=1&java=1&cookie=0&title=JAVAACCESS&urlref=http%3a%2f%2flyricscatcher.sourceforge.net%2fcomputeraccespage.html";
			System.out.println(GwrD5woq);
			URL ujZopqnF = new URL(GwrD5woq);
			InputStream dpIUuhQq = ujZopqnF.openStream();
			InputStreamReader B5mg8LRG = new InputStreamReader(dpIUuhQq);
			BufferedReader tIQM89Fg = new BufferedReader(B5mg8LRG);
			String C9i4jQbD = "";
			String PZy2lZvC = "";
			while ((PZy2lZvC = tIQM89Fg.readLine()) != null) {
				C9i4jQbD += PZy2lZvC + "\n";
			}
			System.out.println("finished: length of correct url=" + C9i4jQbD.length());
			URL BynBv8jy = new URL(GwrD5woq);
			URLConnection GZWb1tRl = BynBv8jy.openConnection();
			GZWb1tRl.getContent();
			System.out.println(GZWb1tRl.getLastModified());
			System.out.println(GZWb1tRl.getPermission());
			System.out.println(GZWb1tRl.getRequestProperties());
			System.out.println(GZWb1tRl.getContentEncoding());
			System.out.println(GZWb1tRl.getContentLength());
			GZWb1tRl.connect();
			InputStream R7XKaZAP = BynBv8jy.openStream();
			while (dpIUuhQq.available() >= 0) {
				dpIUuhQq.read();
			}
			dpIUuhQq.close();
			Document XQzs2WzV = NMsjeOzI.getEditorKitForContentType("html").createDefaultDocument();
			XQzs2WzV.getDefaultRootElement();
			NMsjeOzI.setContentType("text/html");
			NMsjeOzI.setText(
					"<html><img src=\"http://apps.sourceforge.net/piwik/lyricscatcher/piwik.php?idsite=1\" alt=\"there's a problem...\"/><img src=\""
							+ GwrD5woq + "\" alt=\"Another problem\" style=\"border:0\" /></html>");
			rII6YMV8.setLocationByPlatform(true);
			rII6YMV8.setSize(100, 100);
			rII6YMV8.show();
		} catch (MalformedURLException wJv4HemN) {
			wJv4HemN.printStackTrace();
		} catch (IOException XJRK9Xtv) {
			XJRK9Xtv.printStackTrace();
		}
	}

}