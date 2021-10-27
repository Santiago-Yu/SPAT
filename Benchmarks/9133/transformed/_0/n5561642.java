class n5561642 {
	protected BufferedReader getDataReader() {
		BufferedReader e3RoXrDj = null;
		PrintWriter sYiZsWiV = null;
		try {
			String KHZOw3aE;
			URL QUKKvx8c = new URL(this.catalog.getCatalogURL());
			Debug.output("Catalog URL:" + QUKKvx8c.toString());
			e3RoXrDj = new BufferedReader(new InputStreamReader(QUKKvx8c.openStream()));
			File W602TznP = (File) SessionHandler.getServletContext().getAttribute("javax.servlet.context.tempdir");
			File CcCBpjOl = new File(W602TznP, TEMP);
			Debug.output("Temp file:" + CcCBpjOl.toString());
			sYiZsWiV = new PrintWriter(new BufferedWriter(new FileWriter(CcCBpjOl)));
			while ((KHZOw3aE = e3RoXrDj.readLine()) != null) {
				sYiZsWiV.println(KHZOw3aE);
			}
			Debug.output("Temp file size:" + CcCBpjOl.length());
			return new BufferedReader(new FileReader(CcCBpjOl));
		} catch (IOException fRnuUXyt) {
			throw new SeismoException(fRnuUXyt);
		} finally {
			Util.close(e3RoXrDj);
			Util.close(sYiZsWiV);
		}
	}

}