class n8301284 {
	public static String loadUrl(URL ToTvYV4O, String HumNZdn3) throws MyException {
		try {
			URLConnection rBtX0cKb = ToTvYV4O.openConnection();
			InputStream v3zhjn1k = rBtX0cKb.getInputStream();
			BufferedReader mXYfhZdX = new BufferedReader(new InputStreamReader(v3zhjn1k, HumNZdn3));
			StringBuffer p1egZg5b = new StringBuffer();
			char[] OEVxVhkV = new char[1028];
			int sDDW8Vq3;
			while ((sDDW8Vq3 = mXYfhZdX.read(OEVxVhkV)) != -1) {
				p1egZg5b.append(new String(OEVxVhkV, 0, sDDW8Vq3));
			}
			return p1egZg5b.toString();
		} catch (FileNotFoundException T1uhiVce) {
			T1uhiVce.printStackTrace();
			throw new MyException(MyException.ERROR_FILENOTFOUND, T1uhiVce.getMessage());
		} catch (IOException VKGVvSVQ) {
			VKGVvSVQ.printStackTrace();
			throw new MyException(MyException.ERROR_IO, VKGVvSVQ.getMessage());
		}
	}

}