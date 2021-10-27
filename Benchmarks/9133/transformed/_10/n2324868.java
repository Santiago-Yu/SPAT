class n2324868 {
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			BufferedReader r = new BufferedReader(
					new InputStreamReader(new GZIPInputStream(new FileInputStream("/home/lindenb/jeter.txt.gz"))));
			Pattern delim = Pattern.compile("[ ]");
			URL url = new URL("http://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi");
			String line = null;
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write("db=snp&retmode=xml");
			while ((line = r.readLine()) != null) {
				String tokens[] = delim.split(line, 2);
				if (!tokens[0].startsWith("rs"))
					continue;
				wr.write("&id=" + tokens[0].substring(2).trim());
			}
			wr.flush();
			r.close();
			InputStream in = conn.getInputStream();
			IOUtils.copyTo(in, System.err);
			in.close();
			wr.close();
		} catch (IOException err) {
			err.printStackTrace();
		}
	}

}