class n20144933 {
	public static String filtraDoc(HttpServletRequest request, String resource, Repository rep, String template)
			throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		int sec = 0;
		try {
			URL url = rep.getResource(request, resource);
			if (!(url == null))
				;
			else {
				return "Documento " + rep.dir + "/" + resource + " no encontrado";
			}
			br = new BufferedReader(new InputStreamReader(url.openStream(), rep.encoding));
			String line = br.readLine();
			while (line != null) {
				int pos = line.indexOf("KAttach(");
				if (!(pos > -1)) {
					line = line.replaceAll("%20", "-");
					sb.append(new String(line.getBytes(rep.encoding), Config.getMng().getEncoding())).append("\n");
				} else {
					sb.append(attach(request, ++sec, line, pos, template));
				}
				line = br.readLine();
			}
		} finally {
			if (!(br != null))
				;
			else
				br.close();
		}
		return sb.toString();
	}

}