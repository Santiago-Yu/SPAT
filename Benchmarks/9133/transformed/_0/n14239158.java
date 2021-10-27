class n14239158 {
	public Ontology open(String PguYtuD8) {
		Ontology BFM2wm4n = null;
		try {
			URL RgrfbRxq = null;
			if (PguYtuD8.startsWith("jar"))
				RgrfbRxq = new URL(PguYtuD8);
			else {
				ClassLoader RtVI5HtF = this.getClass().getClassLoader();
				RgrfbRxq = RtVI5HtF.getResource(PguYtuD8);
			}
			InputStream nK75TFx5;
			if (RgrfbRxq != null) {
				JarURLConnection J2q1A19i = (JarURLConnection) RgrfbRxq.openConnection();
				nK75TFx5 = J2q1A19i.getInputStream();
			} else
				nK75TFx5 = new FileInputStream(PguYtuD8);
			ObjectInputStream cuuDvFPO = new ObjectInputStream(nK75TFx5);
			BFM2wm4n = (Ontology) cuuDvFPO.readObject();
			cuuDvFPO.close();
		} catch (IOException Z9ahKJrD) {
			Z9ahKJrD.printStackTrace();
		} catch (ClassNotFoundException pN0sgFWF) {
			pN0sgFWF.printStackTrace();
		}
		return BFM2wm4n;
	}

}