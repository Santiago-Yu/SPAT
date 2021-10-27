class n8384539 {
	public static void main(String[] Bvuc1HOD) throws IOException, ClassNotFoundException {
		URL MIJozSQ0 = null;
		try {
			MIJozSQ0 = new URL("http://wofproj.appspot.com/test");
		} catch (MalformedURLException F5mzYB2i) {
			F5mzYB2i.printStackTrace();
		}
		URLConnection KtDFrOd5 = null;
		try {
			KtDFrOd5 = MIJozSQ0.openConnection();
		} catch (IOException C4pnhmHS) {
			C4pnhmHS.printStackTrace();
		}
		KtDFrOd5.setDoInput(true);
		KtDFrOd5.setDoOutput(true);
		KtDFrOd5.setUseCaches(false);
		KtDFrOd5.setRequestProperty("Content-Type", "application/x-java-serialized-object");
		OutputStream QB3Rt2Eu = KtDFrOd5.getOutputStream();
		ObjectOutputStream MbZi9kyK = new ObjectOutputStream(QB3Rt2Eu);
		MbZi9kyK.writeObject("tom");
		MbZi9kyK.flush();
		MbZi9kyK.close();
		InputStream wVhXNb80 = KtDFrOd5.getInputStream();
		ObjectInputStream CowOXS6N = new ObjectInputStream(wVhXNb80);
		Object afRXUfIU = CowOXS6N.readObject();
		CowOXS6N.close();
		wVhXNb80.close();
		System.out.println(afRXUfIU.getClass().toString());
	}

}