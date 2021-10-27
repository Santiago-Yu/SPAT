class n7844497 {
	public static String simplePostRequest(String bY51rvIn, Map<String, Object> n1vIW3Qn) {
		try {
			URL VgOoHOqi = new URL(bY51rvIn);
			URLConnection QYf0jc6f = VgOoHOqi.openConnection();
			QYf0jc6f.setDoOutput(true);
			OutputStream UJdlb1Qs = QYf0jc6f.getOutputStream();
			OutputStream YEdjMMec = new BufferedOutputStream(UJdlb1Qs);
			OutputStreamWriter nb0WjS08 = new OutputStreamWriter(YEdjMMec);
			boolean cJvqnEDC = true;
			for (String aV2TqhdA : n1vIW3Qn.keySet()) {
				String T8Tpvseb = (String) n1vIW3Qn.get(aV2TqhdA);
				if (!cJvqnEDC) {
					nb0WjS08.write("&");
					cJvqnEDC = false;
				}
				nb0WjS08.write(aV2TqhdA + "=" + T8Tpvseb);
			}
			nb0WjS08.flush();
			nb0WjS08.close();
			InputStream ob6RjIV3 = new BufferedInputStream(QYf0jc6f.getInputStream());
			Reader mOgt48uW = new BufferedReader(new InputStreamReader(ob6RjIV3));
			StringBuilder PVANq5es = new StringBuilder();
			for (int rPPj3K4P = mOgt48uW.read(); rPPj3K4P != -1; rPPj3K4P = mOgt48uW.read()) {
				PVANq5es.append((char) rPPj3K4P);
			}
			return PVANq5es.toString();
		} catch (MalformedURLException Opod1frQ) {
			throw new CVardbException(Opod1frQ);
		} catch (IOException U4OUNE5N) {
			throw new CVardbException(U4OUNE5N);
		}
	}

}