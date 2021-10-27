class n16900369 {
	private void addAllSpecialPages(Environment DU1YySy0, ZipOutputStream p6gHScY2, int vMrRwLCc, int hFG7INdO)
			throws Exception, IOException {
		ResourceBundle SMvW4fVF = ResourceBundle.getBundle("ApplicationResources", locale);
		String nQ6dQf9c;
		int CGoiXBL4 = 0;
		int BrTBCmFb = 7;
		progress = Math.min(vMrRwLCc + (int) ((double) CGoiXBL4 * (double) hFG7INdO / BrTBCmFb), 99);
		CGoiXBL4++;
		String faW8Gqb9 = wb.readRaw(virtualWiki, "StyleSheet");
		addZipEntry(p6gHScY2, "css/vqwiki.css", faW8Gqb9);
		progress = Math.min(vMrRwLCc + (int) ((double) CGoiXBL4 * (double) hFG7INdO / BrTBCmFb), 99);
		CGoiXBL4++;
		nQ6dQf9c = getTemplateFilledWithContent("search");
		addTopicEntry(p6gHScY2, nQ6dQf9c, "WikiSearch", "WikiSearch.html");
		progress = Math.min(vMrRwLCc + (int) ((double) CGoiXBL4 * (double) hFG7INdO / BrTBCmFb), 99);
		CGoiXBL4++;
		p6gHScY2.putNextEntry(new ZipEntry("applets/export2html-applet.jar"));
		IOUtils.copy(new FileInputStream(ctx.getRealPath("/WEB-INF/classes/export2html/export2html-applet.jar")),
				p6gHScY2);
		p6gHScY2.closeEntry();
		p6gHScY2.flush();
		try {
			ByteArrayOutputStream PRtsHUbt = new ByteArrayOutputStream();
			JarOutputStream I22neVqz = new JarOutputStream(PRtsHUbt);
			JarEntry CPYiet0B;
			File w0de8bAc = new File(wb.getSearchEngine().getSearchIndexPath(virtualWiki));
			String dLaVgs6N[] = w0de8bAc.list();
			StringBuffer PxnSRorh = new StringBuffer();
			for (int wrt28Hob = 0; wrt28Hob < dLaVgs6N.length; wrt28Hob++) {
				if (PxnSRorh.length() > 0) {
					PxnSRorh.append(",");
				}
				PxnSRorh.append(dLaVgs6N[wrt28Hob]);
				CPYiet0B = new JarEntry("lucene/index/" + dLaVgs6N[wrt28Hob]);
				I22neVqz.putNextEntry(CPYiet0B);
				IOUtils.copy(new FileInputStream(new File(w0de8bAc, dLaVgs6N[wrt28Hob])), I22neVqz);
				I22neVqz.closeEntry();
			}
			I22neVqz.flush();
			I22neVqz.putNextEntry(new JarEntry("lucene/index.dir"));
			IOUtils.copy(new StringReader(PxnSRorh.toString()), I22neVqz);
			I22neVqz.closeEntry();
			I22neVqz.flush();
			I22neVqz.close();
			p6gHScY2.putNextEntry(new ZipEntry("applets/index.jar"));
			p6gHScY2.write(PRtsHUbt.toByteArray());
			p6gHScY2.closeEntry();
			p6gHScY2.flush();
			PRtsHUbt.reset();
		} catch (Exception efPlL335) {
			logger.log(Level.FINE, "Exception while adding lucene index: ", efPlL335);
		}
		progress = Math.min(vMrRwLCc + (int) ((double) CGoiXBL4 * (double) hFG7INdO / BrTBCmFb), 99);
		CGoiXBL4++;
		StringBuffer U10VWpKY = new StringBuffer();
		U10VWpKY.append(
				"<table><tr><th>" + SMvW4fVF.getString("common.date") + "</th><th>" + SMvW4fVF.getString("common.topic")
						+ "</th><th>" + SMvW4fVF.getString("common.user") + "</th></tr>" + IOUtils.LINE_SEPARATOR);
		Collection fEcJY88e = null;
		try {
			Calendar X8GapnCI = Calendar.getInstance();
			ChangeLog vERJdZPV = wb.getChangeLog();
			int abDbadbC = DU1YySy0.getIntSetting(Environment.PROPERTY_RECENT_CHANGES_DAYS);
			if (abDbadbC == 0) {
				abDbadbC = 5;
			}
			fEcJY88e = new ArrayList();
			for (int g2EQ57RC = 0; g2EQ57RC < abDbadbC; g2EQ57RC++) {
				Collection slxUWYbd = vERJdZPV.getChanges(virtualWiki, X8GapnCI.getTime());
				if (slxUWYbd != null) {
					fEcJY88e.addAll(slxUWYbd);
				}
				X8GapnCI.add(Calendar.DATE, -1);
			}
		} catch (Exception vD5IRPzJ) {
		}
		DateFormat nBAgVYK2 = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, locale);
		for (Iterator K9HBzzCe = fEcJY88e.iterator(); K9HBzzCe.hasNext();) {
			Change HxgnIli4 = (Change) K9HBzzCe.next();
			U10VWpKY.append("<tr><td class=\"recent\">" + nBAgVYK2.format(HxgnIli4.getTime())
					+ "</td><td class=\"recent\"><a href=\"" + safename(HxgnIli4.getTopic()) + ".html\">"
					+ HxgnIli4.getTopic() + "</a></td><td class=\"recent\">" + HxgnIli4.getUser() + "</td></tr>");
		}
		U10VWpKY.append("</table>" + IOUtils.LINE_SEPARATOR);
		nQ6dQf9c = getTemplateFilledWithContent(null);
		nQ6dQf9c = nQ6dQf9c.replaceAll("@@CONTENTS@@", U10VWpKY.toString());
		addTopicEntry(p6gHScY2, nQ6dQf9c, "RecentChanges", "RecentChanges.html");
		logger.fine("Done adding all special topics.");
	}

}