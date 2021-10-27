class n14340901 {
	public static void main(String[] qB9kkCwM) throws Exception {
		ClassPathXmlApplicationContext bYy4j5o2 = new ClassPathXmlApplicationContext("camel/exec-context.xml");
		CamelContext ppEqxG9Q = bYy4j5o2.getBean(CamelContext.class);
		Exchange d6mBRqqH = new DefaultExchange(ppEqxG9Q);
		List<String> olaCnomx = new ArrayList<String>();
		olaCnomx.add("/home/sumit/derby.log");
		olaCnomx.add("helios:cameltesting/");
		d6mBRqqH.getIn().setHeader(ExecBinding.EXEC_COMMAND_ARGS, olaCnomx);
		Exchange uwM8DmY3 = ppEqxG9Q.createProducerTemplate().send("direct:input", d6mBRqqH);
		ExecResult GhCFEeQp = (ExecResult) uwM8DmY3.getIn().getBody();
		System.out.println(GhCFEeQp.getExitValue());
		System.out.println(GhCFEeQp.getCommand());
		if (GhCFEeQp.getStderr() != null) {
			IOUtils.copy(GhCFEeQp.getStderr(), new FileOutputStream(new File("/home/sumit/error.log")));
		}
		if (GhCFEeQp.getStdout() != null) {
			IOUtils.copy(GhCFEeQp.getStdout(), new FileOutputStream(new File("/home/sumit/out.log")));
		}
		bYy4j5o2.close();
	}

}