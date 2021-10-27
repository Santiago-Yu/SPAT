class n2330583 {
	private CExtractHelper getData(String w3cLlSFd) {
		CExtractHelper mhX2Ef8a = new CExtractHelper();
		URL q5cvhWWR;
		HttpURLConnection zVzKL8Ig;
		try {
			System.out.println("Getting [" + w3cLlSFd + "]");
			q5cvhWWR = new URL(w3cLlSFd);
			try {
				URLConnection brSd03KU = q5cvhWWR.openConnection();
				zVzKL8Ig = (HttpURLConnection) brSd03KU;
				zVzKL8Ig.setConnectTimeout(2000);
				zVzKL8Ig.setReadTimeout(2000);
				zVzKL8Ig.setRequestProperty("User-Agent",
						"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.1) Gecko/20061204 Firefox/2.0.0.1");
				zVzKL8Ig.connect();
				int kz2vORwE = zVzKL8Ig.getResponseCode();
				String tEEOFWtO = zVzKL8Ig.getResponseMessage();
				System.out.println("HTTP/1.x " + kz2vORwE + " " + tEEOFWtO);
				for (int BulPnWho = 1;; BulPnWho++) {
					String k0YRsfQ6 = zVzKL8Ig.getHeaderField(BulPnWho);
					String d8T9VevI = zVzKL8Ig.getHeaderFieldKey(BulPnWho);
					if (k0YRsfQ6 == null || d8T9VevI == null) {
						break;
					}
				}
				InputStream HDIMhYA1 = new BufferedInputStream(zVzKL8Ig.getInputStream());
				CRemoteXML OWVEQYoE = new CRemoteXML();
				try {
					Document Ed6T0f5Y = OWVEQYoE.parse(HDIMhYA1);
					PrintWriter YYozmHj7 = new PrintWriter(new OutputStreamWriter(System.out, charsetName), true);
					OutputFormat k3scvZkW = OutputFormat.createPrettyPrint();
					XMLWriter gCAGgFOU = new XMLWriter(YYozmHj7, k3scvZkW);
					gCAGgFOU.write(Ed6T0f5Y);
					gCAGgFOU.flush();
					zVzKL8Ig.disconnect();
					mhX2Ef8a.m_document = Ed6T0f5Y;
					return mhX2Ef8a;
				} catch (DocumentException AhdeNKNG) {
					AhdeNKNG.printStackTrace();
					zVzKL8Ig.disconnect();
					System.out.println("XML parsing issue");
					mhX2Ef8a.m_generalFailure = true;
				}
			} catch (SocketTimeoutException Me4HAqQH) {
				mhX2Ef8a.m_timeoutFailure = true;
				System.out.println("Timed out");
			} catch (IOException IfrULKxf) {
				IfrULKxf.printStackTrace();
				mhX2Ef8a.m_generalFailure = true;
			}
		} catch (MalformedURLException Khg3D4kl) {
			Khg3D4kl.printStackTrace();
			mhX2Ef8a.m_generalFailure = true;
		}
		return mhX2Ef8a;
	}

}