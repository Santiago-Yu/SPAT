package spat.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.SwitchCase;
import org.eclipse.jdt.core.dom.SwitchStatement;
import org.eclipse.jdt.core.dom.ParenthesizedExpression;
import org.eclipse.jdt.core.dom.PrefixExpression;
import org.eclipse.jdt.core.dom.PrefixExpression.Operator;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.core.dom.rewrite.ListRewrite;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;

import spat.Utils;

public class Case2IfElse extends ASTVisitor{
	CompilationUnit cu = null;
	Document document = null;
	String outputDirPath = null;
	ArrayList<SwitchStatement> switchStatements = new ArrayList<SwitchStatement>();
	
	public Case2IfElse(CompilationUnit cu_, Document document_, String outputDirPath_) {
		this.cu = cu_;
		this.document = document_;
		this.outputDirPath = outputDirPath_;
	}
	
	
	public boolean visit(SwitchStatement node) {
		
		List caseStatments = node.statements();
		switchStatements.add(node);
		return true;
	}
	
	public void endVisit(CompilationUnit node) {
		
		if (switchStatements.size() == 0) {
			return;
		}
		
		AST ast = cu.getAST();
		ASTRewrite rewriter = ASTRewrite.create(ast);
		for(SwitchStatement switchCase: switchStatements){
			List<Statement> caseStatments = switchCase.statements();
			HashMap<Expression,List<Statement>> cond2Sts = new HashMap<Expression,List<Statement>>();
			List<Expression> wait2fill = new ArrayList<Expression>();
			for (Statement caseSt: caseStatments) {
				if (caseSt.getNodeType() == ASTNode.SWITCH_CASE) {
					Expression condexp = ((SwitchCase) caseSt).getExpression();
					wait2fill.add(condexp);
					assert(!cond2Sts.containsKey(condexp));
					cond2Sts.put(condexp, new ArrayList<Statement>());

				}
				else if (caseSt.getNodeType() == ASTNode.BREAK_STATEMENT) {
					wait2fill.clear();
				}
				else {
					assert(caseSt.getNodeType() == ASTNode.EXPRESSION_STATEMENT);
					for (Expression exp: wait2fill) {
						assert(cond2Sts.containsKey(exp));

						cond2Sts.get(exp).add(caseSt);
					}
				}
			}
			
			IfStatement thefirstIf = ast.newIfStatement();
			IfStatement thecurrentIf = thefirstIf;
			for (Expression condexp: cond2Sts.keySet()) {
				if (condexp==null) {
					continue;
				}
				Expression swtichExp = (Expression) ASTNode.copySubtree(ast,switchCase.getExpression());
				InfixExpression theExp = ast.newInfixExpression();
				theExp.setOperator(InfixExpression.Operator.EQUALS);
				theExp.setLeftOperand(swtichExp);
				theExp.setRightOperand((Expression) ASTNode.copySubtree(ast,condexp));
				thecurrentIf.setExpression(theExp);
				
				Block block =ast.newBlock();
				for (Statement casest: cond2Sts.get(condexp)) {
					//List<Statement> bsts = block.statements();
					block.statements().add((Statement) ASTNode.copySubtree(ast,casest));
				}
				thecurrentIf.setThenStatement(block);
				IfStatement theNextIf = ast.newIfStatement(); 
				thecurrentIf.setElseStatement(theNextIf);
				thecurrentIf = theNextIf;
			}
			
			if (cond2Sts.containsKey(null)) {
				IfStatement lastSecond = (IfStatement) thecurrentIf.getParent();
				Block block =ast.newBlock();
				for (Statement casest: cond2Sts.get(null)) {
					//List<Statement> bsts = block.statements();
					block.statements().add((Statement) ASTNode.copySubtree(ast,casest));
				}
				lastSecond.setElseStatement(block);
			}
			else {
				IfStatement lastSecond = (IfStatement) thecurrentIf.getParent();
				lastSecond.setElseStatement(null);
			}
			

	
			rewriter.replace(switchCase, thefirstIf, null);
		}
		TextEdit edits = rewriter.rewriteAST(document, null);
		Utils.applyRewrite(node, edits, document,outputDirPath);
	}
}
