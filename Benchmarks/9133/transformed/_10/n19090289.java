class n19090289 {
	public static Channel getChannelFromSite(String siteURL)
			throws LinkNotFoundException, MalformedURLException, SAXException, IOException {
		siteURL = siteURL.trim();
		String channelURL = "";
		if (!siteURL.startsWith("http://")) {
			siteURL = "http://" + siteURL;
		}
		URL url = new URL(siteURL);
		String[] lines = new String[3];
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		for (int i = 0; i < lines.length; i++) {
			if ((lines[i] = in.readLine()) == null) {
				lines[i] = "";
				break;
			}
		}
		if (lines[0].contains("xml version")) {
			if (lines[0].contains("rss") || lines[1].contains("rss")) {
				channelURL = siteURL;
			}
			if (lines[0].contains("Atom") || lines[1].contains("Atom") || lines[2].contains("Atom")) {
				channelURL = siteURL;
			}
		}
		in.close();
		String iconURL = null;
		in = new BufferedReader(new InputStreamReader(url.openStream()));
		String inputLine;
		if ("".equals(channelURL)) {
			boolean isChannelURLFound = false;
			boolean isIconURLFound = false;
			while ((inputLine = in.readLine()) != null) {
				if (inputLine.contains("type=\"image/x-icon\"")
						|| inputLine.toLowerCase().contains("rel=\"shortcut icon\"")) {
					String tmp = new String(inputLine);
					String[] smallLines = inputLine.replace(">", ">\n").split("\n");
					isIconURLFound = true;
					for (String smallLine : smallLines) {
						if (smallLine.contains("type=\"image/x-icon\"")
								|| smallLine.toLowerCase().contains("rel=\"shortcut icon\"")) {
							tmp = smallLine;
							break;
						}
					}
					iconURL = tmp.replaceAll("^.*href=\"", "");
					tmp = null;
					iconURL = iconURL.replaceAll("\".*", "");
					String originalSiteURL = new String(siteURL);
					siteURL = getHome(siteURL);
					if (iconURL.charAt(0) == '/') {
						if (siteURL.charAt(siteURL.length() - 1) == '/') {
							iconURL = siteURL + iconURL.substring(1);
						} else {
							iconURL = siteURL + iconURL;
						}
					} else if (!iconURL.startsWith("http://")) {
						if (siteURL.charAt(siteURL.length() - 1) == '/') {
							iconURL = siteURL + iconURL;
						} else {
							iconURL = siteURL + "/" + iconURL;
						}
					}
					if (isChannelURLFound && isIconURLFound) {
						break;
					}
					siteURL = originalSiteURL;
				}
				if ((inputLine.contains("type=\"application/rss+xml\"")
						|| inputLine.contains("type=\"application/atom+xml\"")) && !isChannelURLFound) {
					if (!inputLine.contains("href=")) {
						while ((inputLine = in.readLine()) != null) {
							if (inputLine.contains("href=")) {
								break;
							}
						}
					}
					inputLine = inputLine.replace(">", ">\n");
					String[] smallLines = inputLine.split("\n");
					for (String smallLine : smallLines) {
						if (smallLine.contains("type=\"application/rss+xml\"")
								|| smallLine.contains("type=\"application/atom+xml\"")) {
							inputLine = smallLine;
							break;
						}
					}
					channelURL = inputLine.replaceAll("^.*href=\"", "");
					channelURL = channelURL.replaceAll("\".*", "");
					isChannelURLFound = true;
					if (channelURL.charAt(0) == '/') {
						if (siteURL.charAt(siteURL.length() - 1) == '/') {
							channelURL = siteURL + channelURL.substring(1);
						} else {
							channelURL = siteURL + channelURL;
						}
					} else if (!channelURL.startsWith("http://")) {
						if (siteURL.charAt(siteURL.length() - 1) == '/') {
							channelURL = siteURL + channelURL;
						} else {
							channelURL = siteURL + "/" + channelURL;
						}
					}
					if (isChannelURLFound && isIconURLFound) {
						break;
					}
				}
				if (inputLine.contains("</head>".toLowerCase())) {
					break;
				}
			}
			in.close();
			if ("".equals(channelURL)) {
				throw new LinkNotFoundException();
			}
		}
		channel = getChannelFromXML(channelURL.trim());
		if (iconURL == null || "".equals(iconURL.trim())) {
			if (siteURL.equalsIgnoreCase(channel.getChannelURL())) {
				siteURL = channel.getLink();
			}
			iconURL = "favicon.ico";
			siteURL = getHome(siteURL);
			if (siteURL.charAt(siteURL.length() - 1) == '/') {
				iconURL = siteURL + iconURL;
			} else {
				iconURL = siteURL + "/" + iconURL;
			}
		}
		try {
			String iconFileName = getHome(channel.getLink());
			if (iconFileName.startsWith("http://")) {
				iconFileName = iconFileName.substring(7);
			}
			iconFileName = iconFileName.replaceAll("\\W", " ").trim().replace(" ", "_").concat(".ico");
			String iconPath = JReader.getConfig().getShortcutIconsDir() + File.separator + iconFileName;
			OutputStream outIcon = new FileOutputStream(iconPath);
			InputStream inIcon = new URL(iconURL).openStream();
			int len;
			byte[] buf = new byte[1024];
			while ((len = inIcon.read(buf)) > 0) {
				outIcon.write(buf, 0, len);
			}
			inIcon.close();
			outIcon.close();
			channel.setIconPath(iconPath);
		} catch (Exception e) {
		}
		return channel;
	}

}