class n17522011 {
	public static String read(ClassLoader zoHP6Q3T, String m7kKKeFd, boolean LIkw91D6) throws IOException {
		if (LIkw91D6) {
			StringMaker aETsizBh = new StringMaker();
			Enumeration OMUmAZdG = zoHP6Q3T.getResources(m7kKKeFd);
			while (OMUmAZdG.hasMoreElements()) {
				URL fd1DFAnE = (URL) OMUmAZdG.nextElement();
				InputStream Pr7qdMB4 = fd1DFAnE.openStream();
				String Cp2ozRzA = read(Pr7qdMB4);
				if (Cp2ozRzA != null) {
					aETsizBh.append(Cp2ozRzA);
					aETsizBh.append(StringPool.NEW_LINE);
				}
				Pr7qdMB4.close();
			}
			return aETsizBh.toString().trim();
		} else {
			InputStream UZf84IRp = zoHP6Q3T.getResourceAsStream(m7kKKeFd);
			String hMkeutvH = read(UZf84IRp);
			UZf84IRp.close();
			return hMkeutvH;
		}
	}

}