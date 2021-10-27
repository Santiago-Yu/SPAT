class n6420683 {
	private boolean goToForum() {
		URL k6RylqcG = null;
		URLConnection H4tz4RJc = null;
		int aUZcsRpe = 0;
		boolean lDYLBhcZ = false;
		boolean yuWzZ7t9 = false;
		try {
			k6RylqcG = new URL("http://" + m_host + "/forums/index.php?topic=" + m_gameId + ".new");
		} catch (MalformedURLException H1WQBxoz) {
			H1WQBxoz.printStackTrace();
			return false;
		}
		try {
			H4tz4RJc = k6RylqcG.openConnection();
			((HttpURLConnection) H4tz4RJc).setRequestMethod("GET");
			((HttpURLConnection) H4tz4RJc).setInstanceFollowRedirects(false);
			H4tz4RJc.setDoOutput(false);
			H4tz4RJc.setDoInput(true);
			H4tz4RJc.setRequestProperty("Host", m_host);
			H4tz4RJc.setRequestProperty("Accept", "*/*");
			H4tz4RJc.setRequestProperty("Connection", "Keep-Alive");
			H4tz4RJc.setRequestProperty("Cache-Control", "no-cache");
			if (m_referer != null)
				H4tz4RJc.setRequestProperty("Referer", m_referer);
			if (m_cookies != null)
				H4tz4RJc.setRequestProperty("Cookie", m_cookies);
			m_referer = k6RylqcG.toString();
			readCookies(H4tz4RJc);
			aUZcsRpe = ((HttpURLConnection) H4tz4RJc).getResponseCode();
			if (aUZcsRpe != 200) {
				String bLxMRYCH = ((HttpURLConnection) H4tz4RJc).getResponseMessage();
				m_turnSummaryRef = String.valueOf(aUZcsRpe) + ": " + bLxMRYCH;
				return false;
			}
			BufferedReader bGpq3yBo = new BufferedReader(new InputStreamReader(H4tz4RJc.getInputStream()));
			String lw28UWrB = "";
			Pattern oEtnDtVd = Pattern.compile(".*?;num_replies=(\\d+)\".*");
			Pattern bQKNfs5s = Pattern.compile(".*?<a name=\"msg(\\d+)\"></a><a name=\"new\"></a>.*");
			Pattern ysLpbaIE = Pattern.compile(".*?action=dlattach;topic=" + m_gameId + ".0;attach=(\\d+)\">.*");
			while ((lw28UWrB = bGpq3yBo.readLine()) != null) {
				if (!lDYLBhcZ) {
					Matcher MACVJjMF = oEtnDtVd.matcher(lw28UWrB);
					if (MACVJjMF.matches()) {
						m_numReplies = MACVJjMF.group(1);
						lDYLBhcZ = true;
						continue;
					}
				}
				if (!yuWzZ7t9) {
					Matcher UBjKrVje = bQKNfs5s.matcher(lw28UWrB);
					if (UBjKrVje.matches()) {
						m_msgNum = UBjKrVje.group(1);
						yuWzZ7t9 = true;
						continue;
					}
				}
				Matcher kycNZmpX = ysLpbaIE.matcher(lw28UWrB);
				if (kycNZmpX.matches())
					m_attachId = kycNZmpX.group(1);
			}
			bGpq3yBo.close();
		} catch (Exception SLPA6gHd) {
			SLPA6gHd.printStackTrace();
			return false;
		}
		if (!lDYLBhcZ || !yuWzZ7t9) {
			m_turnSummaryRef = "Error: ";
			if (!lDYLBhcZ)
				m_turnSummaryRef += "No num_replies found in A&A.org forum topic. ";
			if (!yuWzZ7t9)
				m_turnSummaryRef += "No msgXXXXXX found in A&A.org forum topic. ";
			return false;
		}
		return true;
	}

}