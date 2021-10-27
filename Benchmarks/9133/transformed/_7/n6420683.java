class n6420683 {
	private boolean goToForum() {
		URL url = null;
		URLConnection urlConn = null;
		int code = 0;
		boolean gotNumReplies = false;
		boolean gotMsgNum = false;
		try {
			url = new URL("http://" + m_host + "/forums/index.php?topic=" + m_gameId + ".new");
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return false;
		}
		try {
			urlConn = url.openConnection();
			((HttpURLConnection) urlConn).setRequestMethod("GET");
			((HttpURLConnection) urlConn).setInstanceFollowRedirects(false);
			urlConn.setDoOutput(false);
			urlConn.setDoInput(true);
			urlConn.setRequestProperty("Host", m_host);
			urlConn.setRequestProperty("Accept", "*/*");
			urlConn.setRequestProperty("Connection", "Keep-Alive");
			urlConn.setRequestProperty("Cache-Control", "no-cache");
			if (m_referer != null)
				urlConn.setRequestProperty("Referer", m_referer);
			if (m_cookies != null)
				urlConn.setRequestProperty("Cookie", m_cookies);
			m_referer = url.toString();
			readCookies(urlConn);
			code = ((HttpURLConnection) urlConn).getResponseCode();
			if (code != 200) {
				String msg = ((HttpURLConnection) urlConn).getResponseMessage();
				m_turnSummaryRef = String.valueOf(code) + ": " + msg;
				return false;
			}
			BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			String line = "";
			Pattern p_numReplies = Pattern.compile(".*?;num_replies=(\\d+)\".*");
			Pattern p_msgNum = Pattern.compile(".*?<a name=\"msg(\\d+)\"></a><a name=\"new\"></a>.*");
			Pattern p_attachId = Pattern.compile(".*?action=dlattach;topic=" + m_gameId + ".0;attach=(\\d+)\">.*");
			while ((line = in.readLine()) != null) {
				if (!gotNumReplies) {
					Matcher match_numReplies = p_numReplies.matcher(line);
					if (match_numReplies.matches()) {
						m_numReplies = match_numReplies.group(1);
						gotNumReplies = true;
						continue;
					}
				}
				if (!gotMsgNum) {
					Matcher match_msgNum = p_msgNum.matcher(line);
					if (match_msgNum.matches()) {
						m_msgNum = match_msgNum.group(1);
						gotMsgNum = true;
						continue;
					}
				}
				Matcher match_attachId = p_attachId.matcher(line);
				if (match_attachId.matches())
					m_attachId = match_attachId.group(1);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		if (!gotNumReplies || !gotMsgNum) {
			m_turnSummaryRef = "Error: ";
			if (!gotNumReplies)
				m_turnSummaryRef = m_turnSummaryRef + ("No num_replies found in A&A.org forum topic. ");
			if (!gotMsgNum)
				m_turnSummaryRef = m_turnSummaryRef + ("No msgXXXXXX found in A&A.org forum topic. ");
			return false;
		}
		return true;
	}

}