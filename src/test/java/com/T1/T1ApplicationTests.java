package com.T1;

import com.T1.service.CharFrequencyService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

@SpringBootTest
class T1ApplicationTests {

	@Test
	public void testCalculateCharFrequency() {
		CharFrequencyService charFrequencyService = new CharFrequencyService();

		// Тестирование на непустой строке
		String inputString = "aaaabbbcc";
		List<Map.Entry<Character, Long>> result = charFrequencyService.calculateCharFrequency(inputString);

		assertThat(result).hasSize(3); // Ожидаем, что у нас будет 3 уникальных символа
		assertThat(result).containsExactly(
				Map.entry('a', 4L),
				Map.entry('b', 3L),
				Map.entry('c', 2L)
		);

		inputString = "";
		result = charFrequencyService.calculateCharFrequency(inputString);

		assertThat(result).isEmpty(); // Ожидаем, что список будет пустым

		// Тестирование на строке с пробелами
		inputString = "a b c";
		result = charFrequencyService.calculateCharFrequency(inputString);

		assertThat(result).hasSize(4); // Ожидаем, что у нас будет 4 уникальных символа
		assertThat(result).containsExactly(
				Map.entry(' ', 2L),
				Map.entry('a', 1L),
				Map.entry('b', 1L),
				Map.entry('c', 1L)
		);
	}
}
