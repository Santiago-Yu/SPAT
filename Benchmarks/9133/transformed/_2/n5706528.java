class n5706528 {
	public void run() {
		try {
			URL url = new URL(myListURL);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = null;
			Pattern folderPattern = Pattern.compile(".*DIR.*<a href=.(.*)/.>(.*)</a>.*");
			Pattern folderPatternCloudmake = Pattern
					.compile(".*<li><a href=./(.*)#breadcrumbs. class=.folder.>(.*)</a></li>.*");
			Pattern filePatternCloudmake = Pattern.compile(
					".*<a href=.(.*).bz2. class=.default.>(.*).osm(.*).bz2</a>&nbsp;<span class=\"file-size\">(.*)</span>.*");
			for (; (line = reader.readLine()) != null;) {
				Matcher matcher = folderPattern.matcher(line);
				if (matcher.matches()) {
					String dirUrl = myListURL + matcher.group(1) + "/";
					String name = matcher.group(2);
					if (name.equalsIgnoreCase("Parent Directory")) {
						continue;
					}
					DownloadMenu.this
							.add(new DownloadMenu(DownloadMenu.this.myMainFrame, dirUrl, name, myLoadChildren));
					continue;
				}
				matcher = folderPatternCloudmake.matcher(line);
				if (matcher.matches()) {
					String dirUrl = myListURL.substring(0, myListURL.indexOf(".com/") + ".com/".length())
							+ matcher.group(1);
					String name = matcher.group(2);
					DownloadMenu.this
							.add(new DownloadMenu(DownloadMenu.this.myMainFrame, dirUrl, name, myLoadChildren));
					continue;
				}
				matcher = filePatternCloudmake.matcher(line);
				if (matcher.matches()) {
					String fileUrl = myListURL.substring(0, myListURL.indexOf(".com") + ".com".length())
							+ matcher.group(1) + ".bz2";
					final int typeAt = 3;
					final int nameAt = 2;
					String type = matcher.group(typeAt);
					String name = matcher.group(nameAt);
					if (type.length() > 0) {
						if (type.startsWith(".")) {
							type = type.substring(1);
						}
						name += "-" + type;
					}
					JMenuItem subMenu = new JMenuItem(name);
					subMenu.addActionListener(new DownloadActionListener(fileUrl, name));
					subMenu.putClientProperty("URL", fileUrl);
					add(subMenu);
					continue;
				}
				int index = line.indexOf("<a href=\"");
				if (index < 0) {
					continue;
				}
				index += "<a href=\"".length();
				int index2 = line.indexOf("</a");
				if (index2 < 0) {
					continue;
				}
				int index1 = line.indexOf(".osm.bz2\">");
				if (index1 < 0) {
					continue;
				}
				index1 += ".osm.bz2".length();
				String fileUrl = line.substring(index, index1);
				if (!fileUrl.contains(".osm"))
					continue;
				if (!fileUrl.startsWith("http"))
					fileUrl = myListURL + fileUrl;
				index1 += "\">".length();
				String fileName = line.substring(index1, index2);
				JMenuItem subMenu = new JMenuItem(fileName);
				subMenu.addActionListener(new DownloadActionListener(fileUrl, fileName));
				subMenu.putClientProperty("URL", fileUrl);
				add(subMenu);
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "[Exception] Problem in " + getClass().getName(), e);
		}
		LOG.info("Done with async download of list of downloadable maps for " + getText() + "...");
		remove(isLoadingMenuItem);
		if (myTreeNode != null) {
			myTreeNode.doneLoading();
		}
	}

}