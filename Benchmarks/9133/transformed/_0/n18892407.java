class n18892407 {
	private void copyTemplateFile(String oJTdLzkw, String iQq7nLxF, String Yx4uwZZk) throws Exception {
		String tVrXg0Jt = oJTdLzkw + Yx4uwZZk;
		String QcEJExlN = iQq7nLxF + Yx4uwZZk;
		System.out.println("Copying resource file: " + QcEJExlN);
		File PKKDuxCw = new File(tVrXg0Jt);
		if (!PKKDuxCw.exists() || !PKKDuxCw.canRead()) {
			throw new Exception("Could not read from the file " + tVrXg0Jt);
		}
		File f43sSt0c = new File(QcEJExlN);
		if (!f43sSt0c.exists()) {
			if (!f43sSt0c.createNewFile() || !f43sSt0c.canWrite())
				throw new Exception("Could not write to the file " + QcEJExlN);
		}
		FileReader LPoJxYHV = new FileReader(PKKDuxCw);
		FileWriter morYxWrc = new FileWriter(f43sSt0c);
		try {
			char[] u2qLvDyE = new char[1024];
			int HQzHkQ4A = 0;
			while ((HQzHkQ4A = LPoJxYHV.read(u2qLvDyE)) != -1) {
				morYxWrc.write(u2qLvDyE, 0, HQzHkQ4A);
			}
		} finally {
			LPoJxYHV.close();
			morYxWrc.close();
		}
	}

}