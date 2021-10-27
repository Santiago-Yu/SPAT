class n19090289 {
	public static Channel getChannelFromSite(String siteURL)
			throws LinkNotFoundException, MalformedURLException, SAXException, IOException {
		String channelURL = "";
		siteURL = siteURL.trim();
		siteURL = (!siteURL.startsWith("http://")) ? "http://" + siteURL : siteURL;
		URL url = new URL(siteURL);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String[] lines = new String[3];
		for (int i = 0; i < lines.length; i++) {
			if ((lines[i] = in.readLine()) == null) {
				lines[i] = "";
				break;
			}
		}
		if (lines[0].contains("xml version")) {
			channelURL = (lines[0].contains("rss") || lines[1].contains("rss")) ? siteURL : channelURL;
			channelURL = (lines[0].contains("Atom") || lines[1].contains("Atom") || lines[2].contains("Atom")) ? siteURL
					: channelURL;
		}
		in.close();
		in = new BufferedReader(new InputStreamReader(url.openStream()));
		String iconURL = null;
		String inputLine;
		if ("".equals(channelURL)) {
			boolean isIconURLFound = false;
			boolean isChannelURLFound = false;
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
					isIconURLFound = true;
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
					if (isChannelURLFound && isIconURLFound) {
						break;
					}
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
					if (channelURL.charAt(0) == '/') {
						channelURL = (siteURL.charAt(siteURL.length() - 1) == '/') ? siteURL + channelURL.substring(1)
								: siteURL + channelURL;
					} else if (!channelURL.startsWith("http://")) {
						channelURL = (siteURL.charAt(siteURL.length() - 1) == '/') ? siteURL + channelURL
								: siteURL + "/" + channelURL;
					}
					isChannelURLFound = true;
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
			iconURL = "favicon.ico";
			siteURL = (siteURL.equalsIgnoreCase(channel.getChannelURL())) ? channel.getLink() : siteURL;
			siteURL = getHome(siteURL);
			iconURL = (siteURL.charAt(siteURL.length() - 1) == '/') ? siteURL + iconURL : siteURL + "/" + iconURL;
		}
		try {
			String iconFileName = getHome(channel.getLink());
			iconFileName = (iconFileName.startsWith("http://")) ? iconFileName.substring(7) : iconFileName;
			iconFileName = iconFileName.replaceAll("\\W", " ").trim().replace(" ", "_").concat(".ico");
			String iconPath = JReader.getConfig().getShortcutIconsDir() + File.separator + iconFileName;
			InputStream inIcon = new URL(iconURL).openStream();
			OutputStream outIcon = new FileOutputStream(iconPath);
			byte[] buf = new byte[1024];
			int len;
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