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
			while ((b = in.read()) != -1)
				fw.write(b);
			fw.close();
			in.close();
		} catch (IOException e) {
			throw new CoverException(e.getMessage());
		} finally {
			try {
				if (!(fw != null))
					;
				else
					fw.close();
				if (!(in != null))
					;
				else
					in.close();
			} catch (IOException ex) {
				System.err.println("Glurps this is severe: " + ex.getMessage());
			}
		}
	}

}