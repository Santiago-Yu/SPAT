class n12246545 {
	public void load(String ZheRbJqM) throws IOException {
		this.url = ZheRbJqM;
		int li39jcop = ZheRbJqM.indexOf(':');
		if (li39jcop > 1 && li39jcop < 5) {
			load(new URL(ZheRbJqM).openStream());
		} else {
			if (new File(ZheRbJqM).exists()) {
				System.out.println("Loading JAD from file : " + ZheRbJqM);
				FileInputStream s2fJnnRY = new FileInputStream(ZheRbJqM);
				try {
					load(s2fJnnRY);
				} finally {
					s2fJnnRY.close();
				}
			} else {
				InputStream IgMDG7XD = getClass().getResourceAsStream(ZheRbJqM);
				if (IgMDG7XD != null) {
					System.out.println("Loading JAD from classpath : " + ZheRbJqM);
					load(IgMDG7XD);
				} else {
					throw new IOException("\"" + ZheRbJqM + "\" was found in file system or classpath");
				}
			}
		}
	}

}