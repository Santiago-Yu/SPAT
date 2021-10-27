class n20519147 {
	public boolean load() {
		if (getFilename() != null && getFilename().length() > 0) {
			try {
				File hmhhDkE5 = new File(
						PreferencesManager.loadDirectoryLocation("macros") + File.separator + getFilename());
				URL ugfqQOiF = hmhhDkE5.toURL();
				InputStreamReader yJTgiSGS = new InputStreamReader(ugfqQOiF.openStream());
				BufferedReader JsJb0cOH = new BufferedReader(yJTgiSGS);
				String Mv3L1e1m = JsJb0cOH.readLine();
				String kSXIL4wq = "";
				while (Mv3L1e1m != null) {
					kSXIL4wq = kSXIL4wq.concat(Mv3L1e1m);
					Mv3L1e1m = JsJb0cOH.readLine();
					if (Mv3L1e1m != null) {
						kSXIL4wq = kSXIL4wq.concat(System.getProperty("line.separator"));
					}
				}
				code = kSXIL4wq;
			} catch (Exception QY2911de) {
				System.err.println("Exception at StoredMacro.load(): " + QY2911de.toString());
				return false;
			}
		}
		return true;
	}

}