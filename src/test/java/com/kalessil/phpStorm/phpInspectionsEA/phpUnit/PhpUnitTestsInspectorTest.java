package com.kalessil.phpStorm.phpInspectionsEA.phpUnit;

import com.kalessil.phpStorm.phpInspectionsEA.PhpCodeInsightFixtureTestCase;
import com.kalessil.phpStorm.phpInspectionsEA.inspectors.phpUnit.PhpUnitTestsInspector;
import com.kalessil.phpStorm.phpInspectionsEA.inspectors.phpUnit.PhpUnitVersion;

final public class PhpUnitTestsInspectorTest extends PhpCodeInsightFixtureTestCase {
    public void testIfFindsCoversAnnotationPatterns() {
        myFixture.enableInspections(new PhpUnitTestsInspector());
        myFixture.configureByFile("testData/fixtures/phpUnit/annotation-covers.php");
        myFixture.testHighlighting(true, false, true);
    }
    public void testIfFindsTestAnnotationPatterns() {
        myFixture.enableInspections(new PhpUnitTestsInspector());
        myFixture.configureByFile("testData/fixtures/phpUnit/annotation-test.php");
        myFixture.testHighlighting(true, false, true);
    }
    public void testIfFindsDependsAnnotationPatterns() {
        myFixture.enableInspections(new PhpUnitTestsInspector());
        myFixture.configureByFile("testData/fixtures/phpUnit/annotation-depends.php");
        myFixture.testHighlighting(true, false, true);
    }
    public void testIfFindsDataProviderAnnotationPatterns() {
        final PhpUnitTestsInspector inspector   = new PhpUnitTestsInspector();
        inspector.SUGGEST_TO_USE_NAMED_DATASETS = true;
        myFixture.enableInspections(inspector);
        myFixture.configureByFile("testData/fixtures/phpUnit/annotation-data-provider.php");
        myFixture.testHighlighting(true, false, true);
    }
    public void testIfFindsNormalizationPatterns() {
        myFixture.enableInspections(new PhpUnitTestsInspector());
        myFixture.configureByFile("testData/fixtures/phpUnit/assert-normalization.php");
        myFixture.testHighlighting(true, false, true);
    }


    public void testIfFindsSamePatterns() {
        final PhpUnitTestsInspector inspector = new PhpUnitTestsInspector();
        inspector.SUGGEST_TO_USE_ASSERTSAME   = true;
        inspector.PROMOTE_PHPUNIT_API         = true;
        myFixture.configureByFile("testData/fixtures/phpUnit/assert-same.php");
        myFixture.enableInspections(inspector);
        myFixture.testHighlighting(true, false, true);

        myFixture.getAllQuickFixes().forEach(fix -> myFixture.launchAction(fix));
        myFixture.setTestDataPath(".");
        myFixture.checkResultByFile("testData/fixtures/phpUnit/assert-same.fixed.php");
    }
    public void testIfFindsAssertStringEqualsFilePatterns() {
        myFixture.enableInspections(new PhpUnitTestsInspector());
        myFixture.configureByFile("testData/fixtures/phpUnit/assert-string-equals-file.php");
        myFixture.testHighlighting(true, false, true);

        myFixture.getAllQuickFixes().forEach(fix -> myFixture.launchAction(fix));
        myFixture.setTestDataPath(".");
        myFixture.checkResultByFile("testData/fixtures/phpUnit/assert-string-equals-file.fixed.php");
    }
    public void testIfFindsAssertCountPatterns() {
        myFixture.enableInspections(new PhpUnitTestsInspector());
        myFixture.configureByFile("testData/fixtures/phpUnit/assert-count.php");
        myFixture.testHighlighting(true, false, true);

        myFixture.getAllQuickFixes().forEach(fix -> myFixture.launchAction(fix));
        myFixture.setTestDataPath(".");
        myFixture.checkResultByFile("testData/fixtures/phpUnit/assert-count.fixed.php");
    }
    public void testIfFindsAssertFileEqualsPatterns() {
        myFixture.enableInspections(new PhpUnitTestsInspector());
        myFixture.configureByFile("testData/fixtures/phpUnit/assert-file-equals.php");
        myFixture.testHighlighting(true, false, true);

        myFixture.getAllQuickFixes().forEach(fix -> myFixture.launchAction(fix));
        myFixture.setTestDataPath(".");
        myFixture.checkResultByFile("testData/fixtures/phpUnit/assert-file-equals.fixed.php");
    }
    public void testIfFindsAssertConstantPatterns() {
        myFixture.enableInspections(new PhpUnitTestsInspector());
        myFixture.configureByFile("testData/fixtures/phpUnit/assert-constant.php");
        myFixture.testHighlighting(true, false, true);

        myFixture.getAllQuickFixes().forEach(fix -> myFixture.launchAction(fix));
        myFixture.setTestDataPath(".");
        myFixture.checkResultByFile("testData/fixtures/phpUnit/assert-constant.fixed.php");
    }
    public void testIfFindsAssertInstanceofPatterns() {
        myFixture.enableInspections(new PhpUnitTestsInspector());
        myFixture.configureByFile("testData/fixtures/phpUnit/assert-instanceof.php");
        myFixture.testHighlighting(true, false, true);

        myFixture.getAllQuickFixes().forEach(fix -> myFixture.launchAction(fix));
        myFixture.setTestDataPath(".");
        myFixture.checkResultByFile("testData/fixtures/phpUnit/assert-instanceof.fixed.php");
    }
    public void testIfFindsAssertEmptyPatterns() {
        myFixture.enableInspections(new PhpUnitTestsInspector());
        myFixture.configureByFile("testData/fixtures/phpUnit/assert-empty.php");
        myFixture.testHighlighting(true, false, true);

        myFixture.getAllQuickFixes().forEach(fix -> myFixture.launchAction(fix));
        myFixture.setTestDataPath(".");
        myFixture.checkResultByFile("testData/fixtures/phpUnit/assert-empty.fixed.php");
    }
    public void testIfFindsAssertInternalTypePatternsViaAssertInternalType() {
        final PhpUnitTestsInspector inspector = new PhpUnitTestsInspector();
        inspector.PHP_UNIT_VERSION            = PhpUnitVersion.PHPUNIT75;
        myFixture.enableInspections(inspector);
        myFixture.configureByFile("testData/fixtures/phpUnit/assert-internal-type.php");
        myFixture.testHighlighting(true, false, true);

        myFixture.getAllQuickFixes().forEach(fix -> myFixture.launchAction(fix));
        myFixture.setTestDataPath(".");
        myFixture.checkResultByFile("testData/fixtures/phpUnit/assert-internal-type.fixed.php");
    }
    public void testIfFindsAssertInternalTypePatternsViaSpecializedAsserts() {
        myFixture.enableInspections(new PhpUnitTestsInspector());
        myFixture.configureByFile("testData/fixtures/phpUnit/assert-internal-type.after-phpunit-8.php");
        myFixture.testHighlighting(true, false, true);

        myFixture.getAllQuickFixes().forEach(fix -> myFixture.launchAction(fix));
        myFixture.setTestDataPath(".");
        myFixture.checkResultByFile("testData/fixtures/phpUnit/assert-internal-type.after-phpunit-8.fixed.php");
    }
    public void testIfFindsAssertResourceExistsPatterns() {
        myFixture.enableInspections(new PhpUnitTestsInspector());
        myFixture.configureByFile("testData/fixtures/phpUnit/assert-resource-exists.php");
        myFixture.testHighlighting(true, false, true);

        myFixture.getAllQuickFixes().forEach(fix -> myFixture.launchAction(fix));
        myFixture.setTestDataPath(".");
        myFixture.checkResultByFile("testData/fixtures/phpUnit/assert-resource-exists.fixed.php");
    }
    public void testIfFindsAssertContainsPatterns() {
        myFixture.enableInspections(new PhpUnitTestsInspector());
        myFixture.configureByFile("testData/fixtures/phpUnit/assert-contains.php");
        myFixture.testHighlighting(true, false, true);

        myFixture.getAllQuickFixes().forEach(fix -> myFixture.launchAction(fix));
        myFixture.setTestDataPath(".");
        myFixture.checkResultByFile("testData/fixtures/phpUnit/assert-contains.fixed.php");
    }
    public void testIfFindsAssertRegExpPatterns() {
        myFixture.enableInspections(new PhpUnitTestsInspector());
        myFixture.configureByFile("testData/fixtures/phpUnit/assert-regexp.php");
        myFixture.testHighlighting(true, false, true);

        myFixture.getAllQuickFixes().forEach(fix -> myFixture.launchAction(fix));
        myFixture.setTestDataPath(".");
        myFixture.checkResultByFile("testData/fixtures/phpUnit/assert-regexp.fixed.php");

    }
    public void testIfFindsExpectsOncePattern() {
        final PhpUnitTestsInspector inspector = new PhpUnitTestsInspector();
        inspector.PROMOTE_MOCKING_ONCE        = true;
        myFixture.enableInspections(inspector);
        myFixture.configureByFile("testData/fixtures/phpUnit/expects-once.php");
        myFixture.testHighlighting(true, false, true);

        myFixture.getAllQuickFixes().forEach(fix -> myFixture.launchAction(fix));
        myFixture.setTestDataPath(".");
        myFixture.checkResultByFile("testData/fixtures/phpUnit/expects-once.fixed.php");
    }
    public void testIfFindsWillReturnPattern() {
        final PhpUnitTestsInspector inspector = new PhpUnitTestsInspector();
        inspector.PROMOTE_MOCKING_WILL_RETURN = true;
        myFixture.enableInspections(inspector);
        myFixture.configureByFile("testData/fixtures/phpUnit/will-return.php");
        myFixture.testHighlighting(true, false, true);

        myFixture.getAllQuickFixes().forEach(fix -> myFixture.launchAction(fix));
        myFixture.setTestDataPath(".");
        myFixture.checkResultByFile("testData/fixtures/phpUnit/will-return.fixed.php");
    }
}
