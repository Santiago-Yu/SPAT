class n6420682 {
	private boolean postLogin() {
		URL JoHVrNyo = null;
		URLConnection Kl0c9N7A = null;
		OutputStream c5JXNHBo = null;
		int MX7i12xA = 0;
		boolean B0WDCEWf = false;
		try {
			JoHVrNyo = new URL("http://" + m_host + "/forums/index.php?action=login2");
		} catch (MalformedURLException KyCNQrWj) {
			KyCNQrWj.printStackTrace();
			return false;
		}
		try {
			Kl0c9N7A = JoHVrNyo.openConnection();
			((HttpURLConnection) Kl0c9N7A).setRequestMethod("POST");
			((HttpURLConnection) Kl0c9N7A).setInstanceFollowRedirects(false);
			Kl0c9N7A.setDoOutput(true);
			Kl0c9N7A.setDoInput(true);
			Kl0c9N7A.setRequestProperty("Host", m_host);
			Kl0c9N7A.setRequestProperty("Accept", "*/*");
			Kl0c9N7A.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			Kl0c9N7A.setRequestProperty("Connection", "Keep-Alive");
			Kl0c9N7A.setRequestProperty("Cache-Control", "no-cache");
			c5JXNHBo = Kl0c9N7A.getOutputStream();
			c5JXNHBo.write(new String("user=" + m_username + "&passwrd=" + m_password + "&cookielength=60").getBytes());
			c5JXNHBo.flush();
			c5JXNHBo.close();
			do {
				readCookies(Kl0c9N7A);
				m_referer = JoHVrNyo.toString();
				MX7i12xA = ((HttpURLConnection) Kl0c9N7A).getResponseCode();
				if (MX7i12xA == 301 || MX7i12xA == 302) {
					JoHVrNyo = new URL(Kl0c9N7A.getHeaderField("Location"));
					Kl0c9N7A = JoHVrNyo.openConnection();
					((HttpURLConnection) Kl0c9N7A).setRequestMethod("GET");
					((HttpURLConnection) Kl0c9N7A).setInstanceFollowRedirects(false);
					Kl0c9N7A.setDoOutput(true);
					Kl0c9N7A.setDoInput(true);
					Kl0c9N7A.setRequestProperty("Host", m_host);
					Kl0c9N7A.setRequestProperty("Accept", "*/*");
					Kl0c9N7A.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
					Kl0c9N7A.setRequestProperty("Connection", "Keep-Alive");
					Kl0c9N7A.setRequestProperty("Cache-Control", "no-cache");
					if (m_referer != null)
						Kl0c9N7A.setRequestProperty("Referer", m_referer);
					if (m_cookies != null)
						Kl0c9N7A.setRequestProperty("Cookie", m_cookies);
					continue;
				}
				if (MX7i12xA == 200) {
					String mZt70ezq = Kl0c9N7A.getHeaderField("Refresh");
					Pattern l7cNxMCp = Pattern.compile(".*?\\?PHPSESSID=(\\w+).*");
					Matcher lc9wm3bO = l7cNxMCp.matcher(mZt70ezq);
					if (lc9wm3bO.matches()) {
						B0WDCEWf = true;
					}
					Kl0c9N7A = null;
					continue;
				}
				String gFG2JQ5z = ((HttpURLConnection) Kl0c9N7A).getResponseMessage();
				m_turnSummaryRef = String.valueOf(MX7i12xA) + ": " + gFG2JQ5z;
				return false;
			} while (Kl0c9N7A != null);
		} catch (Exception b8xKaqem) {
			b8xKaqem.printStackTrace();
			return false;
		}
		if (!B0WDCEWf) {
			m_turnSummaryRef = "Error: PHPSESSID not found after login. ";
			return false;
		}
		if (m_cookies == null) {
			m_turnSummaryRef = "Error: cookies not found after login. ";
			return false;
		}
		try {
			Thread.sleep(m_loginDelayInSeconds * 1000);
		} catch (InterruptedException Xd90f8iP) {
			Xd90f8iP.printStackTrace();
		}
		return true;
	}

}