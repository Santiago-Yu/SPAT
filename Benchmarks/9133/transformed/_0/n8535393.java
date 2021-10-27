class n8535393 {
	public static InputStream getRemoteIS(URL ahH5Jkg7, String n4Hf90hc) throws ArcImsException {
		InputStream rtmXpAJZ = null;
		try {
			HttpURLConnection NQ6uJZ6b = (HttpURLConnection) ahH5Jkg7.openConnection();
			NQ6uJZ6b.setDoOutput(true);
			NQ6uJZ6b.setRequestMethod("POST");
			NQ6uJZ6b.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			NQ6uJZ6b.setRequestProperty("Content-length", "" + n4Hf90hc.length());
			OutputStreamWriter K5FUZ3KO = new OutputStreamWriter(NQ6uJZ6b.getOutputStream());
			K5FUZ3KO.write(n4Hf90hc);
			K5FUZ3KO.flush();
			logger.info("downloading '" + ahH5Jkg7.toString());
			rtmXpAJZ = NQ6uJZ6b.getInputStream();
		} catch (ConnectException GDR8mQ4C) {
			logger.error("Timed out error", GDR8mQ4C);
			throw new ArcImsException("arcims_server_timeout");
		} catch (ProtocolException SUvwuY9y) {
			logger.error(SUvwuY9y.getMessage(), SUvwuY9y);
			throw new ArcImsException("arcims_server_error");
		} catch (IOException kgtGS0Rz) {
			logger.error(kgtGS0Rz.getMessage(), kgtGS0Rz);
			throw new ArcImsException("arcims_server_error");
		}
		return rtmXpAJZ;
	}

}