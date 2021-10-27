class n8046689 {
	private URL retrieveFirstURL(URL ptYEbRtI, RSLink AAKPvqHx) {
		AAKPvqHx.setStatus(RSLink.STATUS_WAITING);
		URL Mx0dIXNq = null;
		HttpURLConnection ZS1Esomk = null;
		BufferedReader QI806u7K = null;
		Pattern UnYfGEAd = Pattern.compile("<form.+action=\"");
		Pattern uAuFr8ty = Pattern.compile("input type=\"submit\" value=\"Free user\"");
		Pattern CvjxAt01 = Pattern.compile("</form>");
		Pattern zJ5xJSFO = Pattern.compile("http://[a-zA-Z0-9\\.\\-/_]+");
		try {
			ZS1Esomk = (HttpURLConnection) ptYEbRtI.openConnection();
			ZS1Esomk.setDoOutput(false);
			ZS1Esomk.setDoInput(true);
			QI806u7K = new BufferedReader(new InputStreamReader(ZS1Esomk.getInputStream()));
			String VK5HAvhD = null;
			String ffyJGYIM = null;
			boolean F4asu0Ad = false;
			Matcher sxzshHCB = null;
			while ((VK5HAvhD = QI806u7K.readLine()) != null) {
				if (ffyJGYIM == null) {
					sxzshHCB = UnYfGEAd.matcher(VK5HAvhD);
					if (sxzshHCB.find()) {
						ffyJGYIM = VK5HAvhD;
					}
				} else {
					sxzshHCB = CvjxAt01.matcher(VK5HAvhD);
					if (sxzshHCB.find()) {
						ffyJGYIM = null;
					} else {
						sxzshHCB = uAuFr8ty.matcher(VK5HAvhD);
						if (sxzshHCB.find()) {
							F4asu0Ad = true;
							break;
						}
					}
				}
			}
			if (F4asu0Ad) {
				sxzshHCB = zJ5xJSFO.matcher(ffyJGYIM);
				if (sxzshHCB.find()) {
					Mx0dIXNq = new URL(sxzshHCB.group());
				}
			}
		} catch (MalformedURLException gngHQ4n5) {
			log("Malformed URL Exception!");
		} catch (IOException n5IhihSe) {
			log("I/O Exception!");
		} finally {
			try {
				if (QI806u7K != null)
					QI806u7K.close();
			} catch (IOException CwhB9QYo) {
				JOptionPane.showMessageDialog(null, "Can not close some connections:\n" + CwhB9QYo.getMessage(),
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
			if (ZS1Esomk != null)
				ZS1Esomk.disconnect();
			AAKPvqHx.setStatus(RSLink.STATUS_NOTHING);
			return Mx0dIXNq;
		}
	}

}