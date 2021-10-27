class n21808206 {
	public static void main(String sG7c18cH[]) {
		try {
			URL BgoXwfC3 = new URL(
					"http://dev.activeanalytics.ca/piwik.php?url=http%3a%2f%2flyricscatcher.sourceforge.net%2fpiwik.php&action_name=&idsite=1&res=1440x900&h=17&m=2&s=16&fla=1&dir=1&qt=1&realp=1&pdf=1&wma=1&java=1&cookie=0&title=JAVAACCESS&urlref=http%3a%2f%2flyricscatcher.sourceforge.net%2fcomputeraccespage.html");
			InputStream ZBrvrT28 = BgoXwfC3.openStream();
			InputStreamReader ttvANSK3 = new InputStreamReader(ZBrvrT28);
			BufferedReader fJMpA1NG = new BufferedReader(ttvANSK3);
			String T5dyeOlD = "";
			String oUTwxF1V = "";
			while ((oUTwxF1V = fJMpA1NG.readLine()) != null) {
				T5dyeOlD += oUTwxF1V + "\n";
			}
			System.out.println("finished: length=" + T5dyeOlD.length() + "line=" + T5dyeOlD);
		} catch (MalformedURLException CDc0y29D) {
			CDc0y29D.printStackTrace();
		} catch (IOException Rv7c0LdR) {
			Rv7c0LdR.printStackTrace();
		}
		try {
			URL MVlfTdnP = new URL(
					"http://apps.sourceforge.net/piwik/lyricscatcher/piwik.php?url=http%3a%2f%2flyricscatcher.sourceforge.net%2fpiwik.php&action_name=&idsite=1&res=1440x900&h=0&m=22&s=1&fla=1&dir=1&qt=1&realp=1&pdf=1&wma=1&java=1&cookie=0&title=JAVAACCESS&urlref=http%3a%2f%2flyricscatcher.sourceforge.net%2fcomputeraccespage.html");
			InputStream eVEUq5fv = MVlfTdnP.openStream();
			InputStreamReader UASW9d26 = new InputStreamReader(eVEUq5fv);
			BufferedReader ZnANtaJw = new BufferedReader(UASW9d26);
			String vMZ06U5y = "";
			String CZU5f1iK = "";
			while ((CZU5f1iK = ZnANtaJw.readLine()) != null) {
				vMZ06U5y += CZU5f1iK + "\n";
			}
			System.out.println("finished: length=" + vMZ06U5y.length() + "line=" + vMZ06U5y);
		} catch (MalformedURLException s6vnEUzV) {
			s6vnEUzV.printStackTrace();
		} catch (IOException esKMtSHm) {
			esKMtSHm.printStackTrace();
		}
		try {
			URL rV3eQXSS = new URL(
					"http://apps.sourceforge.net/piwik/lyricscatcher/piwik.php?url=http%3A%2F%2Flyricscatcher.sourceforge.net%2Fcomputeracces.html&action_name=&idsite=1&res=1440x900&h=0&m=28&s=36&fla=1&dir=1&qt=1&realp=0&pdf=1&wma=1&java=1&cookie=1&title=&urlref=");
			InputStream AOPOYx6G = rV3eQXSS.openStream();
			InputStreamReader A1b1jorJ = new InputStreamReader(AOPOYx6G);
			BufferedReader A6Mro3yA = new BufferedReader(A1b1jorJ);
			String k7GtACQZ = "";
			String oD3Xi9xN = "";
			while ((oD3Xi9xN = A6Mro3yA.readLine()) != null) {
				k7GtACQZ += oD3Xi9xN + "\n";
			}
			System.out.println("finished: length=" + k7GtACQZ.length() + "line=" + k7GtACQZ);
		} catch (MalformedURLException GKp5C12y) {
			GKp5C12y.printStackTrace();
		} catch (IOException S9MDBcW4) {
			S9MDBcW4.printStackTrace();
		}
	}

}