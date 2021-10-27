package spat.rules;

import java.util.ArrayList;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.ParenthesizedExpression;
import org.eclipse.jdt.core.dom.PrefixExpression;
import org.eclipse.jdt.core.dom.PrefixExpression.Operator;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.core.dom.rewrite.ListRewrite;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;

import spat.Utils;

public class ReveseIf_Else extends ASTVisitor{
	CompilationUnit cu = null;
	Document document = null;
	String outputDirPath = null;
	ArrayList<IfStatement> ifs = new ArrayList<IfStatement>();
	
	public ReveseIf_Else(CompilationUnit cu_, Document document_, String outputDirPath_) {
		this.cu = cu_;
		this.document = document_;
		this.outputDirPath = outputDirPath_;
	}
	
	
	public boolean visit(IfStatement node) {
		ifs.add(node);
		return true;
	}
	
	public void endVisit(CompilationUnit node) {
		
		if (ifs.size() == 0) {
			return;
		}
		
		AST ast = cu.getAST();
		ASTRewrite rewriter = ASTRewrite.create(ast);
		for(IfStatement ifer: ifs){
			IfStatement newifer = ast.newIfStatement();
			Expression theexp = (Expression) ASTNode.copySubtree(ast, ifer.getExpression());
			ParenthesizedExpression psizedexp = ast.newParenthesizedExpression();
			psizedexp.setExpression(theexp);
			PrefixExpression notexp = ast.newPrefixExpression();
			notexp.setOperator(Operator.toOperator("!"));
			notexp.setOperand(psizedexp);
			newifer.setExpression(notexp);
			Statement thenStatement = (Statement) ASTNode.copySubtree(ast,ifer.getThenStatement());
			Statement elseStatement = (Statement) ASTNode.copySubtree(ast,ifer.getElseStatement());
			
			if (elseStatement == null ) {
				elseStatement = ast.newEmptyStatement();
			}
			//Lets chek if this a nested else.
			else if(elseStatement.getNodeType() == ASTNode.IF_STATEMENT) {
				//System.out.println("Jusus! this is a nested if!");
				Block blocker = ast.newBlock();
				ListRewrite lrt = rewriter.getListRewrite(blocker, Block.STATEMENTS_PROPERTY);
				lrt.insertFirst(elseStatement, null);
				elseStatement = blocker;
			}
			newifer.setElseStatement(thenStatement);
			newifer.setThenStatement(elseStatement);
			
			rewriter.replace(ifer, newifer, null);
		}
		TextEdit edits = rewriter.rewriteAST(document, null);
		Utils.applyRewrite(node, edits, document,outputDirPath);
	}
}
