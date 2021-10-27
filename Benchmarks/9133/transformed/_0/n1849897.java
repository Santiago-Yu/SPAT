class n1849897 {
	public String parseInOneLine() throws Exception {
		BufferedReader bAho9R10 = null;
		InputStream bRcs9iwi = null;
		if (url.startsWith("http")) {
			URL F507Lxgr = new URL(url);
			URLConnection cY46FqcV = F507Lxgr.openConnection();
			bRcs9iwi = cY46FqcV.getInputStream();
			bAho9R10 = new BufferedReader(new InputStreamReader(bRcs9iwi, "ISO-8859-1"));
		} else {
			bAho9R10 = new BufferedReader(new FileReader(url));
		}
		StringBuffer szQocN21 = new StringBuffer();
		StringBuffer lDG6Uedi = new StringBuffer();
		String fUwyhmpR = null;
		boolean zLXgXa1u = false;
		while ((fUwyhmpR = bAho9R10.readLine()) != null) {
			log.debug(fUwyhmpR);
			lDG6Uedi.append(fUwyhmpR + " ");
			if (fUwyhmpR.indexOf("<table") != -1) {
				zLXgXa1u = true;
			}
			if (zLXgXa1u) {
				szQocN21.append(fUwyhmpR + " ");
			}
			if (fUwyhmpR.indexOf("</table") != -1
					|| fUwyhmpR.indexOf("</tr></font><center><a href='affichaire.php") != -1
					|| fUwyhmpR.indexOf("</font><center><a href='afficheregion.php") != -1) {
				zLXgXa1u = false;
				break;
			}
		}
		oneLine = szQocN21.toString();
		allDocInOneLine = lDG6Uedi.toString();
		if (oneLine.indexOf("</table") != -1) {
			tableTab = new TableTag(oneLine.substring(oneLine.indexOf(">") + 1, oneLine.indexOf("</table")));
		} else if (oneLine.indexOf("</font><center><a href='affichaire") != -1) {
			tableTab = new TableTag(
					oneLine.substring(oneLine.indexOf(">") + 1, oneLine.indexOf("</font><center><a href='affichaire")));
		} else if (oneLine.indexOf("</font><center><a href='afficheregion.php") != -1) {
			tableTab = new TableTag(oneLine.substring(oneLine.indexOf(">") + 1,
					oneLine.indexOf("</font><center><a href='afficheregion.php")));
		} else {
			log.error("La fin du fichier HTML n'a pas ete trouvee, ca va merder...");
		}
		bAho9R10.close();
		if (bRcs9iwi != null) {
			bRcs9iwi.close();
		}
		return allDocInOneLine;
	}

}