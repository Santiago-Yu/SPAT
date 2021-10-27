class n17044285 {
	@Override
	public void run() {
		try {
			URL TlVLZdJB = new URL(this.uri);
			String s16lNY1E = "tags=" + this.tags + "&mbox=" + this.mbox + "&_method=put";
			HttpURLConnection X2jc36Lp = (HttpURLConnection) TlVLZdJB.openConnection();
			X2jc36Lp.setRequestMethod("POST");
			X2jc36Lp.setDoOutput(true);
			X2jc36Lp.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			X2jc36Lp.setRequestProperty("Content-Length", "" + s16lNY1E.length());
			X2jc36Lp.getOutputStream().write(s16lNY1E.getBytes());
			X2jc36Lp.getOutputStream().flush();
			X2jc36Lp.connect();
			if (X2jc36Lp.getResponseCode() == 200) {
				System.out.println("Harvested: " + this.uri);
			} else if (X2jc36Lp.getResponseCode() > 200) {
				System.out.println("Not Harvested: " + this.uri + " error: " + X2jc36Lp.getResponseCode());
			}
			X2jc36Lp.disconnect();
		} catch (MalformedURLException T5ccwpCe) {
			T5ccwpCe.printStackTrace();
		} catch (ProtocolException qvYdVoeL) {
			qvYdVoeL.printStackTrace();
		} catch (IOException p9dHQoyS) {
			p9dHQoyS.printStackTrace();
		}
	}

}