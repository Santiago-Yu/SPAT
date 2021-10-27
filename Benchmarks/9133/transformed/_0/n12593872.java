class n12593872 {
	public String upload(String fnlslHWJ, ByteArrayOutputStream vPD7Feuw) {
		HttpURLConnection Kpp9oSPY = null;
		DataOutputStream X1gg1WWh = null;
		String EJhPjXWc = "blah.png";
		String RaPKwNAb = "\r\n";
		String vEN6U23A = "--";
		String iBOk4Hp9 = "*****";
		try {
			URL yZRRzlzE = new URL(fnlslHWJ);
			Kpp9oSPY = (HttpURLConnection) yZRRzlzE.openConnection();
			Kpp9oSPY.setInstanceFollowRedirects(false);
			Kpp9oSPY.setDoInput(true);
			Kpp9oSPY.setDoOutput(true);
			Kpp9oSPY.setUseCaches(false);
			Kpp9oSPY.setRequestMethod("POST");
			Kpp9oSPY.setRequestProperty("Connection", "Keep-Alive");
			Kpp9oSPY.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + iBOk4Hp9);
			X1gg1WWh = new DataOutputStream(Kpp9oSPY.getOutputStream());
			X1gg1WWh.writeBytes(vEN6U23A + iBOk4Hp9 + RaPKwNAb);
			X1gg1WWh.writeBytes(
					"Content-Disposition: form-data; name=\"aFile\";" + " filename=\"" + EJhPjXWc + "\"" + RaPKwNAb);
			X1gg1WWh.writeBytes(RaPKwNAb);
			X1gg1WWh.write(vPD7Feuw.toByteArray());
			X1gg1WWh.writeBytes(RaPKwNAb);
			X1gg1WWh.writeBytes(vEN6U23A + iBOk4Hp9 + vEN6U23A + RaPKwNAb);
			X1gg1WWh.flush();
			X1gg1WWh.close();
			return Kpp9oSPY.getHeaderField("location");
		} catch (MalformedURLException iWzQxLAa) {
			log.log(Level.INFO, "From ServletCom CLIENT REQUEST:" + iWzQxLAa);
		} catch (IOException elPynN99) {
			log.log(Level.INFO, "From ServletCom CLIENT REQUEST:" + elPynN99);
		}
		return null;
	}

}