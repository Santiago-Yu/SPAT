class n14557732 {
	public List<Rule> parse(Runestone stone, URL url) throws IOException {
		Map<String, String> macros = new HashMap<String, String>();
		List<Rule> rules = new ArrayList<Rule>();
		BufferedReader bin = null;
		try {
			bin = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = bin.readLine();
			while (line != null) {
				line = line.trim();
				if (line.startsWith("Macro:")) {
					String name = line.substring(6).trim();
					String value = bin.readLine();
					if (value != null) {
						value = value.trim();
						for (Map.Entry<String, String> macro : macros.entrySet()) {
							value = value.replace("(" + macro.getKey() + ")", macro.getValue());
						}
						if (macros.containsKey(name))
							System.err.println("WARNING: macro '" + name + "' is being redefined");
						macros.put(name, value);
					}
				}
				if (line.startsWith("Rule:")) {
					String name = line.substring(5).trim();
					Map<String, Boolean> options = new HashMap<String, Boolean>();
					line = bin.readLine();
					String[] requires = new String[0];
					String[] provides = new String[0];
					if (line != null && line.startsWith("Options:")) {
						String data[] = line.substring(8).trim().split(",");
						for (String opt : data) {
							String[] kvp = opt.split("=");
							options.put(kvp[0].trim(), Boolean.valueOf(kvp[1].trim()));
						}
						line = bin.readLine();
					}
					if (line != null && line.startsWith("Requires:")) {
						requires = line.substring(9).trim().split("\\s+");
						line = bin.readLine();
					}
					if (line != null && line.startsWith("Provides:")) {
						provides = line.substring(9).trim().split("\\s+");
						line = bin.readLine();
					}
					String lhs = "";
					if (line == null) {
						throw new RuntimeException(
								"We've found the end of the file in the middle of a rule, something is really wrong");
					}
					while (line != null && (!line.trim().equals("=>") && !line.startsWith("Rule:"))) {
						lhs += line.trim();
						line = bin.readLine();
					}
					Transition t = null;
					for (Map.Entry<String, String> macro : macros.entrySet()) {
						lhs = lhs.replace("(" + macro.getKey() + ")", macro.getValue());
					}
					String rhs = "";
					if (lhs.length() > 0)
						t = parse(stone, lhs);
					if (line != null && !line.startsWith("Rule:"))
						line = bin.readLine();
					while (line != null && !line.trim().startsWith("Rule:")) {
						rhs += line + "\n";
						line = bin.readLine();
					}
					Rule rule = null;
					rhs = rhs.trim();
					if (rhs.equals("")) {
						rule = new RuleSimpleImpl(name, t, options, name);
					} else if (rhs.startsWith("[")) {
						String type = rhs.substring(1, rhs.length() - 1).trim();
						if (type.equals(""))
							type = name;
						rule = new RuleSimpleImpl(name, t, options, type);
					} else if (rhs.startsWith("{")) {
						rhs = rhs.substring(1, rhs.length() - 1);
						try {
							rule = compiler.compile(name, options, t, rhs);
						} catch (Throwable e) {
							System.out.println("\nSomething wicked this way comes...");
							e.printStackTrace();
							e.getCause().printStackTrace();
						}
					} else {
						System.err
								.println("Unsupported type of RHS for rule '" + name + "', rule will not be compiled");
					}
					if (rule != null) {
						rule.addRequired(requires);
						rule.addProvided(provides);
						rules.add(rule);
					} else {
						System.err.println("No idea what happend but the rule instance is null!");
					}
				} else if (line.startsWith("Import:")) {
					rules.addAll(parse(stone, new URL(url, line.substring(7).trim())));
				}
				if (line == null || !line.trim().startsWith("Rule:"))
					line = bin.readLine();
			}
		} finally {
			if (bin != null) {
				try {
					bin.close();
				} catch (IOException e) {
				}
			}
		}
		return rules;
	}

}