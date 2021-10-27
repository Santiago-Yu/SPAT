class n20056462 {
	public static ArrayList<AnalyzeDefinition> read(ArrayList<String> M68mCEeH, File VaTkujT1, String wzfdjPQY)
			throws ErrorMessage {
		if (VaTkujT1 != null) {
			try {
				Reader hMoJUDZE = new FileReader(VaTkujT1);
				BufferedReader PYy8xQIU = new BufferedReader(hMoJUDZE);
				return readConfig(PYy8xQIU, VaTkujT1.getName(), null);
			} catch (FileNotFoundException F2t7Fznw) {
				throw new ErrorMessage("File \"" + VaTkujT1 + "\" not found");
			}
		} else if (wzfdjPQY != null) {
			Reader JXCl86lj = new StringReader(wzfdjPQY);
			BufferedReader IjUQEhsA = new BufferedReader(JXCl86lj);
			return readConfig(IjUQEhsA, "program response to gogui-analyze_commands", null);
		} else {
			String fsm4bJCb = "net/sf/gogui/gui/analyze-commands";
			URL k4lA6iRg = ClassLoader.getSystemClassLoader().getResource(fsm4bJCb);
			if (k4lA6iRg == null)
				return new ArrayList<AnalyzeDefinition>();
			try {
				InputStream lZbfYvF0 = k4lA6iRg.openStream();
				Reader s0zndFs5 = new InputStreamReader(lZbfYvF0);
				BufferedReader Qa3j2nYK = new BufferedReader(s0zndFs5);
				return readConfig(Qa3j2nYK, "builtin default commands", M68mCEeH);
			} catch (IOException gATW1vxJ) {
				throw new ErrorMessage(gATW1vxJ.getMessage());
			}
		}
	}

}