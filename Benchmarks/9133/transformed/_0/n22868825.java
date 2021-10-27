class n22868825 {
	String sendRequest(String[] hH8zaoql, String[] vTKeOgm3, Object[] dDSRUn26, boolean NVOtCfPx) throws IOException {
		String jNqp6trb = wikiBaseURI;
		if (hH8zaoql != null)
			for (int g05MN7df = 0; g05MN7df + 1 < hH8zaoql.length; g05MN7df += 2)
				jNqp6trb += (g05MN7df == 0 ? '?' : '&') + urlEncode(hH8zaoql[g05MN7df]) + '='
						+ urlEncode(hH8zaoql[g05MN7df + 1]);
		URL VcxtUbZa = new URL(jNqp6trb);
		HttpURLConnection rBxh9fnL = (HttpURLConnection) VcxtUbZa.openConnection();
		rBxh9fnL.setDoInput(true);
		rBxh9fnL.setUseCaches(false);
		if (!NVOtCfPx) {
			String TEoRi2Rf = "";
			for (String yBcVKQEB : cookies.keySet())
				TEoRi2Rf += (TEoRi2Rf.length() == 0 ? "" : "; ") + yBcVKQEB + "=" + cookies.get(yBcVKQEB);
			rBxh9fnL.setRequestProperty("Cookie", TEoRi2Rf);
		}
		if (dDSRUn26 != null) {
			rBxh9fnL.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
			rBxh9fnL.setDoOutput(true);
			rBxh9fnL.setRequestMethod("POST");
			rBxh9fnL.connect();
			PrintStream llYBZJnA = new PrintStream(rBxh9fnL.getOutputStream());
			for (int lwQjjHMh = 0; dDSRUn26 != null && lwQjjHMh + 2 < dDSRUn26.length; lwQjjHMh += 3) {
				llYBZJnA.print("--" + boundary + "\r\n");
				postFile(llYBZJnA, rBxh9fnL, (String) dDSRUn26[lwQjjHMh], (String) dDSRUn26[lwQjjHMh + 1],
						(byte[]) dDSRUn26[lwQjjHMh + 2]);
			}
			for (int oMH9GDZU = 0; vTKeOgm3 != null && oMH9GDZU + 1 < vTKeOgm3.length; oMH9GDZU += 2)
				llYBZJnA.print("--" + boundary + "\r\n" + "Content-Disposition: " + "form-data; name=\""
						+ vTKeOgm3[oMH9GDZU] + "\"\r\n\r\n" + vTKeOgm3[oMH9GDZU + 1] + "\r\n");
			llYBZJnA.println("--" + boundary + "--");
			llYBZJnA.close();
		} else if (vTKeOgm3 != null) {
			rBxh9fnL.setDoOutput(true);
			rBxh9fnL.setRequestMethod("POST");
			rBxh9fnL.connect();
			PrintStream r2dxN5G5 = new PrintStream(rBxh9fnL.getOutputStream());
			for (int K3Q3VDOr = 0; vTKeOgm3 != null && K3Q3VDOr + 1 < vTKeOgm3.length; K3Q3VDOr += 2)
				r2dxN5G5.print((K3Q3VDOr == 0 ? "" : "&") + urlEncode(vTKeOgm3[K3Q3VDOr]) + "="
						+ urlEncode(vTKeOgm3[K3Q3VDOr + 1]));
			r2dxN5G5.close();
		}
		int ntLiKb2i = rBxh9fnL.getResponseCode();
		if (ntLiKb2i != 200)
			throw new IOException("HTTP code: " + ntLiKb2i);
		if (NVOtCfPx)
			getCookies(rBxh9fnL.getHeaderFields().get("Set-Cookie"));
		InputStream NItwkgU1 = rBxh9fnL.getInputStream();
		response = "";
		byte[] w31ww7Pu = new byte[1 << 16];
		for (;;) {
			int ZwGjt5gM = NItwkgU1.read(w31ww7Pu);
			if (ZwGjt5gM < 0)
				break;
			response += new String(w31ww7Pu, 0, ZwGjt5gM);
		}
		NItwkgU1.close();
		return response;
	}

}