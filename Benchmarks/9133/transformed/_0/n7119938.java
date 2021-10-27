class n7119938 {
	public void putFile(CompoundName Et4K82zc, FileInputStream bQWbqF4M) throws IOException {
		File CiuHFwzO = new File(REMOTE_BASE_DIR.getCanonicalPath());
		for (int bLOjKBec = 0; bLOjKBec < Et4K82zc.size() - 1; bLOjKBec++)
			CiuHFwzO = new File(CiuHFwzO, Et4K82zc.get(bLOjKBec));
		CiuHFwzO.mkdirs();
		File nlBlzbVe = new File(CiuHFwzO, Et4K82zc.get(Et4K82zc.size() - 1));
		FileOutputStream Phf2x0Bp = new FileOutputStream(nlBlzbVe);
		for (int jo82VAjL = bQWbqF4M.read(); jo82VAjL != -1; jo82VAjL = bQWbqF4M.read())
			Phf2x0Bp.write(jo82VAjL);
		bQWbqF4M.close();
		Phf2x0Bp.close();
	}

}