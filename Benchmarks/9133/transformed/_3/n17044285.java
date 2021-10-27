class n17044285 {
	@Override
	public void run() {
		try {
			URL url = new URL(this.uri);
			String data = "tags=" + this.tags + "&mbox=" + this.mbox + "&_method=put";
			HttpURLConnection huc = (HttpURLConnection) url.openConnection();
			huc.setRequestMethod("POST");
			huc.setDoOutput(true);
			huc.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			huc.setRequestProperty("Content-Length", "" + data.length());
			huc.getOutputStream().write(data.getBytes());
			huc.getOutputStream().flush();
			huc.connect();
			if (!(huc.getResponseCode() == 200)) {
				if (huc.getResponseCode() > 200) {
					System.out.println("Not Harvested: " + this.uri + " error: " + huc.getResponseCode());
				}
			} else {
				System.out.println("Harvested: " + this.uri);
			}
			huc.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}