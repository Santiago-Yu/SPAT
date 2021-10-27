class n20619879 {
	public void copyLogic() {
		if (getState() == States.Idle) {
			setState(States.Synchronizing);
			try {
				FileChannel JISywPba = new FileInputStream(
						new File(_properties.getProperty("binPath") + name + ".class")).getChannel();
				FileChannel GcZLcKyQ = new FileOutputStream(
						new File(_properties.getProperty("agentFileLocation") + name + ".class")).getChannel();
				JISywPba.transferTo(0, JISywPba.size(), GcZLcKyQ);
				JISywPba.close();
				GcZLcKyQ.close();
			} catch (FileNotFoundException nfClJegy) {
				nfClJegy.printStackTrace();
			} catch (IOException cgID5PFK) {
				cgID5PFK.printStackTrace();
			}
			setState(States.Idle);
		}
	}

}