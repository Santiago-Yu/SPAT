class n15287816 {
	public Vector<Question> reload() throws IOException {
		Vector<Question> cVhiNtan = new Vector<Question>();
		InputStream P1wsqA92 = url.openStream();
		BufferedReader KvYC2M5X = new BufferedReader(new InputStreamReader(P1wsqA92));
		shortName = KvYC2M5X.readLine();
		if (shortName != null && shortName.equals("SHORTNAME")) {
			shortName = KvYC2M5X.readLine();
			author = KvYC2M5X.readLine();
			if (author != null && author.equals("AUTHOR")) {
				author = KvYC2M5X.readLine();
				description = KvYC2M5X.readLine();
				if (description != null && description.equals("DESCRIPTION")) {
					description = KvYC2M5X.readLine();
					try {
						cVhiNtan = QuestionLoader.getQuestions(KvYC2M5X);
					} catch (IOException AybNqgB4) {
						AybNqgB4.printStackTrace();
						throw AybNqgB4;
					} finally {
						KvYC2M5X.close();
						P1wsqA92.close();
					}
				} else {
					throw new IllegalArgumentException();
				}
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			throw new IllegalArgumentException();
		}
		return cVhiNtan;
	}

}