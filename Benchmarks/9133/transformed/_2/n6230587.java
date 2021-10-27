class n6230587 {
	public void saveAs(File f) throws CoverException {
		FileOutputStream fw = null;
		BufferedInputStream in = null;
		try {
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setDoInput(true);
			in = new BufferedInputStream(httpConn.getInputStream());
			f.delete();
			fw = new FileOutputStream(f);
			int b;
			for (; (b = in.read()) != -1;)
				fw.write(b);
			fw.close();
			in.close();
		} catch (IOException e) {
			throw new CoverException(e.getMessage());
		} finally {
			try {
				if (fw != null)
					fw.close();
				if (in != null)
					in.close();
			} catch (IOException ex) {
				System.err.println("Glurps this is severe: " + ex.getMessage());
			}
		}
	}

}