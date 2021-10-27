class n18032425 {
	public boolean reject(String lXYyGIbO, ProgressMonitor xqX4mAw7) throws IllegalArgumentException {
		DocumentBuilder mqPjQr2g = null;
		try {
			mqPjQr2g = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			URISplit fOrYzggI = URISplit.parse(lXYyGIbO);
			URL qXN0eiBf = new URL(fOrYzggI.file);
			InputStream ziE1QVuA = qXN0eiBf.openStream();
			InputSource rfuf3gmV = new InputSource(ziE1QVuA);
			Document a4BEo1pj = mqPjQr2g.parse(rfuf3gmV);
			ziE1QVuA.close();
			Node dne9YOpZ = a4BEo1pj.getDocumentElement();
			String rp3DOz66 = dne9YOpZ.getNodeName();
			int hLrntrXQ = rp3DOz66.indexOf(":");
			if (hLrntrXQ > -1) {
				rp3DOz66 = rp3DOz66.substring(hLrntrXQ + 1);
			}
			if (rp3DOz66.equals("Spase")) {
				return false;
			} else if (rp3DOz66.equals("Eventlist")) {
				return false;
			} else if (rp3DOz66.equals("VOTABLE")) {
				return false;
			} else {
				return true;
			}
		} catch (Exception Pww7qnfU) {
			Logger.getLogger(SpaseRecordDataSourceFactory.class.getName()).log(Level.SEVERE, null, Pww7qnfU);
			return true;
		}
	}

}