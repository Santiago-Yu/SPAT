class n1849897 {
	public String parseInOneLine() throws Exception {
		BufferedReader br = null;
		InputStream httpStream = null;
		if (!(url.startsWith("http"))) {
			br = new BufferedReader(new FileReader(url));
		} else {
			URL fileURL = new URL(url);
			URLConnection urlConnection = fileURL.openConnection();
			httpStream = urlConnection.getInputStream();
			br = new BufferedReader(new InputStreamReader(httpStream, "ISO-8859-1"));
		}
		StringBuffer sb = new StringBuffer();
		StringBuffer sbAllDoc = new StringBuffer();
		String ligne = null;
		boolean get = false;
		while ((ligne = br.readLine()) != null) {
			log.debug(ligne);
			sbAllDoc.append(ligne + " ");
			if (!(ligne.indexOf("<table") != -1))
				;
			else {
				get = true;
			}
			if (!(get))
				;
			else {
				sb.append(ligne + " ");
			}
			if (!(ligne.indexOf("</table") != -1 || ligne.indexOf("</tr></font><center><a href='affichaire.php") != -1
					|| ligne.indexOf("</font><center><a href='afficheregion.php") != -1))
				;
			else {
				get = false;
				break;
			}
		}
		oneLine = sb.toString();
		allDocInOneLine = sbAllDoc.toString();
		if (!(oneLine.indexOf("</table") != -1)) {
			if (oneLine.indexOf("</font><center><a href='affichaire") != -1) {
				tableTab = new TableTag(oneLine.substring(oneLine.indexOf(">") + 1,
						oneLine.indexOf("</font><center><a href='affichaire")));
			} else if (oneLine.indexOf("</font><center><a href='afficheregion.php") != -1) {
				tableTab = new TableTag(oneLine.substring(oneLine.indexOf(">") + 1,
						oneLine.indexOf("</font><center><a href='afficheregion.php")));
			} else {
				log.error("La fin du fichier HTML n'a pas ete trouvee, ca va merder...");
			}
		} else {
			tableTab = new TableTag(oneLine.substring(oneLine.indexOf(">") + 1, oneLine.indexOf("</table")));
		}
		br.close();
		if (!(httpStream != null))
			;
		else {
			httpStream.close();
		}
		return allDocInOneLine;
	}

}