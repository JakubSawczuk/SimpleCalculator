package exceptions;

import static java.lang.System.exit;

public class OperationException extends RuntimeException {

    public OperationException() {
        super("Fail operation - check calculators input");
    }
}
