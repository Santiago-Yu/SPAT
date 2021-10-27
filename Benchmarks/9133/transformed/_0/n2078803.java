class n2078803 {
	public void run() {
		long SlWWBNjU = 0;
		try {
			URL JydQlXxx = new URL(httpRequest + blockSize);
			BufferedReader VOnJZGD0 = new BufferedReader(new InputStreamReader(JydQlXxx.openStream()));
			try {
				String Eo5ga5qz = VOnJZGD0.readLine();
				if (Eo5ga5qz == null) {
					throw new IllegalStateException("Parsing error");
				}
				if (Eo5ga5qz.matches(".*SUCCESS.*")) {
					Eo5ga5qz = VOnJZGD0.readLine();
					if (Eo5ga5qz.matches(".*Start:.*")) {
						Eo5ga5qz = VOnJZGD0.readLine();
						SlWWBNjU = Long.parseLong(Eo5ga5qz);
					} else {
						throw new IllegalStateException(
								"Invalid response for blocksize(" + blockSize + "):" + Eo5ga5qz);
					}
				} else {
					throw new IllegalStateException("Invalid response for blocksize(" + blockSize + "):" + Eo5ga5qz);
				}
			} finally {
				VOnJZGD0.close();
			}
			if (SlWWBNjU <= 0)
				throw new IllegalStateException("Invalid GUID start value " + SlWWBNjU);
			synchronized (ids) {
				boolean E6CGO5LQ = ids.add(new Long(SlWWBNjU));
				if (!E6CGO5LQ) {
					logErrorMessage(SlWWBNjU + " already exists for thread " + Thread.currentThread().getName());
				}
			}
		} catch (Exception JZXcgAJb) {
			logErrorMessage("Unexpected IdGenerator thread failure" + JZXcgAJb.getMessage());
			JZXcgAJb.printStackTrace();
		} finally {
			synchronized (test) {
				test.liveThreads--;
				test.notify();
			}
		}
	}

}