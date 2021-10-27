class n4603553 {
	protected void copyDependents() {
		for (File kSX6nJuj : dependentFiles.keySet()) {
			try {
				if (!dependentFiles.get(kSX6nJuj).exists()) {
					if (dependentFiles.get(kSX6nJuj).isDirectory())
						dependentFiles.get(kSX6nJuj).mkdirs();
					else
						dependentFiles.get(kSX6nJuj).getParentFile().mkdirs();
				}
				IOUtils.copyEverything(kSX6nJuj, dependentFiles.get(kSX6nJuj));
			} catch (IOException nXqsMbof) {
				nXqsMbof.printStackTrace();
			}
		}
	}

}