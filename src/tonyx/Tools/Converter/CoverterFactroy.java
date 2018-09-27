package tonyx.Tools.Converter;

public class CoverterFactroy {
	public static SyntaxConverter createCoverter(String srcType, String destType) {
		if ("EDISyntax".equals(srcType)) {
			if ("EDISyntax".equals(destType)) {
				return new EDISyntaxToEDISyntax();
			} else if ("XMLSyntax".equals(destType)) {

			} else if ("PosSyntax".equals(destType)) {
				return new EDISyntaxToPosSyntax();
			}
		} else if ("PosSyntax".equals(srcType)) {
			if ("PosSyntax".equals(destType)) {
				return new PosSyntaxToPosSyntax();
			} else if ("EDISyntax".equals(destType)) {
				return new PosSyntaxToEDISyntax();
			} else if ("XMLSyntax".equals(destType)) {

			}
		} else if ("XMLSyntax".equals(srcType)) {
			if ("XMLSyntax".equals(destType)) {
				return new XMLSyntaxToXMLSyntax();
			} else if ("EDISyntax".equals(destType)) {

			} else if ("PosSyntax".equals(destType)) {

			}
		}
		return null;
	}
}
