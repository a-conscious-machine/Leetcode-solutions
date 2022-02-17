package commons;

public class TestCase {
    InputTest inputTest;
    ExpectedResponse expectedResponse;

    public TestCase(InputTest inputTest, ExpectedResponse expectedResponse) {
        this.inputTest = inputTest;
        this.expectedResponse = expectedResponse;
    }

    public InputTest getInputTest() {
        return this.inputTest;
    }

    public ExpectedResponse getExpectedResponse() {
        return this.expectedResponse;
    }
}

