class n8046689 {
	private URL retrieveFirstURL(URL url, RSLink link) {
		link.setStatus(RSLink.STATUS_WAITING);
		HttpURLConnection httpConn = null;
		URL result = null;
		Pattern formStartPattern = Pattern.compile("<form.+action=\"");
		BufferedReader inr = null;
		Pattern freeUserPattern = Pattern.compile("input type=\"submit\" value=\"Free user\"");
		Pattern formEndPattern = Pattern.compile("</form>");
		Pattern urlString = Pattern.compile("http://[a-zA-Z0-9\\.\\-/_]+");
		try {
			httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setDoOutput(false);
			httpConn.setDoInput(true);
			String line = null;
			inr = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
			boolean freeUser = false;
			String urlLine = null;
			Matcher matcher = null;
			while ((line = inr.readLine()) != null) {
				if (urlLine == null) {
					matcher = formStartPattern.matcher(line);
					if (matcher.find()) {
						urlLine = line;
					}
				} else {
					matcher = formEndPattern.matcher(line);
					if (matcher.find()) {
						urlLine = null;
					} else {
						matcher = freeUserPattern.matcher(line);
						if (matcher.find()) {
							freeUser = true;
							break;
						}
					}
				}
			}
			if (freeUser) {
				matcher = urlString.matcher(urlLine);
				if (matcher.find()) {
					result = new URL(matcher.group());
				}
			}
		} catch (MalformedURLException ex) {
			log("Malformed URL Exception!");
		} catch (IOException ex) {
			log("I/O Exception!");
		} finally {
			try {
				if (inr != null)
					inr.close();
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Can not close some connections:\n" + ex.getMessage(), "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
			if (httpConn != null)
				httpConn.disconnect();
			link.setStatus(RSLink.STATUS_NOTHING);
			return result;
		}
	}

}