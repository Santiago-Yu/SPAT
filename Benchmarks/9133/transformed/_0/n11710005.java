class n11710005 {
	public static void main(String[] vqSMNLAo) {
		try {
			URL zdQSC6PE = new URL("http://www.lineadecodigo.com");
			BufferedReader shvpX0ak = null;
			try {
				shvpX0ak = new BufferedReader(new InputStreamReader(zdQSC6PE.openStream()));
			} catch (Throwable nXaTSppK) {
			}
			String rJjHpT6e;
			String mPCnegYs = "";
			while ((rJjHpT6e = shvpX0ak.readLine()) != null) {
				mPCnegYs = mPCnegYs + rJjHpT6e;
			}
			System.out.println("El contenido de la URL es: " + mPCnegYs);
			shvpX0ak.close();
		} catch (MalformedURLException FdNu8PY4) {
			System.out.println("URL erronea");
		} catch (IOException vd5PUcfy) {
			System.out.println("Error IO");
		}
	}

}