class n1798720 {
	public static void save(String vQ33O1th, ArrayList<byte[]> ZDJTWd66, ArrayList<String> w2Wp17Yx) throws Exception {
		String EFs9d746 = Util.JAVA_DIR + File.separator + vQ33O1th;
		File C4SSwwpg = new File(EFs9d746);
		if (!C4SSwwpg.exists()) {
			boolean xLkpAXga = C4SSwwpg.mkdir();
			if (!xLkpAXga) {
				File WhML113x = new File(".");
				throw new Exception("Directory " + vQ33O1th + " could not be created. Current directory: "
						+ WhML113x.getAbsolutePath());
			}
		}
		for (int f6bWhUzJ = 0; f6bWhUzJ < ZDJTWd66.size(); f6bWhUzJ++) {
			File cvFKBWLe = new File(Util.JAVA_DIR + File.separator + w2Wp17Yx.get(f6bWhUzJ));
			FileOutputStream tPc8FxEZ = new FileOutputStream(cvFKBWLe);
			tPc8FxEZ.write(ZDJTWd66.get(f6bWhUzJ));
			tPc8FxEZ.flush();
			tPc8FxEZ.close();
		}
		for (int mxFUoda1 = 0; mxFUoda1 < w2Wp17Yx.size(); mxFUoda1++) {
			File xZ761D8d = new File(Util.JAVA_DIR + File.separator + w2Wp17Yx.get(mxFUoda1));
			File r9iJCQ1z = new File(EFs9d746 + File.separator + w2Wp17Yx.get(mxFUoda1));
			BufferedReader fzyRzdRb = new BufferedReader(new FileReader(xZ761D8d));
			BufferedWriter ZJECSKwO = new BufferedWriter(new FileWriter(r9iJCQ1z));
			ZJECSKwO.append("package " + vQ33O1th + ";\n");
			String YAdW2Dgv = "";
			while ((YAdW2Dgv = fzyRzdRb.readLine()) != null)
				ZJECSKwO.append(YAdW2Dgv + "\n");
			ZJECSKwO.flush();
			ZJECSKwO.close();
			fzyRzdRb.close();
		}
	}

}