package dev.shiravand.mongodbdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.shiravand.mongodbdemo.application.data.ExpenseDto;
import dev.shiravand.mongodbdemo.domain.model.ExpenseCategory;
import dev.shiravand.mongodbdemo.persistance.repository.ExpenseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class MongodbDemoApplicationTests {

	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:6.0.5");
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ExpenseRepository expenseRepository;

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dymDynamicPropertyRegistry) {
		dymDynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}

	@Test
	void shouldCreateExpense() throws Exception {
		ExpenseDto expenseDto = getExpenseDto();
		String expenseDtoString = objectMapper.writeValueAsString(expenseDto);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/expense")
				.contentType(MediaType.APPLICATION_JSON)
				.content(expenseDtoString))
				.andExpect(MockMvcResultMatchers.status().isCreated());

		int expensesCount = expenseRepository.findAll().size();
		assertThat(expensesCount).as("Check expenses count to be 1")
				.isEqualTo(1);
	}

	private ExpenseDto getExpenseDto() {
		return ExpenseDto.builder()
				.expenseName("Netflix")
				.expenseCategory(ExpenseCategory.ENTERTAINMENT)
				.expenseAmount(new BigDecimal(10))
				.build();
	}

}
