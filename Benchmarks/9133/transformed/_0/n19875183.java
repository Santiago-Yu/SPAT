class n19875183 {
	private void copy(File sOcFeUpl, File VSnO0Ujh) {
		BufferedReader Kl1D4QMB = null;
		BufferedWriter FWRwI5bd = null;
		try {
			Kl1D4QMB = new BufferedReader(new InputStreamReader(new FileInputStream(sOcFeUpl), "UTF-8"));
			FWRwI5bd = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(VSnO0Ujh), "UTF-8"));
			while (Kl1D4QMB.ready()) {
				FWRwI5bd.write(Kl1D4QMB.readLine());
				FWRwI5bd.write(System.getProperty("line.separator"));
			}
		} catch (IOException MgLddQNW) {
		} finally {
			try {
				if (Kl1D4QMB != null)
					Kl1D4QMB.close();
				if (FWRwI5bd != null)
					FWRwI5bd.close();
			} catch (IOException F26MCTWk) {
			}
		}
	}

}