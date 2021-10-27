class n14865741 {
	public boolean login(URL strUrl, String loginName, String loginPwd, String sessionID) throws Exception {
		String starter = "-----------------------------";
		String returnChar = "\r\n";
		URL urlString = strUrl;
		String lineEnd = "--";
		List txtList = new ArrayList();
		String input = null;
		String targetFile = null;
		List fileList = new ArrayList();
		StringBuffer returnMessage = new StringBuffer();
		String actionStatus = null;
		final String boundary = String.valueOf(System.currentTimeMillis());
		List head = new ArrayList();
		URLConnection conn = null;
		URL url = null;
		DataOutputStream dos = null;
		BufferedReader br = null;
		boolean isLogin = false;
		txtList.add(new HtmlFormText("loginName", loginName));
		txtList.add(new HtmlFormText("loginPwd", loginPwd));
		txtList.add(new HtmlFormText("navMode", "I"));
		txtList.add(new HtmlFormText("action", "login"));
		try {
			url = new URL(urlString, "/" + projectName + "/Login.do");
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
				if (i + 1 < txtList.size()) {
					dos.write((starter + boundary + returnChar).getBytes());
				} else if (fileList.size() > 0) {
					dos.write((starter + boundary + returnChar).getBytes());
				}
			}
			dos.write((starter + boundary + "--" + returnChar).getBytes());
			dos.flush();
			String key;
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			int i = 1;
			String header;
			key = conn.getHeaderFieldKey(i);
			header = conn.getHeaderField(i);
			System.out.println(header);
			if (Utility.isEmpty(header) || header.indexOf("JSESSIONID") < 0) {
				header = "JSESSIONID=" + sessionID + "; Path=/" + projectName;
			}
			String tempstr;
			while (key != null) {
				head.add(header);
				i++;
				key = conn.getHeaderFieldKey(i);
				header = conn.getHeaderField(i);
			}
			int line = 0;
			while (null != ((tempstr = br.readLine()))) {
				if (!tempstr.equals("")) {
					line++;
					if ("window.location.replace(\"/eip/Home.do\");"
							.indexOf(returnMessage.append(formatLine(tempstr)).toString()) != -1) {
						isLogin = true;
						break;
					}
				}
			}
			txtList.clear();
			fileList.clear();
		} catch (Exception e) {
			e.printStackTrace();
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
		this.setHeadList(head);
		return isLogin;
	}

}