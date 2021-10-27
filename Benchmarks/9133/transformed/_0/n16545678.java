class n16545678 {
	private boolean copyFile(File ivJSBiBG, File m781jlFG) {
		BufferedReader q0JnMc2p = null;
		BufferedWriter i89DVHV8 = null;
		try {
			q0JnMc2p = new BufferedReader(new FileReader(ivJSBiBG));
			i89DVHV8 = new BufferedWriter(new FileWriter(m781jlFG));
			while (q0JnMc2p.ready()) {
				i89DVHV8.write(q0JnMc2p.read());
			}
			i89DVHV8.flush();
		} catch (IOException MaxAiKvs) {
			MaxAiKvs.printStackTrace();
		} finally {
			if (q0JnMc2p != null) {
				try {
					q0JnMc2p.close();
				} catch (IOException HN3RZxQq) {
					HN3RZxQq.printStackTrace();
					return false;
				}
			}
			if (i89DVHV8 != null) {
				try {
					i89DVHV8.close();
				} catch (IOException gTNKKe5L) {
					return false;
				}
			}
		}
		return true;
	}

}