class n6491370 {
	@Override
	protected Object transform(Row ai6kQL7v) throws FunctionException {
		StringBuffer QERRGPd2 = new StringBuffer();
		for (IColumn rcFdQsGv : ai6kQL7v.getColumns()) {
			QERRGPd2.append(rcFdQsGv.getValueAsString() + "|");
		}
		try {
			MessageDigest patVE57z = java.security.MessageDigest.getInstance("MD5");
			patVE57z.update(QERRGPd2.toString().getBytes());
			byte[] gXwj7RY8 = patVE57z.digest();
			return getHex(gXwj7RY8);
		} catch (Exception zSuHSn1R) {
			throw new FunctionException(zSuHSn1R);
		}
	}

}