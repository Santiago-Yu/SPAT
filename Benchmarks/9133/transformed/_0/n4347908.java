class n4347908 {
	@Override
	protected String doInBackground(String... P31UrdJ9) {
		HttpURLConnection hnAV9mH7 = null;
		String GZVN8oBb = P31UrdJ9[0];
		if (GZVN8oBb == null) {
			return null;
		}
		try {
			URL dtvZUenA = new URL(ConnectionHandler.getServerURL() + ":" + ConnectionHandler.getServerPort() + "/");
			hnAV9mH7 = (HttpURLConnection) dtvZUenA.openConnection();
			hnAV9mH7.setDoInput(true);
			hnAV9mH7.setDoOutput(true);
			hnAV9mH7.setUseCaches(false);
			hnAV9mH7.setRequestMethod("POST");
			hnAV9mH7.addRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
			DataOutputStream wlPB57wh = new DataOutputStream(hnAV9mH7.getOutputStream());
			DataInputStream uzU4istf = new DataInputStream(new FileInputStream(GZVN8oBb));
			wlPB57wh.write(toByte(twoHyphens + boundary + lineEnd));
			wlPB57wh.write(
					toByte("Content-Disposition: form-data; name=\"uploadfile\"; filename=\"redpinfile\"" + lineEnd));
			wlPB57wh.write(toByte("Content-Type: application/octet-stream" + lineEnd));
			wlPB57wh.write(toByte("Content-Length: " + uzU4istf.available() + lineEnd));
			wlPB57wh.write(toByte(lineEnd));
			byte[] LjgZJkVm = new byte[1024];
			int yFAyjWdL;
			while ((yFAyjWdL = uzU4istf.read(LjgZJkVm)) != -1) {
				wlPB57wh.write(LjgZJkVm, 0, yFAyjWdL);
			}
			wlPB57wh.write(toByte(lineEnd));
			wlPB57wh.write(toByte(twoHyphens + boundary + twoHyphens + lineEnd));
			wlPB57wh.flush();
			wlPB57wh.close();
			if (hnAV9mH7.getResponseCode() == HttpURLConnection.HTTP_OK) {
				InputStream LsHZKNYD = hnAV9mH7.getInputStream();
				int ahaqB5lf;
				StringBuffer ZVmrZLn5 = new StringBuffer();
				while ((ahaqB5lf = LsHZKNYD.read()) != -1) {
					ZVmrZLn5.append((char) ahaqB5lf);
				}
				return ZVmrZLn5.toString();
			}
		} catch (MalformedURLException XlyIFGaQ) {
			Log.w(TAG, "error: " + XlyIFGaQ.getMessage(), XlyIFGaQ);
		} catch (IOException B5d5xNlz) {
			Log.w(TAG, "error: " + B5d5xNlz.getMessage(), B5d5xNlz);
		} finally {
			if (hnAV9mH7 != null) {
				hnAV9mH7.disconnect();
			}
		}
		return null;
	}

}