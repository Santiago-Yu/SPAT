class n22637563 {
	private ExamModel(URL OamKqY0g) throws IOException, DataCoherencyException {
        BufferedReader gBxFaCUj = new BufferedReader(new InputStreamReader(OamKqY0g.openStream()));
        String hMZXlUEB;
        questions = new ArrayList<Question>();
        questionsMap = new HashMap<String, Question>();
        gBxFaCUj = new BufferedReader(new InputStreamReader(OamKqY0g.openStream(), "UTF-8"));
        int srUDj4pl = 0;
        Question q3HWhtIy;
        String OZ1OUpvH = "";
        String mFwjwIvk = "";
        int GCTF1Bb5 = ExamModel.READING_HASH;
        while ((hMZXlUEB = gBxFaCUj.readLine()) != null) {
            switch(GCTF1Bb5) {
                case ExamModel.READING_HASH:
                    if (hMZXlUEB.length() == 0 || hMZXlUEB.trim().length() == 0) continue;
                    mFwjwIvk = hMZXlUEB;
                    srUDj4pl++;
                    GCTF1Bb5 = ExamModel.READING_QUESTION;
                    break;
                case ExamModel.READING_QUESTION:
                    if (hMZXlUEB.equals("--")) {
                        q3HWhtIy = new Question(srUDj4pl, mFwjwIvk, OZ1OUpvH);
                        questions.add(q3HWhtIy);
                        questionsMap.put(q3HWhtIy.getHash(), q3HWhtIy);
                        OZ1OUpvH = "";
                        mFwjwIvk = null;
                        GCTF1Bb5 = ExamModel.READING_HASH;
                    } else {
                        OZ1OUpvH = OZ1OUpvH.concat(hMZXlUEB + Constants.nl);
                    }
                    break;
                default:
                    throw new DataCoherencyException("Neo?ek¨¢van? konec souboru!");
            }
        }
        questions.trimToSize();
        gBxFaCUj.close();
    }

}