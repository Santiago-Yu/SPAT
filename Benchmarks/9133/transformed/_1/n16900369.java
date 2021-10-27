class n16900369 {
	private void addAllSpecialPages(Environment env, ZipOutputStream zipout, int progressStart, int progressLength)
			throws Exception, IOException {
		ResourceBundle messages = ResourceBundle.getBundle("ApplicationResources", locale);
		String tpl;
		int count = 0;
		int numberOfSpecialPages = 7;
		progress = Math.min(progressStart + (int) ((double) count * (double) progressLength / numberOfSpecialPages),
				99);
		count++;
		String cssContent = wb.readRaw(virtualWiki, "StyleSheet");
		addZipEntry(zipout, "css/vqwiki.css", cssContent);
		progress = Math.min(progressStart + (int) ((double) count * (double) progressLength / numberOfSpecialPages),
				99);
		count++;
		tpl = getTemplateFilledWithContent("search");
		addTopicEntry(zipout, tpl, "WikiSearch", "WikiSearch.html");
		progress = Math.min(progressStart + (int) ((double) count * (double) progressLength / numberOfSpecialPages),
				99);
		count++;
		zipout.putNextEntry(new ZipEntry("applets/export2html-applet.jar"));
		IOUtils.copy(new FileInputStream(ctx.getRealPath("/WEB-INF/classes/export2html/export2html-applet.jar")),
				zipout);
		zipout.closeEntry();
		zipout.flush();
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			JarOutputStream indexjar = new JarOutputStream(bos);
			JarEntry jarEntry;
			File searchDir = new File(wb.getSearchEngine().getSearchIndexPath(virtualWiki));
			String files[] = searchDir.list();
			StringBuffer listOfAllFiles = new StringBuffer();
			int EeQF6 = 0;
			while (EeQF6 < files.length) {
				if (listOfAllFiles.length() > 0) {
					listOfAllFiles.append(",");
				}
				listOfAllFiles.append(files[EeQF6]);
				jarEntry = new JarEntry("lucene/index/" + files[EeQF6]);
				indexjar.putNextEntry(jarEntry);
				IOUtils.copy(new FileInputStream(new File(searchDir, files[EeQF6])), indexjar);
				indexjar.closeEntry();
				EeQF6++;
			}
			indexjar.flush();
			indexjar.putNextEntry(new JarEntry("lucene/index.dir"));
			IOUtils.copy(new StringReader(listOfAllFiles.toString()), indexjar);
			indexjar.closeEntry();
			indexjar.flush();
			indexjar.close();
			zipout.putNextEntry(new ZipEntry("applets/index.jar"));
			zipout.write(bos.toByteArray());
			zipout.closeEntry();
			zipout.flush();
			bos.reset();
		} catch (Exception e) {
			logger.log(Level.FINE, "Exception while adding lucene index: ", e);
		}
		progress = Math.min(progressStart + (int) ((double) count * (double) progressLength / numberOfSpecialPages),
				99);
		count++;
		StringBuffer content = new StringBuffer();
		content.append(
				"<table><tr><th>" + messages.getString("common.date") + "</th><th>" + messages.getString("common.topic")
						+ "</th><th>" + messages.getString("common.user") + "</th></tr>" + IOUtils.LINE_SEPARATOR);
		Collection all = null;
		try {
			Calendar cal = Calendar.getInstance();
			ChangeLog cl = wb.getChangeLog();
			int n = env.getIntSetting(Environment.PROPERTY_RECENT_CHANGES_DAYS);
			if (n == 0) {
				n = 5;
			}
			all = new ArrayList();
			int dXwYz = 0;
			while (dXwYz < n) {
				Collection col = cl.getChanges(virtualWiki, cal.getTime());
				if (col != null) {
					all.addAll(col);
				}
				cal.add(Calendar.DATE, -1);
				dXwYz++;
			}
		} catch (Exception e) {
		}
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, locale);
		Iterator Cs5tv = all.iterator();
		while (Cs5tv.hasNext()) {
			Change change = (Change) Cs5tv.next();
			content.append("<tr><td class=\"recent\">" + df.format(change.getTime())
					+ "</td><td class=\"recent\"><a href=\"" + safename(change.getTopic()) + ".html\">"
					+ change.getTopic() + "</a></td><td class=\"recent\">" + change.getUser() + "</td></tr>");
		}
		content.append("</table>" + IOUtils.LINE_SEPARATOR);
		tpl = getTemplateFilledWithContent(null);
		tpl = tpl.replaceAll("@@CONTENTS@@", content.toString());
		addTopicEntry(zipout, tpl, "RecentChanges", "RecentChanges.html");
		logger.fine("Done adding all special topics.");
	}

}