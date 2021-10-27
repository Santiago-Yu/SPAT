class n6420682 {
	private boolean postLogin() {
		URLConnection urlConn = null;
		URL url = null;
		int code = 0;
		OutputStream out = null;
		try {
			url = new URL("http://" + m_host + "/forums/index.php?action=login2");
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return false;
		}
		boolean gotPhpsessid = false;
		try {
			urlConn = url.openConnection();
			((HttpURLConnection) urlConn).setRequestMethod("POST");
			((HttpURLConnection) urlConn).setInstanceFollowRedirects(false);
			urlConn.setDoOutput(true);
			urlConn.setDoInput(true);
			urlConn.setRequestProperty("Host", m_host);
			urlConn.setRequestProperty("Accept", "*/*");
			urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			urlConn.setRequestProperty("Connection", "Keep-Alive");
			urlConn.setRequestProperty("Cache-Control", "no-cache");
			out = urlConn.getOutputStream();
			out.write(new String("user=" + m_username + "&passwrd=" + m_password + "&cookielength=60").getBytes());
			out.flush();
			out.close();
			do {
				readCookies(urlConn);
				m_referer = url.toString();
				code = ((HttpURLConnection) urlConn).getResponseCode();
				if (code == 301 || code == 302) {
					url = new URL(urlConn.getHeaderField("Location"));
					urlConn = url.openConnection();
					((HttpURLConnection) urlConn).setRequestMethod("GET");
					((HttpURLConnection) urlConn).setInstanceFollowRedirects(false);
					urlConn.setDoOutput(true);
					urlConn.setDoInput(true);
					urlConn.setRequestProperty("Host", m_host);
					urlConn.setRequestProperty("Accept", "*/*");
					urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
					urlConn.setRequestProperty("Connection", "Keep-Alive");
					urlConn.setRequestProperty("Cache-Control", "no-cache");
					if (m_referer != null)
						urlConn.setRequestProperty("Referer", m_referer);
					if (m_cookies != null)
						urlConn.setRequestProperty("Cookie", m_cookies);
					continue;
				}
				if (code == 200) {
					String refreshHdr = urlConn.getHeaderField("Refresh");
					Pattern p_phpsessid = Pattern.compile(".*?\\?PHPSESSID=(\\w+).*");
					Matcher match_phpsessid = p_phpsessid.matcher(refreshHdr);
					urlConn = null;
					if (match_phpsessid.matches()) {
						gotPhpsessid = true;
					}
					continue;
				}
				String msg = ((HttpURLConnection) urlConn).getResponseMessage();
				m_turnSummaryRef = String.valueOf(code) + ": " + msg;
				return false;
			} while (urlConn != null);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		if (!gotPhpsessid) {
			m_turnSummaryRef = "Error: PHPSESSID not found after login. ";
			return false;
		}
		if (m_cookies == null) {
			m_turnSummaryRef = "Error: cookies not found after login. ";
			return false;
		}
		try {
			Thread.sleep(m_loginDelayInSeconds * 1000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		return true;
	}

}