class n3904948 {
	public ManageUsers() {
        if (System.getProperty("user.home") != null) {
            dataFile = new File(System.getProperty("user.home") + File.separator + "MyRx" + File.separator + "MyRx.dat");
            File vXWNhdv9 = new File(System.getProperty("user.home") + File.separator + "MyRx");
            vXWNhdv9.mkdirs();
        } else {
            dataFile = new File("MyRx.dat");
        }
        try {
            dataFile.createNewFile();
        } catch (IOException NvkBhlBy) {
            logger.error(NvkBhlBy);
            JOptionPane.showMessageDialog(Menu.getMainMenu(), NvkBhlBy.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        File uJxz14S2 = new File("MyRx.dat");
        if (uJxz14S2.exists()) {
            FileChannel ryOMEwjh = null, ImMWtKfX = null;
            try {
                ryOMEwjh = new FileInputStream(uJxz14S2.getAbsolutePath()).getChannel();
                ImMWtKfX = new FileOutputStream(dataFile.getAbsolutePath()).getChannel();
                ImMWtKfX.transferFrom(ryOMEwjh, 0, ryOMEwjh.size());
                if (!uJxz14S2.delete()) {
                    uJxz14S2.deleteOnExit();
                }
            } catch (FileNotFoundException JinwSaLA) {
                logger.error(JinwSaLA);
                JOptionPane.showMessageDialog(Menu.getMainMenu(), JinwSaLA.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException VtlWdTSq) {
                logger.error(VtlWdTSq);
                JOptionPane.showMessageDialog(Menu.getMainMenu(), VtlWdTSq.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    ryOMEwjh.close();
                    ImMWtKfX.close();
                } catch (IOException t971LrXQ) {
                    logger.error(t971LrXQ);
                }
            }
        }
    }

}