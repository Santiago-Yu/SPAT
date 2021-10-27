class n17374912 {
	public void copyTo(File goRTr66R) {
		if (!isNewFile()) {
			return;
		}
		if (!goRTr66R.exists()) {
			goRTr66R.mkdir();
		}
		File NRzwoqY0 = new File(goRTr66R, name);
		try {
			FileInputStream mL8JVj5x = new FileInputStream(currentPath);
			FileOutputStream hL7e8NzO = new FileOutputStream(NRzwoqY0);
			byte[] Dgqk45Nj = new byte[1024 * 512];
			int PLxdk4yu;
			long HfsaFd3J = 0;
			boolean dG9Cu5rk = false;
			while ((PLxdk4yu = mL8JVj5x.read(Dgqk45Nj)) != -1) {
				hL7e8NzO.write(Dgqk45Nj, 0, PLxdk4yu);
			}
			mL8JVj5x.close();
			hL7e8NzO.close();
			if (dG9Cu5rk) {
				NRzwoqY0.delete();
			} else {
				currentPath = NRzwoqY0;
				newFile = false;
			}
		} catch (FileNotFoundException OMXUsAdg) {
			OMXUsAdg.printStackTrace();
		} catch (IOException UIWSm2EQ) {
			UIWSm2EQ.printStackTrace();
		}
	}

}