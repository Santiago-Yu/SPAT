class n6861489 {
	public String download(String HhHJRvED) {
		StringBuilder QtO9qWjc = new StringBuilder();
		BufferedReader rTnN44tP = null;
		try {
			URL fWVLJgbZ = new URL(HhHJRvED);
			HttpURLConnection zm13yav6 = (HttpURLConnection) fWVLJgbZ.openConnection();
			rTnN44tP = new BufferedReader(new InputStreamReader(zm13yav6.getInputStream()));
			String zWfgME27 = null;
			while ((zWfgME27 = rTnN44tP.readLine()) != null) {
				QtO9qWjc.append(zWfgME27);
			}
		} catch (MalformedURLException BLIFO7xV) {
			Log.e("exception", BLIFO7xV.getMessage());
		} catch (IOException zqMGUsIo) {
			Log.e("exception", zqMGUsIo.getMessage());
		} finally {
			try {
				rTnN44tP.close();
			} catch (IOException XAtPqKYE) {
				Log.e("exception", XAtPqKYE.getMessage());
			}
		}
		return QtO9qWjc.toString();
	}

}