class n8265645 {
	public static String readURL(String HrVOpslp, boolean qUna75T4) {
		if (qUna75T4)
			System.out.print("    trying: " + HrVOpslp + "\n");
		URL O3RkPIdT = null;
		try {
			O3RkPIdT = new URL(HrVOpslp);
		} catch (java.net.MalformedURLException RiIg8Wq2) {
			System.out.print("test failed: using URL: ");
			System.out.print(RiIg8Wq2.getMessage());
			System.out.print('\n');
			return null;
		}
		HttpURLConnection XxC6zS3M = null;
		try {
			XxC6zS3M = (HttpURLConnection) O3RkPIdT.openConnection();
		} catch (IOException VtFRRsHc) {
			System.out.print("test failed: using URL: ");
			System.out.print(VtFRRsHc.getMessage());
			System.out.print('\n');
			return null;
		}
		String A2wVjoPw = XxC6zS3M.getContentType();
		if (A2wVjoPw == null || A2wVjoPw.indexOf("text/xml") < 0) {
			System.out.print("*** Warning ***  Content-Type not set to text/xml");
			System.out.print('\n');
			System.out.print("    Content-type: ");
			System.out.print(A2wVjoPw);
			System.out.print('\n');
		}
		InputStream khEivFB7 = null;
		try {
			khEivFB7 = XxC6zS3M.getInputStream();
		} catch (java.io.IOException DIvKKclz) {
			System.out.print("test failed: opening URL: ");
			System.out.print(DIvKKclz.getMessage());
			System.out.print('\n');
			return null;
		}
		BufferedReader PhvMxGeC = new BufferedReader(new InputStreamReader(khEivFB7));
		boolean C7Qej2hH = true;
		String qFgpckhQ = null, BgBK6DPI = null;
		StringBuffer yoXPPeVa = new StringBuffer(), teywlcid = null;
		Transformer u7mWyaUp = null;
		try {
			BgBK6DPI = PhvMxGeC.readLine();
		} catch (java.io.IOException yIbHdHPj) {
			System.out.print("test failed: reading first line of response: ");
			System.out.print(yIbHdHPj.getMessage());
			System.out.print('\n');
			return null;
		}
		if (BgBK6DPI == null) {
			System.out.print("test failed: No input read from URL");
			System.out.print('\n');
			return null;
		}
		if (!BgBK6DPI.startsWith("<?xml ")) {
			C7Qej2hH = false;
			yoXPPeVa.append(BgBK6DPI);
		}
		if (C7Qej2hH) {
			int tkKRdO3k = BgBK6DPI.indexOf('>');
			if (tkKRdO3k + 2 < BgBK6DPI.length()) {
				BgBK6DPI = BgBK6DPI.substring(tkKRdO3k + 1);
				tkKRdO3k = BgBK6DPI.indexOf('<');
				if (tkKRdO3k > 0)
					BgBK6DPI = BgBK6DPI.substring(tkKRdO3k);
			} else
				try {
					BgBK6DPI = PhvMxGeC.readLine();
				} catch (java.io.IOException ADgrI3Dj) {
					System.out.print("test failed: reading response: ");
					System.out.print(ADgrI3Dj.getMessage());
					System.out.print('\n');
					return null;
				}
			yoXPPeVa.append(BgBK6DPI);
		}
		try {
			while ((BgBK6DPI = PhvMxGeC.readLine()) != null)
				yoXPPeVa.append(BgBK6DPI);
		} catch (java.io.IOException xypj3Emk) {
			System.out.print("test failed: reading response: ");
			System.out.print(xypj3Emk.getMessage());
			System.out.print('\n');
			return null;
		}
		String eg1FCUjd = yoXPPeVa.toString();
		if (u7mWyaUp != null) {
			StreamSource w9bCT8Ap = new StreamSource(new StringReader(eg1FCUjd));
			StringWriter dLSxNKbV = new StringWriter();
			try {
				u7mWyaUp.transform(w9bCT8Ap, new StreamResult(dLSxNKbV));
				System.out.print("        successfully applied stylesheet '");
				System.out.print(qFgpckhQ);
				System.out.print("'");
				System.out.print('\n');
			} catch (javax.xml.transform.TransformerException OGjPhXC4) {
				System.out.print("unable to apply stylesheet '");
				System.out.print(qFgpckhQ);
				System.out.print("'to response: ");
				System.out.print(OGjPhXC4.getMessage());
				System.out.print('\n');
				OGjPhXC4.printStackTrace();
			}
		}
		return eg1FCUjd;
	}

}