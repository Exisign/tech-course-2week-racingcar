import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.CarRacingCompetition;

public class RacingRuleTest {

    RacingRuleTest(){
        참가_자동차_명단_등록();
        공백으로만_이뤄진_문자_검증();
    }

    @Test
    @DisplayName("참가_자동차_명단_등록")
    void 참가_자동차_명단_등록(){
        Assertions.assertThrows(NullPointerException.class, ()->CarRacingCompetition.startRacing(null));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> CarRacingCompetition.startRacing("shin,,jin"));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> CarRacingCompetition.startRacing("shin,,,jin"));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> CarRacingCompetition.startRacing("shin, , ,jin"));
    }
    
    @Test
    @DisplayName("공백으로만_이뤄진_문자_검증")
    void 공백으로만_이뤄진_문자_검증(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->CarRacingCompetition.startRacing(" a , "));
    }
}
