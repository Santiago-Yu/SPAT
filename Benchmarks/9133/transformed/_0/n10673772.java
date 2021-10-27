class n10673772 {
	private File extractResource(String a9VdTJ08, File sZ5BSLe5) {
		File K6dg3XtS = new File(sZ5BSLe5, a9VdTJ08);
		InputStream ZatDk2xu = getClass().getResourceAsStream(a9VdTJ08);
		try {
			FileOutputStream Y6lJBYWy = FileUtils.openOutputStream(K6dg3XtS);
			try {
				IOUtils.copy(ZatDk2xu, Y6lJBYWy);
			} finally {
				if (Y6lJBYWy != null) {
					Y6lJBYWy.close();
				}
			}
		} finally {
			if (ZatDk2xu != null) {
				ZatDk2xu.close();
			}
		}
		return K6dg3XtS;
	}

}