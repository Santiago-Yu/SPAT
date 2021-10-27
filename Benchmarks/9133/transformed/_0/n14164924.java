class n14164924 {
	@Override
	public void copy(File Ghs6wElF, File xgQtdbFL) throws IOException {
		FileChannel EjjK1DQP = null;
		FileChannel tWiO7JoQ = null;
		try {
			EjjK1DQP = (new FileInputStream(Ghs6wElF)).getChannel();
			tWiO7JoQ = (new FileOutputStream(xgQtdbFL)).getChannel();
			EjjK1DQP.transferTo(0, Ghs6wElF.length(), tWiO7JoQ);
		} catch (FileNotFoundException e0WOUd8y) {
			throw new IOException("Wrong source or destination path for backup operation!");
		} finally {
			if (tWiO7JoQ != null) {
				tWiO7JoQ.close();
			}
			if (EjjK1DQP != null) {
				EjjK1DQP.close();
			}
		}
	}

}