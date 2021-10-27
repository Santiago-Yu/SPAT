class n19090291 {
	public static String extractIconPath(String siteURL) throws IOException {
		siteURL = siteURL.trim();
		siteURL = (!siteURL.startsWith("http://")) ? "http://" + siteURL : siteURL;
		URL url = new URL(siteURL);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String iconURL = null;
		String iconPath = null;
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			if (inputLine.contains("type=\"image/x-icon\"")
					|| inputLine.toLowerCase().contains("rel=\"shortcut icon\"")) {
				String tmp = new String(inputLine);
				String[] smallLines = inputLine.replace(">", ">\n").split("\n");
				for (String smallLine : smallLines) {
					if (smallLine.contains("type=\"image/x-icon\"")
							|| smallLine.toLowerCase().contains("rel=\"shortcut icon\"")) {
						tmp = smallLine;
						break;
					}
				}
				iconURL = tmp.replaceAll("^.*href=\"", "");
				iconURL = iconURL.replaceAll("\".*", "");
				tmp = null;
				String originalSiteURL = new String(siteURL);
				siteURL = getHome(siteURL);
				if (iconURL.charAt(0) == '/') {
					iconURL = (siteURL.charAt(siteURL.length() - 1) == '/') ? siteURL + iconURL.substring(1)
							: siteURL + iconURL;
				} else if (!iconURL.startsWith("http://")) {
					iconURL = (siteURL.charAt(siteURL.length() - 1) == '/') ? siteURL + iconURL
							: siteURL + "/" + iconURL;
				}
				siteURL = originalSiteURL;
				break;
			}
			if (inputLine.contains("</head>".toLowerCase())) {
				break;
			}
		}
		in.close();
		siteURL = getHome(siteURL);
		if (iconURL == null || "".equals(iconURL.trim())) {
			iconURL = "favicon.ico";
			iconURL = (siteURL.charAt(siteURL.length() - 1) == '/') ? siteURL + iconURL : siteURL + "/" + iconURL;
		}
		try {
			String iconFileName = siteURL;
			iconFileName = (iconFileName.startsWith("http://")) ? iconFileName.substring(7) : iconFileName;
			iconFileName = iconFileName.replaceAll("\\W", " ").trim().replace(" ", "_").concat(".ico");
			iconPath = JReader.getConfig().getShortcutIconsDir() + File.separator + iconFileName;
			InputStream inIcon = new URL(iconURL).openStream();
			OutputStream outIcon = new FileOutputStream(iconPath);
			byte[] buf = new byte[1024];
			int len;
			while ((len = inIcon.read(buf)) > 0) {
				outIcon.write(buf, 0, len);
			}
			inIcon.close();
			outIcon.close();
		} catch (Exception e) {
		}
		return iconPath;
	}

}