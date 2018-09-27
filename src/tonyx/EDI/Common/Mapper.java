package tonyx.EDI.Common;

import tonyx.EDI.Accumulators.Accumulators;
import tonyx.EDI.CodeListTables.CodeListTables;
import tonyx.EDI.ConstantMap.ConstantMap;
import tonyx.EDI.Constants.Constants;
import tonyx.EDI.DBCSTokens.DBCSTokens;
import tonyx.EDI.ExtendedRuleLibraries.ExtendedRuleLibraries;
import tonyx.EDI.MapDetails.MapDetails;
import tonyx.EDI.SyntaxTokens.SyntaxTokens;

final public class Mapper {
	private MapDetails ediMapDetails;
	private String ediTemplateOption;
	private ExtendedRuleLibraries ediExtendedRuleLibraries;
	private INPUT ediINPUT;
	private OUTPUT ediOUTPUT;
	private Constants ediConstants;
	private SyntaxTokens ediSyntaxTokens;
	private DBCSTokens ediDBCSTokens;
	private CodeListTables ediCodeListTables;
	private ConstantMap ediConstantMap;
	private Accumulators ediAccumulators;

	public MapDetails getEdiMapDetails() {
		return ediMapDetails;
	}

	public void setEdiMapDetails(MapDetails ediMapDetails) {
		this.ediMapDetails = ediMapDetails;
	}

	public String getEdiTemplateOption() {
		return ediTemplateOption;
	}

	public void setEdiTemplateOption(String ediTemplateOption) {
		this.ediTemplateOption = ediTemplateOption;
	}

	public ExtendedRuleLibraries getEdiExtendedRuleLibraries() {
		return ediExtendedRuleLibraries;
	}

	public void setEdiExtendedRuleLibraries(
			ExtendedRuleLibraries ediExtendedRuleLibraries) {
		this.ediExtendedRuleLibraries = ediExtendedRuleLibraries;
	}

	public SyntaxTokens getEdiSyntaxTokens() {
		return ediSyntaxTokens;
	}

	public void setEdiSyntaxTokens(SyntaxTokens ediSyntaxTokens) {
		this.ediSyntaxTokens = ediSyntaxTokens;
	}

	public CodeListTables getEdiCodeListTables() {
		return ediCodeListTables;
	}

	public void setEdiCodeListTables(CodeListTables ediCodeListTables) {
		this.ediCodeListTables = ediCodeListTables;
	}

	public ConstantMap getEdiConstantMap() {
		return ediConstantMap;
	}

	public void setEdiConstantMap(ConstantMap ediConstantMap) {
		this.ediConstantMap = ediConstantMap;
	}

	public Accumulators getEdiAccumulators() {
		return ediAccumulators;
	}

	public void setEdiAccumulators(Accumulators ediAccumulators) {
		this.ediAccumulators = ediAccumulators;
	}

	public INPUT getEdiINPUT() {
		return ediINPUT;
	}

	public void setEdiINPUT(INPUT ediINPUT) {
		this.ediINPUT = ediINPUT;
	}

	public OUTPUT getEdiOUTPUT() {
		return ediOUTPUT;
	}

	public void setEdiOUTPUT(OUTPUT ediOUTPUT) {
		this.ediOUTPUT = ediOUTPUT;
	}

	public Constants getEdiConstants() {
		return ediConstants;
	}

	public void setEdiConstants(Constants ediConstants) {
		this.ediConstants = ediConstants;
	}

	public DBCSTokens getEdiDBCSTokens() {
		return ediDBCSTokens;
	}

	public void setEdiDBCSTokens(DBCSTokens ediDBCSTokens) {
		this.ediDBCSTokens = ediDBCSTokens;
	}
}
