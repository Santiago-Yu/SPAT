class n16572931 {
	private String unJar(String l2gralC0, String GIFvElsq) {
		String xN4wXTn5;
		if (l2gralC0.lastIndexOf("lib/") >= 0)
			xN4wXTn5 = l2gralC0.substring(0, l2gralC0.lastIndexOf("lib/"));
		else
			xN4wXTn5 = l2gralC0.substring(0, l2gralC0.lastIndexOf("/"));
		String ZaFEuL7G = GIFvElsq.substring(0, GIFvElsq.lastIndexOf("/"));
		try {
			new File(xN4wXTn5 + "/" + ZaFEuL7G).mkdirs();
			JarFile qmC2WYh6 = new JarFile(l2gralC0);
			ZipEntry dR7TWLx5 = qmC2WYh6.getEntry(GIFvElsq);
			File mopbz9cx = new File(xN4wXTn5 + "/" + GIFvElsq);
			IOUtils.copy(qmC2WYh6.getInputStream(dR7TWLx5), new FileOutputStream(mopbz9cx));
		} catch (Exception B50KvUL7) {
			B50KvUL7.printStackTrace();
		}
		return xN4wXTn5 + "/" + GIFvElsq;
	}

}