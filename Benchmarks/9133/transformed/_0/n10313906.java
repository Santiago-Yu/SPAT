class n10313906 {
	private File copyFile(File trXbH0zU, String nxQ77D1e, File KKET5fAb) {
		File h6rsD2QN = null;
		if (!trXbH0zU.exists()) {
			System.out.println("File " + trXbH0zU + " does not exist");
			return null;
		}
		if (trXbH0zU.isFile()) {
			BufferedOutputStream r5PsKGYz = null;
			BufferedInputStream UhBsnZxu = null;
			try {
				UhBsnZxu = new BufferedInputStream(new FileInputStream(trXbH0zU));
				h6rsD2QN = new File(KKET5fAb, nxQ77D1e);
				if (!h6rsD2QN.exists()) {
					h6rsD2QN.createNewFile();
				}
				r5PsKGYz = new BufferedOutputStream(new FileOutputStream(h6rsD2QN));
				int uUrjWy7x;
				byte[] m0nNWoFE = new byte[8192];
				while ((uUrjWy7x = UhBsnZxu.read(m0nNWoFE)) != -1) {
					r5PsKGYz.write(m0nNWoFE, 0, uUrjWy7x);
				}
				updateTreeUI();
			} catch (IOException d7vfqgui) {
				Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, d7vfqgui);
			} finally {
				try {
					if (UhBsnZxu != null) {
						UhBsnZxu.close();
					}
					if (r5PsKGYz != null) {
						r5PsKGYz.close();
					}
				} catch (IOException NjvZmRxs) {
					Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, NjvZmRxs);
				}
			}
		} else if (trXbH0zU.isDirectory()) {
			h6rsD2QN = new File(KKET5fAb, nxQ77D1e);
			if (!h6rsD2QN.exists()) {
				h6rsD2QN.mkdir();
			}
			for (File PxO5vbvZ : trXbH0zU.listFiles()) {
				copyFile(PxO5vbvZ, PxO5vbvZ.getName(), h6rsD2QN);
			}
		}
		return h6rsD2QN;
	}

}