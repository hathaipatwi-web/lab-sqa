import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.health.fitness.HealthIndexScore;
import com.health.fitness.HealthIndexScore.FitnessLevel;

class TestHealthIndexScore {
	
	@ParameterizedTest
	@CsvSource({
		"24, 7",
		"25, 8",
		"26, 8",
		"42, 10",
		"60, 11",
		"61, 12",
		"62, 12"
	})
	void testBoundaryVo2max(double vo2, int expectedTotal) {
		HealthIndexScore score = new HealthIndexScore(vo2, 70, 20);
		assertEquals(expectedTotal, score.getTotalScore());
		
	}
	
	@ParameterizedTest
	@CsvSource({
		"39, 12",
		"40, 12",
		"41, 12",
		"219, 8",
		"220, 8",
		"221, 8"
	})
	void testBoundaryRhr(int rhr, int expectedTotal) {
		HealthIndexScore score = new HealthIndexScore(42, rhr, 20);
		assertEquals(expectedTotal, score.getTotalScore());
	}
	
	
	@ParameterizedTest
	@CsvSource({
		"11, 7",
		"12, 9",
		"13, 9",
		"29, 11",
		"30, 11",
		"31, 11"
	})
	void testBoundaryHrr(int hrr, int expectedTotal) {
		HealthIndexScore score = new HealthIndexScore(42, 70, hrr);
		assertEquals(expectedTotal, score.getTotalScore());
	}

}