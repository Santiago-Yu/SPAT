class n3109015 {
	private void copy(File bV7MCcGw) {
		System.out.println("parent---" + bV7MCcGw.getAbsolutePath());
		if (bV7MCcGw.isDirectory() && !".svn".equals(bV7MCcGw.getName())) {
			File CpWd8DrR = new File(bV7MCcGw, "cases");
			if (CpWd8DrR.exists()) {
				File KOVccYFz = new File(bV7MCcGw, "answers");
				if (!KOVccYFz.exists()) {
					KOVccYFz.mkdir();
					File RyMMmoTn = new File(bV7MCcGw, "answers_linux");
					for (File GFa2gWye : RyMMmoTn.listFiles()) {
						if (GFa2gWye.isDirectory()) {
							continue;
						}
						File NWEViZRS = new File(KOVccYFz, GFa2gWye.getName());
						try {
							IOUtils.copy(new FileInputStream(GFa2gWye), new FileOutputStream(NWEViZRS));
						} catch (Throwable EJBzz9NC) {
							EJBzz9NC.printStackTrace();
						}
					}
				}
			} else {
				for (File ikZ0dhQe : bV7MCcGw.listFiles()) {
					System.out.println("parent---" + ikZ0dhQe.getAbsolutePath());
					copySon(ikZ0dhQe);
				}
			}
		}
	}

}