class n2078803 {
	public void run() {
		long id = 0;
		try {
			URL url = new URL(httpRequest + blockSize);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			try {
				String str = in.readLine();
				if (str == null) {
					throw new IllegalStateException("Parsing error");
				}
				if (str.matches(".*SUCCESS.*")) {
					str = in.readLine();
					if (str.matches(".*Start:.*")) {
						str = in.readLine();
						id = Long.parseLong(str);
					} else {
						throw new IllegalStateException("Invalid response for blocksize(" + blockSize + "):" + str);
					}
				} else {
					throw new IllegalStateException("Invalid response for blocksize(" + blockSize + "):" + str);
				}
			} finally {
				in.close();
			}
			if (id <= 0)
				throw new IllegalStateException("Invalid GUID start value " + id);
			synchronized (ids) {
				boolean absent = ids.add(new Long(id));
				if (!absent) {
					logErrorMessage(id + " already exists for thread " + Thread.currentThread().getName());
				}
			}
		} catch (Exception e) {
			logErrorMessage("Unexpected IdGenerator thread failure" + e.getMessage());
			e.printStackTrace();
		} finally {
			synchronized (test) {
				test.liveThreads -= 1;
				test.notify();
			}
		}
	}

}