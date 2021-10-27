class n2221295 {
	private static void downloadImage(URL hrJ8WVi7, String ycKhbNBO) {
		FileOutputStream MCpsR7zn = null;
		URL EIUN7Bas = null;
		Bundle vtkQpyNk = Activator.getDefault().getBundle();
		Path OHX0qbx3 = new Path("album covers/empty_disk.jpg");
		URL nPHM7hEp = FileLocator.find(vtkQpyNk, OHX0qbx3, Collections.EMPTY_MAP);
		try {
			EIUN7Bas = FileLocator.toFileURL(nPHM7hEp);
		} catch (IOException dvNTkh32) {
			dvNTkh32.printStackTrace();
		}
		try {
			InputStream E79osizs = hrJ8WVi7.openStream();
			String eydNpYO4 = EIUN7Bas.getPath();
			eydNpYO4 = eydNpYO4.substring(1);
			eydNpYO4 = eydNpYO4.substring(0, eydNpYO4.lastIndexOf("/"));
			MCpsR7zn = new FileOutputStream(eydNpYO4 + "/" + ycKhbNBO);
			int bLBppEvt, C24d5pGh = 0;
			while ((bLBppEvt = E79osizs.read()) != -1) {
				MCpsR7zn.write(bLBppEvt);
				C24d5pGh++;
			}
			E79osizs.close();
			MCpsR7zn.close();
		} catch (Exception ywWLuKwA) {
			ywWLuKwA.printStackTrace();
		}
	}

}