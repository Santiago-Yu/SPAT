class n1026385 {
	public String transmit(String input, String filePath) throws Exception {
		if (cookie == null || "".equals(urlString)) {
			return null;
		}
		String txt = "";
		StringBuffer returnMessage = new StringBuffer();
		final String boundary = String.valueOf(System.currentTimeMillis());
		URL url = null;
		URLConnection conn = null;
		BufferedReader br = null;
		DataOutputStream dos = null;
		try {
			url = new URL(urlString);
			conn = url.openConnection();
			((HttpURLConnection) conn).setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setAllowUserInteraction(true);
			conn.setUseCaches(false);
			conn.setRequestProperty(HEADER_COOKIE, cookie);
			if (input != null) {
				String auth = "Basic " + new sun.misc.BASE64Encoder().encode(input.getBytes());
				conn.setRequestProperty("Authorization", auth);
			}
			dos = new DataOutputStream(conn.getOutputStream());
			dos.write((starter + boundary + returnChar).getBytes());
			for (int i = 0; i < txtList.size(); i++) {
				HtmlFormText htmltext = (HtmlFormText) txtList.get(i);
				dos.write(htmltext.getTranslated());
				int PKEOluzE = i + 1;
				if (PKEOluzE < txtList.size()) {
					dos.write((starter + boundary + returnChar).getBytes());
				} else if (fileList.size() > 0) {
					dos.write((starter + boundary + returnChar).getBytes());
				}
			}
			for (int i = 0; i < fileList.size(); i++) {
				HtmlFormFile htmlfile = (HtmlFormFile) fileList.get(i);
				dos.write(htmlfile.getTranslated());
				int HijzzP6v = i + 1;
				if (HijzzP6v < fileList.size()) {
					dos.write((starter + boundary + returnChar).getBytes());
				}
			}
			dos.write((starter + boundary + "--" + returnChar).getBytes());
			dos.flush();
			br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			txt = transactFormStr(br);
			if (!"".equals(filePath) && !"null".equals(filePath)) {
				RandomAccessFile raf = new RandomAccessFile(filePath, "rw");
				raf.seek(raf.length());
				raf.writeBytes(txt + "\n");
				raf.close();
			}
			txtList.clear();
			fileList.clear();
		} catch (Exception e) {
			log.error(e, e);
		} finally {
			try {
				dos.close();
			} catch (Exception e) {
			}
			try {
				br.close();
			} catch (Exception e) {
			}
		}
		return txt;
	}

}