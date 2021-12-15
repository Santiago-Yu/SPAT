package spat;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jface.text.Document;

import spat.rules.*;




public class RuleSelector {
	static final int LocalVarRenaming = 0;
	static final int For2While = 1;
	static final int While2For = 2;
	static final int ReverseIfElse = 3;
	static final int SingleIF2ConditionalExp  = 4;
	static final int ConditionalExp2SingleIF  = 5;
	static final int PP2AddAssignment = 6;
	static final int AddAssignemnt2EqualAssignment = 7;
	static final int InfixExpressionDividing = 8;
	static final int IfDividing=9;
	static final int StatementsOrderRearrangement = 10;
	static final int LoopIfContinue2Else = 11;
	static final int VarDeclarationMerging = 12;
	static final int VarDeclarationDividing = 13;
	static final int SwitchEqualSides = 14;
	static final int SwitchStringEqual = 15;
	static final int PrePostFixExpressionDividing = 16;
	static final int Case2IfElse = 17;
	
	static final int ReverseIfElse_Wrongly= -3;
	static final int For2While_Wrongly=-1;
	static final int StatementsOrderRearrangement_Wrongly=-10;
	static final int LocalVarRenaming_Wrongly=-99;
	
	
	static ASTVisitor create(String ruleId, CompilationUnit cu_, Document document_, String outputDirPath_) {
		int ider = Integer.parseInt(ruleId);
		switch (ider) {
		case LocalVarRenaming://local var Renaming
			return new LocalVariableRenaming(cu_, document_, outputDirPath_);
		case For2While://for statement trans to while statement
			return new ChangeFor2While(cu_, document_, outputDirPath_);
		case While2For://while statement trans to for statement
			return new ChangeWhile2For(cu_, document_, outputDirPath_);
		case ReverseIfElse:
			return new ReveseIf_Else(cu_, document_, outputDirPath_);
		case SingleIF2ConditionalExp:
			return new SingleIf2ConditionalExp(cu_, document_, outputDirPath_);
		case ConditionalExp2SingleIF:
			return new ConditionalExp2SingleIF(cu_, document_, outputDirPath_);
		case PP2AddAssignment:
			return new PP2AddAssignment(cu_, document_, outputDirPath_);
		case AddAssignemnt2EqualAssignment:
			return new AddAssignemnt2EqualAssignment(cu_, document_, outputDirPath_);
		case InfixExpressionDividing:
			return new InfixExpressionDividing(cu_, document_, outputDirPath_);
		case PrePostFixExpressionDividing:
			return new PrePostFixExpressionDividing(cu_, document_, outputDirPath_);
		case StatementsOrderRearrangement:
			return new StatementsOrderRearrangement(cu_, document_, outputDirPath_);
		case LoopIfContinue2Else:
			return new LoopIfContinue2Else(cu_, document_, outputDirPath_);
		case VarDeclarationMerging:
			return new VarDeclarationMerging(cu_, document_, outputDirPath_);
		case VarDeclarationDividing:
			return new VarDeclarationDividing(cu_, document_, outputDirPath_);
		case SwitchEqualSides:
			return new SwitchEqualSides(cu_, document_, outputDirPath_);
		case SwitchStringEqual:
			return new SwitchStringEqual(cu_, document_, outputDirPath_);
		case ReverseIfElse_Wrongly:
			return new ReveseIf_Else2_Wrongly(cu_, document_, outputDirPath_);
		case For2While_Wrongly:
			return new ChangeFor2While_Wrongly(cu_, document_, outputDirPath_);
		case StatementsOrderRearrangement_Wrongly:
			return new StatementsOrderRearrangement_Wrongly(cu_, document_, outputDirPath_);
		case LocalVarRenaming_Wrongly:
			return new LocalVariableRenaming_Wrongly(cu_, document_, outputDirPath_);
		case IfDividing:
			return new If_Dividing(cu_, document_, outputDirPath_);
		case Case2IfElse:
			return new Case2IfElse(cu_, document_, outputDirPath_);
			
			
		default:
			System.out.println("ERROR:" + "No rule belongs to this id!");
			System.exit(5);
			return null;
		}
		
			
	}
}
