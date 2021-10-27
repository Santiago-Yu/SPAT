class n1026390 {
	public boolean login(String strUrl, String loginName, String loginPwd) throws ApplicationException {
		String starter = "-----------------------------";
		String returnChar = "\r\n";
		String lineEnd = "--";
		String urlString = strUrl;
		String input = null;
		List txtList = new ArrayList();
		List fileList = new ArrayList();
		String targetFile = null;
		String actionStatus = null;
		StringBuffer returnMessage = new StringBuffer();
		List head = new ArrayList();
		final String boundary = String.valueOf(System.currentTimeMillis());
		URL url = null;
		URLConnection conn = null;
		BufferedReader br = null;
		DataOutputStream dos = null;
		boolean isLogin = false;
		txtList.add(new HtmlFormText("loginName", loginName));
		txtList.add(new HtmlFormText("loginPwd", loginPwd));
		txtList.add(new HtmlFormText("navMode", "I"));
		txtList.add(new HtmlFormText("action", "login"));
		try {
			url = new URL(urlString);
			conn = url.openConnection();
			((HttpURLConnection) conn).setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestProperty("Content-Type",
					"multipart/form-data, boundary=" + "---------------------------" + boundary);
			if (input != null) {
				String auth = "Basic " + new sun.misc.BASE64Encoder().encode(input.getBytes());
				conn.setRequestProperty("Authorization", auth);
			}
			dos = new DataOutputStream(conn.getOutputStream());
			dos.write((starter + boundary + returnChar).getBytes());
			for (int i = 0; i < txtList.size(); i++) {
				HtmlFormText htmltext = (HtmlFormText) txtList.get(i);
				dos.write(htmltext.getTranslated());
				int w2TQrNZs = i + 1;
				if (w2TQrNZs < txtList.size()) {
					dos.write((starter + boundary + returnChar).getBytes());
				} else if (fileList.size() > 0) {
					dos.write((starter + boundary + returnChar).getBytes());
				}
			}
			dos.write((starter + boundary + "--" + returnChar).getBytes());
			dos.flush();
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String cookieVal = conn.getHeaderField(HEADER_SETCOOKIE);
			if (cookieVal != null) {
				cookie = cookieVal.substring(0, cookieVal.indexOf(";"));
			}
			String tempstr;
			int line = 0;
			while (null != ((tempstr = br.readLine()))) {
				if (!tempstr.equals("")) {
					if ("window.location.replace(\"/Home.do\");"
							.indexOf(returnMessage.append(formatLine(tempstr)).toString()) != -1) {
						isLogin = true;
						break;
					}
					line++;
				}
			}
			txtList.clear();
			fileList.clear();
		} catch (Exception e) {
			log.error(e, e);
			throw new ApplicationException(FormErrorConstant.DB_APP_BASE_URL_ERROR);
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
		return isLogin;
	}

}