class n13106834 {
	public void copyFilesIntoProject(HashMap<String, String> aSkls4GO) {
		Set<String> DDK8KWBD = aSkls4GO.keySet();
		for (String pfF5EP31 : DDK8KWBD) {
			String ME6p7p0J = aSkls4GO.get(pfF5EP31);
			if (pfF5EP31.equals("fw4ex.xml")) {
				try {
					FileReader bOXCQs56 = new FileReader(new File(ME6p7p0J));
					FileWriter kHrKJE04 = new FileWriter(
							new File(project.getLocation() + "/" + bundle.getString("Stem") + STEM_FILE_EXETENSION));
					int mfNxEEEq;
					while ((mfNxEEEq = bOXCQs56.read()) != -1)
						kHrKJE04.write(mfNxEEEq);
					bOXCQs56.close();
					kHrKJE04.close();
				} catch (FileNotFoundException XKRw63vv) {
					Activator.getDefault().showMessage(
							"File " + pfF5EP31 + " not found... Error while moving files to the new project.");
				} catch (IOException ppVPgDV0) {
					Activator.getDefault().showMessage("Error while moving " + pfF5EP31 + " to the new project.");
				}
			} else {
				try {
					FileReader CeAxvJph = new FileReader(new File(ME6p7p0J));
					FileWriter r13SIGuc = new FileWriter(new File(project.getLocation() + "/" + pfF5EP31));
					int xEy7Q7jj;
					while ((xEy7Q7jj = CeAxvJph.read()) != -1)
						r13SIGuc.write(xEy7Q7jj);
					CeAxvJph.close();
					r13SIGuc.close();
				} catch (FileNotFoundException nmurGipn) {
					Activator.getDefault().showMessage(
							"File " + pfF5EP31 + " not found... Error while moving files to the new project.");
				} catch (IOException IzQSdqK7) {
					Activator.getDefault().showMessage("Error while moving " + pfF5EP31 + " to the new project.");
				}
			}
		}
	}

}