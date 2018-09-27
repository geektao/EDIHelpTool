package tonyx.Tools.EDIHelp.Utilities;

public class SyntaxStructFactroy {
	public static SyntaxStruct createSyntaxStruct(String type){
		if("EDISyntax".equals(type)){
			return new EDISyntaxStruct();
		}else if("PosSyntax".equals(type)){
			return new PosSyntaxStruct();
		}
		return null;
	}
}
