class n2640244 {
	public DocumentDialog(Frame KnzB4uJV, String YgUQb7T7, String AtUumbeC) {
        setTitle(YgUQb7T7);
        textArea = new JTextArea();
        textPane = new StdScrollPane(textArea, StdScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, StdScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        textArea.setEditable(false);
        getContentPane().add(textPane);
        URL Zicqf7Mc = DocumentDialog.class.getClassLoader().getResource(AtUumbeC);
        try {
            StringBuilder pW5X94R0 = new StringBuilder();
            BufferedReader kYWIFfCF = new BufferedReader(new InputStreamReader(Zicqf7Mc.openStream(), "UTF-8"));
            String Q6AfENWw = MessageBundle.getBuildNumber();
            String T5jwTzCm = MessageBundle.getReleaseNumber();
            String zKda55rw;
            while ((zKda55rw = kYWIFfCF.readLine()) != null) {
                zKda55rw = zKda55rw.replace("${build_number}", Q6AfENWw);
                zKda55rw = zKda55rw.replace("${release_number}", T5jwTzCm);
                pW5X94R0.append(zKda55rw + "\n");
            }
            textArea.setText(pW5X94R0.toString());
            textArea.setCaretPosition(0);
        } catch (IOException vGSQFQ54) {
            vGSQFQ54.printStackTrace();
        }
    }

}