class n1734007 {
	private InputStream getConnection() throws BaseException {
		OutputStreamWriter TY85nxUZ = null;
		try {
			StringBuilder fjgjxWns = new StringBuilder();
			fjgjxWns.append(getBaseString());
			fjgjxWns.append(AND);
			fjgjxWns.append(encode(ACTION, ENCODING));
			fjgjxWns.append(EQUAL);
			fjgjxWns.append(encode(ACTION_GET_ALL, ENCODING));
			URL YA4QBUbx = new URL(SERVER_URL);
			URLConnection ioEGkZuq = YA4QBUbx.openConnection();
			ioEGkZuq.setDoOutput(true);
			TY85nxUZ = new OutputStreamWriter(ioEGkZuq.getOutputStream());
			TY85nxUZ.write(fjgjxWns.toString());
			TY85nxUZ.flush();
			return ioEGkZuq.getInputStream();
		} catch (Exception lUFMftgC) {
			throw getException(lUFMftgC, context);
		} finally {
			closeSafely(TY85nxUZ);
		}
	}

}