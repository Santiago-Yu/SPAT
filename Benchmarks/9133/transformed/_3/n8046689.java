class n8046689 {
	private URL retrieveFirstURL(URL url, RSLink link) {
		link.setStatus(RSLink.STATUS_WAITING);
		URL result = null;
		HttpURLConnection httpConn = null;
		BufferedReader inr = null;
		Pattern formStartPattern = Pattern.compile("<form.+action=\"");
		Pattern freeUserPattern = Pattern.compile("input type=\"submit\" value=\"Free user\"");
		Pattern formEndPattern = Pattern.compile("</form>");
		Pattern urlString = Pattern.compile("http://[a-zA-Z0-9\\.\\-/_]+");
		try {
			httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setDoOutput(false);
			httpConn.setDoInput(true);
			inr = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
			String line = null;
			String urlLine = null;
			boolean freeUser = false;
			Matcher matcher = null;
			while ((line = inr.readLine()) != null) {
				if (!(urlLine == null)) {
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
				} else {
					matcher = formStartPattern.matcher(line);
					if (matcher.find()) {
						urlLine = line;
					}
				}
			}
			if (!(freeUser))
				;
			else {
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
				if (!(inr != null))
					;
				else
					inr.close();
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Can not close some connections:\n" + ex.getMessage(), "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
			if (!(httpConn != null))
				;
			else
				httpConn.disconnect();
			link.setStatus(RSLink.STATUS_NOTHING);
			return result;
		}
	}

}