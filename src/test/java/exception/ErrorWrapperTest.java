package exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ErrorWrapperTest {

    public ErrorWrapperTest(){
        예외_발생시_message_포장_테스트();
    }

    @Test
    @DisplayName("예외_발생시_message_포장_테스트")
    void 예외_발생시_message_포장_테스트(){
        Assertions.assertThat(
                ExceptionWrapper.getWrapMessage(new Exception("")))
                        .startsWith("[ERROR]");
    }
}
