class n17001260 {
	public static void getGPX(String ikUsYZIR, String nbEyn0AI) {
		try {
			URL Qm9VzZ2G = new URL(ikUsYZIR);
			HttpURLConnection NGhjD2tJ = (HttpURLConnection) Qm9VzZ2G.openConnection();
			NGhjD2tJ.setRequestMethod("GET");
			NGhjD2tJ.setDoOutput(true);
			NGhjD2tJ.connect();
			File AAK7EkFu = mContext.getExternalFilesDir(null);
			File sxVPfIBp = new File(AAK7EkFu, nbEyn0AI);
			FileOutputStream NStDI4AJ = new FileOutputStream(sxVPfIBp);
			InputStream vDJzI0sT = NGhjD2tJ.getInputStream();
			byte[] WlWVOU97 = new byte[1024];
			int oK7lqBee = 0;
			while ((oK7lqBee = vDJzI0sT.read(WlWVOU97)) > 0) {
				NStDI4AJ.write(WlWVOU97, 0, oK7lqBee);
			}
			NStDI4AJ.close();
		} catch (MalformedURLException KsN2OtOj) {
			KsN2OtOj.printStackTrace();
		} catch (IOException VelYlKPw) {
			VelYlKPw.printStackTrace();
		}
	}

}