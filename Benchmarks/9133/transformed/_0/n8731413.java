class n8731413 {
	public ImportFromFile() {
        JFrame NVmh3K7T = new JFrame();
        JFileChooser dl6F42jP = new JFileChooser(KTH.data._path);
        dl6F42jP.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int wgkdPg0d = dl6F42jP.showOpenDialog(NVmh3K7T);
        File bvjDg7jD = null;
        if (wgkdPg0d == JFileChooser.APPROVE_OPTION) {
            bvjDg7jD = dl6F42jP.getSelectedFile();
            KTH.data._path = bvjDg7jD.getParent();
            System.out.println(bvjDg7jD.getAbsolutePath() + "\n");
        } else {
        }
        if (bvjDg7jD != null) {
            File IMHbe9Mc = new File(KTH.data.getHomeDir() + File.separator + KTH.data.katalogName);
            System.out.println(IMHbe9Mc + (IMHbe9Mc.exists() ? " is found " : " is missing "));
            if (IMHbe9Mc.exists() && !IOUtils.isNewerContent(bvjDg7jD, IMHbe9Mc)) {
            } else {
                try {
                    IOUtils.copyFile(bvjDg7jD, IMHbe9Mc, true);
                } catch (Exception Q2wtcl2a) {
                    KTH.out.err(Q2wtcl2a);
                }
            }
            KTH.dc2.removeDc("Import");
        } else {
        }
    }

}