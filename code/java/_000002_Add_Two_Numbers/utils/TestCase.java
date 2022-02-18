package _000002_Add_Two_Numbers.utils;

public class TestCase {
    InputArgs inputArgs;
    ExpectedObj expectedObj;

    public TestCase(InputArgs inputArgs, ExpectedObj expectedObj) {
        this.inputArgs = inputArgs;
        this.expectedObj = expectedObj;
    }

    public InputArgs getInputArgs() {
        return this.inputArgs;
    }

    public ExpectedObj getExpectedObj() {
        return this.expectedObj;
    }
}

