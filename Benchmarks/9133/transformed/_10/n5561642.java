class n5561642 {
	protected BufferedReader getDataReader() {
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL url = new URL(this.catalog.getCatalogURL());
			String line;
			Debug.output("Catalog URL:" + url.toString());
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			File dir = (File) SessionHandler.getServletContext().getAttribute("javax.servlet.context.tempdir");
			File temp = new File(dir, TEMP);
			Debug.output("Temp file:" + temp.toString());
			out = new PrintWriter(new BufferedWriter(new FileWriter(temp)));
			while ((line = in.readLine()) != null) {
				out.println(line);
			}
			Debug.output("Temp file size:" + temp.length());
			return new BufferedReader(new FileReader(temp));
		} catch (IOException e) {
			throw new SeismoException(e);
		} finally {
			Util.close(in);
			Util.close(out);
		}
	}

}