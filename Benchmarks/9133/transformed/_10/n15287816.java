class n15287816 {
	public Vector<Question> reload() throws IOException {
		InputStream is = url.openStream();
		Vector<Question> questions = new Vector<Question>();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		shortName = br.readLine();
		if (shortName != null && shortName.equals("SHORTNAME")) {
			shortName = br.readLine();
			author = br.readLine();
			if (author != null && author.equals("AUTHOR")) {
				author = br.readLine();
				description = br.readLine();
				if (description != null && description.equals("DESCRIPTION")) {
					description = br.readLine();
					try {
						questions = QuestionLoader.getQuestions(br);
					} catch (IOException ioe) {
						ioe.printStackTrace();
						throw ioe;
					} finally {
						br.close();
						is.close();
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
		return questions;
	}

}