import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.health.fitness.HealthIndexScore;
import com.health.fitness.HealthIndexScore.FitnessLevel;

class TestHealthIndexScore {
	
	@ParameterizedTest
	@CsvSource({
		"25, 8",
		"26, 8",
		"42, 10",
		"60, 11",
		"61, 12"
		
	})
	void testBoundaryVo2max(double vo2, int expectedTotal) {
		HealthIndexScore score = new HealthIndexScore(vo2, 70, 20);
//		assertEquals(expectedScore, score.calculateVo2MaxScore());
		assertEquals(expectedTotal, score.getTotalScore());
		
	}
	
	@ParameterizedTest
	@CsvSource({
		"40, 12",
		"41, 12",
		"219, 8",
		"220, 8"
	})
	void testBoundaryRhr(int rhr, int expectedTotal) {
		HealthIndexScore score = new HealthIndexScore(42, rhr, 20);
		assertEquals(expectedTotal, score.getTotalScore());
	}
	
	@ParameterizedTest
	@CsvSource({
		"12, 9",
		"13, 9",
		"29, 11",
		"30, 11"
	})
	void testBoundaryHrr(int hrr, int expectedTotal) {
		HealthIndexScore score = new HealthIndexScore(42, 70, hrr);
		assertEquals(expectedTotal, score.getTotalScore());
	}

//    @Test
//    void testExcellentFitness() {
//        HealthIndexScore score = new HealthIndexScore(55, 55, 26);
//
//        assertEquals(4, score.calculateVo2MaxScore());
//        assertEquals(5, score.calculateRhrScore());
//        assertEquals(5, score.calculateHrrScore());
//        assertEquals(14, score.getTotalScore());
//        assertEquals(FitnessLevel.EXCELLENT, score.getFitnessLevel());
//    }
//
//    @Test
//    void testStandardFitness() {
//        HealthIndexScore score = new HealthIndexScore(35, 70, 15);
//
//        assertEquals(2, score.calculateVo2MaxScore());
//        assertEquals(3, score.calculateRhrScore());
//        assertEquals(3, score.calculateHrrScore());
//        assertEquals(8, score.getTotalScore());
//        assertEquals(FitnessLevel.STANDARD, score.getFitnessLevel());
//    }
//
//    @Test
//    void testPoorFitness() {
//        HealthIndexScore score = new HealthIndexScore(20, 100, 10);
//
//        assertEquals(0, score.calculateVo2MaxScore());
//        assertEquals(1, score.calculateRhrScore());
//        assertEquals(1, score.calculateHrrScore());
//        assertEquals(2, score.getTotalScore());
//        assertEquals(FitnessLevel.POOR, score.getFitnessLevel());
//    }
//
//    @Test
//    void testNegativeVo2Max() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            new HealthIndexScore(-1, 60, 20);
//        });
//    }
//
//    @Test
//    void testInvalidRhr() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            new HealthIndexScore(40, 30, 20);
//        });
//    }
//
//    @Test
//    void testNegativeHrr() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            new HealthIndexScore(40, 60, -5);
//        });
//    }

}