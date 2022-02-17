package commons;

public class ExpectedResponse {
    public int[] expectedResult;
    public ExpectedResponse(int[] expectedResponse) {
        this.expectedResult = expectedResponse;
    }

    public int[] getExpectedResult() {
        return expectedResult;
    }
}
