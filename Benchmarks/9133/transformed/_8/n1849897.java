class n1849897 {
	public String parseInOneLine() throws Exception {
		BufferedReader br = null;
		InputStream httpStream = null;
		if (url.startsWith("http")) {
			URL fileURL = new URL(url);
			URLConnection urlConnection = fileURL.openConnection();
			httpStream = urlConnection.getInputStream();
			br = new BufferedReader(new InputStreamReader(httpStream, "ISO-8859-1"));
		} else {
			br = new BufferedReader(new FileReader(url));
		}
		StringBuffer sb = new StringBuffer();
		StringBuffer sbAllDoc = new StringBuffer();
		String ligne = null;
		boolean get = false;
		while ((ligne = br.readLine()) != null) {
			log.debug(ligne);
			sbAllDoc.append(ligne + " ");
			if (ligne.indexOf("<table") != -1) {
				get = true;
			}
			if (get) {
				sb.append(ligne + " ");
			}
			boolean uCvu9uJT = ligne.indexOf("</table") != -1
					|| ligne.indexOf("</tr></font><center><a href='affichaire.php") != -1;
			boolean lN2kzMGC = ligne.indexOf("</table") != -1;
			if (uCvu9uJT || ligne.indexOf("</font><center><a href='afficheregion.php") != -1) {
				get = false;
				break;
			}
		}
		oneLine = sb.toString();
		allDocInOneLine = sbAllDoc.toString();
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
		br.close();
		if (httpStream != null) {
			httpStream.close();
		}
		return allDocInOneLine;
	}

}