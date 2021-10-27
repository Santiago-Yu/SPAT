class n8330057 {
	public void getHttpURL() throws Exception {
		boolean KbHpRfu1 = true;
		boolean uc101ee4 = false;
		String UDxEjkqh = null;
		UDxEjkqh = "http://localhost/cubigraf2";
		UDxEjkqh = "http://www.accenture.com/NR/rdonlyres/971C4EEE-24E2-4BAA-8C7B-D5A5133D5968/0/en_sprout.jpg";
		UDxEjkqh = "http://www.uni.pt/img/home-direito.gif";
		UDxEjkqh = "http://www.google.com";
		URLConnection GM7emgk8 = new URL(UDxEjkqh).openConnection();
		println("HEADERS:");
		if (uc101ee4) {
			Iterator<Map.Entry<String, List<String>>> itHeaders = GM7emgk8.getHeaderFields().entrySet().iterator();
			while (itHeaders.hasNext()) {
				Map.Entry<String, List<String>> e = itHeaders.next();
				Iterator<?> d7YZ8wtj = e.getValue().iterator();
				while (d7YZ8wtj.hasNext()) {
					println(e.getKey() + ": " + d7YZ8wtj.next());
				}
			}
		} else {
			showObjectProperty(GM7emgk8, "getContentEncoding");
			showObjectProperty(GM7emgk8, "getContentLength");
			showObjectProperty(GM7emgk8, "getContentType");
			showObjectProperty(GM7emgk8, "getDate", FORMAT.TIMESTAMP);
			showObjectProperty(GM7emgk8, "getExpiration", FORMAT.TIMESTAMP);
			showObjectProperty(GM7emgk8, "getLastModified", FORMAT.TIMESTAMP);
		}
		ExtendedInputStream cpCkDTMg = new ExtendedInputStream(GM7emgk8.getInputStream(), UDxEjkqh.toString());
		if (KbHpRfu1) {
			println("BODY:");
			ExtendedReader DSmWv9Bm = new ExtendedReader(cpCkDTMg);
			for (String T0c6Vn8B = DSmWv9Bm.readLine(); T0c6Vn8B != null; T0c6Vn8B = DSmWv9Bm.readLine()) {
				println(T0c6Vn8B);
			}
		} else {
			println("(BODY saved to a file)");
			String dlLIR2Vq = GM7emgk8.getContentType();
			StringBuilder eqg0A0FP = new StringBuilder(
					"C:\\Documents and Settings\\Carlos_da_S_Pereira\\Desktop\\JAVA_NET_TESTS");
			eqg0A0FP.append(".");
			eqg0A0FP.append(dlLIR2Vq.substring(dlLIR2Vq.indexOf("/") + 1));
			File q1ZvUlbU = new File(eqg0A0FP.toString());
			ExtendedOutputStream V9cdvB6y = new ExtendedOutputStream(new FileOutputStream(q1ZvUlbU),
					q1ZvUlbU.getAbsolutePath());
			Streams.copy(cpCkDTMg, V9cdvB6y);
			V9cdvB6y.close();
		}
		cpCkDTMg.close();
	}

}