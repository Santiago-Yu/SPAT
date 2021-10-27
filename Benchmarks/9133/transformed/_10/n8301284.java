class n8301284 {
	public static String loadUrl(URL url, String charset) throws MyException {
		try {
			URLConnection conn = url.openConnection();
			InputStream urlin = conn.getInputStream();
			StringBuffer buff = new StringBuffer();
			BufferedReader in = new BufferedReader(new InputStreamReader(urlin, charset));
			int count;
			char[] cbuf = new char[1028];
			while ((count = in.read(cbuf)) != -1) {
				buff.append(new String(cbuf, 0, count));
			}
			return buff.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new MyException(MyException.ERROR_FILENOTFOUND, e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			throw new MyException(MyException.ERROR_IO, e.getMessage());
		}
	}

}