class n12524506 {
	public static void copyFile(File zWb6T1Ji, File eGXR84Ho) throws IOException {
		FileChannel LQJbs1gm = null;
		FileChannel qaBD8vCQ = null;
		try {
			LQJbs1gm = new FileInputStream(zWb6T1Ji).getChannel();
			File Aqt78WXq = new File(eGXR84Ho, zWb6T1Ji.getName());
			qaBD8vCQ = new FileOutputStream(Aqt78WXq).getChannel();
			LQJbs1gm.transferTo(0, LQJbs1gm.size(), qaBD8vCQ);
		} finally {
			try {
				if (LQJbs1gm != null) {
					LQJbs1gm.close();
				}
			} finally {
				if (qaBD8vCQ != null) {
					qaBD8vCQ.close();
				}
			}
		}
	}

}