class n13642472 {
	protected void handleConnection(Socket LU0ATv4l) throws IOException {
		OutputStream X1r6EsVi = LU0ATv4l.getOutputStream();
		PrintWriter TimeYogB = new PrintWriter(X1r6EsVi, true);
		BufferedReader GeqpxEdP = SocketUtil.getReader(LU0ATv4l);
		String q9EJUPdG = null;
		int KipfQ0RQ = 0;
		String jsSFmj53 = "HTTP/1.0";
		String ByDzK9oU = null;
		String YPNRou8B = GeqpxEdP.readLine();
		URL hD0Kftw0 = null;
		if (YPNRou8B != null) {
			StringTokenizer AhN5ecJn = new StringTokenizer(YPNRou8B);
			if (AhN5ecJn.countTokens() != 3) {
				KipfQ0RQ = 400;
				q9EJUPdG = "Illformed Request-Line";
			} else {
				String V8iCmG0m = AhN5ecJn.nextToken();
				if (!V8iCmG0m.equalsIgnoreCase("get")) {
					KipfQ0RQ = 501;
					q9EJUPdG = "Only supports GET method";
				} else {
					ByDzK9oU = AhN5ecJn.nextToken();
					jsSFmj53 = AhN5ecJn.nextToken();
					try {
						hD0Kftw0 = getURL(ByDzK9oU);
					} catch (IOException iAR2L3mi) {
						KipfQ0RQ = 404;
						q9EJUPdG = "resource not found";
					}
				}
			}
		} else {
			KipfQ0RQ = 400;
			q9EJUPdG = "Null request";
		}
		if (hD0Kftw0 != null) {
			InputStream zhSMCW61 = null;
			try {
				URLConnection oejaPdFd = hD0Kftw0.openConnection();
				byte[] ba3WKs8X = new byte[1024];
				int iONe0XDD = 0;
				TimeYogB.println(jsSFmj53 + " 200 ");
				TimeYogB.println("Content-Type: " + oejaPdFd.getContentType());
				TimeYogB.println("Content-Length: " + oejaPdFd.getContentLength());
				TimeYogB.println("Content-Encoding: " + oejaPdFd.getContentEncoding());
				TimeYogB.println();
				zhSMCW61 = oejaPdFd.getInputStream();
				iONe0XDD = zhSMCW61.read(ba3WKs8X);
				while (iONe0XDD != -1) {
					X1r6EsVi.write(ba3WKs8X, 0, iONe0XDD);
					iONe0XDD = zhSMCW61.read(ba3WKs8X);
				}
			} catch (IOException xctmfEly) {
				KipfQ0RQ = 500;
				q9EJUPdG = "problem reading the resource content";
			} finally {
				if (zhSMCW61 != null) {
					zhSMCW61.close();
				}
			}
		} else {
			KipfQ0RQ = 404;
			q9EJUPdG = "resource not found";
		}
		if (KipfQ0RQ != 0) {
			TimeYogB.println(jsSFmj53 + " " + KipfQ0RQ + " " + q9EJUPdG);
			TimeYogB.println();
		}
		doDelay();
		LU0ATv4l.close();
	}

}