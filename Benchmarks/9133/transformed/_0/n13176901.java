class n13176901 {
	public boolean refresh() {
		try {
			synchronized (text) {
				stream = (new URL(url)).openStream();
				BufferedReader TueoUGqH = new BufferedReader(new InputStreamReader(stream));
				String lDp0pRxR;
				StringBuilder tRS3Ym0o = new StringBuilder();
				while ((lDp0pRxR = TueoUGqH.readLine()) != null) {
					tRS3Ym0o.append(lDp0pRxR);
					tRS3Ym0o.append("\n");
				}
				text = tRS3Ym0o.toString();
			}
			price = 0;
			date = null;
		} catch (MalformedURLException IFcm8LpO) {
			IFcm8LpO.printStackTrace();
		} catch (IOException a5GpzsTY) {
			a5GpzsTY.printStackTrace();
			return false;
		} finally {
			if (stream != null)
				try {
					stream.close();
				} catch (IOException nCRwMwsF) {
					nCRwMwsF.printStackTrace();
				}
		}
		return true;
	}

}