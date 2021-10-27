class n18076450 {
	public void fetch(URL YeIA8re5, HTTPMethod jxPDAM5Z, String qmE7Guao, WithResponse el7SJ9PO) throws IOException {
		System.out.println("fetchin' " + YeIA8re5.toString() + " with GAE fetch service");
		HttpURLConnection U8lKAyhC = null;
		try {
			U8lKAyhC = (HttpURLConnection) YeIA8re5.openConnection();
			U8lKAyhC.setInstanceFollowRedirects(false);
			U8lKAyhC.setReadTimeout(10000);
			U8lKAyhC.setRequestMethod(jxPDAM5Z.name());
			System.out.println(jxPDAM5Z.name().toString());
			U8lKAyhC.setRequestProperty("Connection", "close");
			U8lKAyhC.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			if (el7SJ9PO != null) {
				U8lKAyhC.setDoOutput(true);
			}
			U8lKAyhC.connect();
			System.out.println(U8lKAyhC.toString());
			if (qmE7Guao != null) {
				OutputStream XMyxgCwv = null;
				OutputStreamWriter lgvSPrBY = null;
				try {
					XMyxgCwv = U8lKAyhC.getOutputStream();
					lgvSPrBY = new OutputStreamWriter(XMyxgCwv, "UTF-8");
					lgvSPrBY.write(qmE7Guao);
					System.out.println(XMyxgCwv.toString());
				} finally {
					close(lgvSPrBY);
					close(XMyxgCwv);
				}
			}
			if (el7SJ9PO != null) {
				InputStream VZ4dodTn = null;
				InputStreamReader kF5ZFyhs = null;
				StringBuilder sDJ8hwDE = new StringBuilder();
				try {
					VZ4dodTn = U8lKAyhC.getInputStream();
					kF5ZFyhs = new InputStreamReader(VZ4dodTn);
					BufferedReader G6DUulZ5 = new BufferedReader(kF5ZFyhs);
					String cYGubltD;
					while ((cYGubltD = G6DUulZ5.readLine()) != null) {
						sDJ8hwDE.append(cYGubltD).append('\n');
					}
					System.out.println(cYGubltD);
				} finally {
					close(kF5ZFyhs);
					close(VZ4dodTn);
				}
			}
		} finally {
			if (U8lKAyhC != null) {
				U8lKAyhC.disconnect();
			}
		}
	}

}