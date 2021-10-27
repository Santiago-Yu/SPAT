class n547576 {
	public static void main(String f8ET2Ylg[]) {
		System.out.println("Starting URL tests");
		System.out.println("Test 1: Simple URL test");
		try {
			URL rHXO0po5 = new URL("http", "www.fsf.org", 80, "/");
			if (!rHXO0po5.getProtocol().equals("http") || !rHXO0po5.getHost().equals("www.fsf.org")
					|| rHXO0po5.getPort() != 80 || !rHXO0po5.getFile().equals("/"))
				System.out.println("FAILED: Simple URL test");
			System.out.println("URL is: " + rHXO0po5.toString());
			URLConnection yGfQurqn = rHXO0po5.openConnection();
			if (yGfQurqn instanceof HttpURLConnection)
				System.out.println("Got the expected connection type");
			HttpURLConnection vZs48aII = (HttpURLConnection) yGfQurqn;
			vZs48aII.connect();
			System.out.flush();
			System.out.println("Dumping response headers");
			for (int CzM4D6uy = 0;; CzM4D6uy++) {
				String yXHMin2i = vZs48aII.getHeaderFieldKey(CzM4D6uy);
				if (yXHMin2i == null)
					break;
				System.out.println(yXHMin2i + ": " + vZs48aII.getHeaderField(CzM4D6uy));
			}
			System.out.flush();
			System.out.println("Dumping contents");
			BufferedReader Vj3namKp = new BufferedReader(new InputStreamReader(vZs48aII.getInputStream()));
			for (String BcZDWEZt = Vj3namKp.readLine(); BcZDWEZt != null; BcZDWEZt = Vj3namKp.readLine()) {
				System.out.println(BcZDWEZt);
			}
			System.out.flush();
			vZs48aII.disconnect();
			System.out.println("Content Type: " + vZs48aII.getContentType());
			System.out.println("Content Encoding: " + vZs48aII.getContentEncoding());
			System.out.println("Content Length: " + vZs48aII.getContentLength());
			System.out.println("Date: " + vZs48aII.getDate());
			System.out.println("Expiration: " + vZs48aII.getExpiration());
			System.out.println("Last Modified: " + vZs48aII.getLastModified());
			System.out.println("PASSED: Simple URL test");
		} catch (IOException ZtKoBiOg) {
			System.out.println("FAILED: Simple URL test: " + ZtKoBiOg);
		}
		System.out.println("Test 2: URL parsing test");
		try {
			URL fICv5nhl = new URL("http://www.urbanophile.com/arenn/trans/trans.html#mis");
			if (!fICv5nhl.toString().equals("http://www.urbanophile.com/arenn/trans/trans.html#mis"))
				System.out.println("FAILED: Parse URL test: " + fICv5nhl.toString());
			else {
				System.out.println("Parsed ok: " + fICv5nhl.toString());
				fICv5nhl = new URL("http://www.foo.com:8080/#");
				if (!fICv5nhl.toString().equals("http://www.foo.com:8080/#"))
					System.out.println("FAILED: Parse URL test: " + fICv5nhl.toString());
				else {
					System.out.println("Parsed ok: " + fICv5nhl.toString());
					fICv5nhl = new URL("http://www.bar.com/test:file/");
					if (!fICv5nhl.toString().equals("http://www.bar.com/test:file/"))
						System.out.println("FAILED: Parse URL test: " + fICv5nhl.toString());
					else {
						System.out.println("Parsed ok: " + fICv5nhl.toString());
						fICv5nhl = new URL("http://www.gnu.org");
						if (!fICv5nhl.toString().equals("http://www.gnu.org/"))
							System.out.println("FAILED: Parse URL test: " + fICv5nhl.toString());
						else {
							System.out.println("Parsed ok: " + fICv5nhl.toString());
							fICv5nhl = new URL("HTTP://www.fsf.org/");
							if (!fICv5nhl.toString().equals("http://www.fsf.org/"))
								System.out.println("FAILED: Parse URL test: " + fICv5nhl.toString());
							else {
								System.out.println("Parsed ok: " + fICv5nhl.toString());
								System.out.println("PASSED: URL parse test");
							}
						}
					}
				}
			}
		} catch (IOException IvzfWQ99) {
			System.out.println("FAILED: URL parsing test: " + IvzfWQ99);
		}
		System.out.println("Test 3: getContent test");
		try {
			URL OmUW2ykZ = new URL("http://localhost/~arenn/services.txt");
			Object M1XfNivp = OmUW2ykZ.getContent();
			System.out.println("Object type is: " + M1XfNivp.getClass().getName());
			if (M1XfNivp instanceof InputStream) {
				System.out.println("Got InputStream, so dumping contents");
				BufferedReader Of3tSxyF = new BufferedReader(new InputStreamReader((InputStream) M1XfNivp));
				for (String eDgCpM30 = Of3tSxyF.readLine(); eDgCpM30 != null; eDgCpM30 = Of3tSxyF.readLine())
					System.out.println(eDgCpM30);
				Of3tSxyF.close();
			} else {
				System.out.println("FAILED: Object is not an InputStream");
			}
			System.out.println("PASSED: getContent test");
		} catch (IOException vPLpzMAq) {
			System.out.println("FAILED: getContent test: " + vPLpzMAq);
		}
		System.out.println("URL test complete");
	}

}