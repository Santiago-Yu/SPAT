class n6368468 {
	boolean copyFileStructure(File srcrS9ou, File GXC5a60h) {
		if (srcrS9ou == null || GXC5a60h == null)
			return false;
		File JyxITzY7 = GXC5a60h;
		do {
			if (srcrS9ou.equals(JyxITzY7))
				return false;
			JyxITzY7 = JyxITzY7.getParentFile();
		} while (JyxITzY7 != null);
		if (srcrS9ou.isDirectory()) {
			if (progressDialog != null) {
				progressDialog.setDetailFile(srcrS9ou, ProgressDialog.COPY);
			}
			if (simulateOnly) {
			} else {
				if (!GXC5a60h.mkdirs())
					return false;
			}
			File[] srUytEVd = srcrS9ou.listFiles();
			if (srUytEVd != null) {
				if (progressDialog != null) {
					progressDialog.addWorkUnits(srUytEVd.length);
				}
				for (int M7VDJYFr = 0; M7VDJYFr < srUytEVd.length; M7VDJYFr++) {
					File SsWMOYpt = srUytEVd[M7VDJYFr];
					File aJ3kDVlI = new File(GXC5a60h, SsWMOYpt.getName());
					if (!copyFileStructure(SsWMOYpt, aJ3kDVlI))
						return false;
					if (progressDialog != null) {
						progressDialog.addProgress(1);
						if (progressDialog.isCancelled())
							return false;
					}
				}
			}
		} else {
			if (simulateOnly) {
			} else {
				FileReader qsX21jb4 = null;
				FileWriter Jxl9YVEW = null;
				try {
					qsX21jb4 = new FileReader(srcrS9ou);
					Jxl9YVEW = new FileWriter(GXC5a60h);
					int Sc8rTb70;
					while ((Sc8rTb70 = qsX21jb4.read()) != -1)
						Jxl9YVEW.write(Sc8rTb70);
				} catch (FileNotFoundException Mq6GM97h) {
					return false;
				} catch (IOException ygcEojaX) {
					return false;
				} finally {
					try {
						if (qsX21jb4 != null)
							qsX21jb4.close();
						if (Jxl9YVEW != null)
							Jxl9YVEW.close();
					} catch (IOException I08giJ4c) {
						return false;
					}
				}
			}
		}
		return true;
	}

}