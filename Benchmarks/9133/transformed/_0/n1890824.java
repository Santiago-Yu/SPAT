class n1890824 {
	private void internalTransferComplete(File Yy5ERMKO) {
		System.out.println("transferComplete : " + Yy5ERMKO);
		try {
			File prcJ8rZL = new File(m_destination.toString() + ".old");
			prcJ8rZL.delete();
			File m4Y7F7Gw = m_destination;
			m4Y7F7Gw.renameTo(prcJ8rZL);
			FileInputStream Ne1kT8H1 = new FileInputStream(Yy5ERMKO);
			FileOutputStream xkLTBp5t = new FileOutputStream(m_destination);
			BufferedInputStream uK1o37yZ = new BufferedInputStream(Ne1kT8H1);
			BufferedOutputStream YteUBcMq = new BufferedOutputStream(xkLTBp5t);
			for (int m9EXpALr = uK1o37yZ.read(); m9EXpALr != -1; m9EXpALr = uK1o37yZ.read()) {
				YteUBcMq.write(m9EXpALr);
			}
			YteUBcMq.flush();
			uK1o37yZ.close();
			YteUBcMq.close();
			Ne1kT8H1.close();
			xkLTBp5t.close();
			Yy5ERMKO.delete();
			setVisible(false);
			transferComplete();
		} catch (Exception q2nPMgwz) {
			q2nPMgwz.printStackTrace();
			JOptionPane.showMessageDialog(this, "An error occurred while downloading!", "ACLocator Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}