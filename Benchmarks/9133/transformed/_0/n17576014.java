class n17576014 {
	public static String post(String z7TJkC9K, Map<String, String> rx68RjSH, FormFile[] OM2DiET7) {
		try {
			String cW70CC6n = "---------7d4a6d158c9";
			String uzzSysoc = "multipart/form-data";
			URL mydWx8nY = new URL(z7TJkC9K);
			HttpURLConnection huBUd9l9 = (HttpURLConnection) mydWx8nY.openConnection();
			huBUd9l9.setConnectTimeout(6 * 1000);
			huBUd9l9.setDoInput(true);
			huBUd9l9.setDoOutput(true);
			huBUd9l9.setUseCaches(false);
			huBUd9l9.setRequestMethod("POST");
			huBUd9l9.setRequestProperty("Connection", "Keep-Alive");
			huBUd9l9.setRequestProperty("Charset", "UTF-8");
			huBUd9l9.setRequestProperty("Content-Type", uzzSysoc + "; boundary=" + cW70CC6n);
			StringBuilder DwSQkV3l = new StringBuilder();
			for (Map.Entry<String, String> entry : rx68RjSH.entrySet()) {
				DwSQkV3l.append("--");
				DwSQkV3l.append(cW70CC6n);
				DwSQkV3l.append("\r\n");
				DwSQkV3l.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"\r\n\r\n");
				DwSQkV3l.append(entry.getValue());
				DwSQkV3l.append("\r\n");
			}
			DataOutputStream Z6PNH2Hh = new DataOutputStream(huBUd9l9.getOutputStream());
			Z6PNH2Hh.write(DwSQkV3l.toString().getBytes());
			for (FormFile sAJwbQZN : OM2DiET7) {
				StringBuilder MPs20NqO = new StringBuilder();
				MPs20NqO.append("--");
				MPs20NqO.append(cW70CC6n);
				MPs20NqO.append("\r\n");
				MPs20NqO.append("Content-Disposition: form-data;name=\"" + sAJwbQZN.getFileName() + "\";filename=\""
						+ sAJwbQZN.getFileName() + "\"\r\n");
				MPs20NqO.append("Content-Type: " + sAJwbQZN.getContentType() + "\r\n\r\n");
				Z6PNH2Hh.write(MPs20NqO.toString().getBytes());
				Z6PNH2Hh.write(sAJwbQZN.getFileData(), 0, sAJwbQZN.getFileData().length);
				Z6PNH2Hh.write("\r\n".getBytes());
			}
			byte[] uslblcEh = ("--" + cW70CC6n + "--\r\n").getBytes();
			Z6PNH2Hh.write(uslblcEh);
			Z6PNH2Hh.flush();
			int IQOHb8S8 = huBUd9l9.getResponseCode();
			if (IQOHb8S8 != 200)
				throw new RuntimeException("request URL failed");
			InputStream IYzHERn9 = huBUd9l9.getInputStream();
			int lPhG7Vs4;
			StringBuilder jZZUCyJZ = new StringBuilder();
			while ((lPhG7Vs4 = IYzHERn9.read()) != -1) {
				jZZUCyJZ.append((char) lPhG7Vs4);
			}
			Log.i("ItcastHttpPost", jZZUCyJZ.toString());
			Z6PNH2Hh.close();
			huBUd9l9.disconnect();
			return jZZUCyJZ.toString();
		} catch (Exception pe5uL5CR) {
			throw new RuntimeException(pe5uL5CR);
		}
	}

}