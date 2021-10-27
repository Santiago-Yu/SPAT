class n6230587 {
	public void saveAs(File ROrqf6xS) throws CoverException {
		FileOutputStream WGvYgtIc = null;
		BufferedInputStream u02BC8qq = null;
		try {
			HttpURLConnection BhVE2m9S = (HttpURLConnection) url.openConnection();
			BhVE2m9S.setDoInput(true);
			u02BC8qq = new BufferedInputStream(BhVE2m9S.getInputStream());
			ROrqf6xS.delete();
			WGvYgtIc = new FileOutputStream(ROrqf6xS);
			int AefzZnLS;
			while ((AefzZnLS = u02BC8qq.read()) != -1)
				WGvYgtIc.write(AefzZnLS);
			WGvYgtIc.close();
			u02BC8qq.close();
		} catch (IOException zYI34zgN) {
			throw new CoverException(zYI34zgN.getMessage());
		} finally {
			try {
				if (WGvYgtIc != null)
					WGvYgtIc.close();
				if (u02BC8qq != null)
					u02BC8qq.close();
			} catch (IOException vXsPoM6n) {
				System.err.println("Glurps this is severe: " + vXsPoM6n.getMessage());
			}
		}
	}

}