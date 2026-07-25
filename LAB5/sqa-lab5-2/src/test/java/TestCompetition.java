import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.sqa.lab.CompetitionScore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TestCompetition {

    private CompetitionScore competitionScore;

    @BeforeEach
    void setUp() {
        competitionScore = new CompetitionScore();
    }
    
    @Test
    void findMaxScore_allValid_returnsMax() {
        assertEquals(250, competitionScore.findMaxScore(250, 250, 250));
        
        int[] scores = {250, 250, 250};
        assertEquals(250, competitionScore.findMaxScore(scores));
    }

    @ParameterizedTest
    @CsvSource({
        "250, 250, -10",
        "250, 250, 600",
        "250, -10, 250",
        "250, -10, -10",
        "250, -10, 600",
        "250, 600, 250",
        "250, 600, -10",
        "250, 600, 600",
        "-10, 250, 250",
        "-10, 250, -10",
        "-10, 250, 600",
        "-10, -10, 250",
        "-10, -10, -10",
        "-10, -10, 600",
        "-10, 600, 250",
        "-10, 600, -10",
        "-10, 600, 600",
        "600, 250, 250",
        "600, 250, -10",
        "600, 250, 600",
        "600, -10, 250",
        "600, -10, -10",
        "600, -10, 600",
        "600, 600, 250",
        "600, 600, -10",
        "600, 600, 600"
    })
    void findMaxScore_strongRobustInvalidCombos_throwsException(int score1, int score2, int score3) {
        assertThrows(IllegalArgumentException.class,
            () -> competitionScore.findMaxScore(score1, score2, score3));
    }


    
    
    @ParameterizedTest
    @CsvSource({
        "250, 250, -10",
        "250, 250, 600",
        "250, -10, 250",
        "250, -10, -10",
        "250, -10, 600",
        "250, 600, 250",
        "250, 600, -10",
        "250, 600, 600",
        "-10, 250, 250",
        "-10, 250, -10",
        "-10, 250, 600",
        "-10, -10, 250",
        "-10, -10, -10",
        "-10, -10, 600",
        "-10, 600, 250",
        "-10, 600, -10",
        "-10, 600, 600",
        "600, 250, 250",
        "600, 250, -10",
        "600, 250, 600",
        "600, -10, 250",
        "600, -10, -10",
        "600, -10, 600",
        "600, 600, 250",
        "600, 600, -10",
        "600, 600, 600"
    })
    void findMaxScore_array_strongRobustInvalidCombos_throwsException(int score1, int score2, int score3) {
        int[] scores = {score1, score2, score3};
        assertThrows(IllegalArgumentException.class, () -> competitionScore.findMaxScore(scores));
    }

}